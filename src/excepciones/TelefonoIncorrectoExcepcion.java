package excepciones;

/**
 * Clase encargada de devolver el mensaje con el error que se ha producido 
 * cuando se ha introducido el telefono
 * 
 * @author Angel
 */
public class TelefonoIncorrectoExcepcion extends Exception {
	
	/**
	 * Funcion que se encarga de devolver el mensaje que se lanza en caso de error
	 * 
	 * @return Devuelve el mensaje de error
	 */
	@Override
	public String toString() {
		return "Error: El telefono introducido no tiene 9 digitos";
	}
	
	/**
	 * Funcion que se encarga de lanzar el mensaje con el error en caso de que ocurra
	 * 
	 * @return Devuelve el mensaje con el error
	 */
	@Override
	public String getMessage() {
		return "Error: El telefono introducido no tiene 9 digitos";
	}
}