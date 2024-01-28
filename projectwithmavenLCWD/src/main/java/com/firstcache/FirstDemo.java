package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//by default enabled
		
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		
		System.out.println("Working something...");
		
		Student student1 = session.get(Student.class, 1);	//here, object from first level cache will be used
		System.out.println(student1);
		System.out.println(session.contains(student1));
		
		session.close();
		factory.close();

	}

}
