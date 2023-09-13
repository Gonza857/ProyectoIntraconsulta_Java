package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import ar.unlam.pb2.*;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearLaUniversidad() {
		Universidad unlam = new Universidad("unlam");
		assertNotNull(unlam);
	}
	
	@org.junit.Test
	public void queSeAgregueUnaMateria() {
		Universidad unlam = new Universidad("unlam");
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		boolean ejecucion = unlam.AgregarMateria(nombreMateria, codigoMateria);
		assertTrue(ejecucion);
	}

	
}
