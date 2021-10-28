package com.br.hospital.wesley.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.br.hospital.wesley.entity.Consulta;
import com.br.hospital.wesley.repository.IConsultaRepository;
import com.br.hospital.wesley.repository.purejdbc.ConsultaRepository;
import com.br.hospital.wesley.utils.Utils;

public class ConsultaService {
	IConsultaRepository consultaRepository = new ConsultaRepository();
	Scanner sc = new Scanner(System.in);

	public void inserir() throws SQLException {
		System.out.println("Digite o CPF do paciente: ");
		String paciente = sc.nextLine();
		System.out.println("Digite o CRM do medico: ");
		String medico = sc.nextLine();
		System.out.println("Digite a data e horario do agendamento da consulta [dd/mm/aaaa hh:mm:ss]: ");
		LocalDateTime horarioConsulta = Utils.stringToDateTime(sc.nextLine());

		Consulta consulta = new Consulta();
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		consulta.setHorarioConsulta(horarioConsulta);

		consultaRepository.insert(consulta);

	}

	public void pesquisar() throws SQLException {
		List<Consulta> consultas = consultaRepository.findAll();
		if (consultas.isEmpty()) {
			System.out.println("NENHUM RESULTADO ENCONTRADO");
		} 
		for (Consulta consulta : consultas) {
			System.out.println("Numero da Consulta: " + consulta.getIdConsulta() + "|| Paciente: "
					+ consulta.getPaciente() + "|| Medico: " + consulta.getMedico() + "|| Agendamento da Consulta: "
					+ consulta.getHorarioConsulta() + "|| Receita: " + consulta.getDescricaoReceita());
		}
	}

	public void update() throws SQLException {
		System.out.println("Digite o número da consulta: ");
		Integer idConsulta = sc.nextInt();
		System.out.println("Digite o CPF do paciente: ");
		String cpf = sc.nextLine();
		System.out.println("Digite o CRM do médico: ");
		String crm = sc.nextLine();
		System.out.println("Digite a data e o agendamento da consulta: ");
		LocalDateTime horarioConsulta = Utils.stringToDateTime(sc.nextLine());
		System.out.println("Digite a receita: ");
		String receita = sc.nextLine();

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(idConsulta);
		consulta.setPaciente(cpf);
		consulta.setMedico(crm);
		consulta.setHorarioConsulta(horarioConsulta);
		consulta.setDescricaoReceita(receita);

		consultaRepository.update(consulta);
	}

	public void delete() throws SQLException {
		System.out.println("Digite o número da consulta: ");
		Integer idConsulta = sc.nextInt();

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(idConsulta);

		consultaRepository.delete(consulta);
	}
}
