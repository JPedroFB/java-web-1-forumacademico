package com.senac.forumAcademico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.IndexColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	private String login;
	private String nomeCompleto;
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@IndexColumn(name = "INDEX")
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(
					name = "usuario_login", referencedColumnName = "login"),
					inverseJoinColumns = @JoinColumn(
					name = "role_name", referencedColumnName = "nameRole"))
	private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@IndexColumn(name = "INDEX")
	@JoinTable(
			name = "usuarios_permissoes",
			joinColumns = @JoinColumn(
					name = "usuario_login", referencedColumnName = "login"),
					inverseJoinColumns = @JoinColumn(
					name = "nome_permissao", referencedColumnName = "nome_permissao"))
	private List<Permissao> permissoes;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		this.permissoes.forEach(p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getNomePermissao());
			authorities.add(authority);
		});
		
		this.roles.forEach(p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getNameRole());
			authorities.add(authority);
		});
		
		
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	

}
