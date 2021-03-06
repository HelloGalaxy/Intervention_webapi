package fr.istic.mmm.domain.internalservice;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.istic.mmm.domain.model.Log;
import fr.istic.mmm.domain.model.OperationType;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.helper.EmfHelper;

public class LogController {

	private static final EntityManagerFactory emf = EmfHelper.get();

	public void createLog(String data, List<Long> ids, String target,
			OperationType oprtype) {

		Log log = new Log();
		log.setData(data);
		log.setDate(new Date());

		StringBuilder keys = new StringBuilder();

		for (int i = 0; i < ids.size(); i++) {
			keys.append(String.valueOf(ids.get(i)) + "\\");
		}

		keys.deleteCharAt(keys.length() - 1);
		log.setKeyList(keys.toString());

		log.setOperationType(oprtype);
		log.setTarget(target);

		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, ids.get(0));

		user.getLog().add(log);

		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// @Post
	// public ExeReport createModels(List<Log> logs) {
	//
	// if (logs == null) {
	// return ExeReportHelper.getParamterError();
	// }
	//
	// String userKey = (String) getRequest().getAttributes().get("userid");
	//
	// if (userKey == null)
	// return ExeReportHelper.getParamterError();
	//
	// try {
	//
	// long userId = Long.valueOf(userKey);
	//
	// EntityManager em = emf.createEntityManager();
	// User user = em.find(User.class, userId);
	//
	// if (user == null) {
	// return ExeReportHelper.getParamterError();
	// }
	//
	// for (Log log : logs) {
	// user.getLog().add(log);
	// }
	//
	// em.getTransaction().begin();
	// em.persist(user);
	// em.getTransaction().commit();
	//
	// } catch (Exception e) {
	//
	// System.out.println(e);
	// return ExeReportHelper.getDataBaseError(e.getMessage());
	// }
	//
	// return ExeReportHelper.getSuccess();
	// }
	//
	//
	// //TODO: DEV AND TEST
	// @Put
	// public void executeLogs() {
	// new LogExecutor().executeLogs();
	// }
	//
	// @Delete
	// public void deleteLogs() {
	// new LogExecutor().removLogs();
	// }

	// @PUT
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @Override
	// public ExeReport update(Log log) {
	// if (log == null) {
	// return ExeReportHelper.getParamterError();
	// }
	//
	// try {
	//
	// EntityManager em = emf.createEntityManager();
	//
	// Log target = em.find(Log.class, log.getId().getId());
	//
	// if (target != null) {
	//
	// em.getTransaction().begin();
	//
	// target.setData(log.getData());
	// target.setDate(log.getDate());
	// target.setOperationType(log.getOperationType());
	//
	// em.merge(target);
	// em.getTransaction().commit();
	// }
	//
	// } catch (Exception e) {
	// return ExeReportHelper.getDataBaseError();
	// }
	//
	// return ExeReportHelper.getSuccess();
	// }

	// @Override
	// public Log read(long id) {
	// Log target = null;
	//
	// try {
	//
	// EntityManager em = emf.createEntityManager();
	// target = em.find(Log.class, id);
	//
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	//
	// return target;
	// }
	//
	// @Override
	// public List<Log> readAll() {
	// List<Log> targets = null;
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

	// @DELETE
	// @Path("{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	// @Override
	// public ExeReport delete(@PathParam("id") long id) {
	// try {
	// EntityManager em = emf.createEntityManager();
	//
	// em.getTransaction().begin();
	// em.remove(id);
	// em.getTransaction().commit();
	//
	// } catch (Exception e) {
	//
	// System.out.println(e);
	//
	// return ExeReportHelper.getDataBaseError();
	// }
	//
	// return ExeReportHelper.getSuccess();
	// }

}
