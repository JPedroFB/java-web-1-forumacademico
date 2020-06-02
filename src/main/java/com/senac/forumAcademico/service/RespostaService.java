package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Resposta;
import com.senac.forumAcademico.model.enuns.StatusAtividade;
import com.senac.forumAcademico.repository.RespostaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class RespostaService {

	@Autowired
	RespostaRepository respostaRepo;

	
	public List<Resposta> listar() {
		return respostaRepo.findAll();
	}

	public Resposta salvar(Resposta resposta) {
		resposta.getAtividade().setStatus(StatusAtividade.RESPONDIDO);
		return respostaRepo.save(resposta);
	}
	
	public void excluir(Long id) {
		respostaRepo.deleteById(id);;	
	}
	
	public Resposta buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Resposta> resposta = respostaRepo.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException("Resposta não encontrado. id:" + id));
	}

	public Resposta alterar(Resposta respostaAlterado) throws ObjectNotFoundException {
		Resposta resposta = buscaPorID(respostaAlterado.getId());
		resposta.setAtividade(respostaAlterado.getAtividade());
		resposta.setDescricao(respostaAlterado.getDescricao());
		resposta.setProfessor(respostaAlterado.getProfessor());
		return salvar(resposta);
	}

}
