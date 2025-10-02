package pruebasJson;

/**
 *  @description Clase que representa una persona
 *  Se cambia el atributo telefono de un Enum a String
 *	@author Laura
 *  @date 29/4/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class Persona {
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Persona() {
		super();
	}
	public Persona(String nombre, String apellido, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + "]";
	}
	
	

}


