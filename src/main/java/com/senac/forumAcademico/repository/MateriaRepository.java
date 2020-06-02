package com.senac.forumAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
