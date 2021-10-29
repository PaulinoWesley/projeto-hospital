package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.hospital.wesley.entity.Paciente;
import com.br.hospital.wesley.repository.IPacienteRepository;

public class PacienteRepository implements IPacienteRepository {

	public void insert(Paciente paciente) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.PACIENTE(cpf, nome, dataNascimento) VALUES (?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);

		preparedStatement.setString(1, paciente.getCpf());
		preparedStatement.setString(2, paciente.getNome());
		preparedStatement.setDate(3, Date.valueOf(paciente.getDataNascimento()));
		
		preparedStatement.execute();
		
		conn.commit();
		conn.close();
	}

	public void update(Paciente paciente) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.PACIENTE SET nome = ?, dataNascimento = ? WHERE cpf = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, paciente.getNome());
		preparedStatement.setDate(2, Date.valueOf(paciente.getDataNascimento()));
		preparedStatement.setString(3, paciente.getCpf());
		
		preparedStatement.executeUpdate();
	}

	public void delete(Paciente paciente) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.PACIENTE WHERE CPF = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, paciente.getCpf());
		preparedStatement.execute();
	}

	public List<Paciente> findAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT * FROM HOSPITAL.PACIENTE";
		ResultSet rs = stmt.executeQuery(SQL);
		
		List<Paciente> resultado = new ArrayList<Paciente>();
		while (rs.next()) {
			Paciente pc = new Paciente();
			pc.setCpf(rs.getString("cpf"));
			pc.setNome(rs.getString("nome"));
			pc.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
			
			resultado.add(pc);
		}
		return resultado;
	}

	public Paciente findByCpf(String cpf) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT NOME, DATANASCIMENTO, CPF FROM HOSPITAL.PACIENTE WHERE CPF = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setString(1, cpf);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Paciente pc = new Paciente();
			pc.setCpf(rs.getString("cpf"));
			pc.setNome(rs.getString("nome"));
			pc.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
			
			return pc;
		}
		return null;
	}

}
