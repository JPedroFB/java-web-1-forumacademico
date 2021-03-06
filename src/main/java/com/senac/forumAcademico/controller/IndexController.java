package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.service.AlunoService;
import com.senac.forumAcademico.service.AvaliacaoService;
import com.senac.forumAcademico.service.LoginService;
import com.senac.forumAcademico.service.ProvaService;

@Controller
public class IndexController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProvaService provaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("")
	public String redirect() {
		return "redirect:/login";
	}

	@GetMapping("/dashboard")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("alunos", alunoService.listar());
		mv.addObject("provas", provaService.listar());
		mv.addObject("avaliacoes", avaliacaoService.listar());
		
		return mv;
	}
	
	
	@GetMapping("login")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	
	}
	
//	@PostMapping("/validar")
//	public String login(Aluno aluno) {
//		boolean validado = loginService.login(aluno);
//		if(validado) {
//			return "redirect:/dashboard";
//		}
//		return "redirect:/login";
//	}
	
	@GetMapping("/perfis")
	public ModelAndView perfis() {
		ModelAndView mv = new ModelAndView("perfis/dashboardPerfis");
		return mv;
	
	}
	
}
