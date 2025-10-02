package pruebasJson;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaXStreamJSON2 {
	
	/**
	 * Se hace uso de una clase contenedora de personas para poder aplicar los alias correctamente
	 * La clase genera un Json correcto pero luego leer de el con los jars de XStream y Jettison resulta imposible
	 * @param args
	 */

	public static void main(String[] args) {
		
		File fichero = new File("personas.json");
		
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.addImplicitCollection(ListaPersonas.class, "persona");
        xstream.addPermission(AnyTypePermission.ANY);
        
		xstream.alias("listaPersonas", ListaPersonas.class);
		xstream.alias("persona", Persona.class);
		
		//Hacemos uso de nuestra lista contenedora para almacenar objetos del tipo Persona
        ListaPersonas listaPersonas = new ListaPersonas();
        listaPersonas.add(new Persona("Romeo","Santos","6531351220"));
        listaPersonas.add(new Persona("Chayanne","Torero","666655243"));
        listaPersonas.add(new Persona("Guts","Berserk","634326279"));

        //Aunque se use el metodo toXML, el resultado es un archivo con estructura JSON
        //Esto se debe al JsonHierarchicalStreamDriver
        System.out.println(xstream.toXML(listaPersonas));
        
        //Lo escribimos al fichero
        try (FileWriter fw = new FileWriter(fichero)){
			xstream.toXML(listaPersonas, fw);
		}catch(Exception e) {
			e.printStackTrace();
		}
        
        
        
        
        
        
       
	}
	
}
