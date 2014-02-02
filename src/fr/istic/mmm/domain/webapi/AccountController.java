package fr.istic.mmm.domain.webapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;

public class AccountController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Post
	public ExeReport createModel(Account account) {

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

		return createModel(userId, account);
	}

	public ExeReport createModel(long userId, Account account) {

		try {

			EntityManager em = emf.createEntityManager();

			User user = em.find(User.class, userId);

			if (user != null) {

				user.getAccount().add(account);

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

		return ExeReportHelper
				.getSuccess(String.valueOf(account.getIdFromKey()));
	}

	@Delete
	public ExeReport deleteModel() {

		String userKey = (String) getRequest().getAttributes().get("userid");
		String accountKey = (String) getRequest().getAttributes().get(
				"accountid");

		if (userKey == null || accountKey == null)
			return ExeReportHelper.getParamterError();
		long userId = 0;
		long accountId = 0;
		try {

			userId = Long.valueOf(userKey);
			accountId = Long.valueOf(accountKey);

		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return deleteModel(userId, accountId);
	}

	public ExeReport deleteModel(long userId, long accountId) {

		try {

			EntityManager em = emf.createEntityManager();

			User user = em.find(User.class, userId);

			if (user != null) {
				for (Account account : user.getAccount()) {
					if (account.getIdFromKey() == accountId) {

						user.getAccount().remove(account);

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
	public Account readModel() {

		Account target = null;

		String userKey = (String) getRequest().getAttributes().get("userid");
		String accountKey = (String) getRequest().getAttributes().get(
				"accountid");

		if (userKey == null || accountKey == null)
			return null;

		try {

			long userId = Long.valueOf(userKey);
			long accountId = Long.valueOf(accountKey);

			EntityManager em = emf.createEntityManager();
			User user = em.find(User.class, userId);

			if (user != null) {
				for (Account account : user.getAccount()) {
					if (account.getIdFromKey() == accountId) {
						target = account;
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
	// public List<Account> readAll() {
	// List<Account> tragets = null;
	// try {
	// EntityManager em = emf.createEntityManager();
	//
	// em.getTransaction().begin();
	// String queryString = "select obj from Account as obj ";
	// Query query = em.createQuery(queryString);
	// tragets = query.getResultList();
	// em.getTransaction().commit();
	//
	// } catch (Exception e) {
	// return tragets;
	// }
	//
	// return tragets;
	// }

	@Put
	public ExeReport updateModel(Account account) {

		if (account == null) {
			return ExeReportHelper.getParamterError();
		}

		String userKey = (String) getRequest().getAttributes().get("userid");
		String accountKey = (String) getRequest().getAttributes().get(
				"accountid");

		if (userKey == null || accountKey == null)
			return null;

		long userId = 0;
		long accountId = 0;

		try {

			userId = Long.valueOf(userKey);
			accountId = Long.valueOf(accountKey);

		} catch (Exception e) {
			System.out.println(e);
			return ExeReportHelper.getParamterError(e.getMessage());
		}

		return updateModel(userId, accountId, account);
	}

	public ExeReport updateModel(long userId, long accountId, Account account) {

		try {

			EntityManager em = emf.createEntityManager();
			User user = em.find(User.class, userId);

			if (user != null) {

				for (Account item : user.getAccount()) {
					if (item.getIdFromKey() == accountId) {

						item.setLogin(account.getLogin());
						item.setPassword(account.getPassword());

						em.getTransaction().begin();

						em.merge(user);
						em.getTransaction().commit();

						break;
					}
				}

			}

		} catch (Exception e) {
			return ExeReportHelper.getDataBaseError();
		}

		return ExeReportHelper.getSuccess();
	}
}
