package com.br.hospital.wesley.entity;

public class Medico {
	private String crm;
	private String nome;

	public Medico() {
	}

	public Medico(String crm, String nome) {
		this.crm = crm;
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
