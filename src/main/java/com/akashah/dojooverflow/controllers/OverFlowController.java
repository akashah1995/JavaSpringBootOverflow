package com.akashah.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akashah.dojooverflow.models.*;
import com.akashah.dojooverflow.services.*;

@Controller
public class OverFlowController {
	
	TagList tagList;
	QuestionList questionList;
	AnswerList answerList;
	
	
	OverFlowController(TagList tagList, QuestionList questionList, AnswerList answerList){
		this.tagList = tagList;
		this.questionList = questionList;
		this.answerList = answerList;

	}
	
	@RequestMapping("/questions/dashboard")
	public String questionDashboard(Model model) {
		List <Question> questions = questionList.getAll();
		model.addAttribute("questions", questions);
		return "questionDashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion() {
		return "questions.jsp";
	}
	
	@PostMapping("/questions/add")
	public String addQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags) {
		Question newQuestion = new Question(question);
		String[] stringTags = tags.split(" ");
		System.out.println(stringTags[0]);
		List <Tag> tagsForQuestion = new ArrayList <Tag> ();
		
		for (int i = 0; i < stringTags.length; i++) {
			if (tagList.tagExists(stringTags[i])) {
				Tag existingTag = tagList.findTag(stringTags[i]);
				tagsForQuestion.add(existingTag);
			}
			
			else {
				Tag newTag = new Tag(stringTags[i]);
				tagList.addTag(newTag);
				tagsForQuestion.add(newTag);
			}
			
		}
		
		newQuestion.setTags(tagsForQuestion);
		questionList.addQuestion(newQuestion);
		
		return "redirect:/questions/dashboard";
		
	}
	
	@RequestMapping("/questions/{id}")
	public String questionDetails(@PathVariable("id") String id, Model model) {
		int intId = Integer.parseInt(id);
		long questionId = (long) intId;
		Question question = questionList.getQuestion(questionId);
		
		List <Answer> answers = question.getAnswers();
		if (answers.isEmpty()) {
			
		}
		
		else {
			System.out.println(answers.get(0));
		}
		model.addAttribute("question", question);
		
		return "questionDetails.jsp";
		
	}
	
	@PostMapping("/questions/{id}/answer")
	public String questionAnswer(@PathVariable("id") String id, @RequestParam("answer") String answer, Model model) {
		int intId = Integer.parseInt(id);
		long questionId = (long) intId;
		Question question = questionList.getQuestion(questionId);
		List <Answer> answers = question.getAnswers();
		Answer answerObj = new Answer(answer);
		answerList.addAnswer(answerObj);
//		System.out.println(answerObj);
//		answers.add(answerObj);
//		question.setAnswers(answers);
//		questionList.addQuestion(question);
	
		questionList.addAnswertoQuestion(question, answerObj);
		
		
		return "redirect:/questions/" + questionId;
		
	}

}
