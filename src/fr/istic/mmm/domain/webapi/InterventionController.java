package fr.istic.mmm.domain.webapi;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.internalservice.LogController;
import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;
import fr.istic.mmm.helper.OperationTypeHelper;

public class InterventionController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();
	private static ObjectMapper om = new ObjectMapper();
	private LogController logController = new LogController();

	@Post
	public ExeReport createModel(Intervention intervention) {

		if (intervention == null) {
			return ExeReportHelper.getParamterError();
		}

		String userKey = (String) getRequest().getAttributes().get("userid");

		if (userKey == null)
			return ExeReportHelper.getParamterError();

		long userId = 0;

		try {

			userId = Long.valueOf(userKey);

		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return createModel(userId, intervention);
	}

	public ExeReport createModel(long userId, Intervention intervention) {

		User user = null;
		EntityManager em = emf.createEntityManager();

		try {

			user = em.find(User.class, userId);

			if (user != null) {

				user.getIntervention().add(intervention);

				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
			} else {
				return ExeReportHelper
						.getParamterError("Can't not find the model.");
			}

		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
			em.close();
			return ExeReportHelper.getDataBaseError();
		} finally {
			em.close();
		}

		// TO LOG
		String data = "";
		try {
			data = om.writeValueAsString(intervention);
		} catch (Exception e) {
			e.printStackTrace();
			return ExeReportHelper.getJsonError(e.getMessage());
		}

		List<Long> ids = new LinkedList<Long>();
		ids.add(user.getIdFromKey());
		ids.add(intervention.getIdFromKey());

		logController.createLog(data, ids, Intervention.class.getName(),
				OperationTypeHelper.getCreate());

		return ExeReportHelper.getSuccess(String.valueOf(intervention
				.getIdFromKey()));
	}

	@Delete
	public ExeReport deleteModel() {

		String userKey = (String) getRequest().getAttributes().get("userid");
		String interventionKey = (String) getRequest().getAttributes().get(
				"interventionid");

		if (userKey == null || interventionKey == null)
			return ExeReportHelper.getParamterError();

		long userId = 0;
		long interventionId = 0;

		try {

			userId = Long.valueOf(userKey);
			interventionId = Long.valueOf(interventionKey);

		} catch (Exception e) {

			System.out.println(e);
			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return deleteModel(userId, interventionId);
	}

	public ExeReport deleteModel(long userId, long interventionId) {

		EntityManager em = emf.createEntityManager();
		User user = null;
		Intervention target = null;
		String data = "";
		List<Long> ids = new LinkedList<Long>();
		try {

			user = em.find(User.class, userId);

			if (user != null) {
				for (Intervention item : user.getIntervention()) {
					if (item.getIdFromKey() == interventionId) {

						target = item;
						user.getIntervention().remove(item);

						em.getTransaction().begin();
						em.merge(user);
						em.getTransaction().commit();

						try {
							data = om.writeValueAsString(target);
						} catch (Exception e) {
							e.printStackTrace();
							return ExeReportHelper.getJsonError(e.getMessage());
						}

						ids.add(user.getIdFromKey());
						ids.add(target.getIdFromKey());

						break;
					}
				}
			} else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}

			if (target == null)
				return ExeReportHelper
						.getParamterError("Can't find the model.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
			em.close();
			return ExeReportHelper.getDataBaseError(e.getMessage());
		} finally {
			em.close();
		}

		// TO LOG
		logController.createLog(data, ids, Intervention.class.getName(),
				OperationTypeHelper.getDelete());

		return ExeReportHelper.getSuccess();
	}

	@Get
	public Intervention read() {

		Intervention target = null;

		String userKey = (String) getRequest().getAttributes().get("userid");
		String interventionKey = (String) getRequest().getAttributes().get(
				"interventionid");

		if (userKey == null || interventionKey == null)
			return null;

		EntityManager em = emf.createEntityManager();
		try {

			long userId = Long.valueOf(userKey);
			long interventionId = Long.valueOf(interventionKey);

			User user = em.find(User.class, userId);

			if (user != null) {
				for (Intervention intervention : user.getIntervention()) {
					if (intervention.getIdFromKey() == interventionId) {

						target = intervention;
						break;
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//em.close();
		}

		return target;
	}

	// @Override
	// public List<Intervention> readAll() {
	// List<Intervention> targets = null;
	// try {
	// EntityManager em = emf.createEntityManager();
	//
	// em.getTransaction().begin();
	// String queryString = "select obj from User as obj ";
	// Query query = em.createQuery(queryString);
	// targets = query.getResultList();
	// em.getTransaction().commit();
	//
	// } catch (Exception e) {
	// return targets;
	// }
	//
	// return targets;
	// }

	@Put
	public ExeReport updateModel(Intervention intervention) {

		if (intervention == null) {
			return ExeReportHelper.getParamterError();
		}

		String userKey = (String) getRequest().getAttributes().get("userid");
		String interventionKey = (String) getRequest().getAttributes().get(
				"interventionid");

		if (userKey == null || interventionKey == null)
			return null;

		long userId = 0;
		long interventionId = 0;

		try {

			userId = Long.valueOf(userKey);
			interventionId = Long.valueOf(interventionKey);

		} catch (Exception e) {
			return ExeReportHelper.getDataBaseError(e.getMessage());
		}

		return updateModel(userId, interventionId, intervention);
	}

	public ExeReport updateModel(long userId, long interventionId,
			Intervention intervention) {

		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, userId);
		String data = "";
		List<Long> ids = new LinkedList<Long>();
		Intervention target = null;

		try {

			if (user != null) {

				for (Intervention item : user.getIntervention()) {
					if (item.getIdFromKey() == interventionId) {

						target = item;
						item.setDate(intervention.getDate());
						item.setInterventionState(intervention
								.getInterventionState());
						item.setRemark(intervention.getRemark());
						item.setInterventionType(intervention
								.getInterventionType());
						item.setLocation(intervention.getLocation());

						em.getTransaction().begin();
						em.merge(user);
						em.getTransaction().commit();

						try {
							data = om.writeValueAsString(target);
						} catch (Exception e) {
							e.printStackTrace();
							return ExeReportHelper.getJsonError(e.getMessage());
						}

						ids.add(user.getIdFromKey());
						ids.add(target.getIdFromKey());

						break;
					}
				}
			} else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}

			if (target == null)
				return ExeReportHelper
						.getParamterError("Can't find the model.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			return ExeReportHelper.getDataBaseError(e.getMessage());
		} finally {
			em.close();
		}

		// TO LOG
		logController.createLog(data, ids, Intervention.class.getName(),
				OperationTypeHelper.getUpdate());

		return ExeReportHelper.getSuccess();
	}
}
