	package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.FontUIResource;

public class Universidad {
	private String nombre;
	private List<Alumno> alumnos;
	private List<Materia> materias;
	private List<Aula> aulas;
	private List<Comision> comisiones;
	
	
	public Universidad (String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.comisiones = new ArrayList<>();
	}
	
	public List<Materia> getMaterias () {
		return this.materias;
	}
	
	public boolean agregarMateria (String nombre, Integer codigo) {
		boolean fueAgregada = false;
		Integer largo = materias.size();
		Materia nuevaMateria = new Materia(nombre, codigo);
		materias.add(nuevaMateria);
		if (materias.size() > largo) {
			fueAgregada = true;
			System.out.println("Materia " + nombre +  " agregada.");
		}
		return fueAgregada;
	}
	
	public Materia buscarMateria (Integer codigo) {
		System.out.println("Buscando materia: " + codigo);
		Materia materiaBuscada = null;
		int indice = 0;
		while (indice < this.materias.size() && materiaBuscada == null) {
			if (this.materias.get(indice).getCodigo().equals(codigo)) {
				materiaBuscada=this.materias.get(indice);
				System.out.println("Encontré: " + materiaBuscada.getCodigo());
			}
			indice++;
		}
		return materiaBuscada;
	}
	
	public boolean anadirCorrelativaMateria (Integer materiaCod, Integer correlativaCod) {
		Materia materia = buscarMateria(materiaCod);
		Materia correlativa = buscarMateria(correlativaCod);
		System.out.println(correlativa);
		boolean fueAgregada = false;
		if (materia != null && correlativa != null) {
			materia.anadirCorrelativa(correlativa);
			fueAgregada = true;
			System.out.println("Añadido.");
		}
		return fueAgregada;
	}

	public boolean registrarAlumno(String nombreAlumno, Integer dniAlumno) {
		boolean fueAgregado = false;
		if (!verificarSiYaExisteElAlumno(dniAlumno)) {
			Alumno nuevoAlumno = new Alumno(nombreAlumno, dniAlumno);
			Integer largo = this.alumnos.size();
			this.alumnos.add(nuevoAlumno);
			if (this.alumnos.size() > largo ) {
				fueAgregado = true;
				System.out.println(dniAlumno + " registrado.");
			}
		}
		
		return fueAgregado;
	}
	
	public boolean verificarSiYaExisteElAlumno (Integer dni) {
		boolean existe = false;
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public Integer getCantidadDeAlumnosRegistrados () {
		System.out.println("Largo: " + this.alumnos.size());
		return this.alumnos.size();
	}
	
	public List<Alumno> getAlumnosRegistrados () {
		return this.alumnos;
	}
	
	public Alumno getAlumno (Integer dni) {
		Alumno buscado = null;
		for (int i = 0; i < this.alumnos.size() && buscado == null; i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				buscado =  this.alumnos.get(i);
			}
		}
		return buscado;
	}
	
	public void abrirComision (Integer codMateria, Integer numComision) {
		Materia buscarMateriaParaComision = buscarMateria(codMateria);
		if (buscarMateriaParaComision != null) {
			Comision com0 = new Comision(buscarMateriaParaComision,numComision);	
			comisiones.add(com0);
			System.out.println("Comision para " + buscarMateriaParaComision.getNombre()+  " creada.");
		}		
	}
	
	public Integer getCantidadComisiones () {
		return this.comisiones.size();
	}
	
	public Comision getComision (Integer codComision) {
		Comision buscada = null;
		for (int i = 0; i < this.comisiones.size() && buscada == null; i++) {
			if (this.comisiones.get(i).getCodigo().equals(codComision)) {
				buscada = this.comisiones.get(i);
			}
		}
		return buscada;
	}

	public boolean agregarAlumnoAComision(Integer dniAlumno1, Integer codComision) {
		Alumno alumno = getAlumno(dniAlumno1);
		Comision comision = getComision(codComision);
		boolean pudoAgregar = false;
		if (alumno != null && comision != null) {
			pudoAgregar = comision.agregarAlumno(alumno);
		}
		return pudoAgregar;
		
		
	}

}
