package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
