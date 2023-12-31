package com.map.onetomany;

import java.util.ArrayList;
import java.util.List;

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
		
		QuestionOTM q1 = new QuestionOTM();
		q1.setQuestionId(1);
		q1.setQuestion("What is java?");
		
		AnswerOTM a1 = new AnswerOTM();
		a1.setAnswerId(11);
		a1.setAnswer("Java is a programming language");
		a1.setQuestion(q1);
		
		AnswerOTM a2 = new AnswerOTM();
		a2.setAnswerId(12);
		a2.setAnswer("With the help of java we can create software");
		a2.setQuestion(q1);
		
		AnswerOTM a3 = new AnswerOTM();
		a3.setAnswerId(13);
		a3.setAnswer("Java has different types of frameworks");
		a3.setQuestion(q1);

		List<AnswerOTM> list = new ArrayList<AnswerOTM>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswers(list);
		
		Session s = sFactory.openSession();
		Transaction tx = s.beginTransaction();
		//save
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
		
		//fetching:
//		QuestionOTM readQuestion = (QuestionOTM)s.get(QuestionOTM.class, 1);
//		System.out.println(readQuestion.getQuestion());
//		for (AnswerOTM a : readQuestion.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}
		
		tx.commit();
		
		s.close();
		sFactory.close();

	}

}
