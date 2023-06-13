package com.rays.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestMarksheet {

	public static void main(String[] args) {

		//testAdd();
		//testSelect();
		//testWhere();
		//testColumn();
		//testOrderBy();
        testCriteria();
	}

	private static void testCriteria() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Marksheet ms = new Marksheet();

		Query q = s.createQuery("from Marksheet where name like '%al'");
		
		Criteria cr = s.createCriteria(Marksheet.class);
		
		/*
		 * cr.add(Restrictions.like("name", "a%")); cr.add(Restrictions.eq("id", 3));
		 */
		
		
		/*
		 * cr.add(Restrictions.or(Restrictions.like("name", "al%"),
		 * Restrictions.eq("physics", "80")));
		 */
		
		
		/*
		 * cr.addOrder(Order.asc("name")); cr.addOrder(Order.desc("id"));
		 */
		
		
		/*
		 * cr.setMaxResults(2); cr.setFirstResult(0);
		 */
		
		
		
		/*
		 * ProjectionList pj = Projections.projectionList();
		 * pj.add(Projections.count("id")); pj.add(Projections.rowCount());
		 * pj.add(Projections.groupProperty("chemistry"));
		 * 
		 */
	
		
		
		
		List list = cr.list();
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			ms = (Marksheet) it.next();
			
			
			System.out.print(ms.getId()+"\t");
			//System.out.print(ms.getName()+"\t");
			//System.out.print(ms.getPhysics()+"\t");
			//System.out.print(ms.getChemistry()+"\t");
			//System.out.println(ms.getMaths());
			
			
		}
		
		
	}

	private static void testOrderBy() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Marksheet ms = new Marksheet();

		Query q = s.createQuery("from Marksheet where physics>=90 and chemistry>=80 order by name");
		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			ms = (Marksheet) it.next();
			System.out.println(ms.getId() + " " + ms.getName() + " " + ms.getPhysics() + " " + ms.getChemistry() + " "
					+ ms.getMaths());

		}
		tx.commit();
		s.close();

	}

	private static void testColumn() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Marksheet ms = new Marksheet();

		Query q = s.createQuery("select m.id , m.name from Marksheet m");
		List rows = q.list();

		Iterator it = rows.iterator();
		Object[] columns;

		while (it.hasNext()) {
			columns = (Object[]) it.next();
			Integer id = (Integer) columns[0];
			String name = (String) columns[1];

			System.out.println(id + " " + name);

			tx.commit();
			s.close();
		}

	}

	private static void testWhere() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Marksheet ms = new Marksheet();

		Query q = s.createQuery("from Marksheet where ID =1");
		List list = q.list();

		ms = (Marksheet) list.get(0);
		System.out.println(ms.getId() + " " + ms.getName() + " " + ms.getPhysics() + " " + ms.getChemistry() + " "
				+ ms.getMaths());

		tx.commit();
		s.close();

	}

	private static void testSelect() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Marksheet ms = new Marksheet();

		Query q = s.createQuery("from Marksheet");
		List list = q.list();

		ms = (Marksheet) list.get(2);
		System.out.println(ms.getId() + " " + ms.getName() + " " + ms.getPhysics() + " " + ms.getChemistry() + " "
				+ ms.getMaths());

		tx.commit();
		s.close();

	}

	private static void testAdd() {

		Marksheet ms = new Marksheet();
		ms.setId(4);
		ms.setName("darshan");
		ms.setPhysics(99);
		ms.setChemistry(70);
		ms.setMaths(88);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		s.save(ms);

		tx.commit();
		s.close();

	}

}
