package com.senac.forumAcademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.forumAcademico.model.Materia;
import com.senac.forumAcademico.service.MateriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("materia")
public class MateriaController {

	@Autowired
	MateriaService materiaService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("materia/listaMaterias");
		mv.addObject("materias", materiaService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("materia/cadastroMateria");
		mv.addObject("materia", new Materia());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Materia materia) {
		materiaService.salvar(materia);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("materia/alterarMateria");
		mv.addObject("materia", materiaService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Materia materia) throws ObjectNotFoundException {
		materiaService.alterar(materia);
		return listar();
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			materiaService.excluir(id);
		}finally {
			return listar();			
		}
	}
	
	
}
