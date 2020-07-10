package com.senac.forumAcademico.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		Optional<Usuario> usuario = usuarioRepo.findByLogin(login);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Usuario não existe");
	}
	
	

}
