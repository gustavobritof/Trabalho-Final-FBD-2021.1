package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao_BD.ConnectionFactory;
import model.Model;

public abstract class Control <T extends Model, V extends Object>
	implements IControl<T, V> {
	
	protected abstract String getInserirSQL();
	protected abstract String getAlterarSQL();
	protected abstract String getExcluirSQL();
	protected abstract String getObterPorIdSQL();
	protected abstract String getObterTodosSQL();
	
	protected abstract T parse(ResultSet resultado) throws SQLException;
	
	public boolean inserir (T model) {
		
		String sql = this.getInserirSQL();
		Connection conn = ConnectionFactory.getConnection();
	
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			this.configurarParametrosInserir(model, stm);
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(T model) {
		String sql = this.getAlterarSQL(); 
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			this.configurarParametrosAlterar(model, stm);
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean excluir(T model) {
		String sql = this.getExcluirSQL(); 
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			
			this.configurarParametrosExcluir(model, stm);
			
			stm.execute();
			stm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public T obterPorId(V id){
		String sql = getObterPorIdSQL();
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			this.configurarParametrosObterPorId(id, stmt);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				T model = this.parse(resultado);
				
				stmt.close();
				conn.close();
				
				return model;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<T> obterTodos(){
		String sql = this.getObterTodosSQL();
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			List<T> model = new ArrayList<T>();
			while(resultado.next()) {
				model.add(this.parse(resultado));
			}
			stmt.close();
			conn.close();
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	protected abstract void configurarParametrosInserir(T model, PreparedStatement stm) throws SQLException;
	protected abstract void configurarParametrosAlterar(T model, PreparedStatement stm) throws SQLException;
	protected abstract void configurarParametrosExcluir(T model, PreparedStatement stm) throws SQLException;
	protected abstract void configurarParametrosObterPorId(V id, PreparedStatement stm) throws SQLException;
	
}
