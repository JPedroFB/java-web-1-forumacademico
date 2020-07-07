package com.senac.forumAcademico.model.init;

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
		
		
		Permissao permitionUser = new Permissao();
		permitionUser.setNomePermissao("insert");
		permRepository.save(permitionUser);
		usuario.setPermissoes(Arrays.asList(permitionUser));
		
		
		
		Usuario teacher = new Usuario();
		teacher.setLogin("teacher");
		teacher.setNomeCompleto("teacher");
		teacher.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		Role roleTeacher = new Role();
		roleTeacher.setNameRole("ROLE_TEACHER");
		roleRepository.save(roleTeacher);
		
		teacher.setRoles(Arrays.asList(roleTeacher));
		usuarioRepository.save(teacher);
		
		
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("student");
		usuario3.setNomeCompleto("student");
		usuario3.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		Role roleStudent = new Role();
		roleStudent.setNameRole("ROLE_STUDENT");
		roleRepository.save(roleStudent);
		
		usuario3.setRoles(Arrays.asList(roleStudent));
		usuarioRepository.save(usuario3);
		
		
	}

}
