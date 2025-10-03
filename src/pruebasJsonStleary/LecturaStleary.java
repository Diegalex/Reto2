package pruebasJsonStleary;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;
import org.json.JSONObject;
import org.json.JSONTokener;

import pruebasJson.Persona;

/**
 * Lectura del mismo fichero con la libreria org/json de Stleary
 * Documentacion: https://github.com/stleary/JSON-java/tree/master/docs , Diapositivas Manuel Barroso
 * https://javadoc.io/doc/org.json/json/latest/index.html 
 * @param args
 */

public class LecturaStleary {

	
	public static void main(String[] args) {
		
		File file=new File("personas.json");
		
		try (FileReader reader = new FileReader(file)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject raiz = new JSONObject(tokener);
            
            // Elemento raiz como ObjetoJson, cada entrada de personas se lee como Array
            JSONObject listaPersonas = raiz.getJSONObject("listaPersonas");
            JSONArray personasArray = listaPersonas.getJSONArray("persona");
        	
            for (int i = 0; i < personasArray.length(); i++) {
				// Persona personaAux = new Persona();
            	JSONObject personaJsonAux = personasArray.getJSONObject(i);
            	
            	// Usamos variables auxiliares para evitar constructores demasiado largos
            	String nombreAux = personaJsonAux.getString("nombre");
            	String apellidoAux = personaJsonAux.getString("apellido");
            	
            	//Interpreta el telefono como long en vez de string, deberemos hacer un paso de Long(Wrapper) a String
            	Long telefonoLongAux = personaJsonAux.getLong("telefono");
            	String telefonoAux = telefonoLongAux.toString();
            	//String telefonoAux = personaJsonAux.getString("telefono"); Esta manera no funcionaría
            	//String telefonoAux = String.valueOf(personaJsonAux.getLong("telefono")); // Como oneliner
            	
				
				Persona personaAux = new Persona(nombreAux,apellidoAux,telefonoAux);
				System.out.println(personaAux);
				
			}

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

		
	}

}
