package com.br.hospital.wesley.tests;

import java.sql.SQLException;
import java.time.LocalDate;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.repository.purejdbc.PacienteRepository;

public class PacienteRepositoryTest {

	private PacienteRepository pacienteRepository = new PacienteRepository();
	Paciente paciente = new Paciente("60050040090", "Teste de Insert", LocalDate.of(2021, 10, 12));
	
	private void testeInsert() throws SQLException {
		pacienteRepository.insert(paciente);
		Paciente savedPaciente = pacienteRepository.findByCpf(paciente.getCpf());
		
		assert (paciente.getDataNascimento().equals(savedPaciente.getDataNascimento())): "Datas de nascimento diferentes";
		assert (paciente.getNome().equals(savedPaciente.getNome())) : "Nomes diferentes";

		System.out.println("Rodou insert");
	}

	private void testeUpdate() throws SQLException {
		paciente.setNome("Paciente Atualizado");
		pacienteRepository.update(paciente);
		
		Paciente savedPaciente = pacienteRepository.findByCpf(paciente.getCpf());
		assert(savedPaciente.getNome().equals("Paciente Atualizado")): "Atualização não funcionou";
	
		System.out.println("Rodou Update");
	}

	private void testeList() throws SQLException {
		boolean isPacienteNaLista = pacienteRepository.findAll().stream().anyMatch(p -> p.getCpf().equals(paciente.getCpf()));
		
		assert (isPacienteNaLista): "Paciente não encontrado na listagem";
		System.out.println("Rodou list");
	}

	private void testeDelete() throws SQLException {
		pacienteRepository.delete(paciente);
		Paciente savedPaciente = pacienteRepository.findByCpf(paciente.getCpf());
		
		assert (savedPaciente == null): "Paciente ainda está no banco de dados :-(";
		
		System.out.println("Rodou delete");
	}

	public static void run() throws SQLException {
		PacienteRepositoryTest test = new PacienteRepositoryTest();

		test.testeInsert();
		test.testeUpdate();
		test.testeList();
		test.testeDelete();
	}
}
