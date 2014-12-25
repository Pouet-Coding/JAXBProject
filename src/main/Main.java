package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lasergame.Partie;

/**
 * Classe de test en fait.
 * 
 * @author Guillaume Chanson
 * @since 25 déc. 2014
 * @version 1.0
 */
public class Main {

	/**
	 * Main
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		try {
			// Set up the JAXB context (XML generated classes)
			JAXBContext jc = JAXBContext.newInstance("lasergame");
			
			// Unmarshalling
			Unmarshaller um = jc.createUnmarshaller();
			
			Partie partie = (Partie) um.unmarshal(new File("lasergame.xml"));
			System.out.println("==== Unmarshalling ====\n" + partie);
			
			// Marshalling
			Marshaller marshaller = jc.createMarshaller();
			
			System.out.println("\n==== Marshalling ====");
			marshaller.marshal(partie, System.out);			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
