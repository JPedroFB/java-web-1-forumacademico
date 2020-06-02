package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Professor;
import com.senac.forumAcademico.repository.ProfessorRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepo;

	public List<Professor> listar() {
		return professorRepo.findAll();
	}

	public Professor salvar(Professor professor) {
		return professorRepo.save(professor);		
	}

	public void excluir(Long id) {
		professorRepo.deleteById(id);;	
	}
	
	public Professor buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Professor> professor = professorRepo.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado. id:" + id));
	}

	public Professor alterar(Professor professorAlterado) throws ObjectNotFoundException {
		Professor professor = buscaPorID(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return salvar(professor);
	}
	
	
	
}
