package pruebasJsonGson;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import pruebasJson.Persona;

/**
 * Debemos leer el json file como un objeto para poder convertir adecuadamente la lista
 * Documentacion: https://github.com/google/gson/blob/main/UserGuide.md
 * @param args
 */

public class LecturaGson {

	
	public static void main(String[] args) {
	
		Gson gson = new Gson();
		
		 
        try (FileReader reader = new FileReader("personas.json")) {
            // ListaPersonas inputPersonas = gson.fromJson(reader, ListaPersonas.class);
            // Se lee el propio fichero como objeto json en vez de ListaPersonas
        	JsonObject jsonObjeto = gson.fromJson(reader, JsonObject.class);
        	JsonObject listaObjeto = jsonObjeto.getAsJsonObject("listaPersonas");
        	// Se trata a cada entrada de las personas como entrada de un array
        	JsonArray personas = listaObjeto.getAsJsonArray("persona");
        	
        	// Type y TypeToken https://stackoverflow.com/questions/43117731/what-is-type-typetoken
        	Type tipoLista = new TypeToken<List<Persona>>() {}.getType();
        	List<Persona> listaPersonas = gson.fromJson(personas, tipoLista);
        	
            for (Persona persona : listaPersonas) {
				System.out.println(persona);
			}

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

}
