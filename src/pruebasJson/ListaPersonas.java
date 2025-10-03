package pruebasJson;

import java.util.ArrayList;
import java.util.List;

//Clase contenedora de Personas para intentar recuperar de un JSON con XStream y Jettison
public class ListaPersonas{

	private List<Persona> persona = new ArrayList<Persona>();

    public ListaPersonas() {
        persona = new ArrayList<>();
    }

    //Getter y Setters default
	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}

	// Se crea el metodo add para poder añadir mas facilmente nuevos elementos
	public void add(Persona per) {
		persona.add(per);
	}

	//Override metodo toString
	@Override
	public String toString() {
		return "ListaPersonas [persona=" + persona + "]";
	}
	
	
    
	
}
