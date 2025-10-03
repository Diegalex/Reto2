package pruebasJson;

import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaXStreamJSONHierarchical {
	
	/**
	 * A diferencia de la clase PruebaXStreamJSON se usa HierarchicalDriver que de igual manera añade un elemento raiz al json
	 * Se usará la clase PruebaXStreamJSONLista (Usa MappedXml) para la generacion del fichero que luego leeremos con otras librerias
	 * @param args
	 */

	public static void main(String[] args) {
		
		File fichero = new File("personas.json");
		
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        
        xstream.alias("persona", Persona.class);
        //No se hace uso de coleccion implicita
		
		//Hacemos uso de nuestra lista contenedora para almacenar objetos del tipo Persona
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Romeo","Santos","6531351220"));
        listaPersonas.add(new Persona("Chayanne","Torero","666655243"));
        listaPersonas.add(new Persona("Guts","Berserk","634326279"));

        //Aunque se use el metodo toXML, el resultado es un archivo con estructura JSON
        //Esto se debe al JsonHierarchicalStreamDriver/MappedDriver
        String outputJson = xstream.toXML(listaPersonas);
        
        //Imprime con un "PrettyPrint"
        System.out.println(outputJson);
        
        //Lo escribimos al fichero
        try (FileWriter fw = new FileWriter(fichero)){
			fw.write(outputJson);;
		}catch(Exception e) {
			e.printStackTrace();
		}
        
        
        
        
        
        
       
	}
	
}
