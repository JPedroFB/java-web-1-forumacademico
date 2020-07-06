package com.senac.forumAcademico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Usuario findByLogin(String login);
	
}
