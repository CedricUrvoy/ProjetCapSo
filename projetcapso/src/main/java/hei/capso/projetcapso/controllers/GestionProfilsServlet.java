package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionProfilsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4958039801632454751L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//LISTE DES PROFILS
		List<Eleve> eleves = EleveManager.getInstance().listerEleve();
		req.setAttribute("eleves", eleves);
		
		// AFFICHE LA PAGE	
		RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/gestionProfils.jsp");
		view.forward(req, resp);
	}
}
