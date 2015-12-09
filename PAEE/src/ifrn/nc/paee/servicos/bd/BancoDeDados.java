package ifrn.nc.paee.servicos.bd;

import ifrn.nc.paee.dominio.Campo;
import ifrn.nc.paee.dominio.Experimento;

public interface BancoDeDados {

	/**
	 * TODO : Documentar ... 
	 * 
	 * @param experimento
	 * @throws InicializacaoBDException
	 */
	public void inicializacao(Experimento experimento) throws ExperimentoValidoException, ConexaoException, InicializacaoBDException;
	public boolean guardar(String nomeDoExperimento, Campo campo) throws ConexaoException;
	public Campo recuperar(String nomeDoExperimento, Campo campo) throws ConexaoException;
	public boolean termino();

}


