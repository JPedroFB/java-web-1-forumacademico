package com.senac.forumAcademico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.forumAcademico.model.Atividade;
import com.senac.forumAcademico.repository.AtividadeRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AtividadeService {

	@Autowired
	AtividadeRepository atividadeRepo;

	
	public List<Atividade> listar() {
		return atividadeRepo.findAll();
	}

	public Atividade salvar(Atividade atividade) {
		return atividadeRepo.save(atividade);
	}
	
	public void excluir(Long id) {
		atividadeRepo.deleteById(id);;	
	}
	
	public Atividade buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Atividade> atividade = atividadeRepo.findById(id);
		return atividade.orElseThrow(() -> new ObjectNotFoundException("Atividade não encontrado. id:" + id));
	}

	public Atividade alterar(Atividade atividadeAlterado) throws ObjectNotFoundException {
		Atividade atividade = buscaPorID(atividadeAlterado.getId());
		atividade.setTopico(atividadeAlterado.getTopico());
		atividade.setAluno(atividadeAlterado.getAluno());
		atividade.setDescricao(atividadeAlterado.getDescricao());
		return salvar(atividade);
	}

}
