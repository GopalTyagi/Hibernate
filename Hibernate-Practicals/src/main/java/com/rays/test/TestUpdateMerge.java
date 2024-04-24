package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestUpdateMerge {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		UserDTO dto = (UserDTO) session.get(UserDTO.class, 1);

		session.close();

		dto.setFirstName("Gopi");

		Session session1 = factory.openSession();

		Transaction tx = session1.beginTransaction();

	//	session1.merge(dto);

		session1.update(dto);

		tx.commit();

		session1.close();

	}

}
