package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certifcate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Practical of Hibernate Object states:
		//transient
		//persistent
		//detached
		//removed
		
		System.out.println("Example: ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating student object
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certifcate("Java Hibernate Course", "2 Month"));
		//student: transient
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//student: persistent - session. database
		student.setName("John");   //student object is still in session so once commit is done, update will happen in database
		tx.commit();
		
		s.close();   
		//student: detached
		student.setName("Sachin");
		System.out.println(student);
		
		f.close();

	}

}
