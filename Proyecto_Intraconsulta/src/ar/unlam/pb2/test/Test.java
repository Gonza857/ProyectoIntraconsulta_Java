package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.List;

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
		boolean ejecucion = unlam.agregarMateria(nombreMateria, codigoMateria);
		assertTrue(ejecucion);
	}
	
	@org.junit.Test
	public void queSeAgregueDosMaterias() {
		Universidad unlam = new Universidad("unlam");
		
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		
		String nombreMateria2 = "Programacion Basica 2";
		Integer codigoMateria2 = 200;
		
		boolean ejecucion = unlam.agregarMateria(nombreMateria, codigoMateria);
		ejecucion = unlam.agregarMateria(nombreMateria2, codigoMateria2);
		assertTrue(ejecucion);
	}
	
	@org.junit.Test
	public void buscarMateria() {
		Universidad unlam = new Universidad("unlam");
		
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		
		unlam.agregarMateria(nombreMateria, codigoMateria);
		Materia buscada = unlam.buscarMateria(codigoMateria);
		
		assertNotNull(buscada);
	}
	
	@org.junit.Test
	public void agregarCorrelativaAUnaMateria() {
		Universidad unlam = new Universidad("unlam");
		
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		String nombreMateria2 = "Programacion Basica 2";
		Integer codigoMateria2 = 200;
		
		unlam.agregarMateria(nombreMateria, codigoMateria);
		unlam.agregarMateria(nombreMateria2, codigoMateria2);
		
		boolean ejecucion = unlam.anadirCorrelativaMateria(codigoMateria2, codigoMateria);
		
		assertTrue(ejecucion);
	}
	
	@org.junit.Test
	public void verQueUnaMateriaTengaUnaCorrelativa() {
		Universidad unlam = new Universidad("unlam");
		
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		String nombreMateria2 = "Programacion Basica 2";
		Integer codigoMateria2 = 200;
		
		unlam.agregarMateria(nombreMateria, codigoMateria);
		unlam.agregarMateria(nombreMateria2, codigoMateria2);
		
		unlam.anadirCorrelativaMateria(codigoMateria2, codigoMateria);
		
		Materia buscada = unlam.buscarMateria(codigoMateria2);
		List<Materia> correlativas = buscada.getCorrelativas();
		
		System.out.println("Correlativas de:" + nombreMateria);
		for (int i = 0;i < correlativas.size(); i++) {
			System.out.println(correlativas.get(i).getNombre());
		}
		
		assertTrue(1 == buscada.getCantidadCorrelativas());
	}
	
	@org.junit.Test
	public void queNoSeAgregueUnaCorrelativa() {
		Universidad unlam = new Universidad("unlam");
		
		String nombreMateria = "Programacion Basica 1";
		Integer codigoMateria = 100;
		String nombreMateria2 = "Programacion Basica 2";
		Integer codigoMateria2 = 200;
		Integer codigoDeMateriaNoRegistrada = 400;
		
		unlam.agregarMateria(nombreMateria, codigoMateria);
		unlam.agregarMateria(nombreMateria2, codigoMateria2);
		
		boolean ejecucion = unlam.anadirCorrelativaMateria(codigoMateria2, codigoDeMateriaNoRegistrada);
		
		Materia buscada = unlam.buscarMateria(codigoMateria2);
		List<Materia> correlativas = buscada.getCorrelativas();
		
		System.out.println("Materia " + nombreMateria2 + " tiene " + correlativas.size() + " correlativas");
		
		assertFalse(ejecucion);
	}
	
	@org.junit.Test
	public void queUnaMateriaTengaTresCorrelativas() {
		Universidad unlam = new Universidad("unlam");
		
		String bd1 = "Base de datos 1";
		Integer codBd1 = 201;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		String ig = "Informatica general";
		Integer codIg = 102;
		String mg = "Matematica general";
		Integer codMg = 103;
		
		unlam.agregarMateria(bd1, codBd1);
		unlam.agregarMateria(pb1, codPb1);
		unlam.agregarMateria(ig, codIg);
		unlam.agregarMateria(mg, codMg);
		
		unlam.anadirCorrelativaMateria(codBd1, codPb1);
		unlam.anadirCorrelativaMateria(codBd1, codIg);
		unlam.anadirCorrelativaMateria(codBd1, codMg);
		
		Materia buscada = unlam.buscarMateria(codBd1);
		List<Materia> correlativas = buscada.getCorrelativas();
		
		System.out.println("Correlativas de: " + bd1);
		for (int i = 0;i < correlativas.size(); i++) {
			System.out.println(correlativas.get(i).getNombre());
		}
		
		assertTrue(3 == buscada.getCantidadCorrelativas());
	}

	@org.junit.Test
	public void queSeAgregueUnAlumnoALaUniversidad () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno = "Gonzalo";
		Integer dniAlumno =  45400606;
		boolean ejecucion = unlam.registrarAlumno(nombreAlumno, dniAlumno);
		assertTrue(ejecucion);		
	}
	
	@org.junit.Test
	public void queSeIntenteRegistrarUnAlumnoYaRegistrado () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno = "Gonzalo";
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno =  45400606;
		boolean ejecucion = unlam.registrarAlumno(nombreAlumno, dniAlumno);
		ejecucion = unlam.registrarAlumno(nombreAlumno2, dniAlumno);
		assertFalse(ejecucion);		
	}
	
}
