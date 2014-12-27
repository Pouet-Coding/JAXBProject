/**
 * 
 */
package webservice;

import java.io.File;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lasergame.Partie;

/**
 * EndPoint Lasergame réalisant le contrat {@link Lasergame}.
 * 
 * @author Guillaume Chanson
 * @since 27 déc. 2014
 * @version 1.0
 */
@WebService(endpointInterface = "webservice.Lasergame")
public class LasergameImpl implements Lasergame {

	/*
	 * @see webservice.Lasergame#afficherPartie(java.io.File)
	 */
	@Override
	public void afficherPartie(File partieXML) {
		System.out.println("\nNew partie received.. loading");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("lasergame");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Partie partie = (Partie) unmarshaller.unmarshal(partieXML);
			System.out.println("\n===== Unmarshalled partie =====\n" + partie);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
