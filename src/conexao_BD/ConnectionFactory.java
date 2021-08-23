package conexao_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/futebolista_teste",
														  "postgres", "admin");
			System.out.println("Conectado!");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
