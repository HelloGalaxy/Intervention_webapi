package fr.istic.mmm.domain.webapi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.helper.EmfHelper;
import fr.istic.mmm.helper.ExeReportHelper;

public class LoginController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@SuppressWarnings("unchecked")
	@Get
	public ExeReport login() {

		String login = (String) getRequest().getAttributes().get("login");
		String password = (String) getRequest().getAttributes().get("password");

		EntityManager em = emf.createEntityManager();

		List<Account> targets = null;

		String queryString = "select obj from Account as obj ";

		Query query = em.createQuery(queryString);

		targets = query.getResultList();

		for (Account item : targets) {
			if (item.getLogin().equals(login)
					&& item.getPassword().equals(password)) {
				return ExeReportHelper.getValideAccount(String.valueOf(item
						.getUserId()));
			}
		}

		return ExeReportHelper.getUnvalideAccount();
	}
}
