package com.senac.forumAcademico.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.senac.forumAcademico.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Optional<Usuario> findByLogin(String login);
	
}
