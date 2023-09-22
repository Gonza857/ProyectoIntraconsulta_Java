package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Comision {
	private List<Alumno> alumnos;
	private Materia materiaAsignada;
	private List<Profesor> profesores;
	private Integer codigo;
	
	public Comision (Materia materia, Integer codigo) {
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.materiaAsignada = materia;
		this.codigo = codigo;
	}
	
	public boolean agregarAlumno (Alumno alumno) {
		Integer largo = this.alumnos.size();
		boolean fueAgregado = false;
		alumnos.add(alumno);
		if (this.alumnos.size() > largo) {
			fueAgregado = true;
			System.out.println(alumno.getNombre() + " fue agregado a " + "comision de " + materiaAsignada.getNombre());
		}
		return fueAgregado;
	}
	public boolean agregarProfesor (Profesor profesor) {
		Integer largo = this.profesores.size();
		boolean fueAgregado = false;
		profesores.add(profesor);
		if (this.profesores.size() > largo) {
			fueAgregado = true;
			System.out.println(profesor.getNombre() + " fue agregado a " + "comision de " + materiaAsignada.getNombre());
		}
		return fueAgregado;
	}
	
	public List<Alumno> getAlumnosDeComision () {
		return this.alumnos;
	}
	public List<Profesor> getProfesoresDeComision () {
		return this.profesores;
	}
	
	public Integer getCodigo () {
		return this.codigo;
	}
}
