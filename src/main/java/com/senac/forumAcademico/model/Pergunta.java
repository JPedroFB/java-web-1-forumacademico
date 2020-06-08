package com.senac.forumAcademico.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.senac.forumAcademico.model.enuns.StatusAtividade;

@Entity
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private LocalDate dataCriacao = LocalDate.now();
	
	@Enumerated(EnumType.STRING)
	private StatusAtividade status = StatusAtividade.NAO_RESPONDIDO;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Prova prova;
	
	@OneToMany(mappedBy = "pergunta")
	private List<Resposta> respostas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusAtividade getStatus() {
		return status;
	}

	public void setStatus(StatusAtividade status) {
		this.status = status;
	}


	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	
}
