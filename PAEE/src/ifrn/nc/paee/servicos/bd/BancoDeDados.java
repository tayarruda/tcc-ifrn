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
	public void inicializacao(Experimento experimento) throws InicializacaoBDException;
	public boolean guardar(String nomeDoExperimento, Campo campo);
	public Campo recuperar(String nomeDoExperimento, Campo campo);
	public boolean termino();

}


