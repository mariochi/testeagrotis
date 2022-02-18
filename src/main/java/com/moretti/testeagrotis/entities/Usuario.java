package com.moretti.testeagrotis.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataInicial;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataFinal;
	@ManyToOne
	@JoinColumn(name = "info_id")
	private InfosPropriedade infoPropriedade;
	private String cnpj;
	@ManyToOne
	@JoinColumn(name = "lab_id")
	private Laboratorio laboratorio;
	private String observacoes;


	
	//---- Getters and Setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome()	{
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Instant getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Instant dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Instant getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Instant dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public InfosPropriedade getInfoPropriedade() {
		return infoPropriedade;
	}
	public void setInfoPropriedade(InfosPropriedade infoPropriedade) {
		this.infoPropriedade = infoPropriedade;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	//------- hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	public Usuario() {
	
	}
	public Usuario(Long id, String nome, Instant dataInicial, Instant dataFinal, InfosPropriedade infoPropriedade, String cnpj,
			Laboratorio laboratorio, String observacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.infoPropriedade = infoPropriedade;
		this.cnpj = cnpj;
		this.laboratorio = laboratorio;
		this.observacoes = observacoes;
	}

	
}
