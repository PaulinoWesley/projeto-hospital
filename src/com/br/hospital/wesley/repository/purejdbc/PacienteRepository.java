package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.repository.IPacienteRepository;

public class PacienteRepository implements IPacienteRepository {

	public void insert(Paciente paciente) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.PACIENTE(cpf, nome, dataNascimento)VALUES(?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);

		preparedStatement.setString(1, paciente.getCpf());
		preparedStatement.setString(2, paciente.getNome());
		preparedStatement.setDate(3, Date.valueOf(paciente.getDataNascimento()));
	}

	public void update(Paciente paciente) {

	}

	public void delete(Paciente paciente) {

	}

	public List<Paciente> findAll() {

		return null;
	}

	public List<Paciente> findByCpf(String cpf) {

		return null;
	}

}
