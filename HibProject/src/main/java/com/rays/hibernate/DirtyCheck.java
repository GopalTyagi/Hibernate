package com.rays.hibernate;




import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

public class DirtyCheck {
	
	
	public static void main(String[] args) {
		
	
	String newDescription = "XYZ";
	
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	   
	   Session s = sessionFactory.openSession();
	   
	   Transaction tx = s.beginTransaction();
	   
	   
	  AuctionItem item = ( AuctionItem)s.get( AuctionItem.class,2L);
	
     item.setDescription(newDescription);
	  
	/*  Set st = item.getBids();
	  st.add
     */
     tx.commit();
     s.close();
     
}
	}

