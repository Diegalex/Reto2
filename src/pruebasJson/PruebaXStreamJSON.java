package pruebasJson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaXStreamJSON {
	
	//Clase de escritura de un objeto simple en un json

	public static void main(String[] args) {
		File fichero = new File("persona.json");
		
		//Hacemos uso del driver de XStream para Json files en el constructor
		//Solo hacemos cambio al constructor de XStream
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());        
		xstream.alias("persona", Persona.class);
        xstream.addPermission(AnyTypePermission.ANY);
        
        Persona persona1 = new Persona("Romeo","Santos","6531351220");

        //Aunque se use el metodo toXML, el resultado es un archivo con estructura JSON
        //Esto se debe al JsonHierarchicalStreamDriver
        System.out.println(xstream.toXML(persona1));
        
        //Lo escribimos al fichero
        try (FileWriter fw = new FileWriter(fichero)){
			xstream.toXML(persona1, fw);
		}catch(Exception e) {
			e.printStackTrace();
		}
        
        
        
        
        
        
       
	}
	
}
