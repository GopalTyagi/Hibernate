package com.rays.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDetachment {
	
	public static void main(String[] args) {
		
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
				
		AuctionItem item = (AuctionItem)s.get(AuctionItem.class, 2L) ;
		s.close();
		
		item.setDescription("project 4");
		
		Session s2 = sessionFactory.openSession();
		
		Transaction tx = s2.beginTransaction();
		
		s2.update(item);
		
		tx.commit();
		s2.close();
		
		
	}

}
