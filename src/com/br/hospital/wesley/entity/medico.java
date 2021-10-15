package com.br.hospital.wesley.entity;

public class medico {
	private String crm;
	private String nome;

	public medico() {
	}

	public medico(String crm, String nome) {
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
