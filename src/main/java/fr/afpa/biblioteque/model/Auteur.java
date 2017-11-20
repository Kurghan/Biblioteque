package fr.afpa.biblioteque.model;

public class Auteur {

	private String nom;
	private String Prenom;
	private String dateNaissance;
	private int idAuteur;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	public Auteur(String nom, String prenom ,String dateNaissance,int idAuteur) {
		super();
		this.nom = nom;
		this.Prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.idAuteur =idAuteur;
	}
	public String toString() {
		String msg=getNom()+ " - " + getPrenom() + " né le " + getDateNaissance();
		return msg;
	
	}
}
