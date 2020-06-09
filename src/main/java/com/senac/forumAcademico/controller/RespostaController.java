package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Resposta;
import com.senac.forumAcademico.service.PerguntaService;
import com.senac.forumAcademico.service.ProfessorService;
import com.senac.forumAcademico.service.RespostaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("resposta")
public class RespostaController {

	@Autowired
	ProfessorService professorService;
	
	@Autowired
	PerguntaService perguntaService;
	
	@Autowired
	RespostaService respostaService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("resposta/listaRespostas");
		mv.addObject("respostas", respostaService.listar());
		return mv;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("resposta/cadastroResposta");
		mv.addObject("resposta", new Resposta());
		mv.addObject("professores", professorService.listar());
		mv.addObject("perguntas", perguntaService.listar());
		return mv;
	}
	
	@PostMapping("salvar")
	public String salvar(Resposta resposta) {
		respostaService.salvar(resposta);
		return "redirect:/resposta";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("resposta/alterarResposta");
		mv.addObject("resposta", respostaService.buscaPorID(id));	
		mv.addObject("professores", professorService.listar());
		mv.addObject("perguntas", perguntaService.listar());
		return mv;
	}
	
	@PostMapping("/alterar")
	public String alterar(Resposta resposta) throws ObjectNotFoundException {
		respostaService.alterar(resposta);
		return "redirect:/resposta";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		try{
			respostaService.excluir(id);
		}finally {
			return "redirect:/resposta";			
		}
	}
	
	
}
