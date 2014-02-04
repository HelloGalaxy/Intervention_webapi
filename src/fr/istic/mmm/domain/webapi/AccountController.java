package fr.istic.mmm.domain.webapi;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.internalservice.LogController;
import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;
import fr.istic.mmm.helper.OperationTypeHelper;

public class AccountController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();
	private static ObjectMapper om = new ObjectMapper();
	private LogController logController = new LogController();

	@Post
	public ExeReport createModel(Account account) {

		String userKey = (String) getRequest().getAttributes().get("userid");

		if (userKey == null)
			return ExeReportHelper.getParamterError();

		if (!isUniqueLogin(account))
			return ExeReportHelper.getNotUniqueValue();

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

		EntityManager em = emf.createEntityManager();
		User user = null;
		String data = "";
		List<Long> ids = new LinkedList<Long>();

		try {

			user = em.find(User.class, userId);

			if (user != null) {

				user.getAccount().add(account);
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();

				try {
					data = om.writeValueAsString(account);
				} catch (Exception e) {
					e.printStackTrace();
					return ExeReportHelper.getJsonError(e.getMessage());
				}

				ids.add(user.getIdFromKey());
				ids.add(account.getIdFromKey());

			} else {
				return ExeReportHelper.getParamterError();
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
		logController.createLog(data, ids, Account.class.getName(),
				OperationTypeHelper.getCreate());

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

		EntityManager em = emf.createEntityManager();
		String data = "";
		User user = em.find(User.class, userId);
		Account target = null;
		List<Long> ids = new LinkedList<Long>();

		try {

			if (user != null) {
				for (Account item : user.getAccount()) {
					if (item.getIdFromKey() == accountId) {

						target = item;

						user.getAccount().remove(item);
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

				if (target == null)
					return ExeReportHelper
							.getParamterError("Can't find the object.");

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
			em.close();
		}

		// TO LOG
		logController.createLog(data, ids, Account.class.getName(),
				OperationTypeHelper.getDelete());

		return ExeReportHelper.getSuccess();
	}

	@Get
	public Account readModel() {

		System.out.println("+++++++++" + readAll().size());

		Account target = null;

		String userKey = (String) getRequest().getAttributes().get("userid");
		String accountKey = (String) getRequest().getAttributes().get(
				"accountid");

		if (userKey == null || accountKey == null)
			return null;

		EntityManager em = emf.createEntityManager();
		try {

			long userId = Long.valueOf(userKey);
			long accountId = Long.valueOf(accountKey);

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
		} finally {
			// em.close();
		}

		return target;
	}

	public List<Account> readAll() {
		List<Account> tragets = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String queryString = "select obj from Account as obj ";
			Query query = em.createQuery(queryString);
			tragets = query.getResultList();
			em.getTransaction().commit();

		} catch (Exception e) {
			return tragets;
		} finally {
			em.close();
		}

		return tragets;
	}

	@Put
	public ExeReport updateModel(Account account) {

		if (account == null) {
			return ExeReportHelper.getParamterError();
		}

		if (!isUniqueLogin(account))
			return ExeReportHelper.getNotUniqueValue();

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

		User user = null;
		EntityManager em = emf.createEntityManager();
		String data = "";
		Account target = null;
		List<Long> ids = new LinkedList<Long>();

		try {
			user = em.find(User.class, userId);

			if (user != null) {

				for (Account item : user.getAccount()) {

					if (item.getIdFromKey() == accountId) {

						target = item;

						item.setLogin(account.getLogin());
						item.setPassword(account.getPassword());

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

				if (target == null)
					return ExeReportHelper
							.getParamterError("Can't find the object.");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			em.close();
			return ExeReportHelper.getDataBaseError(e.getMessage());
		} finally {
			em.close();
		}

		// TO LOG
		logController.createLog(data, ids, Account.class.getName(),
				OperationTypeHelper.getUpdate());

		return ExeReportHelper.getSuccess();
	}

	private boolean isUniqueLogin(Account target) {
		List<Account> accounts = readAll();

		for (Account item : accounts) {
			if (item.getLogin().equals(target.getLogin()))
				return false;
		}

		return true;
	}
}
