package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao_BD.ConnectionFactory;
import futebolistas.Jogador;

public class Controle_jogador {
	public boolean inserir (Jogador jogador) {
		
		String sql = "INSERT into Jogador (ID_Jogador, Nome, Posicao, Idade, Pe_Dominante)"+
				 "values (default, ?, ?, ?, ?)";

		Connection conn = ConnectionFactory.getConnection();
	
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, jogador.getNome());
			stm.setString(2, jogador.getPosicao());
			stm.setInt(3, jogador.getIdade());
			stm.setString(4, jogador.getPe_dominante());
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean excluir(Jogador jogador) {
		String sql = "delete from jogador where ID_jogador = ?";
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, jogador.getId_jogador());
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Jogador jogador) {
		String sql = "update jogador set  Nome = ?, Posicao = ?, Idade = ?, Pe_Dominante = ? where ID_jogador = ?";
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, jogador.getNome());
			stm.setString(2, jogador.getPosicao());
			stm.setInt(3, jogador.getIdade());
			stm.setString(4, jogador.getPe_dominante());
			stm.setInt(5, jogador.getId_jogador());
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Jogador> obterTodos(){
		String sql = "select * from jogador";
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet result = stmt.executeQuery();
			List<Jogador> jogadores = new ArrayList<Jogador>();
			while(result.next()) {
				Jogador jogador = new Jogador();
				jogador.setId_jogador(result.getInt("ID_jogador"));
				jogador.setNome(result.getString("Nome"));
				jogador.setPosicao(result.getString("Posicao"));
				jogador.setIdade(result.getInt("Idade"));
				jogador.setPe_dominante(result.getString("Pe_Dominante"));
				jogadores.add(jogador);
			}
			stmt.close();
			conn.close();
			return jogadores;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	public Jogador obterPorId(Integer Id){
		String sql = "select * from Jogador where ID_jogador = ?";
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Id);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				Jogador jogador = new Jogador();
				jogador.setId_jogador(result.getInt("ID_jogador"));
				jogador.setNome(result.getString("Nome"));
				jogador.setPosicao(result.getString("Posicao"));
				jogador.setIdade(result.getInt("Idade"));
				jogador.setPe_dominante(result.getString("Pe_Dominante"));
				
				stmt.close();
				conn.close();
				
				return jogador;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
