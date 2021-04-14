package com.instructorrob.languagesdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.instructorrob.languagesdemo.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	List<Language> findAll();

}
