package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

}
