package mockaroo;

/**
 *  @description Clase que representa una persona
 *  Se cambia el atributo telefono de un Enum a String
 *	@author Laura
 *  @date 29/4/2015
 *  @version 1.0
 *  @license GPLv3
 */

// Deben de coincidir los nombres con los del json
public class PersonaMockaroo {
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	
	public PersonaMockaroo() {
		super();
	}

	public PersonaMockaroo(String nombre, String apellido, String email, String genero) {
		super();
		this.first_name = nombre;
		this.last_name = apellido;
		this.email = email;
		this.gender = genero;
	}
	
	public String getNombre() {
		return first_name;
	}
	
	public void setNombre(String nombre) {
		this.first_name = nombre;
	}
	
	public String getApellido() {
		return last_name;
	}
	
	public void setApellido(String apellido) {
		this.last_name = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGenero() {
		return gender;
	}
	
	public void setGenero(String genero) {
		this.gender = genero;
	}
	
	@Override
	public String toString() {
		return "PersonaMockaroo [nombre=" + first_name + ", apellido=" + last_name + ", email=" + email + ", genero="
				+ gender + "]";
	}
	
	
	
	

}


