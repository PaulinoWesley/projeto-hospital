package com.br.hospital.wesley.repository;

import java.sql.SQLException;
import java.util.List;

import com.br.hospital.wesley.entity.Medico;

public interface IMedicoRepository {
	void insert(Medico medico) throws SQLException;
	void update(Medico medico) throws SQLException;
	void delete(Medico medico) throws SQLException;
	List<Medico> findAll() throws SQLException;
	Medico findByCrm(String crm) throws SQLException;	
}
