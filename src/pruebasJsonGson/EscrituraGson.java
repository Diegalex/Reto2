package pruebasJsonGson;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pruebasJson.ListaPersonas;
import pruebasJson.Persona;

public class EscrituraGson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File("personasGson.json");
		
		ListaPersonas listaPersonas = new ListaPersonas();
        listaPersonas.add(new Persona("Romeo","Santos","6531351220"));
        listaPersonas.add(new Persona("Chayanne","Torero","666655243"));
        listaPersonas.add(new Persona("Guts","Berserk","634326279"));

        //Creación de objeto Gson para correcta escritura de un json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fichero)) {
            gson.toJson(listaPersonas, writer);
            System.out.println("JSON escrito correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
