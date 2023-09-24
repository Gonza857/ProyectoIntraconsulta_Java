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

	public boolean asignarNota (Integer valorNota, Integer dni) {
		boolean asignada = false;
		if(!verificarQueNoHayaFinalizado()) {
		
		Instancia[] instancias = Instancia.values();
		Integer largo = this.notas.size();
		Nota aAsignar = new Nota(valorNota, instancias[this.contador]) ;

		notas.add(aAsignar);
		System.out.println("Se asigno la nota de " + valorNota + " en la intancia de " + instancias[this.contador] + " al alumno " + alumno.getNombre());
		if(largo < this.notas.size()) {
			asignada = true;
			if(valorNota >= 4) {
				this.contador += 2;
			}else {
				this.contador++;
			}
			
			
			
		}}
		if(valorNota > 4) {
			this.contadorAprobadas++;
		}
		if(this.contadorAprobadas >= 2) {
			actualizarSituacion();
		}
		
		return asignada;
		
	}



	

	private void actualizarSituacion() {
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

	private boolean verificarQueNoHayaFinalizado() {
		boolean termino = true;
		if(getCondicionFinal().equals(CondicionFinal.CURSANDO)) {
			termino = false;
		}
		
		return termino;
	}

	

//	private Comision getComision(Integer codigo) {
//		Comision buscado = null;
//		for (int i = 0; i < this.comisiones.size() && buscado == null; i++) {
//			if (this.comisiones.get(i).getCodigo().equals(codigo)) {
//				buscado =  this.comisiones.get(i);
//			}
//		}
//		return buscado;
//	}




	public List<Nota> getNotas() {
		return notas;
	}


	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

//	public Alumno getAlumno (Integer dni) {
//		Alumno buscado = null;
//		for (int i = 0; i < this.alumnos.size() && buscado == null; i++) {
//			if (this.alumnos.get(i).getDni().equals(dni)) {
//				buscado =  this.alumnos.get(i);
//			}
//		}
//		return buscado;
//	}
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

	public CondicionFinal getCondicionFinal() {
		return condicionFinal;
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
}
