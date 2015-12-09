package ifrn.nc.paee.servicos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FabricaDeConexao {
	private String driverClassName = "org.hsqldb.jdbcDriver";
	private String url = "jdbc:hsqldb:file:C:\\Users\\taynarruda\\git\\tcc-paee\\PAEE\\bd\\PAEE";
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

	public Connection getConnection() throws ConexaoException {
		Connection conn = null;
		try{
		conn = DriverManager.getConnection(url, usuario, senha);
		}catch(SQLException sqle){
			throw new ConexaoException("Problemas com a conexao!!!", sqle);
		}
		return conn;
	}

	public static FabricaDeConexao getInstance() {
		if (fabricadeconexao == null) {
			fabricadeconexao = new FabricaDeConexao();
		}
		return fabricadeconexao;
	}

	public static void main(String[] args) throws ConexaoException {
		FabricaDeConexao.getInstance().getConnection();
		System.out.println("Conectou!");
	}
}
