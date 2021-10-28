package com.br.hospital.wesley.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.repository.IPacienteRepository;
import com.br.hospital.wesley.repository.purejdbc.PacienteRepository;
import com.br.hospital.wesley.utils.Utils;

public class PacienteService {
	IPacienteRepository pacienteRepository = new PacienteRepository();
	Scanner sc = new Scanner(System.in);

	public void inserir() throws SQLException {

		System.out.print("Digite o nome:");
		String nome = sc.nextLine();
		System.out.print("Digite o CPF:");
		String cpf = sc.nextLine();
		System.out.println("Digite a Data de Nascimento [dd/mm/aaaa]:");
		LocalDate dataDeNascimento = Utils.stringToDate(sc.nextLine());

		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setCpf(cpf);
		paciente.setDataNascimento(dataDeNascimento);
		
		pacienteRepository.insert(paciente);
	}
		
	public void pesquisar() throws SQLException {
		List<Paciente> pacientes = pacienteRepository.findAll();
		if (pacientes.isEmpty()) {
			System.out.println("NENHUM RESULTADO ENCONTRADO");
		}
		for (Paciente paciente : pacientes) {
				System.out.println("Nome= " + paciente.getNome() + "; CPF = " + paciente.getCpf() 
					+ "; Nascimento = " + paciente.getDataNascimento().toString());
		}
	}
	
	public void update() throws SQLException {
		System.out.println("Digite o CPF do paciente: ");
		String cpf = sc.nextLine();
		System.out.println("Digite o Nome: ");
		String nomeAtualizado = sc.nextLine();
		System.out.println("Digite a Data de Nascimento: ");
		LocalDate dataNascAtualizada = Utils.stringToDate(sc.nextLine());
		
		Paciente paciente = new Paciente();
		paciente.setNome(nomeAtualizado);
		paciente.setDataNascimento(dataNascAtualizada);
		paciente.setCpf(cpf);
		
		pacienteRepository.update(paciente);
	}
	
	public void delete() throws SQLException {
		System.out.println("Digite o cpf do paciente que deseja excluir: ");
		String cpf = sc.nextLine();
		
		Paciente paciente = new Paciente();
		paciente.setCpf(cpf);
		
		pacienteRepository.delete(paciente);
	}
}
