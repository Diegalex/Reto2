package serializacionXML;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class GuardarLibros {

	public static void main(String[] args) {
		
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		
		List<Libro> biblioteca=new ArrayList<Libro>();
		biblioteca.add(new Libro(419260444,"Mistborn","Nova",672,"Brandon Sanderson",1000000));
		biblioteca.add(new Libro(419260445,"El pozo de la Ascensión","Nova",784,"Brandon Sanderson",1000000));
		biblioteca.add(new Libro(419260446,"El heroe de las eras","Nova",760,"Brandon Sanderson",1000000));
		
		//Alias para que en el XML aparezca la etiqueta que quiro poner (campo 1) en lugar de en nombre de la clase(Campo 2)
		xs.alias("libro", Libro.class);
		xs.alias("biblioteca", List.class);
		//Este caso al ser un atributo se pone el nombre que le quieres poner, la clase a la que pertenece y que atributo es
		xs.aliasField("codigo", Libro.class,"isbn");
		
		//para mostrar en consola
		String xml = xs.toXML(biblioteca);
		System.out.println(xml);
		
		try (FileWriter fw=new FileWriter("libro.xml")){
			//creo el fichero xml dentro de los parentesis del try y meto mi array de libros convertido en xml dentro del fichero
			xs.toXML(biblioteca, fw);
		}catch(Exception e) {
			
		}

	}

}
