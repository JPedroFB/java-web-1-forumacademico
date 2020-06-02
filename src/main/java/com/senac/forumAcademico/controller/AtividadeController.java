package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Atividade;
import com.senac.forumAcademico.service.AlunoService;
import com.senac.forumAcademico.service.AtividadeService;
import com.senac.forumAcademico.service.RespostaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("atividade")
public class AtividadeController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	AtividadeService atividadeService;
	
	@Autowired
	RespostaService respostaService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("atividade/listaAtividades");
		mv.addObject("atividades", atividadeService.listar());
//		mv.addObject("respostas", respostaService.listar());
		return mv;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("atividade/cadastroAtividade");
		mv.addObject("atividade", new Atividade());
		mv.addObject("alunos", alunoService.listar());
		return mv;
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Atividade atividade) {
		atividadeService.salvar(atividade);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("atividade/alterarAtividade");
		mv.addObject("atividade", atividadeService.buscaPorID(id));	
		mv.addObject("alunos", alunoService.listar());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Atividade atividade) throws ObjectNotFoundException {
		atividadeService.alterar(atividade);
		return listar();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			atividadeService.excluir(id);
		}finally {
			return listar();			
		}
	}
	
	
	
}
