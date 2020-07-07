package com.senac.forumAcademico.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.senac.forumAcademico.model.Usuario;
import com.senac.forumAcademico.repository.UsuarioRepository;

@Component
public class CurrentUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não existe");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, 
				usuario.getAuthorities());
	}
	
	

}
