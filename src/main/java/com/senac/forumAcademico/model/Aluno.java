package com.senac.forumAcademico.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6772175714133494505L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Professor professor;
	
//	@OneToMany
//	private List<Atividade> atividades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Professor getProfessor() {
//		return professor;
//	}
//
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}

//	public List<Atividade> getAtividades() {
//		return atividades;
//	}
//
//	public void setAtividades(List<Atividade> atividades) {
//		this.atividades = atividades;
//	}
	
	
	
}
