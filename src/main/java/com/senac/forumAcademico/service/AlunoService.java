package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Aluno;
import com.senac.forumAcademico.model.enuns.StatusAtividade;
import com.senac.forumAcademico.repository.AlunoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepo;

	public List<Aluno> listar() {
		return alunoRepo.findAll();
	}

	public Aluno salvar(Aluno aluno) {
		return alunoRepo.save(aluno);		
	}

	public void excluir(Long id) {
		alunoRepo.deleteById(id);;	
	}
	
	public Aluno buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Aluno> aluno = alunoRepo.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado. id:" + id));
	}

	public Aluno alterar(Aluno alunoAlterado) throws ObjectNotFoundException {
		Aluno aluno = buscaPorID(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}	
	
}
