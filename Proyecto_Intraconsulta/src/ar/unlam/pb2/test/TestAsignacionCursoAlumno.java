package ar.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Aula;
import ar.unlam.pb2.CicloLectivo;
import ar.unlam.pb2.Comision;
import ar.unlam.pb2.CondicionFinal;
import ar.unlam.pb2.CursoAlumno;
import ar.unlam.pb2.Instancia;
import ar.unlam.pb2.Materia;
import ar.unlam.pb2.Nota;
import ar.unlam.pb2.Turno;
import ar.unlam.pb2.Universidad;

public class TestAsignacionCursoAlumno {

	@org.junit.Test
	public void asignarAlumnoALaComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		
	}
	@org.junit.Test
	public void asignarNota () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
        unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		Integer valorNota = 3;
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota) );
		
	}
	
	@org.junit.Test
	public void asignarDosNotas () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota) );
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		
	}
	@org.junit.Test
	public void asignarTresAlumnosALaComision () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno2 =  200;
		
		String nombreAlumno3 = "Dario";
		Integer dniAlumno3 =  100;
		
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.registrarAlumno(nombreAlumno2, "", null, null, dniAlumno2);
		unlam.registrarAlumno(nombreAlumno3, "", null, null, dniAlumno3);
		
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno2, numComision));
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno3, numComision));
		
		
			
	}
	@org.junit.Test
	public void puedaAprobarDirecto () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertFalse(  unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision,dniAlumno1).getCondicionFinal());
	}
	@org.junit.Test
	public void queNoSeAsigneAAlumnoALaComisionSinTenerAprobadasCorrelativas () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
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
		
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		

		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(buscada, numComision, aula, cicloLectivo, turno);
		
		
		assertFalse(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		
	}
	@org.junit.Test
	public void queNoSeInscribaUnAlumnoFueraDeFechaDeInscripcion () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-10-01");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		
		assertFalse(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		
	}
	@org.junit.Test
	public void queSoloSeAsignesLosAlumnosQueEntranEnElAula () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Aula aula = new Aula(23,2);
		
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		
		String nombreAlumno2 = "Leonel";
		Integer dniAlumno2 =  200;
		
		String nombreAlumno3 = "Dario";
		Integer dniAlumno3 =  100;
		
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.registrarAlumno(nombreAlumno2, "", null, null, dniAlumno2);
		unlam.registrarAlumno(nombreAlumno3, "", null, null, dniAlumno3);
		
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;

		unlam.agregarMateria(pb1, codPb1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno2, numComision));
		assertFalse(unlam.asignarAlumnoAComision(dniAlumno3, numComision));
		
		
			
	}
	@org.junit.Test
	public void queNoSeAsigneUnMismoAlumnoEnElMismoTurnoParaDosMaterias () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Materia materia2 = new Materia("Matematica", 1111);
		Integer numComision = 1000;
		Integer numComision2 = 1100;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  300;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		unlam.abrirComision(materia2, numComision2, aula, cicloLectivo, turno);
		
		
		
		assertTrue(unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		assertFalse(unlam.asignarAlumnoAComision(dniAlumno1, numComision2));
		
	}
	@org.junit.Test
	public void queNoSePuedaAsignarUnAlumoAUnaMateriaQueYaAprobo () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		LocalDate fechaInicio2 = LocalDate.parse("1991-10-15");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1992-12-01");
		
		Materia materia = new Materia("Ingles" , 0110);
		Integer numComision = 1000;
		Integer numComision2 = 1100;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaIncripcion, fechaInicio2, fechaFinalizacion2);
		Turno turno = Turno.NOCHE;
		Turno turno2 = Turno.MANIANA;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		
		assertTrue(unlam.agregarMateria(pb1, codPb1));
		assertTrue(unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1));
		assertTrue(unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno));
		assertTrue(unlam.abrirComision(materia, numComision2, aula, cicloLectivo2, turno2));
		
		
		assertTrue( unlam.asignarAlumnoAComision(dniAlumno1, numComision));
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision,dniAlumno1).getCondicionFinal());
		
		assertFalse(unlam.asignarAlumnoAComision(dniAlumno1, numComision2));
		
		
	}
	@org.junit.Test
	public void obtenerMateriasAprobadasParaUnAlumno () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		LocalDate fechaInicio2 = LocalDate.parse("1991-10-15");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1992-12-01");
		
		Integer numComision = 1000;
		Integer numComision2 = 1111;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaIncripcion,fechaInicio2,fechaFinalizacion2);
		Turno turno = Turno.NOCHE;
		Turno turno2 = Turno.TARDE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		String ing = "Ingles";
		Integer codIng = 3333;
		Materia materia = new Materia(pb1, codPb1);
		Materia materia2 = new Materia(ing, codIng);
		List<Materia> listaEsperada = new ArrayList<Materia>();
		listaEsperada.add(materia);
		listaEsperada.add(materia2);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.agregarMateria(ing, codIng);
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		unlam.abrirComision(materia2, numComision2, aula, cicloLectivo2, turno2);
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision2);
		
		Integer valorNota = 7;
		
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertFalse(  unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision,dniAlumno1).getCondicionFinal());
		
		assertTrue( unlam.asignarNota(numComision2, dniAlumno1,valorNota));
		assertTrue( unlam.asignarNota(numComision2, dniAlumno1,valorNota));
		assertFalse(  unlam.asignarNota(numComision2, dniAlumno1,valorNota));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision2,dniAlumno1).getCondicionFinal());
		
		assertEquals(listaEsperada,unlam.obtenerMateriasAprobadasParaUnAlumno(dniAlumno1));
	}
	@org.junit.Test
	public void  obtenerArregloDeNotasEnMateriaCursada () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		
		Integer numComision = 1000;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		Turno turno = Turno.NOCHE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		Materia materia = new Materia(pb1, codPb1);
		
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
	    unlam.asignarAlumnoAComision(dniAlumno1, numComision);
	    List<Nota> listaEsperada = unlam.obtenerNotas(dniAlumno1, numComision);
		Nota nota1 = new Nota(7,Instancia.PRIMER_PARCIAL);
		Nota nota2 = new Nota(8,Instancia.SEGUNDO_PARCIAL);
		listaEsperada.add(nota1);
		listaEsperada.add(nota2);
		
		
		
		Integer valorNota1 = 7;
		Integer valorNota2 = 8;
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota1));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota2));
		
	
		assertEquals(listaEsperada, unlam.obtenerNotas(dniAlumno1, numComision));
		
	}
	@org.junit.Test
	public void  obtenerMateriasQueFaltanCursarParaUnAlumno () {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		LocalDate fechaInicio2 = LocalDate.parse("1991-10-15");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1992-12-01");
		
		Integer numComision = 1000;
		Integer numComision2 = 1111;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaIncripcion,fechaInicio2,fechaFinalizacion2);
		Turno turno = Turno.NOCHE;
		Turno turno2 = Turno.TARDE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		String ing = "Ingles";
		Integer codIng = 3333;
		Materia materia = new Materia(pb1, codPb1);
		Materia materia2 = new Materia(ing, codIng);
		
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.agregarMateria(ing, codIng);
		
		List<Materia> listaEsperada = unlam.getMaterias();
		listaEsperada.remove(materia);
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		unlam.abrirComision(materia2, numComision2, aula, cicloLectivo2, turno2);
		
	    unlam.asignarAlumnoAComision(dniAlumno1, numComision);
		Integer valorNota = 7;
		
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertFalse(  unlam.asignarNota(numComision, dniAlumno1,valorNota));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision,dniAlumno1).getCondicionFinal());
		
		assertEquals(listaEsperada , unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(dniAlumno1));
	}
	@org.junit.Test
	public void calcularPromedioFinalDeMateriasAprobadas() {
		Universidad unlam = new Universidad("Unlam");
		
		LocalDate fechaIncripcion = LocalDate.parse("1990-05-15");
		LocalDate fechaInicio = LocalDate.parse("1990-10-15");
		LocalDate fechaFinalizacion = LocalDate.parse("1990-12-01");
		LocalDate fechaInicio2 = LocalDate.parse("1991-10-15");
		LocalDate fechaFinalizacion2 = LocalDate.parse("1992-12-01");
		
		Integer numComision = 1000;
		Integer numComision2 = 1111;
		Aula aula = new Aula(23,30);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaIncripcion,fechaInicio,fechaFinalizacion);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaIncripcion,fechaInicio2,fechaFinalizacion2);
		Turno turno = Turno.NOCHE;
		Turno turno2 = Turno.TARDE;
		
		String nombreAlumno1 = "Gonzalo";
		Integer dniAlumno1 =  1111;
		String pb1 = "Programacion Basica 1";
		Integer codPb1 = 101;
		String ing = "Ingles";
		Integer codIng = 3333;
		Materia materia = new Materia(pb1, codPb1);
		Materia materia2 = new Materia(ing, codIng);
		List<Materia> listaEsperada = new ArrayList<Materia>();
		listaEsperada.add(materia);
		listaEsperada.add(materia2);
		
		unlam.agregarMateria(pb1, codPb1);
		unlam.agregarMateria(ing, codIng);
		
		unlam.registrarAlumno(nombreAlumno1, "", null, null, dniAlumno1);
		unlam.abrirComision(materia, numComision, aula, cicloLectivo, turno);
		unlam.abrirComision(materia2, numComision2, aula, cicloLectivo2, turno2);
		
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision);
	   unlam.asignarAlumnoAComision(dniAlumno1, numComision2);
		
		Integer valorNota1 = 7;
		Integer valorNota2 = 8;
		
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota1));
		assertTrue( unlam.asignarNota(numComision, dniAlumno1,valorNota2));
		assertFalse(  unlam.asignarNota(numComision, dniAlumno1,valorNota2));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision,dniAlumno1).getCondicionFinal());
		
		assertTrue( unlam.asignarNota(numComision2, dniAlumno1,valorNota2));
		assertTrue( unlam.asignarNota(numComision2, dniAlumno1,valorNota2));
		assertFalse(  unlam.asignarNota(numComision2, dniAlumno1,valorNota1));
		assertEquals(CondicionFinal.APROBADO,  unlam.getCursoAlumno(numComision2,dniAlumno1).getCondicionFinal());
		
		assertEquals(listaEsperada,unlam.obtenerMateriasAprobadasParaUnAlumno(dniAlumno1));
		
		assertTrue(unlam.calcularPromedioFinal(dniAlumno1));
	}
}
