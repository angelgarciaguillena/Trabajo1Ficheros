package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entidades.Paciente;
import excepciones.TelefonoIncorrectoExcepcion;


public class GestionFicheros {
	
	/**
	 * Creamos una constante para almacenar el fichero
	 */
	public static final String FICHERO = "src\\ficheros\\Pacientes.txt";
	
	public static boolean leerFichero() {
		boolean realizado = false;
		String pacientes[];
		String linea;
		try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			
			linea = br.readLine();
			
			while(linea != null) {
				pacientes = linea.split(";");
				linea = br.readLine();
				
				try {
					Paciente paciente = new Paciente(pacientes[0], pacientes[1], Integer.parseInt(pacientes[2]), pacientes[3]);
					PacienteCRUD.pacientes.add(paciente);
				} catch (NumberFormatException e) {
					System.out.println();
				} catch (TelefonoIncorrectoExcepcion e) {
					System.out.println(e.getMessage());;
				}
			}
			
			realizado = true;
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero " + e.getMessage());
		}
		
		return realizado;
	}
	
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