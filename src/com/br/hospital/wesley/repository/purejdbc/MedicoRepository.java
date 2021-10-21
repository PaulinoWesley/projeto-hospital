package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.hospital.wesley.entity.Medico;
import com.br.hospital.wesley.repository.IMedicoRepository;

public class MedicoRepository implements IMedicoRepository {

	public void insert(Medico medico) throws SQLException  {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.MEDICO (crm, nome)VALUES(?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico.getCrm());
		preparedStatement.setString(2, medico.getNome());
	}

	public void update(Medico medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.MEDICO SET nome = ? WHERE cpf = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico.getNome());
		preparedStatement.setString(2, medico.getCrm());
	}

	public void delete(Medico medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.MEDICO WHERE crm = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico.getCrm());
	}

	public List<Medico> findAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT CRM, NOME FROM HOSPITAL.MEDICO";
		ResultSet rs = stmt.executeQuery(SQL);
		
		List<Medico> resultado = new ArrayList<Medico>();
		while(rs.next()) {
			Medico medico = new Medico();
			medico.setCrm(rs.getString("crm"));
			medico.setNome(rs.getString("nome"));
			
			resultado.add(medico);
		}
		return resultado;
	}

	public Medico findByCrm(String crm) throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT MEDICO FROM HOSPITAL.MEDICO WHERE crm = ?";
		ResultSet rs = stmt.executeQuery(SQL);
		
		Medico medico = null;
		while(rs.next()) {
			medico = new Medico();
			medico.setNome(rs.getString("nome"));
			medico.setCrm(rs.getString("crm"));
		}
		return medico;
	}
}
