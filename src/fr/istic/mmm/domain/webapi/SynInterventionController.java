package fr.istic.mmm.domain.webapi;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.helper.EmfHelper;

public class SynInterventionController extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Get
	public Set<Intervention> readAll() {

		Set<Intervention> interventions = null;

		String userkey = (String) getRequest().getAttributes().get("userid");

		if (userkey == null)
			return null;

		User target = null;

		try {

			long userid = Long.valueOf(userkey);

			EntityManager em = emf.createEntityManager();

			target = em.find(User.class, userid);

			if (target != null) {
				interventions = target.getIntervention();
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);

		}

		return interventions;

	}
}