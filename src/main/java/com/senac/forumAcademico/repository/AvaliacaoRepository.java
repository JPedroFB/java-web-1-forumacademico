package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.AlunoProva;
import com.senac.forumAcademico.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AlunoProva>{

}
