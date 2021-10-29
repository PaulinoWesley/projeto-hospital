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
		
		preparedStatement.execute();
		
		conn.commit();
		conn.close();
	}

	public void update(Medico medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.MEDICO SET nome = ? WHERE crm = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico.getNome());
		preparedStatement.setString(2, medico.getCrm());
		
		preparedStatement.executeUpdate();
	}

	public void delete(Medico medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.MEDICO WHERE crm = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setString(1, medico.getCrm());
		
		preparedStatement.execute();
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
		String SQL = "SELECT CRM, NOME FROM HOSPITAL.MEDICO WHERE CRM = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setString(1, crm);
		ResultSet rs = preparedStatement.executeQuery();
		
		Medico medico = null;
		while(rs.next()) {
			medico = new Medico();
			medico.setNome(rs.getString("nome"));
			medico.setCrm(rs.getString("crm"));
		}
		return medico;
	}
}
