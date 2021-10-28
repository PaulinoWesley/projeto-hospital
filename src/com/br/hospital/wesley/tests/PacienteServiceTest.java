package com.br.hospital.wesley.tests;

import java.sql.SQLException;
import java.time.LocalDate;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.service.PacienteService;

public class PacienteServiceTest {
	private PacienteService service = new PacienteService();
	
	private void testInserirPaciente() throws SQLException {
		String cpf = "00011122234";
		String nome = "Joe Doe";
		LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
		//service.inserir(new Paciente(cpf, nome, dataNascimento));
	}
	
	public static void run() throws SQLException {
		PacienteServiceTest test = new PacienteServiceTest();
		
		test.testInserirPaciente();
	}
}
