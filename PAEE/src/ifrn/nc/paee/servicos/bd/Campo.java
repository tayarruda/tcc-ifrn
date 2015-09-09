package ifrn.nc.paee.servicos.bd;

public class Campo {
	private String nome = null;
	private String valor = null;
	private boolean multivalorado = false;

	public Campo(String nome, String valor, boolean multivalorado) {
		nome = this.nome;
		valor = this.valor;
		multivalorado = this.multivalorado;
	}

	public Campo(String nome, String valor) {
		nome = this.nome;
		valor = this.valor;
		multivalorado = false;
	}

	public String getNome() {
		return nome;
	}

	public String getValor() {
		return valor;
	}

	public boolean isMultivalorado() {
		return multivalorado;
	}

}
