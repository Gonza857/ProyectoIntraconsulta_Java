package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Aula;
import ar.unlam.pb2.CicloLectivo;
import ar.unlam.pb2.Comision;
import ar.unlam.pb2.CursoAlumno;
import ar.unlam.pb2.CursoProfesor;
import ar.unlam.pb2.Materia;
import ar.unlam.pb2.Profesor;
import ar.unlam.pb2.Turno;
import ar.unlam.pb2.Universidad;

public class TestClaseComision {

	@org.junit.Test
	public void crearComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 111;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		

		boolean agregado = unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);

		
		assertTrue(agregado);		
	}
	
	@org.junit.Test
	public void queNoSeCreeComisionSuperpuesta () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 111;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		

		LocalDate fechaIncripcion2 = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio2 = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1990-12-01");
	
		Materia materia2 = new Materia("Ingles" , 0110);
		Integer numComision2 = 111;
		Aula aula2 = new Aula(22,30);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno2 = Turno.NOCHE;
		

		boolean agregado = unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		agregado = unlam.abrirComision(materia2, numComision2, aula2, cicloLectivo2, turno2);

		
		assertFalse(agregado);		
	}
	


}
