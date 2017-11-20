package fr.afpa.biblioteque.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPages extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//private IService service;

	public void init() throws ServletException {
		//IDao dao = new Dao();
		//service = new Service(dao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		if (path != null) {
			if (path.equals("/accueil")) {
				displayAccueil(req, resp);
			} else if (path.equals("/auteurs")) {
				displayAuteurs(req, resp);
			} else if (path.equals("/recherche")) {
				displayRecherche(req, resp);
			} else if (path.equals("/livres")) {
				displayLivres(req, resp);
			} else if (path.equals("/utilisateurs")) {
				displayUtilisateurs(req, resp);
			}
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void displayAccueil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/accueil.jsp").forward(req, resp);
	}

	private void displayAuteurs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/auteurs.jsp").forward(req, resp);

	}

	private void displayRecherche(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/recherche.jsp").forward(req, resp);
	}

	private void displayLivres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/livres.jsp").forward(req, resp);
	}

	private void displayUtilisateurs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/utilisateurs.jsp").forward(req, resp);
	}



}
