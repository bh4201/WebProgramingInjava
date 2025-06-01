package com.cdac.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in staatic init block");

		factory=new Configuration() 
			    .configure()//loaded 
			    .buildSessionFactory();
		
	}
}
