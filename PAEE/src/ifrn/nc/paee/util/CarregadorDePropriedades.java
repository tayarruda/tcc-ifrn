package ifrn.nc.paee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe criado com a responsabilidade ...
 * 
 * @author taynarruda
 */
public class CarregadorDePropriedades {

	private Properties props = new Properties();
	private String nomeDoArquivo = "/experimentos.properties";
	
	/**
	 * 
	 * @param nomeDoArquivo este parametro é para lbal caso não seja necessa blblb 
	 */
	public CarregadorDePropriedades(String nomeDoArquivo){
		
		if(nomeDoArquivo != null &&
				nomeDoArquivo.trim().isEmpty()){
			this.nomeDoArquivo = nomeDoArquivo;
		} 
		
		InputStream input = CarregadorDePropriedades.class.getResourceAsStream(this.nomeDoArquivo);
		try {
			props.load(input);
		} catch (IOException e) {
			// TODO Temos que analisar como será o tratamento de excetpiions
			e.printStackTrace();
		}
	}
	
	public void printValues(){
		props.list(System.out);
	}
}
