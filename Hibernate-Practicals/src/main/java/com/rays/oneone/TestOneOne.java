package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOne {

	public static void main(String[] args) {
		Address empAddress = new Address();
		empAddress.setId(1);
		empAddress.setStreet("VIP Road");
		empAddress.setCity("Bhopal");

		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Gopal");
		employee.setEmpAddress(empAddress);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(employee);

		tx.commit();

		session.close();
	}

}
