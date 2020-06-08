package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.service.AlunoService;
import com.senac.forumAcademico.service.AvaliacaoService;
import com.senac.forumAcademico.service.ProvaService;

@Controller
public class IndexController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProvaService provaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("")
	public String redirect() {
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("alunos", alunoService.listar());
		mv.addObject("provas", provaService.listar());
		mv.addObject("avaliacoes", avaliacaoService.listar());
		
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
