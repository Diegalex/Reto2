package serializacionXML;

import java.io.File;
import java.util.Iterator;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;


public class PersistenciaLibro {
	
	/**
	 * @description Metodo main para probar la persistencia, creando un archivo por cada Objeto a serializar en XML
	 * Posteriormente se lee haciendo uso de un iterador
	 * https://x-stream.github.io/persistence-tutorial.html
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.addPermission(AnyTypePermission.ANY);
		
		//PersistenceStrategy permite serializar a ficheros una colección de Objetos de manera facil.
		//Aunque crea un fichero separado por elemento
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."),xstream);
		XmlArrayList lista = new XmlArrayList(strategy);
		
		// Se crea un fichero por cada elemento del XmlArrayList conteniendo ese solo Objeto en el fichero
		// crea elementos con el nombre int@(indice).xml
		lista.add(new Libro(419260447,"Death Note Tomo 2","Norma Editorial",180,"Tsugumi Ohba",185));
		lista.add(new Libro(419260448,"Neon Genesis Evangelion Tomo 2","Norma Editorial",380,"Yoshiyuki Sadamoto",22));
		lista.add(new Libro(419260449,"Berserk Deluxe Volume 1","Dark Horse Manga",696,"Kentaro Miura",352));
		lista.add(new Libro(419260449,"Bloom Into You Volumen 1","Planeta Comics",196,"Nakatani Nio",12));
		
		// Leer elementos creados
		for(Iterator it = lista.iterator(); it.hasNext(); ) {
			Libro libro = (Libro) it.next();
			System.out.println(libro.toString());
		}

		
	}
	
	

}
