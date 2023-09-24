	package ar.unlam.pb2;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import javax.swing.plaf.FontUIResource;

public class Universidad {
	private String nombre;
	private List<Alumno> alumnos;
	private List<Profesor> profesores;
	private List<Materia> materias;
	private List<Aula> aulas;
	private List<Comision> comisiones;
	private List<CicloLectivo> ciclosLectivos;
	private List<CursoAlumno> cursosAlumnos;
	
	public Universidad (String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cursosAlumnos = new ArrayList<>();
	}
	
	public boolean agregarCicloLectivo (LocalDate fechaInscripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
		boolean fueAgregada = false;
		if (!verificarQueNoSeSuperpoga( fechaInicio, fechaFinalizacion)) {
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInscripcion, fechaInicio, fechaFinalizacion);
		Integer largo = this.ciclosLectivos.size();
		this.ciclosLectivos.add(nuevoCicloLectivo);
		if (ciclosLectivos.size() > largo) {
			fueAgregada = true;
			System.out.println("Ciclo Lectivo con inicio en " + fechaInicio +  " y finalizacion en " + fechaFinalizacion + " fue agregado.");
		}
	}
		return fueAgregada;
	}
	
	public boolean verificarQueNoSeSuperpoga( LocalDate fechaInicio, LocalDate fechaFinalizacion) {
		boolean superpone = false;
		for (int i = 0; i < this.ciclosLectivos.size(); i++) {
		    if(fechaInicio.isBefore(this.ciclosLectivos.get(i).getFechaFinalizacion()) && fechaFinalizacion.isAfter(this.ciclosLectivos.get(i).getFechaInicio())) {
			superpone = true;
	     	}
		}
		return superpone;
	}
	
	
	
 	public boolean agregarMateria (String nombre, Integer codigo) {
		boolean fueAgregada = false;
		if (!verificarSiYaExisteMateria(codigo)) {
		Materia nuevaMateria = new Materia(nombre, codigo);
		Integer largo = this.materias.size();
		this.materias.add(nuevaMateria);
		if (materias.size() > largo) {
			fueAgregada = true;
			System.out.println("Materia " + nombre +  " agregada.");
		}
	}
		return fueAgregada;
	}
	
	private boolean verificarSiYaExisteMateria(Integer codigo) {
		boolean existe = false;
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo)) {
				existe = true;
			}
		}
		return existe;
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

	public boolean registrarAlumno(String nombreAlumno, String apellidoAlumno, LocalDate fechaNacimiento, LocalDate fechaIngreso, Integer dniAlumno) {
		boolean fueAgregado = false;
		if (!verificarSiYaExisteElAlumno(dniAlumno)) {
			Alumno nuevoAlumno = new Alumno(nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso, dniAlumno);
			Integer largo = this.alumnos.size();
			this.alumnos.add(nuevoAlumno);
			if (this.alumnos.size() > largo ) {
				fueAgregado = true;
				System.out.println(dniAlumno + " registrado.");
			}
		}
		
		return fueAgregado;
	}
	
	public boolean agregarProfesor(String nombreProfesor, String apellidoProfesor, LocalDate fechaNacimiento, LocalDate fechaIngreso, Integer dniProfesor) {
		boolean fueAgregado = false;
		if (!verificarSiYaExisteElProfesor(dniProfesor)) {
			Profesor nuevoProfesor = new Profesor(nombreProfesor, apellidoProfesor, fechaNacimiento, fechaIngreso, dniProfesor);
			Integer largo = this.alumnos.size();
			this.profesores.add(nuevoProfesor);
			if (this.profesores.size() > largo ) {
				fueAgregado = true;
				System.out.println(dniProfesor + " registrado.");
			}
		}
		
		return fueAgregado;
	}

	
	private boolean verificarSiYaExisteElProfesor(Integer dniProfesor) {
		boolean existe = false;
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dniProfesor)) {
				existe = true;
			}
		}
		return existe;
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

	public boolean abrirComision (Materia materia, Integer numComision, Aula aula, CicloLectivo cicloLectivo, Turno turno) {
		boolean agregado = false;
			if(!verificarSolapamientos(materia, turno, cicloLectivo)) {
			
			
			Comision comisionAgregada = new Comision(materia,numComision,aula,cicloLectivo,turno);	
			comisiones.add(comisionAgregada);
			System.out.println("Comision para " + materia.getNombre()+  " creada.");
			agregado = true;
			}
			return agregado;
	}
	
	public boolean verificarSolapamientos(Materia materia, Turno turno, CicloLectivo cicloLectivo) {
		boolean solapado = false;
		
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getCicloLectivoAsignado().getId().equals(cicloLectivo.getId()) && this.comisiones.get(i).getTurno().equals(turno) && this.comisiones.get(i).getMateriaAsignada().getCodigo().equals(materia.getCodigo())) {
				solapado = true;
			}
		}
		
		return solapado;
	}
	
	
	public boolean asignarAlumnoAComision(Integer dniAlumno1, Integer codComision) { 
		boolean fueAgregado = false;
		Alumno alumno = getAlumno(dniAlumno1);
		Comision comision = getComision(codComision);
		CursoAlumno nuevaAsignacion = new CursoAlumno( alumno, comision); 
		Integer largo = this.cursosAlumnos.size();
		
		this.cursosAlumnos.add(nuevaAsignacion);
		
		if (this.cursosAlumnos.size() > largo ) {
			fueAgregado = true;
			System.out.println(alumno.getNombre() + " fue registrado a la materia " + comision.getMateriaAsignada());
		}
		return fueAgregado;
		
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
	public List<Materia> getMaterias () {
		return this.materias;
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
	public CursoAlumno getCursoAlumno (Integer dniAlumno, Integer idMateria) {
		CursoAlumno buscado = null;
		for (int i = 0; i < this.cursosAlumnos.size() && buscado == null; i++) {
			if (this.cursosAlumnos.get(i).getAlumno().getDni().equals(dniAlumno) && this.cursosAlumnos.get(i).getComision().getCodigo().equals(idMateria)) {
				buscado =  this.cursosAlumnos.get(i);
			}
		}
		return buscado;
	}
	public Profesor getProfesor (Integer dni) {
		Profesor buscado = null;
		for (int i = 0; i < this.profesores.size() && buscado == null; i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				buscado =  this.profesores.get(i);
			}
		}
		return buscado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<Aula> getAulas() {
		return aulas;
	}


	public List<Comision> getComisiones() {
		return comisiones;
	}


	public List<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<CursoAlumno> getCursosAlumnos() {
		return cursosAlumnos;
	}

	public void setCursosAlumnos(List<CursoAlumno> cursosAlumnos) {
		this.cursosAlumnos = cursosAlumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public void setCiclosLectivos(List<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}


}
