package com.ham.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyConnection {
	private static SessionFactory instance;
	private static ServiceRegistry serviceRegistry = null;

	public MyConnection() {
		/*Configuration configuration = new Configuration();

		configuration.configure("/hibernate.cfg.xml");

		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();

		instance = configuration.buildSessionFactory(serviceRegistry);
		System.out.println("Session factory mch�t");*/
		instance =new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getInstance() {
		if (instance == null)
			new MyConnection();
		return instance;
		

	}

}
