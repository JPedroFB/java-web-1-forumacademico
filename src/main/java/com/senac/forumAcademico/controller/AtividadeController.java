package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Atividade;
import com.senac.forumAcademico.service.AlunoService;

@Controller
@RequestMapping("atividade")
public class AtividadeController {

	@Autowired
	AlunoService alunoService;
	
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ativade/listaAtividades");
		mv.addObject("atividade", new Atividade());
		mv.addObject("aluno", alunoService.buscarTodos());
		return mv;
	}
	
	
}
