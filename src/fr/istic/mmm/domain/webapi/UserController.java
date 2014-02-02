package fr.istic.mmm.domain.webapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;

public class UserController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Post
	public ExeReport createModel(User user) {

		if (user == null) {
			return ExeReportHelper.getParamterError();
		}

		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getDataBaseError();
		}

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

	public ExeReport deleteModel(long userid) {

		try {

			EntityManager em = emf.createEntityManager();

			User target = em.find(User.class, userid);

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

			return ExeReportHelper.getDataBaseError(e.getMessage());
		}

		return ExeReportHelper.getSuccess();
	}

	@Get
	public User readModel() {

		String userkey = (String) getRequest().getAttributes().get("userid");

		if (userkey == null)
			return null;

		User target = null;

		try {

			long userid = Long.valueOf(userkey);
			EntityManager em = emf.createEntityManager();
			target = em.find(User.class, userid);

		} catch (Exception e) {
			System.out.println(e);
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

		User target = null;

		try {

			EntityManager em = emf.createEntityManager();

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
}
