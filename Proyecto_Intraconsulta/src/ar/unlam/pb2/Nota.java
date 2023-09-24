package ar.unlam.pb2;

public class Nota {
	
	private Integer valor;
	private Instancia instancia;
	
	public Nota(Integer valor, Instancia instancia) {
		super();
		this.valor = valor;
		this.instancia = instancia;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}
	
	

}
