package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long>{

}
