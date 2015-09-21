package ifrn.nc.paee.util;

import ifrn.nc.paee.servicos.bd.Experimento;

public class CarregadorDeExperimentos {

	private final String EXPERIMENTOS = "experimentos";
	
	private final String CHAVE_NOME = ".nome";
	private final String CHAVE_ETAPA = ".etapa";
	private final String CHAVE_DISCIPLINA = ".disciplina";
	private final String CHAVE_CONTEUDO = ".conteudo";
	private final String CHAVE_CLASSE = ".classe";

	
	private final CarregadorDePropriedades props = new CarregadorDePropriedades();

	private Experimento[] experimentos = null;
	private String[] chaves = null;
	public CarregadorDeExperimentos(){
		chaves = props.getValor(EXPERIMENTOS).split(","); // nesse caso, o que  ai fazer o split ?
	}
		// não entendi isso
	public Experimento[] getExperimentos(){
		
		
		experimentos = new Experimento[chaves.length];
        
		for (int i = 0; i< chaves.length; i++) {
			Experimento experimento = new Experimento();
			
			experimento.setNome(props.getValor(chaves[i]+CHAVE_NOME));
			experimento.setEtapa(Integer.parseInt(props.getValor(chaves[i]+CHAVE_ETAPA)));
			experimento.setConteudo(props.getValor(chaves[i]+CHAVE_CONTEUDO));
			experimento.setDisciplina(Integer.parseInt(props.getValor(chaves[i]+CHAVE_DISCIPLINA)));
			experimento.setClasseExecutavel(props.getValor(chaves[i]+CHAVE_CLASSE));
			
			experimentos[i] = experimento;
			
		
		}
		
		return experimentos;
	}

	
	
	
}
