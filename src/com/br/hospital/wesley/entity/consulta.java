package com.br.hospital.wesley.entity;

import java.time.LocalDateTime;

public class consulta {
	private Integer idConsulta;
	private String medico;
	private String paciente;
	private String descricaoReceita;
	private LocalDateTime horarioConsulta;

	public consulta() { }
	
	public consulta(Integer idConsulta, String medico, String paciente,
			String descricaoReceita, LocalDateTime horarioConsulta) {
		this.idConsulta = idConsulta;
		this.medico = medico;
		this.paciente = paciente;
		this.descricaoReceita = descricaoReceita;
		this.horarioConsulta = horarioConsulta;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public LocalDateTime getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(LocalDateTime horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	
}
