package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Universidad;

public class TestClaseAlumnos {

	@org.junit.Test
	public void queSeAgregueUnAlumnoALaUniversidad () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno = "Gonzalo";
		String apellidoAlumno = "Casto";
		LocalDate fechaNacimiento = LocalDate.parse("1998-05-13");
		LocalDate fechaIngreso = LocalDate.now();
		Integer dniAlumno =  45400606;
		boolean ejecucion = unlam.registrarAlumno(nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso, dniAlumno);
		assertTrue(ejecucion);		
	}
	
	@org.junit.Test
	public void queSeIntenteRegistrarUnAlumnoYaRegistrado () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno = "Gonzalo";
		String apellidoAlumno = "Casto";
		LocalDate fechaNacimiento = LocalDate.parse("1998-05-13");
		LocalDate fechaIngreso = LocalDate.now();
		
		String nombreAlumno2 = "Leonel";
		String apellidoAlumno2 = "Casto";
		LocalDate fechaNacimiento2 = LocalDate.parse("1995-04-25");
		LocalDate fechaIngreso2 = LocalDate.now();
		
		Integer dniAlumno =  45400606;
		
		boolean ejecucion = unlam.registrarAlumno(nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso, dniAlumno);
		ejecucion = unlam.registrarAlumno(nombreAlumno2, apellidoAlumno2, fechaNacimiento2, fechaIngreso2, dniAlumno);
		assertFalse(ejecucion);		
	}
	
	@org.junit.Test
	public void queSeRegistrenTresALumnos () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno2 =  200;
		
		String nombreAlumno3 = "Dario";
		Integer dniAlumno3 =  100;
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.registrarAlumno(nombreAlumno2, "", null, null, dniAlumno2);
		unlam.registrarAlumno(nombreAlumno3, "", null, null, dniAlumno3);
		
		assertTrue(3 == unlam.getCantidadDeAlumnosRegistrados());		
	}
	
	@org.junit.Test
	public void traerListaDeAlumnosRegistrados () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno2 =  200;
		
		String nombreAlumno3 = "Dario";
		Integer dniAlumno3 =  100;
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.registrarAlumno(nombreAlumno2, "", null, null, dniAlumno2);
		unlam.registrarAlumno(nombreAlumno3, "", null, null, dniAlumno3);
		
		System.out.println("Registrados:");
		List<Alumno> registrados = unlam.getAlumnosRegistrados();
		for (int i = 0; i < registrados.size(); i++) {
			System.out.println((i+1) +  ") " + registrados.get(i).getNombre());
		}
		
		assertTrue(3 == registrados.size());		
	}
}
