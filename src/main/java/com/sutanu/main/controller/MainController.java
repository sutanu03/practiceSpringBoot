package com.sutanu.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// read programmer details by Language
		@PostMapping("/readDataByLang")
		public String readProgrammerDetailsByLang(@RequestParam String pLang, Model m) {
			//for auto query dsl
			//List<Programmer> p = pr.findBypLang(pLang);
			
			//for query annotation and custom query way
			List<Programmer> p = pr.findName(pLang);
			m.addAttribute("programmers", p);
			return "allProgrammers.html";
		}
	
	// update programmer details
	@PostMapping("/updateData")
	public String updateProgrammer(@ModelAttribute Programmer programmer)
	{
		Programmer p = pr.getOne(programmer.getpID());
		
		p.setpName(programmer.getpName());
		p.setpLang(programmer.getpLang());
		
		pr.save(programmer);
		
		return "ProgrammerInfo.html";
	}
	
	// delete programmer details by ID
		@GetMapping("/deleteData")
		public String deleteProgrammerDetails(@RequestParam int pID) {
			pr.deleteById(pID);
			return"redirect:/indexPage";
		}
	
//	public ModelAndView allProgrammer(Model m)
//	{
//		Model
//	}
}
