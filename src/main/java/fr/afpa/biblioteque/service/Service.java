package fr.afpa.biblioteque.service;

import java.util.ArrayList;
import fr.afpa.biblioteque.dao.IDao;
import fr.afpa.biblioteque.model.*;



public class Service implements IService {

	private IDao dao;

	public Service(IDao dao) {
		this.dao = dao;

	}

	// methode des boutons

	// livre :
	public void addLivre(Livre livre) {
		dao.addLivre(livre);
	}

	public Livre openModifyLivre(Livre livre) {
		return livre;
	}

	public void modifyLivre(Livre livre) {
		dao.modifLivre(livre);
	}

	public void supLivre(Livre livre) {
		dao.supLivre(livre);
	}

	public ArrayList<Livre> afficherListeLivre() {
		return dao.afficherListeLivre();
	}

	public ArrayList<Livre> rechercherLivre(int ISBN,String titre,String sousTitre,String auteur) {
		return dao.rechercherLivre(ISBN,titre,sousTitre,auteur);
	}

	// Auteurs :

	public void AddAuteur(Auteur auteur) {
		dao.addAuteur(auteur);
	}

	public void modifyAuteur(Auteur auteur) {
		dao.modifyAuteur(auteur);
	}

	public Auteur openModifyAuteur(Auteur auteur) {
		return auteur;
	}

	public void supAuteur(Auteur auteur) {
		dao.supAuteur(auteur);
	}

	public ArrayList<Auteur> afficherListeAuteur() {
		return dao.afficherListeAuteur();
	}

	// Emprunteurs

	public void addEmprunteur(Utilisateur emprunteur) {
		dao.addEmprunteur(emprunteur);
	}

	public void modifyEmprunteur(Utilisateur emprunteur) {
		dao.ModifyEmprunteur(emprunteur);
	}

	public void supEmprunteur(Utilisateur emprunteur) {
		dao.supEmprunteur(emprunteur);
	}

	public ArrayList<Utilisateur> afficherListeEmprunteur() {
		return dao.afficherListeEmprunteur();
	}
	
	public ArrayList<Utilisateur> rechercherEmpunteur(String nom , String prenom){
		return dao.rechercherEmprunteur(nom ,prenom);
		
	}

}
