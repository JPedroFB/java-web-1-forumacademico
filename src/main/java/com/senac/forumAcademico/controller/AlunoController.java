package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.service.AlunoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("aluno/listaAlunos");
		mv.addObject("alunos", alunoService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("aluno/cadastroAluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Aluno aluno) {
		alunoService.salvar(aluno);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno", alunoService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) throws ObjectNotFoundException {
		alunoService.alterar(aluno);
		return listar();
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			alunoService.excluir(id);
		}finally {
			return listar();			
		}
	}
	
	
}
