package entidades;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	
	private String nombre = "No especificado";
	
	private String direccion = "No especificado";
	
	private int telefono = 0;
	
	private boolean baja = false;
	
	public Paciente(String nombre, String direccion, int telefono, boolean baja) {
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		if(direccion != null && !direccion.isBlank()) {
			this.direccion = direccion;
		}
		
		if(telefono <= 999999999 && telefono > 99999999) {
			this.telefono = telefono;
		}
		
		this.baja = baja;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if(direccion != null && !direccion.isBlank()) {
			this.direccion = direccion;
		}
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		if(telefono <= 999999999 && telefono > 99999999) {
			this.telefono = telefono;
		}
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		Paciente paciente = (Paciente) obj;
		return this.nombre.equalsIgnoreCase(paciente.nombre) && this.telefono == paciente.telefono;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" + "Direccion: " + this.direccion + "\n" + "Telefono: " + this.telefono + "\n" + "Baja: " + (this.baja ? "Si" : "No");
	}	
}