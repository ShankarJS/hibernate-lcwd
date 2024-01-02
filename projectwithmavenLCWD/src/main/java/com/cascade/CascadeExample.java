package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.onetomany.AnswerOTM;
import com.map.onetomany.QuestionOTM;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		QuestionOTM q1 = new QuestionOTM();
		q1.setQuestionId(5625);
		q1.setQuestion("What is Swing framework?");
		
		AnswerOTM a1 = new AnswerOTM(23423, "Used for development");
		AnswerOTM a2 = new AnswerOTM(255, "Desktop");
		AnswerOTM a3 = new AnswerOTM(35, "Learned by programmers");
		List<AnswerOTM> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		s.save(q1);
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		tx.commit();
		
		s.close();
		factory.close();
	}

}
