package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		//SQL query, so student will be table name, not Entity name
		String q = "select * from student";
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> list = nq.list();
		
		for(Object[] student: list) {
//			System.out.println(Arrays.toString(student));
			System.out.println(student[4]+ " : "+student[3]);   //here we are printing the columns data
		}
		
		s.close();
		factory.close();
		
	}
}
