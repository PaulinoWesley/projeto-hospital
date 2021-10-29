package com.br.hospital.wesley.tests;

import java.sql.SQLException;

import com.br.hospital.wesley.entity.Medico;
import com.br.hospital.wesley.repository.purejdbc.MedicoRepository;

public class MedicoRepositoryTeste {

	private MedicoRepository medicoRepository = new MedicoRepository();
	Medico medico = new Medico("6061", "Van Damme");
	
	private void testInsert() throws SQLException {
		medicoRepository.insert(medico);
		Medico savedMedico = medicoRepository.findByCrm(medico.getCrm());
		
		assert (medico.getCrm().equals(savedMedico.getCrm())): "CRM diferentes";
		assert (medico.getNome().equals(savedMedico.getNome())): "Nomes diferentes";
		
		System.out.println("Rodou o Insert de medico");
	}
	
	private void testUpdate() throws SQLException {
		medico.setNome("Médico Atualizado");
		medicoRepository.update(medico);
		
		Medico savedMedico = medicoRepository.findByCrm(medico.getCrm());
		assert(savedMedico.getNome().equals("Médico Atualizado")): "Atualização não funcionou";
		
		System.out.println("Rodou Update de Médico");
	}
	
	private void testeList() throws SQLException {
		boolean isMedicoNaLista = medicoRepository.findAll().stream().anyMatch(m -> m.getCrm().equals(medico.getCrm()));
		
		assert (isMedicoNaLista): "Medico não encontrado na listagem";
		System.out.println("Rodou list de médico");
	}
	
	private void testeDelete() throws SQLException {
		medicoRepository.delete(medico);
		Medico savedMedico = medicoRepository.findByCrm(medico.getCrm());
		
		assert (savedMedico == null): "Medico ainda está no banco de dados :-(";
		
		System.out.println("Rodou delete de medico");
	}
	
	public static void run() throws SQLException {
		MedicoRepositoryTeste test = new  MedicoRepositoryTeste();
		
		test.testInsert();
		test.testUpdate();
		test.testeList();
		test.testeDelete();
	}
}
