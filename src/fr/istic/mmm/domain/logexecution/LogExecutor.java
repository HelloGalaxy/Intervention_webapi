package fr.istic.mmm.domain.logexecution;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.istic.mmm.domain.model.Log;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;

public class LogExecutor {

	private static final EntityManagerFactory emf = EmfHelper.get();

	public void executeLogs() {

		List<Log> targets = null;

		EntityManager em = emf.createEntityManager();

		String queryString = "select obj from Log as obj where obj.persisted =: false ";
		Query query = em.createQuery(queryString);
		targets = query.getResultList();

		em.close();

		persist(targets);

	}

	public void removLogs() {

		List<Log> targets = null;

		EntityManager em = emf.createEntityManager();

		String queryString = "select obj from Log as obj where obj.persisted =: true ";
		Query query = em.createQuery(queryString);
		targets = query.getResultList();

		em.getTransaction().begin();
		for (int i = 0; i < targets.size(); i++) {
			Log item = targets.get(i);
			// if (item.hasPersisted()) {
			em.remove(item);
			// }
		}
		em.getTransaction().commit();
		em.close();

		persist(targets);

	}

	private void persist(List<Log> logs) {

		for (Log item : logs) {

			String modelTarget = item.getTarget();

			if ("Account".equals(modelTarget)) {

			} else if ("User".equals(modelTarget)) {

				LogCommand logcmd = new UserLogCmd();

				String[] keys = item.getKeyList().split("+");

				ExeReport report = logcmd.execute(item.getData(), keys,
						item.getOperationType());

				if (report.getState() == 0)
					item.setPersisted(true);

			} else if ("Intervention".equals(modelTarget)) {

			} else {
				// throw new Exception("The model target don't exist.");
			}
		}

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(logs);
		em.getTransaction().commit();

	}
}
