package ar.unlam.pb2;
import java.time.LocalDate;
public class CicloLectivo {

	private LocalDate fechaInscripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	
	
	public CicloLectivo(LocalDate fechaInscripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
		this.fechaInscripcion = fechaInscripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
	}


	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}


	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	
}
