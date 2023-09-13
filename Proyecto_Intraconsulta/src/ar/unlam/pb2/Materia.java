package ar.unlam.pb2;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigo;
	private ArrayList<Materia> correlativas;
	
	public Materia (String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
}
