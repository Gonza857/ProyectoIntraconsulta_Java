package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.FontUIResource;

public class Universidad {
	private String nombre;
	private List<Alumno> alumnos;
	private List<Materia> materias;
	private List<Aula> aulas;
	
	
	public Universidad (String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
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
			System.out.println("Largo: " + this.materias.size());
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

}
