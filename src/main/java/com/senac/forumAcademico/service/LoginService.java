package com.senac.forumAcademico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.repository.AlunoRepository;

@Service
public class LoginService {
	
	@Autowired
	AlunoRepository alunoRepo;
	
	public boolean login(Aluno aluno) {
		Aluno alunoAutenticado = alunoRepo.findByEmailAndNome(aluno.getEmail(), aluno.getNome());
		if(alunoAutenticado != null) {
			return true;
		}
		return false;
	}
}
