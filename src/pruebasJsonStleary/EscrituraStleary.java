package pruebasJsonStleary;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import pruebasJson.ListaPersonas;
import pruebasJson.Persona;

import org.json.*;
import org.json.JSONObject;
import org.json.JSONTokener;

public class EscrituraStleary {
	/**
	 * https://javadoc.io/doc/org.json/json/latest/index.html
	 * @param args
	 */
	public static void main(String[] args) {
		
		File fichero = new File("personasStleary.json");
		
		//ArrayList en vez de ListaPersonas
		List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("Romeo","Santos","6531351220"));
        listaPersonas.add(new Persona("Chayanne","Torero","666655243"));
        listaPersonas.add(new Persona("Guts","Berserk","634326279"));
		

        //Creación de array JSON
        JSONArray arrayPersonas = new JSONArray();
        
        for(Persona p :listaPersonas) {
        	JSONObject objAux = new JSONObject();
        	objAux.put("nombre", p.getNombre());
        	objAux.put("apellido", p.getApellido());
        	objAux.put("telefono", p.getTelefono());
        	
        	arrayPersonas.put(objAux);
        }

        System.out.println(arrayPersonas.toString());
        
        try (FileWriter writer = new FileWriter(fichero)) {
            writer.write(arrayPersonas.toString());
            System.out.println("JSON escrito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
