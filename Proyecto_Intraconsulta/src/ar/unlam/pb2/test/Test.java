package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import ar.unlam.pb2.*;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearLaUniversidad() {
		Universidad unlam = new Universidad("unlam");
		assertNotNull(unlam);
	}
	


	

}
