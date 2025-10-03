package mockaroo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * Gson lee los nombres para los campos de la clase de la manera literal en el fichero json
 * debemos implementar por lo tanto los campos adecuados en la clase Persona
 */

public class LecturaGson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fileOutput = new File("./mockaroo/outputGsonXstream.xml");
		File file = new File("./mockaroo/MOCK_DATA.json");
		Gson gson = new Gson();
		
		try(FileReader reader = new FileReader(file)){
			
			Type tipoLista = new TypeToken<List<PersonaMockaroo>>() {}.getType();
			List<PersonaMockaroo> listaPersonas = gson.fromJson(reader, tipoLista);
			
			for (PersonaMockaroo personaMockaroo : listaPersonas) {
				System.out.println(personaMockaroo);
			}
			
			XStream xstream = new XStream(new DomDriver());
			xstream.addPermission(AnyTypePermission.ANY);
			xstream.alias("persona", PersonaMockaroo.class);
			xstream.alias("personas", List.class); //raiz
			
			try (FileWriter fw = new FileWriter(fileOutput)){
				xstream.toXML(listaPersonas, fw);
				System.out.println("XML Generado");
			}
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
