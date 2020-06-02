package com.senac.forumAcademico.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Avaliacao {

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
