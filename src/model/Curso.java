package model;

public class Curso {

	private String nombre;
	private int numEstudiantes;
	
	private Estudiante primero;
	private Estudiante ultimo;
	
	public Curso(String n, int nm) {
		nombre = n;
		numEstudiantes = nm;
	}
	
	public Curso(String n, int num, Estudiante e) {
		
	}
	
	//Methods
	public void addEstudiante(Estudiante e) {
		if(primero == null) {
			primero = e;
			ultimo = e;
			primero.setAnterior(ultimo);
			primero.setSiguiente(ultimo);
			ultimo.setSiguiente(primero);
			ultimo.setAnterior(primero);
		}else {
			ultimo.setSiguiente(e);
			e.setSiguiente(primero);
			e.setAnterior(ultimo);
			ultimo = e;
		}
	}
	
	public int eliminarEstudiante(String code) {
		Estudiante temp = primero;
		
		do {
			if(temp.getCodigo().equals(code)) {
				if(temp == primero && temp.getSiguiente() == primero) {
					primero = null;
				} else if(temp == primero && temp.getSiguiente() != primero) {
					primero = primero.getSiguiente();
					ultimo.setSiguiente(primero);
				} else {
					temp.getAnterior().setSiguiente(temp.getSiguiente());
					temp.getSiguiente().setAnterior(temp.getAnterior());
					temp = primero;
				}
				
				return 1;
			} else {
				temp = temp.getSiguiente();
			}
		}while(temp != primero);
		return -1;
	}
	
	public String pintarGeneral() {
		String s = "";
		Estudiante temp = primero;
		if(primero != null) {
			do {
				s += temp.toString() + "\n";
				temp = temp.getSiguiente();
			}while(temp != primero);
		} else {
			s = "No hay estudiantes registrados aun\n";
		}
		
		return s;
	}
	
	//Metodos vacios
	public void addEstudianteOrdenadamente(Estudiante e) {
		
	}
	
	public void pintarEstudiantes() {
		
	}
	
	public void pintarAtrasAdelanteEstudiantes() {
		
	}
	
	public void pintarEstudiantesRecursivo(Estudiante e) {
		
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEstudiantes() {
		return numEstudiantes;
	}

	public void setNumEstudiantes(int numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	public Estudiante getPrimero() {
		return primero;
	}
	
	public void setPrimero(Estudiante primero) {
		this.primero = primero;
	}
}
