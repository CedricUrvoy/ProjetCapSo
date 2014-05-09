package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.GroupeManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerGroupeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 422559256709149869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//SUPPRIMER UN GROUPE
		Integer idGroupe = Integer.parseInt(req.getParameter("id"));
		
		GroupeManager.getInstance().supprimerlienGroupe(idGroupe);
		GroupeManager.getInstance().supprimerGroupe(idGroupe);
		
		resp.sendRedirect("gestiongroupes");
	}
}
