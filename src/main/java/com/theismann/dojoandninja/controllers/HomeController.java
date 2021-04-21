package com.theismann.dojoandninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theismann.dojoandninja.models.Dojo;
import com.theismann.dojoandninja.models.Ninja;
import com.theismann.dojoandninja.services.DojoNinja_Services;

@Controller
public class HomeController {

	private DojoNinja_Services dnService;

	public HomeController(DojoNinja_Services dnService) {
		super();
		this.dnService = dnService;
	}
	
	// index will show dojos
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", dnService.getAllDojos());
		model.addAttribute("allNinjas", dnService.getAllNinjas());
		return "index.jsp";
	}
	
	//new ninjas and dojos
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dnService.getAllDojos());
		return "newNinja.jsp";
	}
	
	
	//submitting for form
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
        	dnService.create(dojo);
        }
		return "redirect:/";
	}
	
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
        	dnService.create(ninja);
        }
		return "redirect:/";
	}
	
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo myDojo = this.dnService.getDojo(id);
		model.addAttribute("dojo", myDojo);
		model.addAttribute("ninja", dnService.getAllNinjas());
		return "show.jsp";
	}
	
	

}

