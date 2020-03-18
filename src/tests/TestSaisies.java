package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projPOO01.Exceptions.ExceptionContratAgence;
import projPOO01.Exceptions.ExceptionNumeroUnique;
import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionPersonnes.Client;
import projPOO01.GestionPersonnes.ExceptionNbMoisContrat;
import projPOO01.GestionPersonnes.Fournisseur;
import projPOO01.GestionPersonnes.Interimaire;
import projPOO01.GestionPersonnes.Personne;
import projPOO01.GestionPersonnes.Salarie;

public class TestSaisies {

//Constante utilisées pour les test
	private final String cpf = "698400";
	private final String cpf1 = "60cde";
	private final String cpt = "69100";
	private final String nsf = "12345678901234";
	private final String nsf1 = "123abcd890123";
	private final String nst = "1234567890123";
	private ArrayList<Fournisseur> flist;
	private Fournisseur f;
	private final Integer ofnumunique = 1;
	private final String fnumuniquef = "1";
	private final String fnumuniquef1 = "a";
	private final String fnumuniquet = "2";
	private ArrayList<Client> clist;
	private Client c;
	private final Integer ocnumunique = 1;
	private final String cnumuniquef = "1";
	private final String cnumuniquef1 = "a";
	private final String cnumuniquet = "2";
	private Interimaire i;
	private final String iContratAgence = "123456F";
	private final String iContratAgenceErrone = "123";
	private final int nbMoisContrat = 2;
	private final int nbMoisContratErrone = 0;
	private ArrayList<Interimaire> ilist;

//Before realisé avant la classe de test, permeert la création d'une list de fournisseur et d'une de client
//	pour utilisation dans test
	@Before
	public void init() {
		flist = new ArrayList<Fournisseur>();
		f = new Fournisseur("Fournisseur", "test", "rue", "Lyon", "69000", ofnumunique);
		flist.add(f);

		clist = new ArrayList<Client>();
		c = new Client("Client", "test", "rue", "Lyon", "69000", ocnumunique);
		clist.add(c);

		ilist = new ArrayList<Interimaire>();
		i = new Interimaire("Dupond", "Francis", "rue truc", "machin", "79000", "2", 1000d, "ohdesf", 3);
		ilist.add(i);
	}

	/**
	 * Test U pour la saisie des code postal, ici test les cas ou : le code postal a
	 * 5 chiffre (cpt) s'il y en a plus de 5 (cpf) Si les caractéres sont bien des
	 * chiffres (cpf1)
	 */
	@Test
	public void testCtrlCodePostal() {
		try {
			Personne.CtrlCodePostal(cpt); // code postal correct
			Personne.CtrlCodePostal(cpf);// code postal trop long
		} catch (ExceptionSaisieCodePostal e) {
			assertThat(e.getMessage(), is("Le nombre de caractère est différents de 5."));
		}
		try {
			Personne.CtrlCodePostal(cpf1); // caractére autre que chiffre pour code postal
		} catch (ExceptionSaisieCodePostal e) {
			assertThat(e.getMessage(), is("Il faut saisir uniquement des chiffres"));
		}
	}

	/**
	 * Test U pour la saisi des numero de sécu, ici test les cas ou : le nombre de
	 * caractere est egale a 13 (nst) le nb de caractere est supperieur a 13 (nsf)
	 * cas avec caractere autre que chiffre (nsf1)
	 */
	@Test
	public void testCtrlNumSecu() {
		try {
			Salarie.CtrlSaisiNumeroSecu(nst); // cas passant
			Salarie.CtrlSaisiNumeroSecu(nsf); // cas plus de 13 caractere
		} catch (ExceptionSaisiNumeroSecu e) {
			assertThat(e.getMessage(), is("Le nombre de caractère est différents de 13"));
		}

		try {
			Salarie.CtrlSaisiNumeroSecu(nsf1); // cas avec caractere autre que chiffre
		} catch (ExceptionSaisiNumeroSecu e) {
			assertThat(e.getMessage(), is("Il faut saisir uniquement des chiffres"));
		}
	}

	/**
	 * Test U sur methode de control des numero de fournisseur puis de client
	 * comprend les cas suivant : cas id est un entier (cas passant) cas id deja
	 * utilisé cas ou id n'est pas un entier
	 */
	@Test
	public void testCtrlDoublons() {
		try {
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquet, flist); // cas id fournisseur est un entier
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquef, flist);// cas id fournisseur deja utilisé
		} catch (ExceptionNumeroUnique e) {
			assertThat(e.getMessage(), is("Le numero unique est déja utilisé"));
		}

		try {
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquef1, flist); // cas ou le id fournisseur n'est pas un
																			// entier
		} catch (ExceptionNumeroUnique e) {
			assertThat(e.getMessage(), is("Le numero saisi n'est pas un entier"));
		}

		try {
			Client.CtrlNumeroUniqueClient(cnumuniquet, clist);// cas passant
			Client.CtrlNumeroUniqueClient(cnumuniquef, clist);// cas id deja utilisé
		} catch (ExceptionNumeroUnique e) {
			assertThat(e.getMessage(), is("Le numero unique est déja utilisé"));
		}

		try {
			Client.CtrlNumeroUniqueClient(cnumuniquef1, clist);// cas ou id n'est pas un entier
		} catch (ExceptionNumeroUnique e) {
			assertThat(e.getMessage(), is("Le numero saisi n'est pas un entier"));
		}

	}

	/**
	 * Test U sur methodes de control des contratAgence et nbMoisContrat d'un
	 * Interimaire 
	 * 
	 */
	@Test
	public void testCtrlSaisiContratAgence() {
		try {
			Interimaire.ctrlSaisiContratAgence(iContratAgence); // cas passant
			Interimaire.ctrlSaisiContratAgence(iContratAgenceErrone);// nb caractere insuffisant
		} catch (ExceptionContratAgence e) {
			assertThat(e.getMessage(), is("Le nombre de caractere utilise pour le contrat agence est insuffisant"));

		}
		try {
			Interimaire.ctrlSaisiNbMoisContrat(nbMoisContrat); // cas passant
			Interimaire.ctrlSaisiNbMoisContrat(nbMoisContratErrone);// nb mois insuffisant
		} catch (ExceptionNbMoisContrat e) {
			assertThat(e.getMessage(), is(" le nombre de mois est insuffisant, il doit etre superieur ou egal a 1"));
		}

	}

}
