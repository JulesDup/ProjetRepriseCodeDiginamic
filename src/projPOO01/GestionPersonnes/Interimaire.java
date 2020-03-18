package projPOO01.GestionPersonnes;

import projPOO01.Exceptions.ExceptionContratAgence;

public class Interimaire extends Salarie {

	/** contratAgence : information relative au contrat de l'interimaire */
	private String contratAgence;
	/** nbMoisContrat : nombre de mois du contrat de l'interimaire */
	private int nbMoisContrat;
	
	

	/**
	 * Constructeur autogeneré avec les attributs des parents salarier mais aussi de
	 * 
	 * @param nom           de l'interimaire
	 * @param prenom        de l'interimaire
	 * @param adresse       de l'interimaire
	 * @param ville         de l'interimaire
	 * @param codepostal    de l'interimaire
	 * @param secu          numero de secu de l'interimaire
	 * @param salaire       de l'interimaire
	 * @param contratAgence : information relative au contrat de l'interimaire
	 * @param nbMoisContrat : nombre de mois du contrat de l'interimaire
	 */
	public Interimaire(String nom, String prenom, String adresse, String ville, String codepostal, String secu,
			double salaire, String contratAgence, int nbMoisContrat) {
		super(nom, prenom, adresse, ville, codepostal, secu, salaire);
		this.contratAgence = contratAgence;
		this.nbMoisContrat = nbMoisContrat;
	}

	public static void ctrlSaisiContratAgence(String contratAgence) throws ExceptionContratAgence {
		if (contratAgence.length() < 5) {
			throw new ExceptionContratAgence("Le contrat doit comprendre 5 caracteres minimum ");
		}

	}

	public static void ctrlSaisiNbMoisContrat(int nbMoisContrat) throws ExceptionNbMoisContrat {
		if (nbMoisContrat < 1) {
			throw new ExceptionNbMoisContrat("le nombre de mois du contrat de l'interimaire doit être suppérieur à 1");
		}
	}

	/**
	 * Getter
	 * 
	 * @return les informations du contratAgence
	 */
	public String getContratAgence() {
		return contratAgence;
	}

	/**
	 * Getter
	 * 
	 * @return le nombre de mois du contrat de l'interimaire nbMoisContrat
	 */
	public int getNbMoisContrat() {
		return nbMoisContrat;
	}

	/**
	 * Setter
	 * 
	 * @param contratAgence the contratAgence to set
	 */
	public void setContratAgence(String contratAgence) {
		this.contratAgence = contratAgence;
	}

	/**
	 * Setter
	 * 
	 * @param nbMoisContrat the nbMoisContrat to set
	 */
	public void setNbMoisContrat(int nbMoisContrat) {
		this.nbMoisContrat = nbMoisContrat;
	}

}
