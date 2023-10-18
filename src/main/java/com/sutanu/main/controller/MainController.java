package com.sutanu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sutanu.main.model.Person;
import com.sutanu.main.model.Programmer;
import com.sutanu.main.repository.ProgrammerRepo;

@Controller
@ControllerAdvice
public class MainController {

	
	@Autowired
	ProgrammerRepo pr;
	
//	@ModelAttribute
//	public void welcome(Model m)
//	{
//		m.addAttribute("m","Welcome Sutanu");
//	}
//	
	
	@GetMapping("/indexPage")
	public String homepage()
	{
		return"programmer.html";
	}
/*	
	@RequestMapping("/RegPage")
	public ModelAndView addPerson(@ModelAttribute Person person)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("details.html");
		
		return mv;
	}
	
	@RequestMapping("/detailsPage")
	public ModelAndView addPerson2(@ModelAttribute Person person)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		
		return mv;
	} 
	
*/	

	// creating new programmer
	@PostMapping("/addedProgrammer")
	public String addedProgrammer(@ModelAttribute Programmer programmer)
	{
		pr.save(programmer);
		// return "ProgrammerInfo.html";
		return"redirect:/indexPage";
	}
	
	// read programmer details by ID
	@PostMapping("/readData")
	public String readProgrammerDetails(@RequestParam int pID, Model m) {
		Programmer p = pr.getOne(pID);
		m.addAttribute("programmer", p);
		return "ProgrammerInfo.html";
	}
	
//	public ModelAndView allProgrammer(Model m)
//	{
//		Model
//	}
}
