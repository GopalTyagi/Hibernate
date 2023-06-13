package com.rays.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {
	
   public static void main(String[] args) {
	
	   
	   AuctionItem auctionItem = new AuctionItem();
	   
	   auctionItem.setId(3);
	   auctionItem.setDescription("Auction 2");

   
   Bid bid1 = new Bid();
   
   bid1.setId(1);
   bid1.setAmount(100);
   bid1.setTimestamp("XXX");
   
   
 Bid bid2 = new Bid();
   
   bid2.setId(2);
   bid2.setAmount(200);
   bid2.setTimestamp("XX");
   
 Bid bid3 = new Bid();
   
   bid3.setId(3);
   bid3.setAmount(300);
   bid3.setTimestamp("Xyz");
   
 Bid bid4 = new Bid();
   
   bid4.setId(4);
   bid4.setAmount(400);
   bid4.setTimestamp("X2X");
   
 Bid bid5 = new Bid();
   
   bid5.setId(5);
   bid5.setAmount(500);
   bid5.setTimestamp("XXY");
   
   
   Set bids = new HashSet();
   bids.add(bid1);
   bids.add(bid2);
   bids.add(bid3);
   bids.add(bid4);
   bids.add(bid5);
   
   
   
   
   
   auctionItem.setBids(bids);
   
   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
   
   Session s = sessionFactory.openSession();
   
   Transaction tx = s.beginTransaction();
   
   s.save(auctionItem);
   
   tx.commit();
   s.close();
   
   
   }
	
	

}
