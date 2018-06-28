package com.ibm.br.dvilela.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Candidato {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private byte[] cv;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getCv() {
		return cv;
	}
	public void setCv(byte[] cv) {
		this.cv = cv;
	}
	
	public Candidato(String nome, String email, byte[] cv) {
		this.nome = nome;
		this.email = email;
		this.cv = cv;
	}
	
	public Candidato() {
	}
	
	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", email=" + email + ", cv=" + Arrays.toString(cv) + "]";
	}
	
	
	
}
