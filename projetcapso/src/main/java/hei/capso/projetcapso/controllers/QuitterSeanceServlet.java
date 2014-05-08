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
import javax.servlet.http.HttpSession;

public class QuitterSeanceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -642752157718046304L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	/*** Supprimer un élève de la seance ****/
		
	HttpSession session = req.getSession();	
	Eleve eleve = (Eleve) session.getAttribute("sessionEleve");	
	
	Integer idSeance = Integer.parseInt(req.getParameter("idSeance"));
		
	EleveManager.getInstance().quitterSeance(eleve.getId_Eleve(), idSeance);
	resp.sendRedirect("calendrier");
	}
}