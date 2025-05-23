package com.cdac.tester;

import static com.cdac.HibernateUtils.Utils.*;

import org.hibernate.SessionFactory;
public class Tester {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			System.out.println("Hibernate Is running");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
