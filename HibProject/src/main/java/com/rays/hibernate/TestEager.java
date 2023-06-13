package com.rays.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEager {
	
	public static void main(String[] args) {
		
		
		
		
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		AuctionItem item = (AuctionItem)s.get(AuctionItem.class, 3L) ;
		
		
		tx.commit();
		s.close();
		
	}

}
