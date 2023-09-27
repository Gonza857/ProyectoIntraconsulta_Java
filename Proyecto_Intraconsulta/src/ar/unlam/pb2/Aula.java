package ar.unlam.pb2;

public class Aula {
	private Integer numero;
	private Integer asientos;
	
	public Aula (Integer nAula, Integer nAsientos) {
		this.numero = nAula;
		this.asientos = nAsientos;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	

}
