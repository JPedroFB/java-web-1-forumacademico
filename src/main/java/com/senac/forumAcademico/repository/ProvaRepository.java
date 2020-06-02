package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Prova;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long>{

}
