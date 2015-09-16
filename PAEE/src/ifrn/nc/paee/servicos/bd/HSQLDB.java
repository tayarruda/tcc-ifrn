package ifrn.nc.paee.servicos.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDB implements BancoDeDados {

	@Override
	public void inicializacao(Experimento experimento)
			throws InicializacaoBDException {

		Connection connection = null;
		try {
			connection = FabricaDeConexao.getInstance().getConnection();

			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO experimento (nome) values (?)");
			pstm.setString(1, experimento.getNome());
			pstm.executeUpdate();
			pstm.close();

			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("CALL IDENTITY()");
			stm.close();

			if (rs.next()) {
				experimento.setId(rs.getInt(1));

				for (Campo campo : experimento.getCampos()) {

					pstm = connection
							.prepareStatement("INSERT INTO campos (nome, valor, multivalorado, idexp) values (?,?,?,?)");
					pstm.setString(1, campo.getNome());
					pstm.setString(2, campo.getValor());
					pstm.setBoolean(3, campo.isMultivalorado());
					pstm.setInt(4, experimento.getId());

					pstm.executeUpdate();
					pstm.close();
				}
			}
			;

		} catch (SQLException e) {

			throw new InicializacaoBDException(e);
		} finally {
			try {
				connection.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean guardar(String campo, String valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(Campo campo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] recuperar(String campo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campo[] recuperar(Campo campo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean termino() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {

	}

}
