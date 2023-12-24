package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sFactory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(1111);
		q1.setQuestion("What is java?");
		
		Answer a1 = new Answer();
		a1.setAnswerId(2111);
		a1.setAnswer("Java is a programming language");
		a1.setQuestion(q1);
		q1.setAnswer(a1);
		
		Question q2 = new Question();
		q2.setQuestionId(1112);
		q2.setQuestion("What is Collection framework");
		
		Answer a2 = new Answer();
		a2.setAnswerId(2112);
		a2.setAnswer("API to work with objects in java");
		a2.setQuestion(q2);
		q2.setAnswer(a2);
		
		Session s = sFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(q1);
		s.save(q2);
		s.save(a1);
		s.save(a2);
		
		tx.commit();
		s.close();
		sFactory.close();

	}

}
