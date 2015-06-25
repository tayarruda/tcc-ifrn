package ifrn.nc.paee.util;

public class PropriedadesUtil {

	private final String EXPERIMENTOS = "experimentos";
	
	private final String CHAVE_NOME = ".nome";
	private final String CHAVE_ETAPA = ".etapa";
	private final String CHAVE_DISCIPLINA = ".discplina";
	private final String CHAVE_CONTEUDO = ".conteudo";
	private final String CHAVE_CLASSE = ".classe";

	private final CarregadorDePropriedades props = new CarregadorDePropriedades(null);
	
	private String[] chaves = null;
	public PropriedadesUtil(){
		chaves = props.getValor(EXPERIMENTOS).split(",");
	}
	
	public void printExperimentos(){
		
		for (String chave : chaves) {
			
			System.out.println("#################");
			System.out.println("#");
			System.out.println("# chave.nome =" + props.getValor(chave+CHAVE_NOME));
			System.out.println("# chave.etapa =" + props.getValor(chave+CHAVE_ETAPA));
			System.out.println("# chave.disciplina =" + props.getValor(chave+CHAVE_DISCIPLINA));
			System.out.println("# chave.conteudo =" + props.getValor(chave+CHAVE_CONTEUDO));
			System.out.println("# chave.classe =" + props.getValor(chave+CHAVE_CLASSE));
		}
	}
	
	
	
	
}
