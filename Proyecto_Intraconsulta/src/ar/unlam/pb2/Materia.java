package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	private String nombre;
	private Integer codigo;
	private List<Materia> correlativas;

	public Materia(String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.correlativas = new ArrayList<>();
	}

	public boolean anadirCorrelativa(Materia materia) {
		boolean fueAgregada = false;
		Integer largoActual = this.correlativas.size();
		correlativas.add(materia);
		if (this.correlativas.size() > largoActual) {
			fueAgregada = true;
		}
		return fueAgregada;
	}

	public Integer getCantidadCorrelativas() {
		return this.correlativas.size();
	}
	
	public List<Materia> getCorrelativas() {
		return this.correlativas;
	}
	
	public Integer getCodigo () {
		return this.codigo;
	}
	
	public String getNombre () {
		return this.nombre;
	}
}
