package com.br.hospital.wesley.tests;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.br.hospital.wesley.entity.Consulta;
import com.br.hospital.wesley.repository.purejdbc.ConsultaRepository;

public class ConsultaRepositoryTest {
	
	private ConsultaRepository consultaRepository = new ConsultaRepository();
	Consulta consulta = new Consulta("2323",  "99988877765", "Isso é uma receita nervosa", LocalDateTime.of(2021, 1 , 15, 8, 30, 0));
	
	private void testInsert() throws SQLException {
		consultaRepository.insert(consulta);
		Consulta savedConsulta = consultaRepository.findById(consulta.getIdConsulta());
		
		assert (consulta.getDescricaoReceita().equals(savedConsulta.getDescricaoReceita())): "Receitas são iguais.";
		assert (consulta.getHorarioConsulta().equals(savedConsulta.getHorarioConsulta())): "Agendamento são iguais";
		assert (consulta.getPaciente().equals(savedConsulta.getPaciente())): "Pacientes são iguais.";
		assert (consulta.getMedico().equals(savedConsulta.getMedico())): "Médicos são iguais.";
		assert (consulta.getIdConsulta() != null): "Id de Consultas são iguais.";
		
		System.out.println("Rodou Insert de consulta");
	}
	
	private void testUpdate() throws SQLException {
		consulta.setDescricaoReceita("Uma nova receita, agora atualizada");
		consultaRepository.update(consulta);
		
		Consulta savedConsulta = consultaRepository.findById(consulta.getIdConsulta());
		assert (savedConsulta.getDescricaoReceita().equals("Uma nova receita, agora atualizada")): "Atualização não foi concluida";
		
		System.out.println("Rodou Update de consulta");
	}
	
	private void testList() throws SQLException {
		boolean isConsultaNaLista = consultaRepository.findAll().stream().anyMatch(p -> p.getIdConsulta().equals(consulta.getIdConsulta()));
		
		assert (isConsultaNaLista): "Consulta é diferente";
		
		System.out.println("Rodou List de consulta");
	}
	
	private void testDelete() throws SQLException {
		consultaRepository.delete(consulta);
		Consulta savedConsulta = consultaRepository.findById(consulta.getIdConsulta());
		
		assert (savedConsulta == null): "Consulta ainda esta no banco";
		System.out.println("Rodou Delete de consulta");
	}
	
	public static void run() throws SQLException {
		ConsultaRepositoryTest test = new ConsultaRepositoryTest();
		
		test.testInsert();
		test.testUpdate();
		test.testList();
		test.testDelete();
	}
}
