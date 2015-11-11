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
	public boolean termino() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(String nomeDoExperimento, Campo campo) {
		// 1. pega a conexão
		Connection conn = null;
		try {
			conn = FabricaDeConexao.getInstance().getConnection();
			// 2. prepara a instrução (update)

			PreparedStatement pstm = conn
					.prepareStatement("UPDATE campos SET valor = ? WHERE campos.nome = ? and campos.idexp = (SELECT id FROM experimento WHERE nome = ?)"); 
			// adicionar no nome do experimento o UNIQUE
			// não pode existir, dentro do mesmo experimento, campos com o mesmo nome. (regra de negócio)
			
			pstm.setString(1, campo.getValor());
			pstm.setString(2, campo.getNome() );
			pstm.setString(3, nomeDoExperimento);

			
			pstm.executeUpdate();
			// 3. fechar e retornar true caso verdade.
			
			pstm.close();
			//por algum motivo, como não estávamos fechando a conexão .. a atualização não era submetida.
			conn.close();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;

		}finally{
		}

		
	}

	@Override
	public Campo recuperar(String nomeDoExperimento, Campo campo) {
		// 1. pegar a conexao
		// 2. prepara a instruçao (select)
		// 2.1. é multivalorado?
		// 3. cria um novo Campo e retornar
		return null;
	}

}
