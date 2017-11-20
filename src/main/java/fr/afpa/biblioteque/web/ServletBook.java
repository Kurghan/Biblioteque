package fr.afpa.biblioteque.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.biblioteque.dao.Dao;
import fr.afpa.biblioteque.dao.IDao;
import fr.afpa.biblioteque.model.Livre;
import fr.afpa.biblioteque.service.IService;
import fr.afpa.biblioteque.service.Service;

public class ServletBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IService service;

	public void init() throws ServletException {
		IDao dao = new Dao();
		service = new Service(dao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		if (path != null) {
			if (path.equals("/displayListBook")) {
				displayList(req, resp);
			} else if (path.equals("/deleteBook")) {
				doDeleteBook(req, resp);
			} else if(path.equals("/addBook2")) {
				displayAddBook(req,resp);
			} else if (path.equals("/validateAddBook")) {
				doAddBook(req,resp);
			} else if(path.equals("/modifyBook")) {
				displayModifyBook(req,resp);
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void displayList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Livre> bookList = service.afficherListeLivre();
		req.setAttribute("Livres", bookList);

		displayLivres(req, resp);
	}

	private void doDeleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int ISBN = Integer.valueOf(req.getParameter("txtId"));
		String titre = "";
		String sousTitre = "";
		String auteur = "";

		ArrayList<Livre> getlivre = service.rechercherLivre(ISBN, titre, sousTitre, auteur);

		Livre livre = getlivre.get(0);

		service.supLivre(livre);

		displayList(req, resp);
	}
	
	private void displayLivres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/livres.jsp").forward(req, resp);
	}
	
	private void displayAddBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/addBook.jsp").forward(req, resp);
	}
	
	private void doAddBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		displayLivres(req, resp);
		int ISBN = Integer.valueOf(req.getParameter("ISBN"));
		String titre = req.getParameter("titre");
		String sousTitre = req.getParameter("sousTitre");
		String auteurFull = req.getParameter("Auteur");
		String auteur = null;
		String[] splitArray = null;
		splitArray = auteurFull.split(" ");
		for(int i = 0; i< splitArray.length;i++){
			auteur = splitArray[i];
		}
		//String nbExemplaires = req.getParameter("nbExemplaires");
		
		Livre livre = new Livre(titre, sousTitre, auteur, ISBN);
		
		service.addLivre(livre);
		
		//System.out.println(auteur);
	}
	
	private void displayModifyBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/modifyBook.jsp").forward(req, resp);
	}

}
