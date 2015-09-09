package ifrn.nc.paee.servicos.bd;

public interface BancoDeDados {
	public void inicializacao(Experimento experimento) throws InicializacaoBDException;
	public boolean guardar (String campo, String valor);
	public boolean guardar(Campo campo);
	public String[] recuperar(String campo);
	public Campo[] recuperar(Campo campo);
	public boolean termino();

}


