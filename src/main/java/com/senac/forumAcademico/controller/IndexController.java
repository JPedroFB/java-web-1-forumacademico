package com.senac.forumAcademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {

	@GetMapping("")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("examples/login");
		return mv;
	
	}
	
	@GetMapping("/perfis")
	public ModelAndView perfis() {
		ModelAndView mv = new ModelAndView("perfis/dashboardPerfis");
		return mv;
	
	}
	
}
