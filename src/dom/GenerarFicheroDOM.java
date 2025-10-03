package dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import serializacionXML.Libro;

public class GenerarFicheroDOM {

	public static void main(String[] args) throws TransformerException {
		List<Libro> biblioteca=new ArrayList<Libro>();
		biblioteca.add(new Libro(338495215,"La cancion de Aquiles","AdN",428,"Madeline Miller",25000));
		biblioteca.add(new Libro(362879955,"Los juegos del hambre","AdN",428,"Suzane Collins",3000000));
		biblioteca.add(new Libro(228782564,"Los mitos de Cthulu","AdN",428,"H.P Lovecraft",100000));
		

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();;
			Document doc = db.newDocument();
			
			//Creo la clase biblioteca como elemento pricipal de mi xml
			Element eRaiz=doc.createElement("Biblioteca");
			doc.appendChild(eRaiz);
			
			
			for(Libro libro:biblioteca) {
				//por cada libro me crea una clase libro en el xml con los datos de cada atributo del libro
				Element eLibro=doc.createElement("Libro");
				eRaiz.appendChild(eLibro);
				
				Element eCodigo = doc.createElement("codigo");
				eCodigo.appendChild(doc.createTextNode(String.valueOf(libro.getIsbn())));
				eLibro.appendChild(eCodigo);

				Element eTitulo = doc.createElement("titulo");
				eTitulo.appendChild(doc.createTextNode(libro.getTitulo()));
				eLibro.appendChild(eTitulo);

				Element eAutor = doc.createElement("autor");
				eAutor.appendChild(doc.createTextNode(libro.getAutor()));
				eLibro.appendChild(eAutor);

				Element eEditorial = doc.createElement("editorial");
				eEditorial.appendChild(doc.createTextNode(libro.getEditorial()));
				eLibro.appendChild(eEditorial);

				Element ePaginas = doc.createElement("paginas");
				ePaginas.appendChild(doc.createTextNode(String.valueOf(libro.getPaginas())));
				eLibro.appendChild(ePaginas);

				Element eCopias = doc.createElement("copias");
				eCopias.appendChild(doc.createTextNode(String.valueOf(libro.getCopias())));
				eLibro.appendChild(eCopias);
				
			}
			//Creo el xml y le paso el documento que se creo al inicio y en el que he guardado los datos de cada atributo de cada libro 
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("libroDOM.xml"));
			
			transformer.transform(source, result);


			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
