package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestGetLoad {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		// UserDTO dto = (UserDTO) session.load(UserDTO.class, 3);

		UserDTO dto = (UserDTO) session.get(UserDTO.class, 3);

		System.out.println(dto.getFirstName());

	}

}
