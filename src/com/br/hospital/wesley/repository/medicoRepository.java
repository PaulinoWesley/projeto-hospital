package com.br.hospital.wesley.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class medicoRepository {

	public static void insertMedico(String crm, String nome) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.MEDICO (crm, nome)VALUES(?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, crm);
		preparedStatement.setString(2, nome);
	}
	
	public static void deleteMedico(String crm) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.MEDICO WHERE crm = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, crm);
	}
	
	public static void updateMedico(String nome, String crm) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.MEDICO SET nome = ? WHERE cpf = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, crm);
	}
	
	public static void readAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT * FROM HOSPITAL.MEDICO";
		System.out.println(SQL);
		ResultSet rs = stmt.executeQuery(SQL);
	}
	
	public static void readMedicoForCrm(String crm) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT NOME FORM HOSPITAL.MEDICO WHERE crm = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		
		preparedStatement.setString(1, crm);
		
		System.out.println(SQL);
	}
}
