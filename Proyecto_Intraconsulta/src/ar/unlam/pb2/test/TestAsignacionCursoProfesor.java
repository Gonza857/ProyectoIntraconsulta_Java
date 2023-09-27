package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.unlam.pb2.Aula;
import ar.unlam.pb2.CicloLectivo;
import ar.unlam.pb2.Comision;
import ar.unlam.pb2.CursoProfesor;
import ar.unlam.pb2.Materia;
import ar.unlam.pb2.Profesor;
import ar.unlam.pb2.Turno;
import ar.unlam.pb2.Universidad;

public class TestAsignacionCursoProfesor {

	@org.junit.Test
	public void asignarProfesorALaComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreProfesor1 = "Gonzalo";
		Integer dniProfesor1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		assertTrue(unlam.agregarMateria(pb1, codPb1));
		assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor1));
		assertTrue(unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno));
		
		
		assertTrue(unlam.asignarProfesoraComision(dniProfesor1,numComision));		
	}
	
	@org.junit.Test
	public void queNoSeAsigneUnProfesorSiYaHayUnoParaVeinteAlumnos () {
		Universidad unlam = new Universidad("Unlam");
	
			LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
			LocalDate fechaInicio = LocalDate.parse("1990-10-15");
			LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
			
			Materia materia = new Materia("Ingles" , 0110);
			Integer numComision = 1000;
			Aula aula = new Aula(23,30);
			
			Turno turno = Turno.NOCHE;
			
			String nombreAlumno1 = "Gonzalo";
		
			
			String nombreProfesor1 = "ProfJose";
			Integer dniProfesor1 =  320;
			Integer dniProfesor2 =  322;
			
			CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
			
			assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor1));
		    assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor2));
		    
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 1));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 2));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 3));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 4));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 5));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 6));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 7));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 8));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 9));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 10));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 11));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 12));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 13));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 14));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 15));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 16));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 17));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 18));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 19));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 20));
			
			assertTrue(unlam.agregarMateria("Ingles" , 0110));
		    assertTrue(unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno));
			
			assertTrue(unlam.asignarAlumnoAComision(1, numComision));
			assertTrue(unlam.asignarAlumnoAComision(2, numComision));
			assertTrue(unlam.asignarAlumnoAComision(3, numComision));
			assertTrue(unlam.asignarAlumnoAComision(4, numComision));
			assertTrue(unlam.asignarAlumnoAComision(5, numComision));
			assertTrue(unlam.asignarAlumnoAComision(6, numComision));
			assertTrue(unlam.asignarAlumnoAComision(7, numComision));
			assertTrue(unlam.asignarAlumnoAComision(8, numComision));
			assertTrue(unlam.asignarAlumnoAComision(9, numComision));
			assertTrue(unlam.asignarAlumnoAComision(10, numComision));
			assertTrue(unlam.asignarAlumnoAComision(11, numComision));
			assertTrue(unlam.asignarAlumnoAComision(12, numComision));
			assertTrue(unlam.asignarAlumnoAComision(13, numComision));
			assertTrue(unlam.asignarAlumnoAComision(14, numComision));
			assertTrue(unlam.asignarAlumnoAComision(15, numComision));
			assertTrue(unlam.asignarAlumnoAComision(16, numComision));
			assertTrue(unlam.asignarAlumnoAComision(17, numComision));
			assertTrue(unlam.asignarAlumnoAComision(18, numComision));
			assertTrue(unlam.asignarAlumnoAComision(19, numComision));
			assertTrue(unlam.asignarAlumnoAComision(20, numComision));
		 
			assertTrue(unlam.asignarProfesoraComision(dniProfesor1,numComision));
	     	assertFalse(unlam.asignarProfesoraComision(dniProfesor2,numComision));		
	}
	@org.junit.Test
	public void queSiSeAsignenDosProfesorParaMasDeVeineteAlumnos () {
		Universidad unlam = new Universidad("Unlam");
	
			LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
			LocalDate fechaInicio = LocalDate.parse("1990-10-15");
			LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
			
			Materia materia = new Materia("Ingles" , 0110);
			Integer numComision = 1000;
			Aula aula = new Aula(23,30);
			
			Turno turno = Turno.NOCHE;
			
			String nombreAlumno1 = "Gonzalo";
		
			
			String nombreProfesor1 = "ProfJose";
			Integer dniProfesor1 =  320876;
			Integer dniProfesor2 =  322345;
			
			CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
			
			assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor1));
		    assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor2));
		    
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 1));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 2));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 3));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 4));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 5));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 6));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 7));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 8));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 9));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 10));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 11));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 12));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 13));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 14));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 15));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 16));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 17));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 18));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 19));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 20));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 21));
			assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, 22));
			
			assertTrue(unlam.agregarMateria("Ingles" , 0110));
		    assertTrue(unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno));

			assertTrue(unlam.asignarProfesoraComision(dniProfesor1,numComision));
			assertFalse(unlam.asignarProfesoraComision(dniProfesor2,numComision));	
			
			assertTrue(unlam.asignarAlumnoAComision(1, numComision));
			assertTrue(unlam.asignarAlumnoAComision(2, numComision));
			assertTrue(unlam.asignarAlumnoAComision(3, numComision));
			assertTrue(unlam.asignarAlumnoAComision(4, numComision));
			assertTrue(unlam.asignarAlumnoAComision(5, numComision));
			assertTrue(unlam.asignarAlumnoAComision(6, numComision));
			assertTrue(unlam.asignarAlumnoAComision(7, numComision));
			assertTrue(unlam.asignarAlumnoAComision(8, numComision));
			assertTrue(unlam.asignarAlumnoAComision(9, numComision));
			assertTrue(unlam.asignarAlumnoAComision(10, numComision));
			assertTrue(unlam.asignarAlumnoAComision(11, numComision));
			assertTrue(unlam.asignarAlumnoAComision(12, numComision));
			assertTrue(unlam.asignarAlumnoAComision(13, numComision));
			assertTrue(unlam.asignarAlumnoAComision(14, numComision));
			assertTrue(unlam.asignarAlumnoAComision(15, numComision));
			assertTrue(unlam.asignarAlumnoAComision(16, numComision));
			assertTrue(unlam.asignarAlumnoAComision(17, numComision));
			assertTrue(unlam.asignarAlumnoAComision(18, numComision));
			assertTrue(unlam.asignarAlumnoAComision(19, numComision));
			assertTrue(unlam.asignarAlumnoAComision(20, numComision));
			assertTrue(unlam.asignarAlumnoAComision(21, numComision));
			assertTrue(unlam.asignarAlumnoAComision(22, numComision));
			
			assertTrue(unlam.asignarProfesoraComision(dniProfesor2,numComision));	
	     		
	}
	@org.junit.Test
	public void queNoSeAsigneUnMismoProfesorALaMismaComisionDosVeces () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreProfesor1 = "Gonzalo";
		Integer dniProfesor1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		assertTrue(unlam.agregarMateria(pb1, codPb1));
		assertTrue(unlam.agregarProfesor(nombreProfesor1, "", null, null, dniProfesor1));
		assertTrue(unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno));
		
		
		assertTrue(unlam.asignarProfesoraComision(dniProfesor1,numComision));
		assertFalse(unlam.asignarProfesoraComision(dniProfesor1,numComision));
		
	}
}
