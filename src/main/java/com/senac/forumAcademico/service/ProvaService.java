package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Prova;
import com.senac.forumAcademico.repository.ProvaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProvaService {

	@Autowired
	ProvaRepository provaRepo;
	
	public List<Prova> listar() {
		return provaRepo.findAll();
	}

	public Prova salvar(Prova prova) {
		return provaRepo.save(prova);		
	}

	public void excluir(Long id) {
		provaRepo.deleteById(id);;	
	}
	
	public Prova buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Prova> prova = provaRepo.findById(id);
		return prova.orElseThrow(() -> new ObjectNotFoundException("Prova não encontrado. id:" + id));
	}

	public Prova alterar(Prova provaAlterado) throws ObjectNotFoundException {
		Prova prova = buscaPorID(provaAlterado.getId());
		prova.setNome(provaAlterado.getNome());
		return salvar(prova);
	}	
}
