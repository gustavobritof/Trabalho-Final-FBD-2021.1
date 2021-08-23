package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Jogador;

public class Controle_jogador extends Control<Jogador, Integer>{
	
	protected String getInserirSQL() {
		return "INSERT into Jogador (ID_Jogador, Nome, Posicao, Idade, Pe_Dominante) "+
				 "values (default, ?, ?, ?, ?)";
	}
	
	protected String getAlterarSQL() {
		return "update jogador set  Nome = ?, Posicao = ?, Idade = ?, Pe_Dominante = ? where ID_jogador = ?";
	}
	
	protected String getExcluirSQL() {
		return "delete from jogador where ID_jogador = ?";
	}
	
	protected String getObterPorIdSQL() {
		return "select * from Jogador where ID_jogador = ?";
	}
	
	protected String getObterTodosSQL() {
		return "select * from jogador";
	}
	
	protected  Jogador parse(ResultSet resultado) throws SQLException{
		Jogador jogador = new Jogador();
		jogador.setId_jogador(resultado.getInt("ID_jogador"));
		jogador.setNome(resultado.getString("Nome"));
		jogador.setPosicao(resultado.getString("Posicao"));
		jogador.setIdade(resultado.getInt("Idade"));
		jogador.setPe_dominante(resultado.getString("Pe_Dominante"));
		return jogador;
	}
	
	@Override
	protected void configurarParametrosInserir(Jogador model, PreparedStatement stm) throws SQLException{
		stm.setString(1, model.getNome());
		stm.setString(2, model.getPosicao());
		stm.setInt(3, model.getIdade());
		stm.setString(4, model.getPe_dominante());
	}
	
	@Override
	protected void configurarParametrosAlterar(Jogador model, PreparedStatement stm) throws SQLException{
		stm.setString(1, model.getNome());
		stm.setString(2, model.getPosicao());
		stm.setInt(3, model.getIdade());
		stm.setString(4, model.getPe_dominante());
		stm.setInt(5, model.getId_jogador());
	}
	
	@Override
	protected void configurarParametrosExcluir(Jogador model, PreparedStatement stm) throws SQLException{
		stm.setInt(1, model.getId_jogador());
	}
	
	@Override
	protected void configurarParametrosObterPorId(Integer id, PreparedStatement stm) throws SQLException{
		stm.setInt(1, id);
	}
}
