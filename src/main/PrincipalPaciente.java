package main;

import java.util.Scanner;

import entidades.Paciente;
import excepciones.TelefonoIncorrectoExcepcion;
import utils.GestionFicheros;
import utils.PacienteCRUD;

public class PrincipalPaciente {
	
	/*Creamos el Scanner*/
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*Creamos una variable que almacenara la opcion del usuario*/
		int opcion = 0;
		
		/*Creamos una variable para almacenar el nombre del paciente*/
		String nombre;
		
		/*Creamos una variable para almacenar el telefono del paciente*/
		int telefono;
		
		/*Creamos una variable para almacenar la direccion del paciente*/
		String direccion;
		
		/*Creamos un paciente*/
		Paciente paciente = null;
		
		/*LLamamos a la funcion para cargar a los pacientes que teniamos registrados
		 * en el fichero y si no se puede realizar se le notifica al usuario*/
		if(GestionFicheros.leerFichero()) {
			System.out.println("Se han cargado a los pacientes");
		} else {
			System.out.println("No se ha podido cargar a los pacientes");
		}
		
		/*Creamos un bucle do while para que se repita el programa mientras que 
		 * el usuario no introduzca 0*/
		do {
			
			/*LLamamos a la funcion para mostrar el menu*/
			menu();
			
			/*Pedimos al usuario que introduzca una opcion*/
			System.out.println("Introduce una opcion");
			
			/*Leemos la opcion del usuario*/
			opcion = sc.nextInt();
			sc.nextLine();
			
			/*Creamos un switch para que depende de la opcion que introduzca el usuario se
			 * realice una funcion u otra*/
			switch(opcion) {
			
			/*Si la opcion es 1 añadimos a un nuevo paciente*/
			case 1 -> {
				
				/*LLamamosa a la funcion para pedir al usuario los datos del paciente*/
				paciente = pedirPaciente();
				
				/*Llamamos a la funcion para añadir al paciente*/
				if(PacienteCRUD.añadirPaciente(paciente)) {
					System.out.println("El paciente se ha añadido");
				} else {
					System.out.println("No se ha podido añadir al paciente");
				}
			}
			
			/*Si la opcion es 2 buscamos a un paciente*/
			case 2 -> {
				
				/*LLamamos a la funcion para pedir el nombre del paciente*/
				nombre = pedirNombre();
				
				/*LLamamos a la funcion para pedir el telefono del paciente*/
				telefono = pedirTelefono();
				
				/*Buscamos al paciente llamando a la funcion*/
				paciente = PacienteCRUD.buscarPaciente(nombre, telefono);
				
				/*Si se ha encontrado al paciente mostramos su informacion sino notificamos
				 * al usuario de que no se ha encontrado al paciente*/
				if(paciente != null) {
					System.out.println(paciente);
				} else {
					System.out.println("No se ha encontrado al paciente");
				}
			}
			
			/*Si la opcion es 3 mostramos a todos los pacientes*/
			case 3 -> {
				
				/*Llamamos a la funcion para mostrar a los pacientes*/
				PacienteCRUD.mostrarPaciente();
			}
			
			/*Si la opcion es 4 modificamos a un paciente*/
			case 4 -> {
				
				/*LLamamos a la funcion para pedir el nombre del paciente*/
				nombre = pedirNombre();
				
				/*LLamamos a la funcion para pedir el telefono del paciente*/
				telefono = pedirTelefono();
				
				/*Buscamos al paciente llamando a la funcion*/
				paciente = PacienteCRUD.buscarPaciente(nombre, telefono);
				
				/*Si no se ha encontrado al paciente notificamos al usuario*/
				if(paciente != null) {
					
					/*Pedimos al usuario que introduzca el parametro que se quiere modificar del paciente*/
					System.out.println("1. Direccion");
					System.out.println("2. Baja");
					System.out.println("Introduce el parametro que se quiere modificar del paciente");
					
					/*Leemos la opcion del usuario*/
					opcion = sc.nextInt();
					sc.nextLine();
					
					/*Si la opcion que ha introducido el usuario es 1 modificamos la direccion del paciente*/
					if(opcion == 1) {
						
						/*Pedimos al usuario que introduzca la nueva direccion del paciente*/
						System.out.println("Introduce la nueva direccion del paciente");
						
						/*Leemos la nueva direccion del paciente*/
						direccion = sc.nextLine();
						
						/*Modificamos la direccion del paciente y si no se ha podido lanzamos un mensaje al usuario*/
						if(PacienteCRUD.modificarDireccionPaciente(nombre, telefono, direccion)) {
							System.out.println("Se ha modificado la direccion del paciente");
						} else {
							System.out.println("No se ha podido modificar la direccion del paciente");
						}
					
					/*Si la opcion del usuario es 2 modificamos la baja del paciente*/
					} else if(opcion == 2) {
						
						/*Modificamos la baja del paciente y si no se ha podido modificar se le notifica al usuario*/
						if(PacienteCRUD.modificarBajaPaciente(nombre, telefono)) {
							System.out.println("Se ha modificado la baja del paciente");
						} else {
							System.out.println("No se ha podido modificar la baja del paciente");
						}
					}
					
				} else {
					System.out.println("No se ha encontrado al paciente");
				}
			}
			
			/*Si la opcion es 5 eliminamos a un paciente*/
			case 5 -> {
				
				/*LLamamosa a la funcion para pedir al usuario el nombre del paciente*/
				nombre = pedirNombre();
				
				/*Llamamos a la funcion para pedir al usuario el telefono del paciente*/
				telefono = pedirTelefono();
				
				/*Creamos un objeto con los datos del paciente*/
				try {
					paciente = new Paciente(nombre, telefono);
				} catch (TelefonoIncorrectoExcepcion e) {
					System.out.println(e.getMessage());
				}
				
				/*Llamamos a la funcion para eliminar al paciente*/
				if(PacienteCRUD.eliminarPaciente(paciente)) {
					System.out.println("Se ha eliminado al paciente");
				} else {
					System.out.println("No se ha podido eliminar al paciente");
				}
			}
			
			/*Si la opcion es 6 guardamos a los pacientes en el fichero*/
			case 6 -> {
				
				/*LLamamos a la funcion para guardar a los nuevos pacientes en el fichero*/
				if(GestionFicheros.escribirFichero()) {
					System.out.println("Se han guardado a los pacientes");
				} else {
					System.out.println("No se ha podido guardar a los pacientes");
				}
			}
			
			/*Si la opcion es 0 se informara al usuario de que ha salido del programa*/
			case 0 -> {
				System.out.println("Has salido del programa");
			}
			
			/*Si no es ninguna de las opciones anteriores la opcion que ha elegido el 
			 * usuario no sera valida*/
			default -> {
				System.out.println("Opcion no valida");
			}
			}
		}while(opcion != 0);
		
		/*Cerramos el Scanner*/
		sc.close();
	}
	
	public static void menu() {
		/*Mostramos el menu al usuario*/
		System.out.println("\n" + "Menu:");
		System.out.println("1. Añadir paciente");
		System.out.println("2. Buscar paciente");
		System.out.println("3. Listar pacientes");
		System.out.println("4. Modificar paciente");
		System.out.println("5. Eliminar paciente");
		System.out.println("6. Guardar pacientes");
		System.out.println("0. Salir");
	}
	
	private static Paciente pedirPaciente() {
		
		/*Creamos una variable para almacenar el nombre del paciente*/
		String nombre;
		
		/*Creamos una variable para almacenar la direccion del paciente*/
		String direccion;
		
		/*Creamos una variable para almacenar el telefono del paciente*/
		int telefono;
		
		/*Creamos una variable para almacenar el estado de la baja del paciente*/
		String baja;
		
		/*Creamos un paciente*/
		Paciente paciente = null;
		
		/*Pedimos al usuario el nombre del paciente*/
		nombre = pedirNombre();
		
		/*Pedimos al usuario que introduzca la direccion del paciente*/
		System.out.println("Introduce la direccion del paciente");
		
		/*Leemos la direccion del paciente*/
		direccion = sc.nextLine();
		
		/*Pedimos al usuario el telefono del paciente*/
		telefono = pedirTelefono();
		
		/*Pedimos al usuario que introduzca el estado de la baja del paciente*/
		System.out.println("Introduce el estado de la baja del paciente");
		
		/*Leemos la direccion del paciente*/
		baja = sc.nextLine();
		
		/*Creamos un try catch para notificar al usuario en caso de error*/
		try {
			/*Creamos al nuevo paciente con los datos*/
			paciente = new Paciente(nombre, direccion, telefono, baja);
			
		/*Si el telefono se ha introducido mal se le lanza el mensaje al usuario*/
		} catch (TelefonoIncorrectoExcepcion e) {
			System.out.println(e.getMessage());
		}
		
		/*Devolvemos al paciente*/
		return paciente;
	}
	
	private static String pedirNombre() {
		
		/*Creamos una variable para almacenar el nombre del paciente*/
		String nombre;
		
		/*Pedimos al usuario que introduzca el nombre del paciente*/
		System.out.println("Introduce el nombre del paciente");
		
		/*Leemos el nombre del paciente*/
		nombre = sc.nextLine();
		
		/*Devolvemos el nombre del paciente*/
		return nombre;
	}
	
	private static int pedirTelefono() {
		
		/*Creamos una variable para almacenar el telefono del paciente*/
		int telefono = 0;
		
		/*Creamos una variable para almacenar si se ha introducido correcto el numero*/
		boolean correcto = false;
		
		do {
			try {
				/*Pedimos al usuario que introduzca el telefono del paciente*/
				System.out.println("Introduce el telefono del paciente");
				
				/*Leemos el telefono del paciente*/
				telefono = sc.nextInt();
				
				assert (telefono <= 999999999 && telefono > 99999999) : "Error: El telefono introducido no tiene 9 digitos";
				correcto = true;
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while(!correcto);
		
		/*Devolvemos el telefono del paciente*/
		return telefono;
	}
}