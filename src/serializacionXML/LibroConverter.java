package serializacionXML;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * https://x-stream.github.io/converter-tutorial.html
 * https://javadoc.io/doc/com.thoughtworks.xstream/xstream/latest/index.html
 */

public class LibroConverter implements Converter{

	public boolean canConvert(Class c) {
        return c.equals(Libro.class);
	}
	
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		Libro libro = (Libro) value;
		
		//ISBN como atributo de cada libro en vez de nodo XML
		writer.addAttribute("isbn", String.valueOf(libro.getIsbn()));
		
		writer.startNode("titulo");
		//Paginas como Atributo de titulo
		writer.addAttribute("paginas", String.valueOf(libro.getPaginas()));
		writer.setValue(libro.getTitulo());
		writer.endNode();
		
		writer.startNode("editorial");
		writer.setValue(libro.getTitulo());
		writer.endNode();
		
		writer.startNode("autor");
		writer.setValue(libro.getAutor());
		writer.endNode();
		
		writer.startNode("copias");
		writer.setValue(String.valueOf(libro.getCopias()));
		writer.endNode();
	}
	
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		
		//Usamos la clase wrapper para poder leer el atributo isbn
		int isbn = Integer.parseInt(reader.getAttribute("isbn"));
		
		reader.moveDown();
		String titulo = reader.getValue();
		int paginas = Integer.parseInt(reader.getAttribute("paginas"));
		reader.moveUp();
		
		reader.moveDown();
		String editorial = reader.getValue();
		reader.moveUp();
		
		reader.moveDown();
		String autor = reader.getValue();
		reader.moveUp();
		
		reader.moveDown();
		int copias = Integer.parseInt(reader.getValue());
		reader.moveUp();
		
		return new Libro(isbn, titulo, editorial, paginas, autor, copias);
	}

	
}
