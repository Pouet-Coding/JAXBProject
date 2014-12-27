package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lasergame.Joueur;
import lasergame.ObjectFactory;
import lasergame.Partie;
import lasergame.Score;

/**
 * Classe de test en fait.
 * 
 * @author Guillaume Chanson
 * @since 25 déc. 2014
 * @version 1.0
 */
public class Main {

	private final JAXBContext jcContext;

	/**
	 * Create a new Main.
	 * 
	 * @param jcContext
	 *            the JAXBContext to define
	 * @throws JAXBException
	 *             if context could'nt be defined
	 */
	public Main(String context) throws JAXBException {
		this.jcContext = JAXBContext.newInstance(context);
	}

	/**
	 * Basic example.
	 * 
	 * @throws JAXBException
	 *             if an error with JAXB happens
	 */
	public void marsh_unmarsh() throws JAXBException {
		// Unmarshalling
		Unmarshaller um = jcContext.createUnmarshaller();

		Partie partie = (Partie) um.unmarshal(new File(
				"ressources/lasergame/lasergame.xml"));
		System.out.println("==== Unmarshalling ====\n" + partie);

		// Marshalling
		Marshaller marshaller = jcContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		System.out.println("\n==== Marshalling ====");
		marshaller.marshal(partie, System.out);
	}

	/**
	 * Marshalle un joueur et l'affiche dans sysout.
	 * 
	 * @throws JAXBException
	 *             if an error with JAXB happens
	 */
	public void marshJoueur() throws JAXBException {
		// Marshalling
		Marshaller marshaller = jcContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		// Création du joueur
		ObjectFactory factory = new ObjectFactory();
		
		// Score joueur
		Score scoreJ0 = factory.createScore();
		scoreJ0.setNumeroScore(0);
		scoreJ0.setNbreTues(0);
		scoreJ0.setNbreMorts(0);
		scoreJ0.setHandicap(0.0);
		
		// Joueur0
		Joueur joueur = factory.createJoueur();
		joueur.setCouleur("Rouge");
		joueur.setNumeroJoueur(0);
		joueur.setPseudo("Test_j0");
		joueur.setScore(scoreJ0);
		
		// Partie
		Partie partie = factory.createPartie();
		List<Joueur> joueurs = new ArrayList<>();
		joueurs.add(joueur);
		partie.setJoueurs(joueurs);

		// Affichage du document xml créé
		System.out.println("\n==== Marshalling ====");
		marshaller.marshal(partie, System.out);
	}

	/**
	 * Main.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		try {
			Main main = new Main("lasergame");
			main.marsh_unmarsh();
			main.marshJoueur();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}