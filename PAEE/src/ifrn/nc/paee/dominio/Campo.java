package ifrn.nc.paee.dominio;

public class Campo {
	
	private final static int INTEIRO = 0;
	private final static int REAL = 1;
	
	private int tipo = -1;
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
	
	public int getValorInteiro() {
		return 0;
	}
	
	public int[] getValorMultivaloradoInteiro() {
		return null;
	}
	
	public double getValorReal() {
		return 0;
	}
	
	public double[] getValorMultivaloradoReal() {
		return null;
	}
}
