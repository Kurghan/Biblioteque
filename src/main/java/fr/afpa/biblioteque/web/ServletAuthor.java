package fr.afpa.biblioteque.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.afpa.biblioteque.dao.Dao;
import fr.afpa.biblioteque.dao.IDao;
import fr.afpa.biblioteque.model.Auteur;
import fr.afpa.biblioteque.service.IService;
import fr.afpa.biblioteque.service.Service;

public class ServletAuthor extends HttpServlet {

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
			if (path.equals("/displayListAuthor")) {
				displayList(req, resp);
			} else if (path.equals("/addAuthor")) {
				displayAddAuthor(req, resp);
			} else if (path.equals("/validateAddAuthor")) {
				doAddAuthor(req, resp);
			} else if (path.equals("/deleteAuthor")) {
				doDeleteAuthor(req, resp);
			} else if(path.equals("/addBook")) {
				displayChooseAuthor(req, resp);}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void displayList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Auteur> authorList = service.afficherListeAuteur();
		req.setAttribute("authors", authorList);
		displayAuthors(req, resp);
	}

	private void displayAuthors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/auteurs.jsp").forward(req, resp);
	}

	private void displayAddAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/addAuthor.jsp").forward(req, resp);
	}

	private void doAddAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String date = req.getParameter("dateNaissance");

		Auteur auteur = new Auteur(nom, prenom, date, 0);

		service.AddAuteur(auteur);

		displayList(req, resp);

	}

	private void doDeleteAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nom = req.getParameter("txtName");
		for (Auteur a : service.afficherListeAuteur()) {
			if (a.getNom().equals(nom)) {
				service.supAuteur(a);
			}
		}
		displayList(req, resp);
	}

	public void displayChooseAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<Auteur> authorList = service.afficherListeAuteur();
		req.setAttribute("authors", authorList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/addBook.jsp").forward(req, resp);
	}

}
