package com.rays.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testEmployee {
	
	public static void main(String[] args) {
		
		
		Address ad = new Address();
		Employee em = new Employee();
		
		ad.setId(1);
		ad.setCity("indore");
		ad.setState("mp");
		
		
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		   
		   Session s = sessionFactory.openSession();
		   
		   Transaction tx = s.beginTransaction();
		   
		   s.save(ad);
		   
		   tx.commit();
		   s.close();
		   
		
		
		
	}

}
