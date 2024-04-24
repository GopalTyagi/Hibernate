package com.rays.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestFirstLevel {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();// Begin a unit of work and return the associated Transaction object

		UserDTO dto = (UserDTO) session.get(UserDTO.class, 1); // Return the persistent instance of the given entity
																// class with the given identifier,or null if there is
																// no such persistent instance

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLoginId());
		System.out.print("\t" + dto.getPassword());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());

		session.evict(dto); // Remove this instance from the session cache

		UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLoginId());
		System.out.print("\t" + dto.getPassword());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());

		tx.commit(); // Flush the associated Session and end the unit of work
		session.close(); // End the session by releasing the JDBC connection and cleaning up

	}

}
