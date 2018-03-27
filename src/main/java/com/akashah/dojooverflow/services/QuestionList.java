package com.akashah.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akashah.dojooverflow.models.Answer;
import com.akashah.dojooverflow.models.Question;
import com.akashah.dojooverflow.repositories.AnswerRepository;
import com.akashah.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionList {
	
	QuestionRepository questionRepository;
	
	AnswerRepository answerRepository;
	
	QuestionList(QuestionRepository questionRepository, AnswerRepository answerRepository){
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public Question getQuestion(Long id) {
		return questionRepository.findOne(id);
	}
	
	public List <Question> getAll(){
		return (List<Question>) questionRepository.findAll();
	}
	
	public void addAnswertoQuestion(Question question, Answer answer) {
//		question.addAnswer(answer);
		answer.setQuestion(question);
		answerRepository.save(answer);
//		questionRepository.save(question);
	}

}
