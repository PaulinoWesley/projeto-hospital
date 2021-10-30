package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.br.hospital.wesley.entity.Consulta;
import com.br.hospital.wesley.repository.IConsultaRepository;

public class ConsultaRepository implements IConsultaRepository {

	public Consulta insert(Consulta consulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "INSERT INTO HOSPITAL.CONSULTA(paciente, descricaoReceita, horarioConsulta, medico) "
				+ " VALUES (?, ?, ?, ?) SELECT CAST(SCOPE_IDENTITY() AS INT); ";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);

		preparedStatement.setString(1, consulta.getPaciente());
		preparedStatement.setString(2, consulta.getDescricaoReceita());
		preparedStatement.setTimestamp(3, Timestamp.valueOf(consulta.getHorarioConsulta()));
		preparedStatement.setString(4, consulta.getMedico());

		ResultSet rs = preparedStatement.executeQuery();
		rs.next();

		consulta.setIdConsulta(rs.getInt(1));

		return consulta;
	}

	public void update(Consulta consulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "UPDATE HOSPITAL.CONSULTA SET "
				+ "medico = ?, paciente = ?, descricaoReceita = ?, horarioConsulta = ? WHERE IDCONSULTA = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);

		preparedStatement.setString(1, consulta.getMedico());
		preparedStatement.setString(2, consulta.getPaciente());
		preparedStatement.setString(3, consulta.getDescricaoReceita());
		preparedStatement.setTimestamp(4, Timestamp.valueOf(consulta.getHorarioConsulta()));
		preparedStatement.setInt(5,  consulta.getIdConsulta());
		
		preparedStatement.executeUpdate();
	}

	public void delete(Consulta consulta) throws SQLException {
		this.delete(consulta.getIdConsulta());
	}

	public void delete(Integer idConsulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String insert = "DELETE FROM HOSPITAL.CONSULTA WHERE idConsulta = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setInt(1, idConsulta);
		
		preparedStatement.execute();
	}

	public List<Consulta> findAll() throws SQLException {
		Connection conn = MyConnection.getInstance();
		Statement stmt = conn.createStatement();
		String SQL = "SELECT idConsulta, medico, paciente, descricaoReceita, horarioConsulta "
				+ " FROM master.hospital.consulta;";
		ResultSet rs = stmt.executeQuery(SQL);
		
		List<Consulta> resultado = new ArrayList<Consulta>();
		while (rs.next()) {
			Consulta c = new Consulta();
			c.setIdConsulta(rs.getInt("idConsulta"));
			c.setMedico(rs.getString("medico"));
			c.setPaciente(rs.getString("paciente"));
			c.setDescricaoReceita(rs.getString("descricaoReceita"));
			c.setHorarioConsulta(rs.getTimestamp("horarioConsulta").toLocalDateTime());
			
			resultado.add(c);
		}
		return resultado;
	}
	
	public List<Consulta> findByMed(String medico) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT IDCONSULTA, PACIENTE, DESCRICAORECEITA, HORARIOCONSULTA FROM HOSPITAL.CONSULTA WHERE medico = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setString(1, medico);
		System.out.println(SQL);
		ResultSet rs = preparedStatement.executeQuery(SQL);
		
		List<Consulta> resultado = new ArrayList<Consulta>();
		while (rs.next()) {
			Consulta consulta = new Consulta();
			consulta.setIdConsulta(rs.getInt("idCOnsulta"));
			consulta.setPaciente(rs.getString("paciente"));
			consulta.setDescricaoReceita(rs.getString("descricaoReceita"));
			consulta.setHorarioConsulta(rs.getTimestamp("horarioConsulta").toLocalDateTime());
			consulta.setMedico(rs.getString("medico"));
			
			resultado.add(consulta);
		}
		return resultado;
	}

	public List<Consulta> findByPaciente(String paciente) throws SQLException{
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT MEDICO, DESCRICAORECEITA, HORARIOCONSULTA, IDCONSULTA FROM HOSPITAL.CONSULTA WHERE PACIENTE = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setString(1, paciente);
		System.out.println(SQL);
		
		ResultSet rs = preparedStatement.executeQuery(SQL);
		
		List<Consulta> resultado = new ArrayList<Consulta>();
		while (rs.next()) {
			Consulta consulta = new Consulta();
			consulta.setMedico(rs.getString("medico"));
			consulta.setDescricaoReceita(rs.getString("descricaoReceita"));
			consulta.setHorarioConsulta(rs.getTimestamp("horarioConsulta").toLocalDateTime());
			consulta.setIdConsulta(rs.getInt("idConsulta"));
			
			resultado.add(consulta);
		}
		return resultado;
	}

	public Consulta findById(Integer idConsulta) throws SQLException {
		Connection conn = MyConnection.getInstance();
		String SQL = "SELECT IDCONSULTA, MEDICO, PACIENTE, DESCRICAORECEITA, HORARIOCONSULTA FROM HOSPITAL.CONSULTA WHERE IDCONSULTA = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setInt(1, idConsulta);
		ResultSet rs = preparedStatement.executeQuery();
		
		Consulta consulta = null;
		while (rs.next()) {
			consulta = new Consulta();
			consulta.setMedico(rs.getString("medico"));
			consulta.setPaciente(rs.getString("paciente"));
			consulta.setDescricaoReceita(rs.getString("descricaoReceita"));
			consulta.setHorarioConsulta(rs.getTimestamp("horarioCOnsulta").toLocalDateTime());
			consulta.setIdConsulta(rs.getInt("idConsulta"));
		}
		return consulta;
	}
}
