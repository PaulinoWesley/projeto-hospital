package com.br.hospital.wesley.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.br.hospital.wesley.entity.Medico;
import com.br.hospital.wesley.repository.IMedicoRepository;
import com.br.hospital.wesley.repository.purejdbc.MedicoRepository;

public class MedicoService {
	IMedicoRepository medicoRepository = new MedicoRepository();
	Scanner sc = new Scanner(System.in);
	
	public void inserir() throws SQLException {
		System.out.println("Digite o CRM do Médico: ");
		String crm = sc.nextLine();
		System.out.println("Digite o nome do Médico: ");
		String nome = sc.nextLine();
		
		Medico medico = new Medico();
		medico.setCrm(crm);
		medico.setNome(nome);
		
		medicoRepository.insert(medico);
	}
	
	public void pesquisar() throws SQLException {
		List<Medico> medicos = medicoRepository.findAll();
		if (medicos.isEmpty()) {
			System.out.println("NENHUM RESULTADO ENCONTRADO.");		
		}
		for (Medico medico : medicos) {
				System.out.println("CRM: " + medico.getCrm() + " || Nome: " + medico.getNome());
		}
	}
	
	public void atualizar() throws SQLException {
		System.out.println("Digite o CRM do Médico: ");
		String crm = sc.nextLine();
		System.out.println("Digite o nome do Médico: ");
		String nome = sc.nextLine();
		
		Medico medico = new Medico();
		medico.setCrm(crm);
		medico.setNome(nome);
		
		medicoRepository.update(medico);
	}
	
	public void deletar() throws SQLException {
		System.out.println("Digite o CRM do médico: ");
		String crm = sc.nextLine();
		
		Medico medico = new Medico();
		medico.setCrm(crm);
		
		medicoRepository.delete(medico);
	}
}
