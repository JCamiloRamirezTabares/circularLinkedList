package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Curso;
import model.Estudiante;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static Curso curso;

	public static void main(String [] juank) {
		Menu();
	}
	
	public static void Menu() {
		int option = -1;
		try {
			System.out.print("Nombre del curso: ");
			String name = br.readLine();
			System.out.print("Numero de estudiantes: ");
			int num = Integer.parseInt(br.readLine());
			
			curso = new Curso(name, num);
		} catch (IOException e1) {
			
		}
		
		
		
		do {
			try {
				option = Menu2();
			} catch (IOException e) {
				System.out.println("Por favor ingrese texto valido");
			}
			System.out.println("\n");
			
			switch(option){
			case 1:
				try {
					addEstudiante();
				} catch (IOException e) {
					System.out.println("Por favor ingrese texto valido");
				}
				break;
			case 2:
				try {
					eliminarEstudiante();
				} catch (IOException e) {
					System.out.println("Por favor ingrese texto valido");
				}
				break;
			case 3:
				imprimirEstudiantes();
				break;
			default:
				option = 0;
				break;
			}
			
		} while(option != 0);
	}
	
	public static int Menu2() throws IOException {
		System.out.print("( 1 ) Para agregar un nuevo estudiante\n"
				+ "( 2 ) Para eliminar un estudiante\n"
				+ "( 3 ) Para imprimir la lista de estudiante\n"
				+ "( Cualquier otro numero ) Para salir\n"
				+ "Opcion: ");
		
		String o = br.readLine();
		return Integer.parseInt(o);
	}
	
	public static void addEstudiante() throws IOException {
		System.out.print("Codigo: ");
		String code = br.readLine();
		System.out.print("Nombre: ");
		String name = br.readLine();
		
		Estudiante nuevo = new Estudiante(code, name);
		curso.addEstudiante(nuevo);
	}
	
	public static void eliminarEstudiante() throws IOException {
		System.out.print("Codigo del Estudiante: ");
		String code = br.readLine();
		
		int confirmation = curso.eliminarEstudiante(code);
		if(confirmation == 1) {
			System.out.println("Se ha eliminado correctamente el estudiante");
		} else if(confirmation == -1){
			System.out.println("No se encontro estudiante con el valor suministrado");
		} else {
			System.out.println("Aun no hay estudiantes registrados\n"
					+ "Porfavor intentelo de nuevo despues de agregar al menos uno");
		}
	}
	
	public static void imprimirEstudiantes() {
		System.out.println("Estudiantes Actuales: ");
		System.out.println(curso.pintarGeneral());
	}
	
	
}
