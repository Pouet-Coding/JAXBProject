/**
 * 
 */
package webservice;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface de définition du comportement du EndPoint Lasergame.
 * 
 * @author Guillaume Chanson
 * @since 27 déc. 2014
 * @version 1.0
 */
@WebService
public interface Lasergame {

	/**
	 * Affiche les paramètres de la partie : <br>
	 * Unmarshall the Partie marshalled as partieXML given and print it to
	 * System.out
	 * 
	 * @param partieXML
	 *            partie dont on veut afficher les détails.
	 */
	@WebMethod
	public void afficherPartie(File partieXML);
}
