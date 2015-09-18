package ifrn.nc.paee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe criado com a responsabilidade ...
 * 
 * @author taynarruda
 */


/* pra que serve esse carregador de propriedades? e como isso aqui vai funcionar*/
// o que ser blblbl?

class CarregadorDePropriedades {

	private  Properties props = new Properties();
	private String nomeDoArquivo = "/experimentos.properties";
	
	/**
	 * 
	 * @param nomeDoArquivo este parametro para lbal caso não seja necessa blblb
	 */
	public CarregadorDePropriedades(){
		
		InputStream input = CarregadorDePropriedades.class.getResourceAsStream(this.nomeDoArquivo);
		try {
			props.load(input);
		} catch (IOException e) {
			// TODO Temos que analisar como serão tratamento de excetpiions
			e.printStackTrace();
		}
	}
	
	public String getValor(String chave){
		return props.getProperty(chave);
	}
	
}
