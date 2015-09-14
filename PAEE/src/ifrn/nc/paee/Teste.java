package ifrn.nc.paee;

import ifrn.nc.paee.servicos.bd.BancoDeDados;
import ifrn.nc.paee.servicos.bd.Campo;
import ifrn.nc.paee.servicos.bd.Experimento;
import ifrn.nc.paee.servicos.bd.HSQLDB;
import ifrn.nc.paee.servicos.bd.InicializacaoBDException;
import ifrn.nc.paee.util.PropriedadesUtil;

public class Teste {
    public static void main(String[] args){

    	testeMecanismoBD();
    }
    
    public static void testeMecanismoProp(){
    	new PropriedadesUtil().printExperimentos();
    }
    
    public static void testeMecanismoBD(){
		BancoDeDados bd = new HSQLDB();

		// configurar a base de dados

		Campo massa = new Campo("massa", "0", false);
		Campo temperatura = new Campo("temp", "0", true);

		Campo[] campos = { massa, temperatura };

		try {
			bd.inicializacao(new Experimento("Fabio", campos));
		} catch (InicializacaoBDException e) {
			// finaliza a aplicação
			
			
			
			
		}
    }
}
