package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestFlush {
	public static void main(String[] args) {
		UserDTO dto = new UserDTO();

		dto.setId(4);
		dto.setFirstName("Gopal");
		dto.setLastName("TYagi");
		dto.setLoginId("gopal@gmail.com");
		dto.setPassword("Gopi1234");
		dto.setAddress("Indore");
		dto.setDob(new Date());

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		session.flush();

		System.out.println("ID = " + dto.getId());

		dto = (UserDTO) session.get(UserDTO.class, 2);

		System.out.println("FirstName = " + dto.getFirstName());

		tx.commit();

		session.close();

	}

}
