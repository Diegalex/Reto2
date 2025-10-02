package dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import serializacionXML.Libro;


public class LeerFicheroDOM {

	public static void main(String[] args) {
		File file=new File("\\Users\\Usuario\\git\\Reto2\\Reto2\\libro.xml");
		
		try {
			//Inicio la clase DocumentBuilder y al documento le paso el archivo que quiero que lea
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			 Document doc = dBuilder.parse(file);
			 //El nodo hago que busque los elementos con nombre libro
			 NodeList biblioteca = doc.getElementsByTagName("libro");
			 //recorro el nodo sacando uno a uno cada libro sacando a su vez cada atributo del libro de uno en uno 
			 //y guardo cada atributo para que me cree un nuevo elemento de la clse libro 
			 for (int i = 0; i < biblioteca.getLength(); i++) {
	                Node nodo = biblioteca.item(i);

	                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
	                    Element elemento = (Element) nodo;

	                    int isbn = Integer.parseInt(elemento.getElementsByTagName("codigo").item(0).getTextContent());
	                    String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
	                    String autor = elemento.getElementsByTagName("autor").item(0).getTextContent();
	                    String editorial = elemento.getElementsByTagName("editorial").item(0).getTextContent();
	                    int paginas = Integer.parseInt(elemento.getElementsByTagName("paginas").item(0).getTextContent());
	                    int copias = Integer.parseInt(elemento.getElementsByTagName("copias").item(0).getTextContent());

	                    
	                    Libro libro = new Libro(isbn, titulo, editorial, paginas, autor, copias);

	                   
	                    System.out.println(libro);
	                }
			}
		
		}catch(Exception e) {
			 e.printStackTrace();
			}


	
	}
}
