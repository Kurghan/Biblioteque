package fr.afpa.biblioteque.model;

public class Livre {

	private int ISBN;
	private String titre;
	private String sousTitre;
	private String auteur;

	// getters and setters

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSousTitre() {
		return sousTitre;
	}

	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	// Constructor
	public Livre(String titre, String sousTitre, String auteur, int ISBN) {
		super();
		this.ISBN = ISBN;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.auteur = auteur;

	}

	public String toString() {
		String msg = null;
		if(!this.getSousTitre().isEmpty()) {
		msg = "Titre : " + this.getTitre() + "  | sous titre : " +this.getSousTitre() + "  | Auteur :  "+ this.getAuteur() + "  |  ISBN :  " + this.getISBN();}
		else {
		msg = "Titre : " + this.getTitre() + "  | Auteur :  "+ this.getAuteur() + "  |  ISBN :  " + this.getISBN();	
		}
		return msg;
		
	}
}
