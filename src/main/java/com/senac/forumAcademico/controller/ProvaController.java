package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Prova;
import com.senac.forumAcademico.service.ProvaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/provas")
public class ProvaController {

	@Autowired
	ProvaService provaService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("prova/listarProvas");
		mv.addObject("provas", provaService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("prova/cadastrarProva");
		mv.addObject("prova", new Prova());
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(Prova prova) {
		provaService.salvar(prova);
		return "redirect:/provas";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("prova/alterarProva");
		mv.addObject("prova", provaService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public String alterar(Prova prova) throws ObjectNotFoundException {
		provaService.alterar(prova);
		return "redirect:/provas";
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		try{
			provaService.excluir(id);
		}finally {
			return "redirect:/provas";			
		}
	}
	
	
}
