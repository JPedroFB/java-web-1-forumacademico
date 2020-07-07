package com.senac.forumAcademico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Permissao;

@Repository
public interface PermissaoRepository extends CrudRepository<Permissao, String>{

}
