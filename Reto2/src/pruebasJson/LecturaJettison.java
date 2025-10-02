package pruebasJson;

import java.io.File;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.*;
import com.thoughtworks.xstream.security.AnyTypePermission;


public class LecturaJettison {

	public static void main(String[] args) {
		
		//Esta clase requiere el uso de un jar de jettison
		//Se inicializa el XStream con un JettisonMappedXmlDriver
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("listaPersonas", ListaPersonas.class);
		xstream.alias("persona", Persona.class);
		xstream.addPermission(AnyTypePermission.ANY);
		
        File fichero = new File("personas.json");

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
