package com.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.hibernate.AuctionItem;
import com.rays.hibernate.Bid;

public class testTransitive {
	
	
	public static void main(String[] args) {
		
		Bid bid = new Bid();
		
		bid.setId(6);
		bid.setAmount(1000);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		AuctionItem item = (AuctionItem)s.get(AuctionItem.class, 2L) ;
		
		Set set = item.getBids();
		
		set.add(bid);
		
		tx.commit();
		s.close();
		
		
		
		
	}

}
