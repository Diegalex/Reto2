package serializacionXML;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class RecuperarLibros {

	public static void main(String[] args) {
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		
		//Vuelvo a poner los alias que puse a la hora de guardar libros porque si no no hace bien el programam y no muestra nada en consola
		xs.alias("libro", Libro.class);
		xs.alias("biblioteca", List.class);
		xs.aliasField("codigo", Libro.class,"isbn");
		
		try (FileReader fr=new FileReader("libro.xml")){
			//Leo el fichero xml y vuelvo a introducir los libros en un array haciedo casting
			List<Libro> biblioteca = (ArrayList<Libro>) xs.fromXML(fr);
			
			//recorro el array para que me muestre los libros en consola
			for (Libro libro : biblioteca) {
                System.out.println(libro);
            }
		}catch(Exception e) {
			
		}

	}

}
