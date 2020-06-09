package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Professor;
import com.senac.forumAcademico.service.ProfessorService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("professor/listaProfessores");
		mv.addObject("professores", professorService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("professor/cadastroProfessor");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor professor) {
		professorService.salvar(professor);
		return "redirect:/professor";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("professor/alterarProfessor");
		mv.addObject("professor", professorService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public String alterar(Professor professor) throws ObjectNotFoundException {
		professorService.alterar(professor);
		return "redirect:/professor";
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		try{
			professorService.excluir(id);
		}finally {
			return "redirect:/professor";			
		}
	}
	
	
}
