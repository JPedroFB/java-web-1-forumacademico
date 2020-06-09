package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.AlunoProva;
import com.senac.forumAcademico.model.Avaliacao;
import com.senac.forumAcademico.repository.AvaliacaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository avaliacaoRepo;
	
	public List<Avaliacao> listar() {
		return avaliacaoRepo.findAll();
	}

	public Avaliacao salvar(Avaliacao avaliacao) {
		return avaliacaoRepo.save(avaliacao);		
	}

	public void excluir(AlunoProva alunoProva) {
		avaliacaoRepo.deleteById(alunoProva);;	
	}
	
	public Avaliacao buscaPorID(AlunoProva alunoProva) throws ObjectNotFoundException {
		Optional<Avaliacao> avaliacao = avaliacaoRepo.findById(alunoProva);
		return avaliacao.orElseThrow(() -> new ObjectNotFoundException("Avaliacao não encontrado. id:" + alunoProva));
	}

}
