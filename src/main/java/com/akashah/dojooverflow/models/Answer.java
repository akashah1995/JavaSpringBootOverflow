package com.akashah.dojooverflow.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String answer;
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	private Question question;
	
	Answer(){}
	
	public Answer(String answer){
		this.answer = answer;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	
	
	
	

}
