package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CursoAlumno {

	private Alumno alumno;
	private Comision comision;
	private List<Nota> notas;
	private Integer contador;
	private Integer contadorAprobadas;
	private Integer id = 0;
	private CondicionFinal condicionFinal;
	
	
	public CursoAlumno(Alumno alumno, Comision comision) {
		this.alumno = alumno;
		this.comision = comision;
		this.notas = new ArrayList<>();
		this.id ++;
		this.contador = 0;
		this.contadorAprobadas = 0;
		this.condicionFinal = CondicionFinal.CURSANDO;
	}




	public void actualizarSituacion() {
		if(this.notas.size() >=2) {
			if(promedioNotas() < 4) {
				this.condicionFinal = CondicionFinal.DESAPROBADO;
			}else { 
				
					this.condicionFinal = CondicionFinal.APROBADO;
				}
			
		}
		
	}

	private int promedioNotas() {
		Integer acumulador = 0;
		boolean aRecuperar = false;
		for (Iterator iterator = notas.iterator(); iterator.hasNext();) {
			Nota nota = (Nota) iterator.next();
			if(nota.getValor() < 4 && !aRecuperar) {
				
			aRecuperar = true;
			
			}else {
				acumulador += nota.getValor();
			}
			
		}
		Integer promedio = (acumulador/2);
		return promedio;
	}

	public List<Nota> getNotas() {
		return notas;
	}


	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}


	public void setCondicionFinal(CondicionFinal condicionFinal) {
		this.condicionFinal = condicionFinal;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}




	public Integer getContadorAprobadas() {
		return contadorAprobadas;
	}




	public void setContadorAprobadas(Integer contadorAprobadas) {
		this.contadorAprobadas = contadorAprobadas;
	}




	public CondicionFinal getCondicionFinal() {
		return condicionFinal;
	}




	public boolean setNotasAdd(Nota aAsignar) {
	boolean asignada = false;
	Integer largo = this.notas.size();
	 this.notas.add(aAsignar);
	 if(largo < this.notas.size()) {
		 asignada = true;
	 }
	return asignada;	
	}
}
