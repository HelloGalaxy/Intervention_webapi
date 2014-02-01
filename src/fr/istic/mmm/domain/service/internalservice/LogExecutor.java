package fr.istic.mmm.domain.service.internalservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.Log;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.helper.EmfHelper;

public class LogExecutor {

	private static final EntityManagerFactory emf = EmfHelper.get();

	// private List<Log> logs = new LinkedList<Log>();
	//
	// // TODO:
	// public synchronized void addLog(Log log) {
	// this.logs.add(log);
	// }
	//
	// protected synchronized void removeLog(Log log) {
	// this.logs.add(log);
	// }

	public void executeLog() {

		List<Log> targets = null;

		EntityManager em = emf.createEntityManager();

		String queryString = "select obj from Log as obj ";

		Query query = em.createQuery(queryString);

		targets = query.getResultList();

		em.getTransaction().begin();
		for (Log item : targets) {
			if (item.hasPersisted()) {
				targets.remove(item);
				em.remove(item);
			}
		}
		em.getTransaction().commit();

		persist(targets, em);

	}

	private void persist(List<Log> logs, EntityManager em ) {
		
		em.getTransaction().begin();
		
		for (Log item : logs) {
			
		}
		
		em.getTransaction().commit();
		
	}

	private Class<?> getModelTarget(String modelTarget) throws Exception {

		if ("Account".equals(modelTarget)) {
			return Account.class;
		} else if ("User".equals(modelTarget)) {
			return User.class;
		} else if ("Intervention".equals(modelTarget)) {
			return Intervention.class;
		} else {
			throw new Exception("The model target don't exist.");
		}

	}
}
