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

public class PageAdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468894855243427147L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Liste domaines dans formulaire
		List<Groupe> domaines = GroupeManager.getInstance().listerGroupeType("Domaine");
		req.setAttribute("domaines", domaines);
		
		// Liste promos dans formulaire
		List<Groupe> promo = GroupeManager.getInstance().listerGroupeType("Promo");
		req.setAttribute("promos", promo);	
		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/pageAdmin.jsp");
	view.forward(req, resp);
	}

}
