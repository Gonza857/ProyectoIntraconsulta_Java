package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Comision;
import ar.unlam.pb2.Universidad;

public class TestClaseComision {

	@org.junit.Test
	public void crearComision () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(codPb1, 1000);
		
		assertTrue(1 == unlam.getCantidadComisiones());		
	}
	@org.junit.Test
	public void agregarAlumnoALaComision () {
		Universidad unlam = new Universidad("Unlam");
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(codPb1, 1000);
		
		Alumno alumnoParaAgregar = unlam.getAlumno(dniAlumno1);
		Comision comisionParaAgregar = unlam.getComision(1000);
		boolean ejecucion = false;
		if (alumnoParaAgregar != null && comisionParaAgregar != null) {
			ejecucion = comisionParaAgregar.agregarAlumno(alumnoParaAgregar);
		}
		assertTrue(ejecucion);		
	}
	
	@org.junit.Test
	public void verAlumnosDeComision () {
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
		
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.abrirComision(codPb1, 1000);
		
		boolean ejecucion = false;
		
		ejecucion = unlam.agregarAlumnoAComision(dniAlumno1,1000);
		ejecucion = unlam.agregarAlumnoAComision(dniAlumno2,1000);
		ejecucion = unlam.agregarAlumnoAComision(dniAlumno3,1000);
		
		Comision comisionParaVer = unlam.getComision(1000);
		
		for (int i = 0; i < comisionParaVer.getAlumnosDeComision().size(); i++) {
			System.out.println((i+1) + ") "+ comisionParaVer.getAlumnosDeComision().get(i).getNombre() );
		}
		
		assertTrue(ejecucion);		
	}
	
}
