package com.br.hospital.wesley.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.repository.IPacienteRepository;
import com.br.hospital.wesley.repository.purejdbc.PacienteRepository;
import com.br.hospital.wesley.utils.Utils;

public class PacienteService {
	IPacienteRepository pacienteRepository = new PacienteRepository();
	Scanner sc = new Scanner(System.in);

	public void Inserir() throws SQLException {
		Paciente paciente = new Paciente();

		System.out.print("Digite o nome: ");
		paciente.setNome(sc.nextLine());
		System.out.print("Digite o CPF: ");
		paciente.setCpf(sc.nextLine());
		System.out.println("Digite a Data de Nascimento [dd/mm/aaaa]:");
		paciente.setDataNascimento(Utils.stringToDate(sc.nextLine()));
		
		pacienteRepository.insert(paciente);
	}
}
