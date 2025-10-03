package serializacionXML;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaLibro {

	/**
	 * Prueba de serialización de la clase Libro sin alias
	 * Al no usar alias, el formato del XML es diferente en cuanto
	 * a que la etiqueta que engloba todos los componentes es por defecto <list>
	 * a diferencia de al aplicar alias, que podemos definir el nombre, en este caso biblioteca
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creación de objeto xstream con TODOS los permisos
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		File fichero = new File("libroSinAlias.xml");
		
		List<Libro> arrayLibros = new ArrayList<Libro>();
		arrayLibros.add(new Libro(419260444,"Mistborn","Nova",672,"Brandon Sanderson",1000000));
		arrayLibros.add(new Libro(419260445,"El pozo de la Ascensión","Nova",784,"Brandon Sanderson",1000000));
		arrayLibros.add(new Libro(419260446,"El heroe de las eras","Nova",760,"Brandon Sanderson",1000000));
		
		
		//Xml a consola
		String xml = xs.toXML(arrayLibros);
		System.out.println(xml);
		System.out.println();
		
		//Output a fichero XML
		try (FileWriter fw = new FileWriter(fichero)){
			xs.toXML(arrayLibros, fw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Lectura del mismo fichero
		try (FileReader fr=new FileReader(fichero)){
			List<Libro> arrayLibrosLectura = (ArrayList<Libro>) xs.fromXML(fr);
			
			for (Libro libro : arrayLibrosLectura) {
                System.out.println(libro);
            }
		}catch(Exception e) {
			
		}

	}

}
