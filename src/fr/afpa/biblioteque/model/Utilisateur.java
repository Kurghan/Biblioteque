package fr.afpa.biblioteque.model;

public class Utilisateur {

	private String nom;
	private String prenom;
	private int numeroAbonne;
	private int numTelephone;

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumeroAbonne() {
		return numeroAbonne;
	}

	public void setNumeroAbonne(int numeroAbonne) {
		this.numeroAbonne = numeroAbonne;
	}

	public Utilisateur(String nom, String prenom, int numeroAbonne, int numTelephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroAbonne = numeroAbonne;
		this.numTelephone = numTelephone;
	}

	public String toString() {
		String msg = getNom() + " - " + getPrenom() + " numero abonné : " + getNumeroAbonne() + " tel : " +getNumTelephone();
		return msg;

	}

}
