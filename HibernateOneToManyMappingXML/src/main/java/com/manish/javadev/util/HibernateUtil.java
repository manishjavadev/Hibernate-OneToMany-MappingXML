package com.manish.javadev.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		factory = cfg.buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
