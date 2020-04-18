package com.senac.forumAcademico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> buscarTodos() {
		return alunoRepository.findAll();
	}
	
	
	
	
}
