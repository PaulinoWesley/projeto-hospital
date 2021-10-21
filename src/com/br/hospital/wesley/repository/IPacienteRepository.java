package com.br.hospital.wesley.repository;

import java.sql.SQLException;
import java.util.List;

import com.br.hospital.wesley.entity.Paciente;

public interface IPacienteRepository {
	void insert(Paciente paciente) throws SQLException;

	void update(Paciente paciente) throws SQLException;

	void delete(Paciente paciente) throws SQLException;

	List<Paciente> findAll() throws SQLException;

	List<Paciente> findByCpf(String cpf) throws SQLException;
}
