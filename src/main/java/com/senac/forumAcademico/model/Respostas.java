package com.senac.forumAcademico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Respostas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String descricao;
	
	@ManyToOne
	Atividade atividade;

	@ManyToOne
	Professor professor;
	
}
