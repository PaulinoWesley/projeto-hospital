package com.br.hospital.wesley.repository;

import java.sql.SQLException;
import java.util.List;

import com.br.hospital.wesley.entity.Consulta;

public interface IConsultaRepository {
	Consulta insert(Consulta consulta) throws SQLException;
	void update(Consulta consulta) throws SQLException;
	void delete(Consulta consulta) throws SQLException;
	void delete(Integer idConsulta) throws SQLException;
	List<Consulta> findAll() throws SQLException;
	List<Consulta> findByMed(String medico) throws SQLException;
	List<Consulta> findByPaciente(String paciente) throws SQLException;
	Consulta findById(Integer idConsulta) throws SQLException;

}
