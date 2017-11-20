package fr.afpa.biblioteque.service;

import java.util.ArrayList;

import fr.afpa.biblioteque.model.*;

public interface IService {


	
		//methodes

		//livres :
		
		public void addLivre(Livre livre);
		
		public Livre openModifyLivre(Livre livre);
		
		public void modifyLivre(Livre livre);
		
		public void supLivre(Livre livre);
		
		public ArrayList<Livre> afficherListeLivre();
		
		public ArrayList<Livre>rechercherLivre(int ISBN,String titre,String sousTitre,String auteur);
		
		//Emprunteurs :
		
		public void addEmprunteur(Utilisateur emprunteur);

		public void modifyEmprunteur(Utilisateur emprunteur);
		
		public void supEmprunteur(Utilisateur emprunteur);

		public ArrayList<Utilisateur> afficherListeEmprunteur();
		
		public ArrayList<Utilisateur> rechercherEmpunteur(String nom , String prenom);
		
		//Auteurs :
		
		public void AddAuteur(Auteur auteur);
		
		public void modifyAuteur(Auteur auteur);
		
		public void supAuteur(Auteur auteur);
		
		public ArrayList<Auteur> afficherListeAuteur();
		
		



	
}
