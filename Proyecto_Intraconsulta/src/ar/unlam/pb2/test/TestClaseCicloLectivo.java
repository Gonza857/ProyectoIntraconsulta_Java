package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.unlam.pb2.Universidad;

public class TestClaseCicloLectivo {
	
	//Podriamos verificar que la fecha del inicio del ciclo este antes que la del final por ejemplo.

	@org.junit.Test
	public void queSeAgregueUnCicloLectivoALaUniversidad () {
		Universidad unlam = new Universidad("Unlam");
		LocalDate fechaInscripcion = LocalDate.parse("1998-05-13");
		LocalDate fechaInicio = LocalDate.parse("1998-03-13");
		LocalDate fechaFinalizacion = LocalDate.parse("1998-06-13");
		
		
		boolean ejecucion = unlam.agregarCicloLectivo(fechaInscripcion, fechaInicio, fechaFinalizacion);
		
		assertTrue(ejecucion);		
	}
	
	@org.junit.Test
	public void queNoSeAgregueUnCicloLectivoSuperpuestoALaUniversidad () {
		Universidad unlam = new Universidad("Unlam");
		LocalDate fechaInscripcion = LocalDate.parse("1998-05-13");
		LocalDate fechaInicio = LocalDate.parse("1998-03-13");
		LocalDate fechaFinalizacion = LocalDate.parse("1998-06-13");
		
		LocalDate fechaInscripcion2 = LocalDate.parse("1998-05-15");
		LocalDate fechaInicio2 = LocalDate.parse("1998-05-13");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1998-09-13");
		
		
		boolean ejecucion = unlam.agregarCicloLectivo(fechaInscripcion, fechaInicio, fechaFinalizacion);
		 ejecucion = unlam.agregarCicloLectivo(fechaInscripcion2, fechaInicio2, fechaFinalizacion2);
		
		assertFalse(ejecucion);		
	}
}
