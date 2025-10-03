package serializacionXML;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class LecturaConverters {

	public static void main(String[] args) {
		
		File file = new File("librosConvertidores.xml");
		
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		
		//Se usan los mismos alias
		xs.alias("libro", Libro.class);
		xs.alias("libreria", List.class);
		
		//Usamos el mismo converter
		xs.registerConverter(new LibroConverter());
		
		
		try (FileReader fr=new FileReader(file)){
			List<Libro> biblioteca = (ArrayList<Libro>) xs.fromXML(fr);
			
			for (Libro libro : biblioteca) {
                System.out.println(libro);
            }
		}catch(Exception e) {
			
		}
		
		
	}

}
