package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.unlam.pb2.Universidad;

public class TestClaseProfesor {

	@org.junit.Test
	public void queSeAgregueUnProfesorALaUniversidad () {
		Universidad unlam = new Universidad("Unlam");
		String nombreProfesor = "ProfAlonso";
		String apellidoProfesor = "Casto";
		LocalDate fechaNacimiento = LocalDate.parse("1986-05-13");
		LocalDate fechaIngreso = LocalDate.now();
		Integer dniProfesor =  45400606;
		boolean ejecucion = unlam.agregarProfesor(nombreProfesor, apellidoProfesor, fechaNacimiento, fechaIngreso, dniProfesor);
		assertTrue(ejecucion);		
	}
	
	@org.junit.Test
	public void queSeIntenteRegistrarUnProfesorYaRegistrado () {
		Universidad unlam = new Universidad("Unlam");
		String nombreProfesor = "ProfPileci";
		String apellidoProfesor = "Casto";
		LocalDate fechaNacimiento = LocalDate.parse("1987-05-13");
		LocalDate fechaIngreso = LocalDate.now();
		
		String nombreProfesor2 = "ProfJuan";
		String apellidoProfesor2 = "Casto";
		LocalDate fechaNacimiento2 = LocalDate.parse("1979-04-25");
		LocalDate fechaIngreso2 = LocalDate.now();
		
		Integer dniProfesor =  45400606;
		
		boolean ejecucion = unlam.agregarProfesor(nombreProfesor, apellidoProfesor, fechaNacimiento, fechaIngreso, dniProfesor);
		ejecucion = unlam.agregarProfesor(nombreProfesor2, apellidoProfesor2, fechaNacimiento2, fechaIngreso2, dniProfesor);
		assertFalse(ejecucion);		
	}
}
