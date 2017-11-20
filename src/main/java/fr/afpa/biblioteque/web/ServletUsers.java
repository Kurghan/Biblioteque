package fr.afpa.biblioteque.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.afpa.biblioteque.dao.Dao;
import fr.afpa.biblioteque.dao.IDao;
import fr.afpa.biblioteque.model.Utilisateur;
import fr.afpa.biblioteque.service.IService;
import fr.afpa.biblioteque.service.Service;

public class ServletUsers extends HttpServlet {

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
			if (path.equals("")) {

			} else if (path.equals("/displayListUsers")) {
				displayListUsers(req, resp);
			} else if (path.equals("/displayAddUser")) {
				displayAddUser(req, resp);
			} else if (path.equals("/validateAddUser")) {
				doAddUser(req, resp);
			} else if (path.equals("/deleteUser")) {
				doDeleteUser(req, resp);
			} else if (path.equals("/displayModifyUser")) {
				doModifyUser(req, resp);
			} else if (path.equals("/validateModifyUser")) {
				modifyUser(req, resp);
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void displayUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/utilisateurs.jsp").forward(req, resp);
	}

	private void displayListUsers(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<Utilisateur> usersList = service.afficherListeEmprunteur();
		req.setAttribute("users", usersList);
		displayUsers(req, resp);
	}

	private void displayAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/addUser.jsp").forward(req, resp);
	}

	private void doAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		int tel = Integer.valueOf(req.getParameter("numeroTelephone"));

		Utilisateur user = new Utilisateur(nom, prenom, 0, tel);
		System.out.println(user);
		service.addEmprunteur(user);
		;

		displayUsers(req, resp);

	}

	private void doDeleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("txtName") != "") {
			String nom = "";
			String prenom = "";
			int numeroAbonne = Integer.valueOf(req.getParameter("txtName"));

			Utilisateur user = new Utilisateur(nom, prenom, numeroAbonne, 0);
			// System.out.println(user);
			service.supEmprunteur(user);

			displayListUsers(req, resp);
		} else {
			displayListUsers(req, resp);
		}

	}

	private void doModifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int numeroAbonne = Integer.valueOf(req.getParameter("txtName1"));
		ArrayList<Utilisateur> usersList = service.afficherListeEmprunteur();
		Utilisateur x = null;
		// System.out.println(usersList);
		for (Utilisateur u : usersList) {
			if (u.getNumeroAbonne() == numeroAbonne) {
				System.out.println(u);
				x = u;
			}
		}
		req.setAttribute("user", x);

		getServletContext().getRequestDispatcher("/WEB-INF/views/modifyUser.jsp").forward(req, resp);
		// System.out.println(x);
	}
	
	private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		int tel = Integer.valueOf(req.getParameter("numeroTelephone"));
		int numeroAbonne = 0;
		ArrayList<Utilisateur> usersList = service.afficherListeEmprunteur();
		for (Utilisateur u : usersList) {
			if (u.getNumTelephone()==tel) {
				numeroAbonne = u.getNumeroAbonne();
			}
		}
		Utilisateur user = new Utilisateur(nom, prenom, numeroAbonne, tel);
		System.out.println(user);
		service.modifyEmprunteur(user);
		;

		displayUsers(req, resp);
		
	}

}
