package model;

public class Estudiante {

	private String codigo;
	private String nombre;
	
	private Estudiante siguiente;
	private Estudiante anterior;
	
	public Estudiante(String c, String n) {
		codigo = c;
		nombre = n;
	}
	
	//Getters & Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estudiante getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Estudiante siguiente) {
		this.siguiente = siguiente;
	}

	public Estudiante getAnterior() {
		return anterior;
	}

	public void setAnterior(Estudiante anterior) {
		this.anterior = anterior;
	}
	
	//toString
	public String toString() {
		return codigo + " - " + nombre;
	}
}
