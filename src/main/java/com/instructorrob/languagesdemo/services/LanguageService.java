package com.instructorrob.languagesdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.instructorrob.languagesdemo.models.Language;
import com.instructorrob.languagesdemo.repositories.LanguageRepository;


@Service
public class LanguageService {
	
	private final LanguageRepository langRepository;
	
	public LanguageService(LanguageRepository langRepository) {
		this.langRepository = langRepository;
	}
	
	//GETS ALL LANGUAGES FROM REPOSITORY (CHEF)
	public List<Language> allLangs(){
		return this.langRepository.findAll();
	}
	
	//CREATES A LANGUAGE
	public Language createLang(Language l) {
		return this.langRepository.save(l);
	}
	
	//GET ONE LANGUAGE
	public Language getLang(Long id) {
		return this.langRepository.findById(id).orElse(null);
	}
	
	
	
	public Language updateLang(Long id,String name, String creator, Float currentVersion) {
    	Language toUpdate = this.langRepository.findById(id).orElse(null);
    	if(toUpdate == null) {
    		return null;
    	}else {
    		
    		toUpdate.setCreator(creator);
    		toUpdate.setName(name);
    		toUpdate.setCurrentVersion(currentVersion);
    		
    		return this.langRepository.save(toUpdate);
    		
    	}
    	
    }
	
	//UPDATE A LANGUAGE
	public Language updateLang(Language lang) {
		System.out.println(lang.toString());
//		return this.langRepository.save(lang);
		return this.langRepository.save(lang);
	}
	
	
	
	
	
}



//
//import org.springframework.stereotype.Service;
//import com.codingdojo.mvc.models.Book;
//@Service
//public class BookService {
//    // adding the book repository as a dependency
//    private final BookRepository bookRepository;
//    
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    // returns all the books
//    public List<Book> allBooks() {
//        return bookRepository.findAll();
//    }
//    // creates a book
//    public Book createBook(Book b) {
//        return bookRepository.save(b);
//    }
//    // retrieves a book
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
//}