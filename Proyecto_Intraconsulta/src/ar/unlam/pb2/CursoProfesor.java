package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class CursoProfesor {

	private Profesor profesor;
	private Comision comision;
	private Integer id = 0;
	
	public CursoProfesor(Profesor profesor, Comision comision) {
		this.profesor = profesor;
		this.comision = comision;
		this.id ++;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public Comision getComision() {
		return comision;
	}


	public void setComision(Comision comision) {
		this.comision = comision;
	}
}
