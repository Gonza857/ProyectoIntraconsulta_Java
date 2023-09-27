	package ar.unlam.pb2;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import javax.swing.plaf.FontUIResource;

public class Universidad {
	private String nombre;
	private LocalDate fechaActual; //Atributo generado, para que los test no den failure usando el metodo .now() de LocalDate, puesto que no sabemos cuando se corregira esto.
	private List<Alumno> alumnos;
	private List<Profesor> profesores;
	private List<Materia> materias;
	private List<Aula> aulas;
	private List<Comision> comisiones;
	private List<CicloLectivo> ciclosLectivos;
	private List<CursoAlumno> cursosAlumnos;
	private List<CursoProfesor> cursosProfesores;
	private List<Nota> notas;
	
	public Universidad (String nombre) {
		this.nombre = nombre;
		this.fechaActual = LocalDate.parse("1990-05-15");
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cursosAlumnos = new ArrayList<>();
		this.cursosProfesores = new ArrayList<>();
		this.notas = new ArrayList<>();
	}
	
	public boolean asignarNota (Integer idComision, Integer dni,Integer valorNota) {
		boolean asignada = false;
		if(valorNota <= 10 && valorNota >=1) {
		CursoAlumno cursoAlumno = getCursoAlumno(idComision,dni);
		if(!verificarQueNoHayaFinalizado(cursoAlumno) ) {
		
		Instancia[] instancias = Instancia.values();
		Integer largo = cursoAlumno.getNotas().size();
		Nota aAsignar = new Nota(valorNota, instancias[cursoAlumno.getContador()]) ;

		cursoAlumno.setNotasAdd(aAsignar);
		System.out.println("Se asigno la nota de " + valorNota + " en la intancia de " + instancias[cursoAlumno.getContador()] + " al alumno " + cursoAlumno.getAlumno().getNombre());
		if(largo < cursoAlumno.getNotas().size()) {
			asignada = true;
			if(valorNota >= 4) {
				cursoAlumno.setContador(cursoAlumno.getContador() + 2);
			}else {
				cursoAlumno.setContador(cursoAlumno.getContador() + 1);
			}
			
			
			
		}}
		if(valorNota > 4) {
			cursoAlumno.setContadorAprobadas(cursoAlumno.getContadorAprobadas() + 1);
		}
		if(cursoAlumno.getContadorAprobadas() >= 2) {
			cursoAlumno.actualizarSituacion();
		}}
		
		return asignada;
		
	}
	
	public boolean calcularPromedioFinal(Integer idAlumno){
		boolean promediado = false;
		Double promedio = 0.0;
		Double acumulador = 0.0;
	for (int i = 0; i < this.cursosAlumnos.size(); i++) {
		if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(idAlumno)) {
			if(verificarQueNoHayaAprobadoMateria(this.cursosAlumnos.get(i))) {
				for (int j = 0; j < this.cursosAlumnos.get(i).getNotas().size(); j++) {
					
				if(!(this.cursosAlumnos.get(i).getNotas().get(j).getValor() < 4)) {
				acumulador +=(double) this.cursosAlumnos.get(i).getNotas().get(j).getValor();
	            }                
				promediado = true;
				promedio=(double) Math.floor( acumulador / 2.0);

				this.cursosAlumnos.get(i).getComision().setPromedioFinal(promedio);
				}
				}
				
		}}
		
         	return promediado;
	}
	
	public List<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer idAlumno) {
	    Materia materiaADescartar = null;
		List<Materia> materiasFaltantes = this.materias;
		
		for(int i = 0; i < this.cursosAlumnos.size() ; i++) {
			if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(idAlumno) && this.cursosAlumnos.get(i).getCondicionFinal().equals(CondicionFinal.APROBADO) ) {
				materiaADescartar = this.cursosAlumnos.get(i).getComision().getMateriaAsignada();
				materiasFaltantes.remove(materiaADescartar);
			}
			}
		
		
		
		return materiasFaltantes;
	}
	
	public List<Nota> obtenerNotas(Integer idAlumno,Integer idComision){
		CursoAlumno cursoAlumno = getCursoAlumno(idComision,idAlumno);
		
		return cursoAlumno.getNotas();
	}
	
	
	public List<Materia> obtenerMateriasAprobadasParaUnAlumno (Integer idAlumno) {
		List<Materia> materiasAprobadas = new ArrayList<>();
		
		Alumno alumno = getAlumno(idAlumno);
		
		for(int i = 0; i < this.cursosAlumnos.size() ; i++) {
			if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(alumno.getDni()) && this.cursosAlumnos.get(i).getCondicionFinal().equals(CondicionFinal.APROBADO) ) {
			 materiasAprobadas.add(this.cursosAlumnos.get(i).getComision().getMateriaAsignada());
			}
			}
		
		return materiasAprobadas;
	}

	public boolean asignarProfesoraComision (Integer dniProfesor, Integer idComision) {
		boolean fueAgregado = false;
		Profesor profesor = getProfesor(dniProfesor);
		Comision comision = getComision(idComision);
		
		CursoProfesor cursoProfesor = new CursoProfesor(profesor,comision);
		
		if(!verificarQueNoEsteEnLaMismaComision(cursoProfesor) && !verificarQueNoHayanProfesorEnVeinteAlumno(cursoProfesor)) {
			
		Integer largoLista= this.cursosProfesores.size();
		
		cursosProfesores.add(cursoProfesor);
		if (this.cursosProfesores.size() > largoLista) {
			fueAgregado = true;
			System.out.println(profesor.getNombre() + " fue agregado a la comision de " + comision.getMateriaAsignada().getNombre());
		}}
		return fueAgregado;
	}

	public boolean asignarAlumnoAComision(Integer dniAlumno1, Integer codComision) { 
		boolean fueAgregado = false;
		Alumno alumno = getAlumno(dniAlumno1);
		Comision comision = getComision(codComision);
		CursoAlumno nuevaAsignacion = new CursoAlumno( alumno, comision); 
		if(!verificacionesParaAgregarAlumnoAComision(nuevaAsignacion)) {
		Integer largo = this.cursosAlumnos.size();
		
		this.cursosAlumnos.add(nuevaAsignacion);
		
		if (this.cursosAlumnos.size() > largo ) {
			fueAgregado = true;
			System.out.println(alumno.getNombre() + " fue registrado a la materia " + comision.getMateriaAsignada());
		}
		}
		return fueAgregado;
		
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
	
	public boolean verificacionesParaAgregarAlumnoAComision(CursoAlumno cursoAlumno) {
		boolean verificado = false;
		if(verificarCorrelativasAprobadas(cursoAlumno) || verificarFechaDeInscripcion(cursoAlumno) || verificarCuposDelAula(cursoAlumno) || verificarSuperposicionDeHorarios(cursoAlumno) || verificarQueNoHayaAprobadoMateria(cursoAlumno)) {
			verificado = true;
		}
		
		return verificado;
	}
	private boolean verificarQueNoHayaAprobadoMateria(CursoAlumno cursoAlumno) {
		boolean verificado = false;
		for(int i = 0; i < this.cursosAlumnos.size() ; i++) {
			if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(cursoAlumno.getAlumno().getDni()) && this.cursosAlumnos.get(i).getComision().getMateriaAsignada().getCodigo().equals(cursoAlumno.getComision().getMateriaAsignada().getCodigo()) && this.cursosAlumnos.get(i).getCondicionFinal().equals(CondicionFinal.APROBADO) ) {
				verificado = true;
			}
			}
		return verificado;
	}

	private boolean verificarSuperposicionDeHorarios(CursoAlumno cursoAlumno) {
		boolean verificado = false;
		for(int i = 0; i < this.cursosAlumnos.size() ; i++) {
			if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(cursoAlumno.getAlumno().getDni()) && this.cursosAlumnos.get(i).getComision().getTurno().equals(cursoAlumno.getComision().getTurno())) {
				verificado = true;
			}
			}
		return verificado;
	}

	private boolean verificarCuposDelAula(CursoAlumno cursoAlumno) {
		boolean verificado = false;
		Integer contadorDeAlumnosAnotadosALaComision = 0;
		for(int i = 0; i < this.cursosAlumnos.size() ; i++) {
			if(this.cursosAlumnos.get(i).getComision().getCodigo().equals(cursoAlumno.getComision().getCodigo())) {
				contadorDeAlumnosAnotadosALaComision ++;
			}
		}
		if(cursoAlumno.getComision().getAulaAsignada().getAsientos() <= contadorDeAlumnosAnotadosALaComision) {
			verificado = true;
		}
		
		return verificado;
	}

	private boolean verificarFechaDeInscripcion(CursoAlumno cursoAlumno) {
		boolean enFecha = false;
		if(!this.fechaActual.equals(cursoAlumno.getComision().getCicloLectivoAsignado().getFechaInscripcion())) {
			enFecha = true;
		}
		
		return enFecha;
	}

	public boolean verificarQueNoHayaFinalizado(CursoAlumno cursoAlumno) {
		boolean termino = true;
		if(cursoAlumno.getCondicionFinal().equals(CondicionFinal.CURSANDO)) {
			termino = false;
		}
		
		return termino;
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
	


	private boolean verificarQueNoHayanProfesorEnVeinteAlumno(CursoProfesor cursoProfesor) {
		boolean verificado = false;
		Integer contadorDeAlumnosAnotadosALaComision = 0;
		Integer contadorDeProfesoresAnotadosALaComision = 0;
		for(int i = 0; i < this.comisiones.size() ; i++) {
			if(this.comisiones.get(i).getCodigo().equals(cursoProfesor.getComision().getCodigo())) {
				
			for(int j = 0; j < this.cursosAlumnos.size(); j++) {
			if(this.comisiones.get(i).getCodigo().equals(this.cursosAlumnos.get(j).getComision().getCodigo()) && this.cursosAlumnos.get(j).getCondicionFinal().equals(CondicionFinal.CURSANDO)) {
				contadorDeAlumnosAnotadosALaComision ++;
			}
			}
			for (int k = 0; k < this.cursosProfesores.size(); k++) {
				if(this.comisiones.get(i).getCodigo().equals(this.cursosProfesores.get(k).getComision().getCodigo())) {
					contadorDeProfesoresAnotadosALaComision ++;
				}
			}
	
			}
		}
		
		if(contadorDeProfesoresAnotadosALaComision > 0 ) {
			if(contadorDeAlumnosAnotadosALaComision <= contadorDeProfesoresAnotadosALaComision + 19) {
			verificado = true;
			}
		}
		return verificado;
	}

	private boolean verificarQueNoEsteEnLaMismaComision(CursoProfesor cursoProfesor) {
		boolean existe = false;
		for (int i = 0; i < this.cursosProfesores.size(); i++) {
			if (this.cursosProfesores.get(i).getProfesor().getDni().equals(cursoProfesor.getProfesor().getDni()) && this.cursosProfesores.get(i).getId().equals(cursoProfesor.getId())) {
				existe = true;
			}
		}
		return existe;
	}

	
	
 	private boolean verificarCorrelativasAprobadas(CursoAlumno nuevaAsignacion) {
		boolean debe = false;
		Integer aprobadas = 0;
		List<Materia> correlativas = nuevaAsignacion.getComision().getMateriaAsignada().getCorrelativas();
		Alumno alumnoAChequear = nuevaAsignacion.getAlumno();
		
	    for (int j = 0; j < correlativas.size(); j++) {
	    	
		for (int i = 0; i < this.cursosAlumnos.size();i++) {
				
		if(this.cursosAlumnos.get(i).getAlumno().getDni().equals(alumnoAChequear.getDni()) && this.cursosAlumnos.get(j).getComision().getMateriaAsignada().getCodigo().equals(correlativas.get(j).getCodigo())) {
					
					if(this.cursosAlumnos.get(i).getCondicionFinal().equals(CondicionFinal.APROBADO)) {
						aprobadas++;
					
				}
				
			}
				}
		}
		if(aprobadas != nuevaAsignacion.getComision().getMateriaAsignada().getCantidadCorrelativas()) {
			debe = true;
		}
		
		
		
		return debe;
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


	public boolean verificarSolapamientos(Materia materia, Turno turno, CicloLectivo cicloLectivo) {
		boolean solapado = false;
		
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getCicloLectivoAsignado().getId().equals(cicloLectivo.getId()) && this.comisiones.get(i).getTurno().equals(turno) && this.comisiones.get(i).getMateriaAsignada().getCodigo().equals(materia.getCodigo())) {
				solapado = true;
			}
		}
		
		return solapado;
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
	public CursoAlumno getCursoAlumno (Integer idComision, Integer dniAlumno) {
		CursoAlumno buscado = null;
		for (int i = 0; i < this.cursosAlumnos.size(); i++) {
			if (this.cursosAlumnos.get(i).getAlumno().getDni().equals(dniAlumno) && this.cursosAlumnos.get(i).getComision().getCodigo().equals(idComision)) {
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

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public List<CursoProfesor> getCursosProfesores() {
		return cursosProfesores;
	}

	public void setCursosProfesores(List<CursoProfesor> cursosProfesores) {
		this.cursosProfesores = cursosProfesores;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}


}
