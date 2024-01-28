package com.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria c = s.createCriteria(Student.class);
//		c.add(Restrictions.eq("certi.course", "Python"));
//		c.add(Restrictions.gt("id", 3));
//		c.add(Restrictions.lt("id", 3));
		c.add(Restrictions.like("certi.course", "Math%"));
		//also available: isNull, notNull, between, like
		List<Student> students = c.list();
		
		for(Student st: students) {
			System.out.println(st);
		}
		
		s.close();
	}
}
