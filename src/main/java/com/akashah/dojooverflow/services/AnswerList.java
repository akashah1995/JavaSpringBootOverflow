package com.akashah.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.*;

import com.akashah.dojooverflow.models.Answer;
import com.akashah.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerList {
	AnswerRepository answerRepository;
	
	AnswerList(AnswerRepository answerRepository){
		this.answerRepository = answerRepository;
	}
	
	public void addAnswer(Answer answer){
		answerRepository.save(answer);
	}
	
	public Answer getAnswer(Long id) {
		return answerRepository.findOne(id);
	}
	
	public List <Answer> getAll() {
		return (List<Answer>) answerRepository.findAll();
	}

}
