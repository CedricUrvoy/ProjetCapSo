package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.manager.MatiereManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerMatiereServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680091819475909157L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//SUPPRIMER MATIERE
		Integer idMatiere = Integer.parseInt(req.getParameter("id"));
		
		MatiereManager.getInstance().supprimerMatiere(idMatiere);
		MatiereManager.getInstance().supprimerLienMatiereGroupe(idMatiere);
	
		
		resp.sendRedirect("gestionmatiere");
}
	
}
