package com.to.Controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.to.Model.todo;
import com.to.Repository.todoRepository;




@Controller
public class MainController {
	
	@Autowired
	todoRepository repository;
	
	
	@RequestMapping(value="/user")
	public ModelAndView welcome(Principal principal) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		mav.addObject("name", principal.getName());
		return mav;
	
	
	 
	}  
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {
		model.setViewName("welcome");
		return model;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add1(@Valid todo Todo,BindingResult result) {
		
		ModelAndView model=new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("welcome");
		}
		else {
			repository.save(Todo);
			model.addObject("msg","successful add!!");
			model.setViewName("welcome");
		}
		return model;
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model,Model model1) {
		model1.addAttribute("lists", repository.findAll());
		model.setViewName("list");
		return model;
		
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView dele(@PathVariable("id") int id,Model model1) {
		ModelAndView model=new ModelAndView();
		todo result=repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	          repository.delete(result);
	          model.setViewName("welcome");
	          return model;
	}
	
}
	

	
	
	

