package fr.istic.mmm.domain.service.webapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;

public class InterventionController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Post
	public ExeReport createModel(Intervention intervention) {

		if (intervention == null) {
			return ExeReportHelper.getParamterError();
		}

		String userKey = (String) getRequest().getAttributes().get("userid");

		if (userKey == null)
			return ExeReportHelper.getParamterError();

		try {
			long userId = Long.valueOf(userKey);

			EntityManager em = emf.createEntityManager();

			User user = em.find(User.class, userId);

			if (user != null) {

				user.getIntervention().add(intervention);

				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
			} else {
				return ExeReportHelper.getParamterError();
			}

		} catch (Exception e) {

			System.out.println(e);
			return ExeReportHelper.getDataBaseError();
		}

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

		try {

			long userId = Long.valueOf(userKey);
			long interventionId = Long.valueOf(interventionKey);

			EntityManager em = emf.createEntityManager();

			User user = em.find(User.class, userId);

			if (user != null) {
				for (Intervention intervention : user.getIntervention()) {
					if (intervention.getIdFromKey() == interventionId) {

						user.getIntervention().remove(intervention);
						
						em.getTransaction().begin();
						em.merge(user);
						em.getTransaction().commit();

						break;
					}
				}
			} else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}

		} catch (Exception e) {

			System.out.println(e);
			return ExeReportHelper.getDataBaseError(e.getMessage());
		}

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

		try {

			long userId = Long.valueOf(userKey);
			long interventionId = Long.valueOf(interventionKey);

			EntityManager em = emf.createEntityManager();
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

		try {

			long userId = Long.valueOf(userKey);
			long interventionId = Long.valueOf(interventionKey);

			EntityManager em = emf.createEntityManager();
			User user = em.find(User.class, userId);

			if (user != null) {

				for (Intervention item : user.getIntervention()) {
					if (item.getIdFromKey() == interventionId) {

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
					}
				}
			} else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}
		} catch (Exception e) {
			return ExeReportHelper.getDataBaseError(e.getMessage());
		}

		return ExeReportHelper.getSuccess();
	}

}
