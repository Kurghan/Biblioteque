package fr.afpa.biblioteque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.afpa.biblioteque.model.*;

public class Dao implements IDao {

	private String url = "jdbc:mariadb://192.168.1.150:3307/biblioteque";
	private String login = "afpa";
	private String passwd = "SuperAFPA";
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet result = null;

	public Dao() {
		init();
	}

	public void init() {
		// Chargement du Driver
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	// livre

	public void addLivre(Livre livre) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "insert into livre (idPersonne,titreLivre,sousTitreLivre,ISBN) values ((select idPersonne from personne where nomPersonne = '"
					+ livre.getAuteur() + "'),'" + livre.getTitre() + "','" + livre.getSousTitre() + "',"
					+ livre.getISBN() + ")";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifLivre(Livre livre) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "update biblioteque.livre set titreLivre = '" + livre.getTitre() + "',sousTitreLivre = '"
					+ livre.getSousTitre() + "' where titreLivre = '" + livre.getTitre() + "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void supLivre(Livre livre) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "delete from biblioteque.livre where titreLivre ='" + livre.getTitre() + "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Livre> afficherListeLivre() {

		ArrayList<Livre> listeLivre = new ArrayList<Livre>();
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "SELECT * FROM livre,auteur,personne where auteur.idPersonne = personne.idPersonne and livre.idPersonne = auteur.idPersonne";
			result = statement.executeQuery(query);
			while (result.next()) {
				int ISBN = result.getInt("ISBN");
				// System.out.println(ISBN);
				String titre = result.getString("titreLivre");
				String sousTitre = result.getString("sousTitreLivre");
				String auteur = result.getString("nomPersonne");
				Livre l = new Livre(titre, sousTitre, auteur, ISBN);
				listeLivre.add(l);

			}
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeLivre;

	}

	public ArrayList<Livre> rechercherLivre(int ISBN, String titre, String sousTitre, String auteur) {

		ArrayList<Livre> listeLivrerechercher = new ArrayList<Livre>();
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = null;
			if (!titre.isEmpty() && !sousTitre.isEmpty() && !auteur.isEmpty() && ISBN != 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where titreLivre like '"
						+ titre + "'and sousTitreLivre like '" + sousTitre + "' and nomPersonne like '" + auteur
						+ "' and ISBN like '" + ISBN + "'";
			} else if (!titre.isEmpty() && sousTitre.isEmpty() && auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where titreLivre like '"
						+ titre + "'";
			} else if (titre.isEmpty() && !sousTitre.isEmpty() && auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where sousTitreLivre like '"
						+ sousTitre + "'";
			} else if (titre.isEmpty() && sousTitre.isEmpty() && !auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where nomPersonne like '"
						+ auteur + "'";
			} else if (titre.isEmpty() && sousTitre.isEmpty() && auteur.isEmpty() && ISBN != 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where ISBN like '"
						+ ISBN + "'";
			} else if (titre.isEmpty() && sousTitre.isEmpty() && auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne";
			} else if (!titre.isEmpty() && !sousTitre.isEmpty() && auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where titreLivre like '"
						+ titre + "' and sousTitreLivre like '" + sousTitre + "' ";
			} else if (!titre.isEmpty() && sousTitre.isEmpty() && !auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where titreLivre like '"
						+ titre + "' and nomPersonne like '" + auteur + "' ";
			} else if (!titre.isEmpty() && sousTitre.isEmpty() && auteur.isEmpty() && ISBN != 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where titreLivre like '"
						+ titre + "' and ISBN like '" + ISBN + "' ";
			}else if (titre.isEmpty() && !sousTitre.isEmpty() && !auteur.isEmpty() && ISBN == 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where sousTitreLivre like '"
						+ sousTitre + "' and nomPersonne like '" + auteur + "' ";
			}else if (titre.isEmpty() && sousTitre.isEmpty() && !auteur.isEmpty() && ISBN != 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where nomPersonne like '"
						+ auteur + "' and ISBN like '" + ISBN + "' ";
			}else if (titre.isEmpty() && !sousTitre.isEmpty() && auteur.isEmpty() && ISBN != 0) {
				query = "select * from biblioteque.livre join biblioteque.personne on livre.idPersonne = personne.idPersonne where sousTitreLivre like '"
						+ sousTitre + "' and ISBN like '" + ISBN + "' ";
			}

			result = statement.executeQuery(query);
			while (result.next()) {
				ISBN = result.getInt("ISBN");
				titre = result.getString("titreLivre");
				sousTitre = result.getString("sousTitreLivre");
				auteur = result.getString("nomPersonne");
				Livre l = new Livre(titre, sousTitre, auteur, ISBN);
				listeLivrerechercher.add(l);
			}

			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeLivrerechercher;
	}

	// Emprunteur

	public void addEmprunteur(Utilisateur emprunteur) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query1 = "insert into personne (nomPersonne,prenomPersonne) values ('" + emprunteur.getNom() + "','"
					+ emprunteur.getPrenom() + "')";

			String query2 = "insert into abonne (idPersonne,numTelephone) values ((select idPersonne from personne where nomPersonne = '"
					+ emprunteur.getNom() + "'), " + emprunteur.getNumTelephone() + ")";
			
			statement.executeUpdate(query1);
			statement.executeUpdate(query2);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void supEmprunteur(Utilisateur emprunteur) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			//System.out.println(emprunteur.getNumeroAbonne());
			String query = "DELETE personne FROM personne where personne.idPersonne ='" + emprunteur.getNumeroAbonne() + "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	public ArrayList<Utilisateur> afficherListeEmprunteur() {
		ArrayList<Utilisateur> listeEmprunteur = new ArrayList<Utilisateur>();
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "SELECT * FROM abonne,personne where abonne.idPersonne = personne.Idpersonne";
			result = statement.executeQuery(query);
			while (result.next()) {
				String nom = result.getString("nomPersonne");
				String prenom = result.getString("prenomPersonne");
				int numeroAbonne = result.getInt("idPersonne");
				int numTelephone = result.getInt("numTelephone");
				Utilisateur a = new Utilisateur(nom, prenom, numeroAbonne,numTelephone);
				listeEmprunteur.add(a);
				
				//System.out.println(a);

			}
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeEmprunteur;

	}
	
	public ArrayList<Utilisateur> rechercherEmprunteur(String nom , String prenom) {
		ArrayList<Utilisateur> listEmprunteurRechercher = new ArrayList<Utilisateur>();
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "SELECT * FROM abonne,personne where abonne.idPersonne = personne.Idpersonne and nomPersonne like '" + nom + "'";
			result = statement.executeQuery(query);
			while (result.next()) {
				nom = result.getString("nomPersonne");
				prenom = result.getString("prenomPersonne");
				int numeroAbonne = result.getInt("numeroAbonne");
				int numTelephone = result.getInt("numTelephone");
				Utilisateur a = new Utilisateur(nom, prenom, numeroAbonne , numTelephone);
				listEmprunteurRechercher.add(a);

			}
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listEmprunteurRechercher;
		
	}

	// Auteur
	public void addAuteur(Auteur auteur) {
		
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");

		String inputText = auteur.getDateNaissance();
		Date dateNaissance = null;
		try {
			dateNaissance = inputFormat.parse(inputText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dateAuteur = outputFormat.format(dateNaissance);
		
		System.out.println(dateAuteur);
		
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "insert into personne (nomPersonne,prenomPersonne) values ('" + auteur.getNom() + "','"
					+ auteur.getPrenom() + "')";
			String query2 = "insert into auteur (idPersonne,dateNaissanceAuteur) values ((select idPersonne from personne where nomPersonne = '"
					+ auteur.getNom() + "'), '" + dateAuteur + "')";
			statement.executeUpdate(query);
			statement.executeUpdate(query2);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifyAuteur(Auteur auteur) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "update biblioteque.auteur , biblioteque.personne set nomPersonne = '" + auteur.getNom()
					+ "', prenomPersonne = '" + auteur.getPrenom() + "' , dateNaissanceAuteur = "
					+ auteur.getDateNaissance()
					+ " where auteur.idPersonne = personne.idPersonne and personne.idPersonne = '"
					+ auteur.getIdAuteur() + "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void supAuteur(Auteur auteur) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "delete from biblioteque.auteur where dateNaissanceAuteur ='" + auteur.getDateNaissance()
					+ "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Auteur> afficherListeAuteur() {
		ArrayList<Auteur> listeAuteur = new ArrayList<Auteur>();
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			statement = connect.createStatement();
			String query = "SELECT * FROM auteur,personne where auteur.idPersonne = personne.Idpersonne";
			result = statement.executeQuery(query);
			while (result.next()) {
				String nom = result.getString("nomPersonne");
				String prenom = result.getString("prenomPersonne");
				String dateNaissance = result.getString("dateNaissanceAuteur");
				int idAuteur = result.getInt("idPersonne");
				Auteur a = new Auteur(nom, prenom, dateNaissance, idAuteur);
				listeAuteur.add(a);

			}
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeAuteur;

	}

	public void ModifyEmprunteur(Utilisateur emprunteur) {
		try {
			// Récupération de la connexion
			connect = DriverManager.getConnection(url, login, passwd);
			// Création du statement
			System.out.println(emprunteur);
			statement = connect.createStatement();
			String query = "update biblioteque.abonne , biblioteque.personne set nomPersonne = '" + emprunteur.getNom()
					+ "', prenomPersonne = '" + emprunteur.getPrenom() + "' , numTelephone = "
					+ emprunteur.getNumTelephone()
					+ " where abonne.idPersonne = personne.idPersonne and personne.idPersonne = '"
					+ emprunteur.getNumeroAbonne() + "'";
			statement.executeUpdate(query);
			statement.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

}
