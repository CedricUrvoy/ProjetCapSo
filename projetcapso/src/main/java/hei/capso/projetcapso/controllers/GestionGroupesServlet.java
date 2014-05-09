package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionGroupesServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2229557011969613842L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Liste de tous les groupes de types "groupe"
		List<Groupe> groupes = GroupeManager.getInstance().listerGroupeType("Groupe");
		req.setAttribute("groupes", groupes);
		
		//Compter le nombre de membre par groupe
		
		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/gestionGroupes.jsp");
	view.forward(req, resp);
	}
}
