package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//#9. Embedding Objects | Hibernate Tutorial | hindi
public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(14124);
		student1.setName("Ankit tiwari");
		student1.setCity("Delhi");
		
		Certifcate certificate1 = new Certifcate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 Months");
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(2123);
		student2.setName("Ravi tiwari");
		student2.setCity("LKO");
		
		Certifcate certificate2 = new Certifcate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 Months");
		student2.setCerti(certificate2);
		
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		tnx.commit();
		session.close();
		sessionFactory.close();
		
	}
}
