package ifrn.nc.paee.servicos.bd;


public class Experimento {

	private String nome;
	private Campo[] campos;
	
	public Experimento(String nome, Campo[] campos) {
		super();
		this.nome = nome;
		this.campos = campos;
	}

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
	
	
	
}
