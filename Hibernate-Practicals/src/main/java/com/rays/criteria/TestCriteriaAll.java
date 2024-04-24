package com.rays.criteria;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;



public class TestCriteriaAll {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDTO.class);
		
		List list = criteria.list();
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
		
			System.out.println(dto.getId());
			System.out.println("\t" + dto.getFirstName());
			System.out.println("\t" + dto.getLastName());
			System.out.println("\t" + dto.getLoginId());
			System.out.println("\t" + dto.getPassword());
			System.out.println("\t" + dto.getAddress());
			System.out.println("\t" + dto.getDob());

		}
		tx.commit();
		session.close();

	}

}
