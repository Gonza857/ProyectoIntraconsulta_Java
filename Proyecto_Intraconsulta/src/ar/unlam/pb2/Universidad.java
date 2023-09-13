package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
	private String nombre;
	private List<Alumno> alumnos;
	private List<Materia> materias;
	private List<Aula> aulas;
	
	
	public Universidad (String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
	}
	
	public List<Materia> getMaterias () {
		return this.materias;
	}
	
	public boolean AgregarMateria (String nombre, Integer codigo) {
		boolean fueAgregada = false;
		Integer largo = materias.size();
		Materia nuevaMateria = new Materia(nombre, codigo);
		materias.add(nuevaMateria);
		if (materias.size() > largo) {
			fueAgregada = true;
		}
		return fueAgregada;
	}
}
