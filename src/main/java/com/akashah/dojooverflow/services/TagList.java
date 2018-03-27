package com.akashah.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akashah.dojooverflow.models.Tag;
import com.akashah.dojooverflow.repositories.TagRepository;

@Service
public class TagList {
	
	TagRepository tagRepository;
	
	TagList(TagRepository tagRepository){
		this.tagRepository = tagRepository;
	}
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public Tag getTag(Long id) {
		return tagRepository.findOne(id);
	}
	
	public List <Tag> getAll(){
		return (List<Tag>) tagRepository.findAll();
	}
	
	public boolean tagExists(String subject) {
		if (tagRepository.findBySubject(subject) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Tag findTag(String subject) {
		if (tagRepository.findBySubject(subject) != null) {
			return tagRepository.findBySubject(subject);
		}
		
		else {
			return null;
		}
	}


}
