package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.Test;

import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Aula;
import ar.unlam.pb2.CicloLectivo;
import ar.unlam.pb2.Comision;
import ar.unlam.pb2.CondicionFinal;
import ar.unlam.pb2.CursoAlumno;
import ar.unlam.pb2.Instancia;
import ar.unlam.pb2.Materia;
import ar.unlam.pb2.Turno;
import ar.unlam.pb2.Universidad;

public class AsignacionCursoAlumno {

	@org.junit.Test
	public void asignarAlumnoALaComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		Alumno alumnoParaAgregar = unlam.getAlumno(dniAlumno1);
		Comision comisionParaAgregar = unlam.getComision(1000);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
		boolean ejecucion = false;
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		
	}
	@org.junit.Test
	public void asignarNota () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		Alumno alumnoParaAgregar = unlam.getAlumno(dniAlumno1);
		Comision comisionParaAgregar = unlam.getComision(1000);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);

	    unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		Integer valorNota = 3;
		
		assertTrue( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		
	}
	
	@org.junit.Test
	public void asignarDosNotas () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		Alumno alumnoParaAgregar = unlam.getAlumno(dniAlumno1);
		Comision comisionParaAgregar = unlam.getComision(1000);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		assertTrue( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		
	}
	@org.junit.Test
	public void verAlumnosDeComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23);
		
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno2 =  200;
		
		String nombreAlumno3 = "Dario";
		Integer dniAlumno3 =  100;
		
		Alumno alumno1 = unlam.getAlumno(dniAlumno1);
		Alumno alumno2 = unlam.getAlumno(dniAlumno2);
		Alumno alumno3 = unlam.getAlumno(dniAlumno3);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		
		Comision comision = unlam.getComision(1000);
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.registrarAlumno(nombreAlumno2, "", null, null, dniAlumno2);
		unlam.registrarAlumno(nombreAlumno3, "", null, null, dniAlumno3);
		
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		boolean ejecucion = false;
		
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno2, numComision));
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno3, numComision));
		
		//No recuerdo como mostrar listas ahora :"u
		
			
	}
	@org.junit.Test
	public void puedaAprobarDirecto () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		Alumno alumnoParaAgregar = unlam.getAlumno(dniAlumno1);
		Comision comisionParaAgregar = unlam.getComision(1000);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		assertTrue( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		assertFalse( unlam.getCursoAlumno(dniAlumno1, numComision).asignarNota(valorNota, dniAlumno1) );
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(dniAlumno1, numComision).getCondicionFinal());
	}
}
