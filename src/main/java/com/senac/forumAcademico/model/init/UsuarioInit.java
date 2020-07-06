package com.senac.forumAcademico.model.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.senac.forumAcademico.model.Usuario;
import com.senac.forumAcademico.repository.UsuarioRepository;

@Component
public class UsuarioInit implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setNomeCompleto("João Pedro Freitas Barros");
		usuario.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		
		usuarioRepository.save(usuario);
	}

}
