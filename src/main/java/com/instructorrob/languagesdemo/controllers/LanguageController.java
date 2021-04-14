package com.instructorrob.languagesdemo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instructorrob.languagesdemo.models.Language;
import com.instructorrob.languagesdemo.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService langService;
	
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	
	
	@RequestMapping("/languages")
	public String home(Model model, @ModelAttribute("language") Language language) {
		
		this.langService.allLangs();
		System.out.println(this.langService.allLangs());
		
		model.addAttribute("allZeLangs", this.langService.allLangs() );
		
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allZeLangs", this.langService.allLangs() );
            return "index.jsp";
        } else {
            this.langService.createLang(language);
            return "redirect:/languages";
        }
	}
	
	@RequestMapping("/languages/edit/{langId}")
	public String editLang(@PathVariable("langId") Long id, Model model) {
		
		Language lang = this.langService.getLang(id);
        model.addAttribute("language", lang);
        
		return "edit.jsp";
	}
	
	@RequestMapping(value = "/languages/{langId}/update", method= RequestMethod.POST)
	public String updateLang(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("langId") Long id) {
		System.out.println(language.getId());
		language.setId(id);
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			System.out.println("HEEYYYYY TRYNA UPDATE!");
			this.langService.updateLang(language);
			return "redirect:/languages";
		}
	}
	
	
	
	
	
	
	
	
//	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/books/edit.jsp";
//        } else {
//            bookService.updateBook(book);
//            return "redirect:/books";
//        }
//    }
	
	
	
	
	
	

}
