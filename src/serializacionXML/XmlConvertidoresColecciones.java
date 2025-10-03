package serializacionXML;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XmlConvertidoresColecciones {

	public static void main(String[] args) {
		
		File file = new File("librosConvertidores.xml");

		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		
		List<Libro> lista=new ArrayList<Libro>();
		lista.add(new Libro(419260447,"Death Note Tomo 2","Norma Editorial",180,"Tsugumi Ohba",185));
		lista.add(new Libro(419260448,"Neon Genesis Evangelion Tomo 2","Norma Editorial",380,"Yoshiyuki Sadamoto",22));
		lista.add(new Libro(419260449,"Berserk Deluxe Volume 1","Dark Horse Manga",696,"Kentaro Miura",352));
		lista.add(new Libro(419260449,"Bloom Into You Volumen 1","Planeta Comics",196,"Nakatani Nio",12));
		
		//Alias para que en el XML aparezca la etiqueta correspondiente
		xs.alias("libro", Libro.class);
		//Cambiamos alias
		xs.alias("libreria", List.class);
		
		//Usamos el convertidor creado
		xs.registerConverter(new LibroConverter());
		
		//para mostrar en consola
		String xml = xs.toXML(lista);
		System.out.println(xml);
		
		try (FileWriter fw=new FileWriter(file)){
			//creo el fichero xml dentro de los parentesis del try y meto mi array de libros convertido en xml dentro del fichero
			xs.toXML(lista, fw);
		}catch(Exception e) {
			
		}
		
	}

}
