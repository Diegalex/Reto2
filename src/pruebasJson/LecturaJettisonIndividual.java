package pruebasJson;

import java.io.File;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.*;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * Clase de lectura de un unico objeto a Json
 * Lee de la clase PruebaXStreamJSON
 * @param args
 */

public class LecturaJettisonIndividual {

	
	
	public static void main(String[] args) {
		//Esta clase requiere el uso de un jar de jettison
		//Se inicializa el XStream con un JettisonMappedXmlDriver
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("persona", Persona.class);
		xstream.addPermission(AnyTypePermission.ANY);
		
        File fichero = new File("persona.json");

        //Esta clase recupera correctamente el fichero json
        try (FileReader fr=new FileReader(fichero)){
        	Persona personaLectura = (Persona) xstream.fromXML(fr);
            System.out.println(personaLectura);
            	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
	
