package ar.unlam.pb2;

public class Alumno {
	private String nombre;
	private Integer dni;
	
	
	public Alumno (String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public Integer getDni () {
		return this.dni;
	}
	
	public String getNombre () {
		return this.nombre;
	}
}
