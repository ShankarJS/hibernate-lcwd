package com.map.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_otm")
public class QuestionOTM {
	@Id
	@Column(name= "question_id")
	private int questionId;
	private String question;
	
	//mappedBy will ensure no foreign key column is created in question_otm table, but in answer_otm table only and also no extra table with only ids be created
	@OneToMany(mappedBy="question")
	private List<AnswerOTM> answers;
	
	public List<AnswerOTM> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerOTM> answers) {
		this.answers = answers;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public QuestionOTM(int questionId, String question, List<AnswerOTM> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	public QuestionOTM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
