package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.model.Pergunta;
import com.senac.forumAcademico.service.ProvaService;
import com.senac.forumAcademico.service.PerguntaService;
import com.senac.forumAcademico.service.RespostaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("pergunta")
public class PerguntaController {

	@Autowired
	ProvaService provaService;
	
	@Autowired
	PerguntaService perguntaService;
	
	@Autowired
	RespostaService respostaService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("pergunta/listaPerguntas");
		mv.addObject("perguntas", perguntaService.listar());
		return mv;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(@RequestParam(name = "prova", required = false) Long prova) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("pergunta/cadastroPergunta");
		mv.addObject("pergunta", new Pergunta());
		mv.addObject("provas", provaService.listar());
		
		if(prova != null) {
			mv.addObject("selecionado", provaService.buscaPorID(prova));
		}
		
		return mv;
	}
	
	@PostMapping("salvar")
	public String salvar(Pergunta pergunta) {
		perguntaService.salvar(pergunta);
		return "redirect:/pergunta";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("pergunta/alterarPergunta");
		mv.addObject("pergunta", perguntaService.buscaPorID(id));	
		mv.addObject("provas", provaService.listar());
		return mv;
	}
	
	
	@PostMapping("/alterar")
	public String alterar(Pergunta pergunta) throws ObjectNotFoundException {
		perguntaService.alterar(pergunta);
		return "redirect:/pergunta";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		try{
			perguntaService.excluir(id);
		}finally {
			return "redirect:/pergunta";			
		}
	}
	
	
	
}
