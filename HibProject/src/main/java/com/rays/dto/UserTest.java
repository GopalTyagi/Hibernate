package com.rays.dto;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserTest {
	

	public static void main(String[] args) {

		 testAdd();
		// testupdate();
		// testdelete();
      //  testget();
		//testAuthenticate("gopal@gmail.com", "1234");
		//testlist();
	}

	private static void testlist() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		 Session s = sessionFactory.openSession();
		 Query q = s.createQuery("from UserDTO");
		 
		 List l = q.list();
		 Iterator it = l.iterator();
		 UserDTO dto = null;
		 
		 while(it.hasNext()) {
			 dto = (UserDTO) it.next();
			 System.out.print(dto.getId()+ "\t");
			 System.out.print(dto.getName()+ "\t");
			 System.out.print(dto.getLoginid()+ "\t");
			 System.out.println(dto.getPassword()+ "\t");
			 
		 }
		 s.close();
		 
		 
	}

	private static void testAuthenticate(String loginid , String pwd) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		 Session s = sessionFactory.openSession();
		 Query q = s.createQuery("from UserDTO where loginid=? and password=?");
		 q.setString(0, loginid);
		 q.setString(1, pwd);
		 
		List list = q.list();
		UserDTO dto = null;
		if(list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}else {
			
		}
		 
		 s.close();
	}

	private static void testget() {
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		 Session s = sessionFactory.openSession();
		
		UserDTO dto = (UserDTO) s.get(UserDTO.class,2);
		
		System.out.print("ID=" + dto.getId() + "\t");
		System.out.print("NAME=" +dto.getName()+ "\t");
		System.out.print("LOGINID=" +dto.getLoginid()+ "\t");	
	    System.out.print("PASSWORD=" +dto.getPassword()+ "\t");	
	
	}

	private static void testdelete() {

		UserDTO dto = new UserDTO();

		dto.setId(4);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.delete(dto);
		tx.commit();
		s.close();

	}

	private static void testupdate() {
 
		UserDTO dto = new UserDTO();

		dto.setId(3);
		dto.setName("Mangal");
		dto.setLoginid("mangal@gmail.com");
		dto.setPassword("1234");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionfactory.openSession();

		Transaction tx = s.beginTransaction();

		s.update(dto);
		tx.commit();
		s.close();

	}

	private static void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setName("rohit");
		dto.setLoginid("rohit@gmail.com");
		dto.setPassword("1234");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionfactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(dto);

		tx.commit();
		s.close();

	}

}
