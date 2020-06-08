package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

}
