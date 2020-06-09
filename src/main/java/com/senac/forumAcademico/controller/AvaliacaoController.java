package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.model.AlunoProva;
import com.senac.forumAcademico.model.Avaliacao;
import com.senac.forumAcademico.service.AlunoService;
import com.senac.forumAcademico.service.AvaliacaoService;
import com.senac.forumAcademico.service.ProvaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("avaliacoes")
public class AvaliacaoController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProvaService provaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("avaliacoes/listaAvaliacoes");
		mv.addObject("avaliacoes", avaliacaoService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("avaliacoes/cadastrarAvaliacao");
		mv.addObject("avaliacao", new Avaliacao());
		mv.addObject("alunos", alunoService.listar());
		mv.addObject("provas", provaService.listar());	
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(Avaliacao avaliacao) {
		avaliacaoService.salvar(avaliacao);
		return "redirect:/avaliacoes";
	}
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{alunoProva}")
	public String excluir(@PathVariable("alunoProva") AlunoProva alunoProva) {
		try{
			avaliacaoService.excluir(alunoProva);
		}finally {
			return "redirect:/avaliacoes";			
		}
	}
 
	
}
