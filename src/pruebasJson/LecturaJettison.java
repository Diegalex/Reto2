package pruebasJson;

import java.io.File;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.*;
import com.thoughtworks.xstream.security.AnyTypePermission;


public class LecturaJettison {

	public static void main(String[] args) {
		
		// Esta clase lee el fichero generado por la clase PruebaXStreamJSONLista
		
		File fichero = new File("personas.json");
		
		//Esta clase requiere el uso de un jar de jettison
		//Se inicializa el XStream con un JettisonMappedXmlDriver
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("listaPersonas", ListaPersonas.class);
		xstream.alias("persona", Persona.class);
		xstream.addPermission(AnyTypePermission.ANY);
		
		//Importante añadir la colección implicita para poder leer correctamente
		xstream.addImplicitCollection(ListaPersonas.class, "persona");

        // Usando Xstream creamos un fichero Json no válido; crearemos uno de vuelta con Gson
        // La clase encargada de crear el fichero correcto será EscrituraGson.java
        try (FileReader fr=new FileReader(fichero)){
        	ListaPersonas personasLectura = (ListaPersonas) xstream.fromXML(fr);
            for (Persona persona : personasLectura.getPersona()) {
                System.out.println(persona);
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
        
	}

}
