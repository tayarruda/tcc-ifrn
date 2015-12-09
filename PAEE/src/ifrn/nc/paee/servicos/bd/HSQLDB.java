package ifrn.nc.paee.servicos.bd;

import ifrn.nc.paee.dominio.Campo;
import ifrn.nc.paee.dominio.Experimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDB implements BancoDeDados {

	@Override
	public void inicializacao(Experimento experimento)
			throws  ExperimentoValidoException, ConexaoException, InicializacaoBDException {
		
		if(experimento == null || !experimento.aptoParaInicializacao()){
			throw new ExperimentoValidoException(experimento);
		}

		/* TODO 
		 * 1 - Especificar no banco que o nome do experimento é UNIQUE
		 */
		Connection connection = FabricaDeConexao.getInstance().getConnection();
		
		
		inserirExperimento(experimento, connection);
		
		
		inserirCampos(experimento, connection);
		
			try {
				connection.close();
			} catch (Exception e) {
				//TODO imprimir o erro .... não silenciar. 
				e.printStackTrace();
			}	

	}


	@Override
	public boolean termino() {
		// TODO Repensar 
		return false;
	}

	@Override
	public boolean guardar(String nomeDoExperimento, Campo campo) throws ConexaoException{
		// 1. pega a conexão
		Connection conn = FabricaDeConexao.getInstance().getConnection();
		try {

			// 2. prepara a instrução (update)

			PreparedStatement pstm = conn
					.prepareStatement("UPDATE campos SET valor = ? WHERE campos.nome = ? and campos.idexp = (SELECT id FROM experimento WHERE nome = ?)"); 
			
			pstm.setString(1, campo.getValor());
			pstm.setString(2, campo.getNome() );
			pstm.setString(3, nomeDoExperimento);

			
			pstm.executeUpdate();
			// 3. fechar e retornar true caso verdade.
			
			pstm.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;

		}finally{
		}

		
	}

	@Override
	public Campo recuperar(String nomeDoExperimento, Campo campo) throws ConexaoException {
		// 1. pegar a conexao
		Connection conn = null;
		Campo campoAtualizado = null;
		
		try {
			conn = FabricaDeConexao.getInstance().getConnection();
			// 2. prepara a instruçao (select)
			PreparedStatement pstm = conn.prepareStatement("SELECT valor FROM campos INNER JOIN experimento ON experimento.id = campos.idexp");
			ResultSet rs = pstm.executeQuery();
			
			// TODO Verificar se é multivalorado 
			
			if(rs.next()){
				String valor = rs.getString(1);
				campoAtualizado = new Campo(campo.getNome(), valor);
			}
			
			// 3. cria um novo Campo e retornar
			
			rs.close();
			pstm.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return campoAtualizado;
	}
	
	private void inserirExperimento(Experimento experimento,
			Connection connection) throws InicializacaoBDException {
		
		try{
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
			}
		}catch(SQLException sqle){
			throw new InicializacaoBDException("Nome do Experimento inválido - já existe!!", sqle);
		}
	}

	private void inserirCampos(Experimento experimento, Connection connection) {
		
		try{
		 PreparedStatement pstm;
		
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
			
		}catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}


}
