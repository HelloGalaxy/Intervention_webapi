package fr.istic.mmm.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfHelper {
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("gae-datastore");

	private EmfHelper() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}

}
