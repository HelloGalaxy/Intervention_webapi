package fr.istic.mmm.domain.service.webapi;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.helper.EmfHelper;

// TODO: DEV TEST
public class TestController_User extends ServerResource {

	private static final EntityManagerFactory emf = EmfHelper.get();

	@Get
	public User createAndRead() {

		User user = new User();
		Account account = new Account();
		account.setLogin("1");
		account.setPassword("2");

		Set<Account> accounts = new HashSet<Account>();
		accounts.add(account);
		user.setAccount(accounts);
		user.setAge(99);
		user.setFirstName("Chengcheng");
		user.setLastName("PU");
		user.setMail("123456@qq.com");
		user.setPhoneNumber("76554321");

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}

		return user;
	}

	@Put
	public void update(User user) {
		String id = (String) getRequest().getAttributes().get("id");
		System.out.println("id: " + id + " name:  "
				+ user.getFirstName());
		
		long idl = Long.parseLong(id);
		
		try {
			
	

			EntityManager em = emf.createEntityManager();
			User users = em.find(User.class, idl);
			
			System.out.println(users);
			
			users.setAge(10000);
			
			em.getTransaction().begin();
			em.merge(users);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Delete
	public void delete(User user) {
		String id = (String) getRequest().getAttributes().get("id");
		System.out.println("id: " + id + " name:  "
				+ user.getFirstName());
		
		long idl = Long.parseLong(id);
		
		try {
			
	

			EntityManager em = emf.createEntityManager();
			User users = em.find(User.class, idl);
			
			System.out.println(users);
			
			em.getTransaction().begin();
			em.remove(users);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
