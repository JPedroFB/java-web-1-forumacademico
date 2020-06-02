package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Materia;
import com.senac.forumAcademico.repository.MateriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MateriaService {

	@Autowired
	MateriaRepository materiaRepo;

	public List<Materia> listar() {
		return materiaRepo.findAll();
	}

	public Materia salvar(Materia materia) {
		return materiaRepo.save(materia);		
	}

	public void excluir(Long id) {
		materiaRepo.deleteById(id);;	
	}
	
	public Materia buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Materia> materia = materiaRepo.findById(id);
		return materia.orElseThrow(() -> new ObjectNotFoundException("Materia não encontrado. id:" + id));
	}

	public Materia alterar(Materia materiaAlterado) throws ObjectNotFoundException {
		Materia materia = buscaPorID(materiaAlterado.getId());
		materia.setNome(materiaAlterado.getNome());
		return salvar(materia);
	}
	
	
	
}
