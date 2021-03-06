package ifrn.nc.paee.dominio;


public class Experimento {
			
	private int id;
	private String nome;
	private int etapa;
	private int disciplina;
	private String conteudo;
	private String classeExecutavel;
	
	// Garantir que estes campos são distintos ... nomes diferentes
	private Campo[] campos; //vai deixar em aberto o numero de campos que pode ser inserida
	
	public Experimento(String nome, Campo[] campos) {
		super(); /* A palavra super é usada pra referenciar uma classe pai da classe em questão. Você pode usar pra chamar o construtor da superclasse*/
		this.nome = nome;/*A palavra reservada this é utilizada dentro de métodos que recebem paramentros com o mesmo nome de atributos de instância da classe ou para fazer referência ao próprio objeto*/

		this.campos = campos; 
		}

	public Experimento() {		}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Campo[] getCampos() {
		return campos;
	}

	public void setCampos(Campo[] campos) {
		this.campos = campos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public int getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getClasseExecutavel() {
		return classeExecutavel;
	}

	public void setClasseExecutavel(String classeExecutavel) {
		this.classeExecutavel = classeExecutavel;
	}
	
	/**
	 * Verificar se o estado/situação do experimento em questão está apto para ser inicializado.
	 * 
	 * @return {@code true} para apto, {@code false} caso não.
	 */
	public boolean aptoParaInicializacao(){
		return false;
	}
	
}
