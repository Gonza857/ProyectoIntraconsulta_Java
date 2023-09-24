package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class CursoProfesor {

	private List<Profesor> profesores;
	private List<Comision> comisiones;
	private Integer id = 0;
	
	public CursoProfesor() {
		this.profesores = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.id ++;
	}


	public boolean asignarProfesor (Profesor profesor, Comision comision) {
		boolean fueAgregado = false;
		
		if(!verificarQueNoEsteEnLaMismaComision(profesor, comision)) {
			
		//en teoria el largo de ambas listas deberia ser igual asi que es algo excesivo quiza(no me sale la palabra) el punto es que el if puede quedar mas corto y virtualmente deberia seguir funcionando.
		
		Integer largoListaComision = this.comisiones.size();
		comisiones.add(comision);
		Integer largoListaAlumnos = this.profesores.size();
		
		profesores.add(profesor);
		if (this.profesores.size() > largoListaAlumnos && this.comisiones.size() > largoListaComision) {
			fueAgregado = true;
			System.out.println(profesor.getNombre() + " fue agregado a " + "comision de " + comision.getMateriaAsignada().getNombre());
		}}
		return fueAgregado;
	}


	private boolean verificarQueNoEsteEnLaMismaComision(Profesor profesor, Comision comision) {
		boolean existe = false;
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.comisiones.get(i).getCodigo().equals(comision.getCodigo()) && this.profesores.get(i).getDni().equals(profesor.getDni()) ) {
				existe = true;
			}
		}
		return existe;
	}


	public List<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}


	public List<Comision> getComisiones() {
		return comisiones;
	}


	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
