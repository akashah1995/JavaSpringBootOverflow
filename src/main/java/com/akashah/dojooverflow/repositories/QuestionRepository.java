package com.akashah.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.akashah.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository <Question, Long>{

}
