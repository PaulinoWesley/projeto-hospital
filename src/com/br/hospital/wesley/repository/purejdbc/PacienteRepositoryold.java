package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class PacienteRepositoryold {
	
	public static void insertPaciente(String cpf, String nome, LocalDate dataNascimento) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.PACIENTE(cpf, nome, dataNascimento)VALUES(?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, cpf);
		preparedStatement.setString(2, nome);
		preparedStatement.setDate(3,Date.valueOf(dataNascimento));
	}
	
	public static void deletePaciente(String cpf) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.PACIENTE WHERE CPF = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, cpf);
	}
	
	public static void updatePaciente(String nome, LocalDate dataNascimento, String cpf) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.PACIENTE SET nome = ?, dataNascimento = ? WHERE cpf = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, nome);
		preparedStatement.setDate(2, Date.valueOf(dataNascimento));
		preparedStatement.setString(3, cpf);
	}
	
	public static void  readAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT * FROM HOSPITAL.PACIENTE";
		System.out.println(SQL);
		ResultSet rs = stmt.executeQuery(SQL);
	}
	
	public static void readByCPF(String cpf) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT NOME, DATANASCIMENTO FROM HOSPITL.PACIENTE WHERE cpf = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setString(1, cpf);
		
		System.out.println(SQL);
	}
	
}
