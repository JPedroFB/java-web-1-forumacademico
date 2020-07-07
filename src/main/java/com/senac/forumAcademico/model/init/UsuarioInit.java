package com.senac.forumAcademico.model.init;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.senac.forumAcademico.model.Permissao;
import com.senac.forumAcademico.model.Role;
import com.senac.forumAcademico.model.Usuario;
import com.senac.forumAcademico.repository.PermissaoRepository;
import com.senac.forumAcademico.repository.RoleRepository;
import com.senac.forumAcademico.repository.UsuarioRepository;

@Component
public class UsuarioInit implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PermissaoRepository permRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setNomeCompleto("João Pedro Freitas Barros");
		usuario.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		Role roleAdmin = new Role();
		roleAdmin.setNameRole("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		usuario.setRoles(Arrays.asList(roleAdmin));
		usuarioRepository.save(usuario);
		
		
//		Permissao permitionUser = new Permissao();
//		permitionUser.setNomePermissao("insert");
//		permRepository.save(permitionUser);
//		usuario.setPermissoes(Arrays.asList(permitionUser));
//		
		
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("teacher");
		usuario2.setNomeCompleto("teacher");
		usuario2.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		Role roleUser = new Role();
		roleUser.setNameRole("ROLE_TEACHER");
		roleRepository.save(roleUser);
		
		usuario2.setRoles(Arrays.asList(roleUser));
		usuarioRepository.save(usuario2);
		
		
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("teacher");
		usuario3.setNomeCompleto("teacher");
		usuario3.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		Role roleStudent = new Role();
		roleStudent.setNameRole("ROLE_STUDENT");
		roleRepository.save(roleStudent);
		
		usuario3.setRoles(Arrays.asList(roleStudent));
		usuarioRepository.save(usuario3);
		
		
	}

}
