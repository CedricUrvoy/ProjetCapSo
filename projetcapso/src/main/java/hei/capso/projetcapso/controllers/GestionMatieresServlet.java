package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.manager.MatiereManager;
import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionMatieresServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468894855243427147L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// LISTES DES DOMAINES DANS FORMULAIRE
		List<Groupe> domaines = GroupeManager.getInstance().listerGroupeType("Domaine");
		req.setAttribute("domaines", domaines);
		
		// LISTES DES PROMOS DANS FORMULAIRE
		List<Groupe> promo = GroupeManager.getInstance().listerGroupeType("Promo");
		req.setAttribute("promos", promo);	
		
		//LISTE DES MATIERES
		List<Matiere> matiere = MatiereManager.getInstance().listertoutesMatiere();
		req.setAttribute("matieres", matiere);
		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/pages/admin/gestionMatieres.jsp");
	view.forward(req, resp);
	}

}
