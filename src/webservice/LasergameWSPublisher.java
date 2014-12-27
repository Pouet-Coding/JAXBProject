/**
 * 
 */
package webservice;

import javax.xml.ws.Endpoint;

/**
 * Publisher of the web service {@link Lasergame}.
 * 
 * @author Guillaume Chanson
 * @since 27 déc. 2014
 * @version 1.0
 */
public class LasergameWSPublisher {

	private static final String URL = "http://localhost:8080/WS/Lasergame";

	/**
	 * Main.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		Endpoint.publish(URL, new LasergameImpl());
		System.out.println("Started ! \nListening on " + URL);
	}
}
