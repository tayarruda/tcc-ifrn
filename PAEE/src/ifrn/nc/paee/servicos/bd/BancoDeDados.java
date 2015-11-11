package ifrn.nc.paee.servicos.bd;

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


