package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Tecnico;

public class Controle_tecnico extends Control<Tecnico, Integer>{

	@Override
	protected String getInserirSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAlterarSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getExluirSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getObterPorIdSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getObterTodosSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Tecnico parse(ResultSet resultado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void configurarParametrosInserir(Tecnico model, PreparedStatement stm) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void configurarParametrosAlterar(Tecnico model, PreparedStatement stm) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void configurarParametrosExcluir(Tecnico model, PreparedStatement stm) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void configurarParametrosObterPorId(Integer id, PreparedStatement stm) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
