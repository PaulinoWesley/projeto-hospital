package com.br.hospital.wesley;

import java.sql.SQLException;
import java.util.Scanner;

import com.br.hospital.wesley.service.PacienteService;

public class HospitalDoWesleyStartup {
	final static int OPCAO_INSERIR = 1;
	
	final static int OPCAO_PACIENTE = 1;
	
	static Scanner sc = new Scanner(System.in);
	
	static PacienteService pacienteService = new PacienteService();

	public static void main(String[] args) throws SQLException {
		System.out.println("Opções ");
		System.out.println("1 - Inserir ");
		System.out.println("2 - Pesquisar ");
		System.out.println("3 - Atualizar ");
		System.out.println("4 - Deletar ");
		int opcao = sc.nextInt();

		if (opcao == OPCAO_INSERIR)
			showMenuInserir();
	}

	static void showMenuInserir() throws SQLException {
		System.out.println("1 - Paciente ");
		System.out.println("2 - Consulta ");
		System.out.println("3 - Médico ");

		int opcao = sc.nextInt();

		if (opcao == OPCAO_PACIENTE)
			pacienteService.Inserir();
	}
}
