package com.rays.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestNamedQuery {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	Session session = sf.openSession();
	
	Query q = session.getNamedQuery("allUser");
	
	/*List list = q.list();
	
	Iterator it = list.iterator();
	
	while (it.hasNext()) {
		UserDTO user = (UserDTO) it.next();

		System.out.print(user.getId() + "\t");
		System.out.print(user.getName() + "\t");
		System.out.println(user.getLoginid() + "\t");
		System.out.println(user.getPassword() + "\t");
	}
	session.close();
*/
}

