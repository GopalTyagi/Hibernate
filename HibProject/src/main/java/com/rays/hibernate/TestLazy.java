package com.rays.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jdk.nashorn.api.tree.WhileLoopTree;

public class TestLazy {

	public static void main(String[] args) {
		
		
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		AuctionItem item = (AuctionItem)s.get(AuctionItem.class, 2L) ;
		
		Set set = item.getBids();
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			
			Bid bi = (Bid) it.next();
			System.out.println(bi.getId());
			System.out.println(bi.getAmount());
		}
		
		tx.commit();
		s.close();
		
		
		
	}
	
	
	
}
