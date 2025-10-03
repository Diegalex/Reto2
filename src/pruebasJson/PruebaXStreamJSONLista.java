package pruebasJson;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.*;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * Se hace uso de una clase contenedora (ListaPersonas) de personas para poder aplicar los alias correctamente
 * La clase genera un Json correcto pero luego leer de el con otras librerias genera muchos pasos innecesarios
 * Para generear el Json con aliases correctos se tuvo que cambiar el HierarchicalDriver por un MappedXmlDriver
 * @param args
 */

public class PruebaXStreamJSONLista {
	

	public static void main(String[] args) {
		
		File fichero = new File("personas.json");
		
		//XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        
        xstream.alias("persona", Persona.class);
        xstream.alias("listaPersonas", ListaPersonas.class);
		
        // Se añade la colección implicita
		xstream.addImplicitCollection(ListaPersonas.class, "persona");
		
		//Hacemos uso de nuestra lista contenedora para almacenar objetos del tipo Persona
        ListaPersonas listaPersonas = new ListaPersonas();
        listaPersonas.add(new Persona("Romeo","Santos","6531351220"));
        listaPersonas.add(new Persona("Chayanne","Torero","666655243"));
        listaPersonas.add(new Persona("Guts","Berserk","634326279"));

        //Aunque se use el metodo toXML, el resultado es un archivo con estructura JSON
        //Esto se debe al JsonHierarchicalStreamDriver/MappedDriver
        String outputJson = xstream.toXML(listaPersonas);
        
        //Imprime sin hacer un "PrettyPrint" a comparación del Hierarchical Driver
        System.out.println(outputJson);
        
        //Lo escribimos al fichero
        try (FileWriter fw = new FileWriter(fichero)){
			fw.write(outputJson);;
		}catch(Exception e) {
			e.printStackTrace();
		}
        
        
        
        
        
        
       
	}
	
}
