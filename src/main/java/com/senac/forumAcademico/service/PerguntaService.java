package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Pergunta;
import com.senac.forumAcademico.repository.PerguntaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PerguntaService {

	@Autowired
	PerguntaRepository perguntaRepo;

	
	public List<Pergunta> listar() {
		return perguntaRepo.findAll();
	}

	public Pergunta salvar(Pergunta pergunta) {
		return perguntaRepo.save(pergunta);
	}
	
	public void excluir(Long id) {
		perguntaRepo.deleteById(id);;	
	}
	
	public Pergunta buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Pergunta> pergunta = perguntaRepo.findById(id);
		return pergunta.orElseThrow(() -> new ObjectNotFoundException("Pergunta não encontrado. id:" + id));
	}

	public Pergunta alterar(Pergunta perguntaAlterado) throws ObjectNotFoundException {
		Pergunta pergunta = buscaPorID(perguntaAlterado.getId());
		pergunta.setDescricao(perguntaAlterado.getDescricao());
		pergunta.setProva(perguntaAlterado.getProva());
		pergunta.setRespostas(perguntaAlterado.getRespostas());
		return salvar(pergunta);
	}

}
