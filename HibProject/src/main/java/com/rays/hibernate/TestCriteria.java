package com.rays.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestCriteria {

	public static void main(String[] args) {

	//	testprojections();
	//	testand();
	//	testget();
	//	testDetachedCriteria();
	//	testor();
	//	testOrderBy();
	//	testRestrictionsequals();
		testRestrictions();
	}

	private static void testDetachedCriteria() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);
		 
		List list = crit.list();
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();
		

		Session session1 = sf.openSession();

		Criteria crit1 = session.createCriteria(UserDTO.class);
		

		
		  crit1.addOrder(Order.asc("name")); 
		  crit1.setMaxResults(3);
			List list1 = crit1.list();

			Iterator its = list1.iterator();

			while (its.hasNext()) {
				UserDTO user = (UserDTO) its.next();

				System.out.print(user.getId() + "\t");
				System.out.print(user.getName() + "\t");
				System.out.println(user.getLoginid() + "\t");
				System.out.println(user.getPassword() + "\t");
			}
			session.close();

		}

	private static void testRestrictions() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);
		
		crit.add(Restrictions.like("name", "o%"));

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

	}


	private static void testRestrictionsequals() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);

		crit.add(Restrictions.eq("name", "gopal"));

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

	}



	private static void testprojections() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);

		ProjectionList pj = Projections.projectionList();

		pj.add(Projections.count("id"));
		pj.add(Projections.rowCount());

		pj.add(Projections.groupProperty("name"));

		crit.setProjection(pj);

		List rows = crit.list();

		Iterator it = rows.iterator();

		Object[] columns;

		while (it.hasNext()) {
			columns = (Object[]) it.next();
			Integer id = (Integer) columns[0];
			String name = (String) columns[1];

			System.out.println(id + " " + name);

			session.close();
		}

	}

	private static void testand() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();
		Criteria crit = session.createCriteria(UserDTO.class);

		crit.add(Restrictions.eq("name", "rohit"));
		crit.add(Restrictions.like("password", "1234"));

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

	}

	private static void testor() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();
		Criteria crit = session.createCriteria(UserDTO.class);

		/*
		 * crit.add(Restrictions.or(Restrictions.like("name", "al%"),
		 * Restrictions.eq("loginid", "gopal@gamil.com")));
		 */

		/*
		 * crit.add(Restrictions.or(Restrictions.like("name",
		 * "gopal"),Restrictions.eq("loginid", "gopal@gmail.com")));
		 */

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

	}

	private static void testOrderBy() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);

		crit.addOrder(Order.asc("name"));

		crit.setMaxResults(2);

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

	}

	private static void testget() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		Criteria crit = session.createCriteria(UserDTO.class);
		

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();

			System.out.print(user.getId() + "\t");
			System.out.print(user.getName() + "\t");
			System.out.println(user.getLoginid() + "\t");
			System.out.println(user.getPassword() + "\t");
		}
		session.close();

		
		

	}

}
