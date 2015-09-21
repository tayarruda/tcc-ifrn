package ifrn.nc.paee;

import ifrn.nc.paee.servicos.bd.BancoDeDados;
import ifrn.nc.paee.servicos.bd.Campo;
import ifrn.nc.paee.servicos.bd.Experimento;
import ifrn.nc.paee.servicos.bd.HSQLDB;
import ifrn.nc.paee.servicos.bd.InicializacaoBDException;
import ifrn.nc.paee.util.CarregadorDeExperimentos;

public class Teste {
	public static void main(String[] args) {

		testeInterfaceGrafica();
	}

	public static void testeInterfaceGrafica() {

		Experimento[] experimentos = (new CarregadorDeExperimentos())
				.getExperimentos();

		for (Experimento experimento : experimentos) {
			testeMecanismoBD(experimento);
		}
		
		//Precisar instanciar uma tela
		//irá passar os experimentos
		

	}

	public static void testeMecanismoProp() {
		Experimento[] experimentos = (new CarregadorDeExperimentos())
				.getExperimentos();

		for (Experimento experimento : experimentos) {
			testeMecanismoBD(experimento);
		}
	}

	public static void testeMecanismoBD(Experimento experimento) {
		BancoDeDados bd = new HSQLDB();

		// configurar a base de dados

		Campo massa = new Campo("massa", "0", false);
		Campo temperatura = new Campo("temp", "0", true);

		Campo[] campos = { massa, temperatura };
		experimento.setCampos(campos);

		try {
			bd.inicializacao(experimento);
		} catch (InicializacaoBDException e) {
			e.printStackTrace();

		}
	}

	public static void testeMecanismoBD() {
		BancoDeDados bd = new HSQLDB();

		// configurar a base de dados

		Campo massa = new Campo("massa", "0", false);
		Campo temperatura = new Campo("temp", "0", true);

		Campo[] campos = { massa, temperatura };

		try {
			bd.inicializacao(new Experimento("Fabio", campos));
		} catch (InicializacaoBDException e) {
			e.printStackTrace();

		}
	}
}
