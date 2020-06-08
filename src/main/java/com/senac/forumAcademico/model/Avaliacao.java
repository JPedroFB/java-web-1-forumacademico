package com.senac.forumAcademico.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoProva alunoProva;
	
	private float conceito;

	public AlunoProva getAlunoProva() {
		return alunoProva;
	}

	public void setAlunoProva(AlunoProva alunoProva) {
		this.alunoProva = alunoProva;
	}

	public float getConceito() {
		return conceito;
	}

	public void setConceito(float conceito) {
		this.conceito = conceito;
	}
	
	
	
	
	
}
