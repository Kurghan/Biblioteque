package fr.afpa.biblioteque.dao;

import java.util.ArrayList;

import fr.afpa.biblioteque.model.*;


public interface IDao {

	//livre
	public void addLivre(Livre livre);
	
	public void supLivre(Livre livre);
	
	public void modifLivre(Livre livre);
	
	public ArrayList<Livre> afficherListeLivre();
	
	public ArrayList<Livre> rechercherLivre(int ISBN,String titre,String sousTitre,String auteur);
	
	//Emprunteur

	public void addEmprunteur(Utilisateur emprunteur);
	
	public void supEmprunteur(Utilisateur emprunteur);
	
	public void ModifyEmprunteur(Utilisateur emprunteur);
	
	public ArrayList<Utilisateur> afficherListeEmprunteur();
	
	public ArrayList<Utilisateur> rechercherEmprunteur(String nom , String prenom);
	
	//Auteur
	
	public void addAuteur(Auteur auteur);
	
	public void supAuteur(Auteur auteur);
	
	public void modifyAuteur(Auteur auteur);
	
	public ArrayList<Auteur> afficherListeAuteur();

	
}
