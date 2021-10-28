package com.br.hospital.wesley;

import java.sql.SQLException;
import java.util.Scanner;

import com.br.hospital.wesley.service.PacienteService;
import com.br.hospital.wesley.service.ConsultaService;
import com.br.hospital.wesley.service.MedicoService;

public class HospitalDoWesleyStartup {
	final static int OPCAO_PACIENTE = 1;
	final static int OPCAO_CONSULTA = 2;
	final static int OPCAO_MEDICO = 3;
	final static int OPCAO_FINALIZAR = 4;
	
	final static int OPCAO_INSERIR = 1;
	final static int OPCAO_PESQUISAR = 2;
	final static int OPCAO_ATUALIZAR = 3;
	final static int OPCAO_DELETAR = 4;
	
	static Scanner sc = new Scanner(System.in);
	
	static PacienteService pacienteService = new PacienteService();
	static ConsultaService consultaService = new ConsultaService();
	static MedicoService medicoService = new MedicoService();

	public static void main(String[] args) throws SQLException {
		run();
	}

	private static void run() throws SQLException {
		
		int opcao;
		do {	
			System.out.println("Opções ");
			System.out.println("1 - Paciente ");
			System.out.println("2 - Consulta ");
			System.out.println("3 - Médico ");
			System.out.println("4 - Sair ");
			
			opcao = sc.nextInt();
			if (opcao == OPCAO_PACIENTE)
				showMenuPaciente();
			
			if (opcao == OPCAO_CONSULTA)
				showMenuConsulta();
			
			if (opcao == OPCAO_MEDICO)
				showMenuMedico();
		}while(opcao != OPCAO_FINALIZAR);
			
	}

	static void showMenuPaciente() throws SQLException {
		System.out.println("PACIENTE");
		System.out.println("1 - Inserir ");
		System.out.println("2 - Pesquisar ");
		System.out.println("3 - Atualizar ");
		System.out.println("4 - Deletar ");

		int opcao = sc.nextInt();

		if (opcao == OPCAO_INSERIR)
			pacienteService.inserir();
		
		if (opcao == OPCAO_PESQUISAR)
			pacienteService.pesquisar();
		
		if (opcao == OPCAO_ATUALIZAR)
			pacienteService.update();
		
		if (opcao == OPCAO_DELETAR)
			pacienteService.delete();
	}
	
	static void showMenuConsulta() throws SQLException {
		System.out.println("CONSULTA");
		System.out.println("1 - Inserir ");
		System.out.println("2 - Pesquisar ");
		System.out.println("3 - Atualizar ");
		System.out.println("4 - Deletar ");
		
		int opcao = sc.nextInt();
		
		if (opcao == OPCAO_INSERIR)
			consultaService.inserir();
		
		if (opcao == OPCAO_PESQUISAR)
			consultaService.pesquisar();
		
		if (opcao == OPCAO_ATUALIZAR)
			consultaService.update();
		
		if (opcao == OPCAO_DELETAR)
			consultaService.delete();
	}
	
	static void showMenuMedico() throws SQLException {
		System.out.println("MEDICO");
		System.out.println("1 - Inserir ");
		System.out.println("2 - Pesquisar ");
		System.out.println("3 - Atualizar ");
		System.out.println("4 - Deletar ");
		
		int opcao = sc.nextInt();
		
		if (opcao == OPCAO_INSERIR)
			medicoService.inserir();
		
		if (opcao == OPCAO_PESQUISAR)
			medicoService.pesquisar();
		
		if (opcao == OPCAO_ATUALIZAR)
			medicoService.atualizar();
		
		if (opcao == OPCAO_DELETAR)
			medicoService.deletar();
	}
}
