package mockaroo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * No funciona
 */

public class LecturaStleary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fileOutput = new File("./mockaroo/outputJettisonXstream.xml");
		File file = new File("./mockaroo/MOCK_DATA.json");
		
		
		try(FileReader reader = new FileReader(file)){
			
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.addPermission(AnyTypePermission.ANY);
			xstream.alias("persona", PersonaMockaroo.class);
			xstream.alias("personas", List.class); //raiz
			
			List<PersonaMockaroo> listaPersonas = (List<PersonaMockaroo>) xstream.fromXML(reader);
			
			for (PersonaMockaroo persona : listaPersonas) System.out.println(persona);
			
			XStream xstreamOutput = new XStream(new DomDriver());
			xstreamOutput.addPermission(AnyTypePermission.ANY);
			xstreamOutput.alias("persona", PersonaMockaroo.class);
			//xstreamOutput.alias("personas", List.class);
			
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
