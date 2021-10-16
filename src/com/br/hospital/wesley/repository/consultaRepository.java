package com.br.hospital.wesley.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class consultaRepository {

	public static void insertConsulta(
			String medico, String paciente, String descricaoReceita, LocalDateTime horarioConsulta
			) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.CONSULTA(paciente, descricaoReceita, horarioConsulta)"
				+ "VALUES(?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico);
		preparedStatement.setString(2, paciente);
		preparedStatement.setString(3, descricaoReceita);
		preparedStatement.setTimestamp(4, Timestamp.valueOf(horarioConsulta));
	}
	
	public static void deleteConsulta(LocalDateTime horarioConsulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.CONSULTA WHERE horarioConsulta = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setTimestamp(1, Timestamp.valueOf(horarioConsulta));
	}
	
	public static void updateConsulta(
			String medico, String paciente, String descricaoReceita, LocalDateTime horarioConsulta
			) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.CONSULTA SET"
				+ "medico = ?, paciente = ?, descricaoReceita = ? WHERE horarioConsulta = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico);
		preparedStatement.setString(2, paciente);
		preparedStatement.setString(3, descricaoReceita);
		preparedStatement.setTimestamp(4, Timestamp.valueOf(horarioConsulta));
	}
	
	public static void readAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT * FROM HOSPITAL.CONSULTA";
		System.out.println(SQL);
		ResultSet rs = stmt.executeQuery(SQL);
	}
	
	public static void readForHorario(LocalDateTime horarioConsulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT MEDICO, PACIENTE, DESCRICAORECEITA FROM HOSPITAL.CONSULTA WHERE horarioConsulta = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setTimestamp(1, Timestamp.valueOf(horarioConsulta));
		
		System.out.println(SQL);
	}
	
	public static void readForMedico(String medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT PACIENTE, DESCRICAORECEITA, HORARIOCONSULTA FROM HOSPITAL.CONSULTA WHERE medico = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setString(1, medico);
		
		System.out.println(SQL);
	}
	
	public static void readForPaciente(String paciente) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT MEDICO, DESCRICAORECEITA, HORARIOCONSULTA FROM HOSPITAL.CONSULTA WHERE paciente = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setString(1, paciente);
		
		System.out.println(SQL);
	}
	
	public static void readForReceita(String descricaoReceita) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT MEDICO, PACIENTE FROM HOSPITAL.CONSULTA WHERE descricaoReceita = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setString(1, descricaoReceita);
		
		System.out.println(SQL);
	}
}
