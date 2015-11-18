package ifrn.nc.paee.dominio;

public class Campo {
	private String nome = null;
	private String valor = null;
	private String[] valores = null;
	private boolean multivalorado = false;

	public Campo(String nome, String valor, boolean multivalorado) {
		this.nome = nome;
		this.valor = valor;
		this.multivalorado = multivalorado;
	}

	public Campo(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
		this.multivalorado = false;
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
