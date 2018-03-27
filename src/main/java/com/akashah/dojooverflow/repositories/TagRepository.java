package com.akashah.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.akashah.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository <Tag, Long>{
	
	public Tag findBySubject(String subject);

}
