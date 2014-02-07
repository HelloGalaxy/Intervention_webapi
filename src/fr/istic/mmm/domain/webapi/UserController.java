package fr.istic.mmm.domain.webapi;

import java.io.IOException;
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
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;
import fr.istic.mmm.helper.OperationTypeHelper;

public class UserController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();
	private static ObjectMapper om = new ObjectMapper();
	private LogController logController = new LogController();

	@Post
	public ExeReport createModel(User user) throws IOException {

		if (user == null) {
			return ExeReportHelper.getParamterError();
		}

		EntityManager em = emf.createEntityManager();
		List<Long> ids = new LinkedList<Long>();

		try {

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

			ids.add(user.getIdFromKey());

		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getDataBaseError();
		}

		String data = "";
		try {
			data = om.writeValueAsString(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ExeReportHelper.getJsonError(e.getMessage());
		} finally {
			em.close();
		}

		// TO LOG
		logController.createLog(data, ids, User.class.getName(),
				OperationTypeHelper.getCreate());

		return ExeReportHelper.getSuccess(String.valueOf(user.getIdFromKey()));
	}

	@Delete
	public ExeReport deleteModel() {

		String userkey = (String) getRequest().getAttributes().get("userid");

		if (userkey == null)
			return ExeReportHelper.getParamterError();

		long userid = 0;

		try {
			userid = Long.valueOf(userkey);
		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return deleteModel(userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.mmm.domain.webapi.IUserController#deleteModel(long)
	 */

	public ExeReport deleteModel(long userid) {

		EntityManager em = emf.createEntityManager();

		User target = null;

		try {

			target = em.find(User.class, userid);

			if (target != null) {
				em.getTransaction().begin();
				em.remove(target);
				em.getTransaction().commit();
			}

			else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}

		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
			em.close();
			return ExeReportHelper.getDataBaseError(e.getMessage());
		} finally {
			em.close();
		}

		return ExeReportHelper.getSuccess();
	}

	@Get
	public User readModel() {

		String userkey = (String) getRequest().getAttributes().get("userid");

		if (userkey == null)
			return null;

		User target = null;
		EntityManager em = emf.createEntityManager();

		try {

			long userid = Long.valueOf(userkey);

			target = em.find(User.class, userid);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// em.close();
		}

		return target;
	}

	// @Override
	// public List<User> readAll() {
	// List<User> targets = null;
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
	public ExeReport updateModel(User user) {

		if (user == null) {
			return ExeReportHelper.getParamterError();
		}

		String userkey = (String) getRequest().getAttributes().get("userid");

		if (userkey == null)
			return null;

		long userid = 0l;
		try {

			userid = Long.valueOf(userkey);

		} catch (Exception e) {
			System.out.println(e);

			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return updateModel(userid, user);
	}

	public ExeReport updateModel(long userid, User user) {

		if (user == null) {
			return ExeReportHelper.getParamterError();
		}

		EntityManager em = emf.createEntityManager();
		User target = null;
		String data = "";
		List<Long> ids = new LinkedList<Long>();

		try {

			target = em.find(User.class, userid);

			if (target != null) {

				target.setAge(user.getAge());
				target.setFirstName(user.getFirstName());
				target.setLastName(user.getLastName());
				target.setMail(user.getMail());
				target.setPhoneNumber(user.getPhoneNumber());

				em.getTransaction().begin();
				em.merge(target);
				em.getTransaction().commit();

				try {
					data = om.writeValueAsString(target);
				} catch (Exception e) {
					e.printStackTrace();
					return ExeReportHelper.getJsonError(e.getMessage());
				}

				ids.add(target.getIdFromKey());

			} else {
				return ExeReportHelper
						.getParamterError("Can't find the model.");
			}

		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
			em.close();
			return ExeReportHelper.getDataBaseError(e.getMessage());
		} finally {
			// em.close();
		}

		// TO LOG
		logController.createLog(data, ids, User.class.getName(),
				OperationTypeHelper.getUpdate());

		return ExeReportHelper.getSuccess();
	}
}
