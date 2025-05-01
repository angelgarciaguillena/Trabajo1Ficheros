package entidades;

import java.util.Objects;

import excepciones.TelefonoIncorrectoExcepcion;

/**
 * Clase encargada de crear un nuevo objeto Paciente
 * 
 * @author Angel
 */
public class Paciente implements Comparable<Paciente>{
	
	/**
	 * Atributo que almacena el nombre del paciente
	 */
	private String nombre = "No especificado";
	
	/**
	 * Atributo que almacena la direccion del paciente
	 */
	private String direccion = "No especificado";
	
	/**
	 * Atributo que almacena el telefono del paciente
	 */
	private int telefono = 000000000;
	
	/**
	 * Atributo que almacena si el paciente esta de baja o no
	 */
	private boolean baja = false;
	
	/**
	 * Constructor que inicializa los atributos de la clase Paciente comprobando
	 * si los valores son validos antes de asignarlos
	 * 
	 * @param nombre Nombre del paciente
	 * @param direccion Direccion del paciente
	 * @param telefono Telefono del paciente
	 * @param baja Estado de la baja del paciente
	 * @throws TelefonoIncorrectoExcepcion Excepcion que indica si el telefono se ha introducido de forma incorrecta
	 */
	public Paciente(String nombre, String direccion, int telefono, String baja) throws TelefonoIncorrectoExcepcion {
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		if(direccion != null && !direccion.isBlank()) {
			this.direccion = direccion;
		}
		
		if(telefono <= 999999999 && telefono > 99999999) {
			this.telefono = telefono;
		} else {
			throw new TelefonoIncorrectoExcepcion();
		}
		
		if(baja.equalsIgnoreCase("Si")) {
			this.baja = true;
		} else if(baja.equalsIgnoreCase("No")) {
			this.baja = false;
		}
	}
	
	/**
	 * Funcion que devuelve el nombre del paciente
	 * 
	 * @return Devuelve el nombre del paciente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Funcion que devuelve la direccion del paciente
	 * 
	 * @return Devuelve la direccion del paciente
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Funcion que modifica la direccion del paciente
	 * si su valor es valido
	 * 
	 * @param direccion Nueva direccion del paciente
	 */
	public void setDireccion(String direccion) {
		if(direccion != null && !direccion.isBlank()) {
			this.direccion = direccion;
		}
	}
	
	/**
	 * Funcion que devuelve el telefono del paciente
	 * 
	 * @return Devuelve el telefono del paciente
	 */
	public int getTelefono() {
		return telefono;
	}
	
	/**
	 * Funcion que devuelve el estado de la baja del paciente
	 * 
	 * @return Devuelve el estado de la baja del paciente
	 */
	public boolean isBaja() {
		return baja;
	}
	
	/**
	 * Funcion que modifica el estado de la baja del paciente
	 */
	public void setBaja() {
		if(this.baja) {
			this.baja = false;
		} else {
			this.baja = true;
		}
	}
	
	/**
	 * Funcion que se encarga de calcular el orden de los pacientes
	 * primero segun su nombre y si es igual segun su telefono y despues
	 * devuelve el orden que tiene que seguir los pacientes
	 * 
	 * @return Devuelve el orden de los pacientes
	 */
	@Override
	public int compareTo(Paciente o) {
		
		int orden;
		
		if(this.nombre.equalsIgnoreCase(nombre)) {
			orden = this.nombre.compareTo(o.nombre);
		} else {
			orden = this.telefono - o.telefono;
		}
		
		return orden;
	}
	
	/**
	 * Funcion encargada de identificar al paciente segun su nombre y 
	 * telefono y devuelve un numero que identifica al paciente
	 * 
	 * @return Devuelve un numero que identifica al paciente
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombre, telefono);
	}
	
	/**
	 * Funcion que comprueba si los pacientes son iguales y devuelve
	 * true si son iguales o false si no lo son
	 * 
	 * @return Devuelve true si los pacientes son iguales o false si no son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		
		Paciente paciente = (Paciente) obj;
		
		return this.nombre.equalsIgnoreCase(paciente.nombre) && this.telefono == paciente.telefono;
	}
	
	/**
	 * Funcion encargada de devolver una cadena con la informacion del paciente
	 * 
	 * @return Devuelve la informacion del paciente
	 */
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" + "Direccion: " + this.direccion + "\n" + "Telefono: " + this.telefono + "\n" + "Baja: " + (this.baja ? "Si" : "No");
	}	
}