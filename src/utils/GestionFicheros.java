package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entidades.Paciente;
import excepciones.TelefonoIncorrectoExcepcion;

/**
 * Clase encargada de la gestion del fichero donde se guardan los datos de los 
 * pacientes
 * 
 * @author Angel
 */
public class GestionFicheros {
	
	/**
	 * Creamos una constante para almacenar el fichero
	 */
	public static final String FICHERO = "src\\ficheros\\Pacientes.txt";
	
	/**
	 * Funcion encargada de leer la informacion de los pacientes que esta en el fichero, la carga en el programa
	 * para trabajar con ella y devuelve true si la ha podido leer o false si no la ha podido leer
	 * 
	 * @return Devuelve true si lo ha leido o false si no lo ha podido leer
	 */
	public static boolean leerFichero() {
		
		String datos[];
		String linea;
		boolean realizado = false;
		
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			linea = br.readLine();
			
			while(linea != null) {
				
				datos = linea.split(";");
				
				try {
					
					Paciente paciente = new Paciente(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]);
					
					PacienteCRUD.pacientes.add(paciente);
					
				} catch (TelefonoIncorrectoExcepcion e) {
					System.out.println(e.getMessage());
				}
				
				linea = br.readLine();
			}
			
			realizado = true;
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			try {
				
				FileWriter fw = new FileWriter(FICHERO);
				
				fw.close();
				
			} catch (IOException e1) {
				System.out.println("Error al crear el fichero: " + e1.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero " + e.getMessage());
		}
		
		return realizado;
	}
	
	/**
	 * Funcion encargada de escribir la informacion de los pacientes en el fichero y devuelve 
	 * true si lo ha realizado o false si no lo ha realizado
	 * 
	 * @return Devuelve true si lo ha realizado o false si no
	 */
	public static boolean escribirFichero() {
		
		boolean escrito = false;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			
			for(Paciente paciente : PacienteCRUD.pacientes) {
				
				bw.write(paciente.getNombre() + ";" + paciente.getDireccion() + ";" + paciente.getTelefono() + ";" + paciente.isBaja());
				
				bw.newLine();
			}
			
			escrito = true;
			
			bw.flush();
			
			bw.close();
			
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero " + e.getMessage());
		}
		
		return escrito;
	}
}