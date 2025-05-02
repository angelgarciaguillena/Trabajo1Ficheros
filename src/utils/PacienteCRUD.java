package utils;

import java.util.HashSet;
import java.util.Set;

import entidades.Paciente;

/**
 * Clase encargada de realizar las funciones para la gestion
 * de los pacientes
 * 
 * @author Angel
 */
public class PacienteCRUD {
	
	/**
	 * Creamos un conjunto para almacenar los pacientes
	 */
	public static Set<Paciente> pacientes = new HashSet<Paciente>();
	
	/**
	 * Funcion que se encarga de añadir a un paciente al conjunto y devuelve true si se ha añadido
	 * o false si no se ha podido añadir
	 * 
	 * @param paciente Paciente que se va a añadir
	 * @return Devuelve true si se ha añadido o false si no se ha añadido
	 */
	public static boolean añadirPaciente(Paciente paciente) {
		return pacientes.add(paciente);
	}
	
	/**
	 * Funcion que se encarga de buscar a un paciente en el conjunto y si lo encuentra
	 * devuelve al paciente sino devuelve un paciente nulo
	 * 
	 * @param nombre Nombre del paciente
	 * @param telefono Telefono del paciente
	 * @return Devuelve al paciente si lo encuentra y sino un paciente nulo
	 */
	public static Paciente buscarPaciente(String nombre, int telefono) {
		Paciente paciente = null;
		
		for(Paciente pacienteB : pacientes) {
			
			if(pacienteB.getNombre().equalsIgnoreCase(nombre) && pacienteB.getTelefono() == telefono) {
				paciente = pacienteB;
			}
		}
		
		return paciente;
	}	
	
	/**
	 * Funcion encargada de mostrar a los pacientes que se encuentran en el conjunto
	 */
	public static void mostrarPaciente() {
		for(Paciente paciente : pacientes) {
			System.out.println(paciente);
			System.out.println("—---------------------------------------------------");
		}
	}
	
	/**
	 * Funcion encargada de modificar la direccion del paciente y devuelve true si se ha realizado
	 * la modificacion o false si no se ha podido realizar
	 * 
	 * @param nombre Nombre del paciente
	 * @param telefono Telefono del paciente
	 * @param direccion Nueva direccion del paciente
	 * @return Devuelve true si se ha realizado la modificacion o false si no se ha realizado
	 */
	public static boolean modificarDireccionPaciente(String nombre, int telefono, String direccion) {
		
		boolean modificado = false;
		
		Paciente paciente = buscarPaciente(nombre, telefono);
		
		if(paciente != null) {
			paciente.setDireccion(direccion);
			modificado = true;
		}
		
		return modificado;
	}
	
	/**
	 * Funcion encargada de modificar la baja del paciente y devuelve true si se ha podido modificar o false
	 * si no se ha realizado
	 * 
	 * @param nombre Nombre del paciente
	 * @param telefono Telefono del paciente
	 * @return Devuelve true si se ha modificado o false si no se ha modificado
	 */
	public static boolean modificarBajaPaciente(String nombre, int telefono) {
		
		boolean modificado = false;
		
		Paciente paciente = buscarPaciente(nombre, telefono);
		
		if(paciente != null) {
			paciente.setBaja();
			modificado = true;
		}
		
		return modificado;
	}
	
	/**
	 * Funcion encargada de eliminar a un paciente del conjunto y devuelve true si se ha eliminado o false
	 * si no se ha podido eliminar
	 * 
	 * @param paciente Paciente que se va a eliminar
	 * @return Devuelve true si se ha eliminado al paciente o false si no se ha podido eliminar
	 */
	public static boolean eliminarPaciente(Paciente paciente) {
		return pacientes.remove(paciente);
	}
}