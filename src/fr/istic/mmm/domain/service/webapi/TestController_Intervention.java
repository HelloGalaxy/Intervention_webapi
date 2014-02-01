package fr.istic.mmm.domain.service.webapi;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.KeyFactory;
import com.sun.org.apache.bcel.internal.generic.LCONST;

import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.InterventionState;
import fr.istic.mmm.domain.model.InterventionType;
import fr.istic.mmm.domain.model.Location;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.helper.EmfHelper;

public class TestController_Intervention extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Get
	public Intervention createAndRead() {

		String id = (String) getRequest().getAttributes().get("id");

		long idl = Long.parseLong(id);

		Intervention iv = new Intervention();

		iv.setDate(new Date());
		InterventionState is = new InterventionState();
		is.setState("DOING");
		iv.setInterventionState(is);
		InterventionType interventionType = new InterventionType();
		interventionType.setType("LIVRASION");
		iv.setInterventionType(interventionType);
		Location location = new Location();
		location.setAddress("WUYIXILU 25");
		location.setCity("NANANING");
		location.setCountry("CHINA");
		location.setGeopoint(10, -10);
		location.setPostCode("35510");
		iv.setLocation(location);
		iv.setRemark("TEST SAMPLE");

		try {
			EntityManager em = emf.createEntityManager();
			User users = em.find(User.class, idl);

			users.getIntervention().add(iv);
			em.getTransaction().begin();
			em.persist(users);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(iv.getId().getId());
		return iv;
	}

	@Put
	public void update() {
		String id = (String) getRequest().getAttributes().get("id");
		System.out.println("id: " + id);

		long idl = Long.parseLong(id);

		try {

			EntityManager em = emf.createEntityManager();
			Intervention users = em.find(Intervention.class,
					KeyFactory.stringToKey(id));

			System.out.println(users);

			users.setRemark("MODIFCATION TEST");

			em.getTransaction().begin();
			// em.merge(users);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Delete
	public void deletelo(Intervention ivt) {
		String id = (String) getRequest().getAttributes().get("id");
		String ivid = (String) getRequest().getAttributes().get("ivid");
		System.out.println("id: " + id);
		System.out.println("ivid: " + ivid);
		System.out.println("Remark: " + ivt.getRemark());
		System.out.println("LOC: " + ivt.getLocation().getLatitude() + " "
				+ ivt.getLocation().getLongitude());
		// long idl = Long.parseLong(id);

		try {

			EntityManager em = emf.createEntityManager();
			User users = em.find(User.class, Long.parseLong(id));
			System.out.println(users);
			for (Intervention iv : users.getIntervention()) {
				if (iv.getId().getId() == Long.parseLong(ivid)) {
					System.out.println(iv);
					users.getIntervention().remove(iv);
				}
			}

			em.getTransaction().begin();
			em.merge(users);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
