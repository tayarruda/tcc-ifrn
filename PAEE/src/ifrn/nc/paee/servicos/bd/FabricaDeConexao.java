package ifrn.nc.paee.servicos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	private String driverClassName = "org.hsqldb.jdbcDriver";//carregando o driver
	private String url = "jdbc:hsqldb:file:C:\\Users\\taynarruda\\Downloads\\hsqldb-2.3.3\\hsqldb-2.3.3\\hsqldb\\data\\PAEE.tmp";
	private String usuario = "sa";
	private String senha = "";

	private static FabricaDeConexao fabricadeconexao = null;

	private FabricaDeConexao() {
		
			try {
				Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, usuario, senha);//faz a conexão com o banco;
		return conn;
	}

	public static FabricaDeConexao getInstance() {
		if (fabricadeconexao == null) {
			fabricadeconexao = new FabricaDeConexao();
		}
		return fabricadeconexao;
	}

	public static void main(String[] args) throws SQLException {
		FabricaDeConexao.getInstance().getConnection();//instanciando
		System.out.println("Conectou!");
	}
}
