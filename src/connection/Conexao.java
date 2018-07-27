package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
	
	static Connection c;
	private static final String URL = "jdbc:mysql://localhost/bdteste?autoReconnect=true&useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection abrir() {
		try {
			Class.forName(DRIVER);
			c = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectado.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro "+e);
		}
		return c;
	}
	
	public Connection fechar() {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Erro "+e);
		}
		return c;
	}
	
}
