package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Comision {
	
	private Double promedioFinal;
	private Integer codigo;
	private Materia materiaAsignada;
	private Turno turno;
	private CicloLectivo cicloLectivoAsignado;
	private Aula aulaAsignada; 
	
	

	public Comision (Materia materia, Integer codigo, Aula aula, CicloLectivo cicloLectivo, Turno turno) {
		this.materiaAsignada = materia;
		this.codigo = codigo;
		this.aulaAsignada = aula;
		this.cicloLectivoAsignado = cicloLectivo;
		this.turno = turno;
		this.promedioFinal = null;
		
	}
	

	
 



	public Materia getMateriaAsignada() {
		return materiaAsignada;
	}


	public void setMateriaAsignada(Materia materiaAsignada) {
		this.materiaAsignada = materiaAsignada;
	}


	

	public CicloLectivo getCicloLectivoAsignado() {
		return cicloLectivoAsignado;
	}


	public void setCicloLectivoAsignado(CicloLectivo cicloLectivoAsignado) {
		this.cicloLectivoAsignado = cicloLectivoAsignado;
	}


	public Aula getAulaAsignada() {
		return aulaAsignada;
	}


	public void setAulaAsignada(Aula aulaAsignada) {
		this.aulaAsignada = aulaAsignada;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Integer getCodigo () {
		return this.codigo;
	}




	public Turno getTurno() {
		return turno;
	}




	public void setTurno(Turno turno) {
		this.turno = turno;
	}







	public Double getPromedioFinal() {
		return promedioFinal;
	}







	public void setPromedioFinal(Double promedioFinal) {
		this.promedioFinal = promedioFinal;
	}
}
