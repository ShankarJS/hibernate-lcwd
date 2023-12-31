package com.map.onetomanyfetchtechnq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer_otm_fetch")
public class AnswerOTMFetch {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionOTMFetch question;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public QuestionOTMFetch getQuestion() {
		return question;
	}
	public void setQuestion(QuestionOTMFetch question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public AnswerOTMFetch(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	public AnswerOTMFetch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
