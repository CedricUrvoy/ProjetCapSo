package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Eleve;


import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RejoindreGroupeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2684573526927291509L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//REJOINDRE UN GROUPE
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		Integer id_Eleve = eleve.getId_Eleve();
		
		Integer id_Groupe = null;
		if(req.getParameter("groupearejoindre").equals("Classe")){
			id_Groupe = Integer.parseInt(req.getParameter("classe"));
		}
		else if(req.getParameter("groupearejoindre").equals("Domaine")){
			id_Groupe = Integer.parseInt(req.getParameter("domaine"));
		}
		else if(req.getParameter("groupearejoindre").equals("Promo")){
			id_Groupe = Integer.parseInt(req.getParameter("promo"));
		}
		else if(req.getParameter("groupearejoindre").equals("Autre")){
			id_Groupe = Integer.parseInt(req.getParameter("autre"));
		}
		
		EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_Groupe);
		
		response.sendRedirect("profil");
	}
}
