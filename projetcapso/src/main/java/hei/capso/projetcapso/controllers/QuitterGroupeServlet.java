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

public class QuitterGroupeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4680923727960935228L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//QUITTER UN GROUPE
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		Integer id_Eleve = eleve.getId_Eleve();
		//String nom_groupe = req.getParameter("groupeQuitter");
		System.out.print("marie nom"+req.getParameter("quitterGroupe"));
		Groupe groupe =GroupeManager.getInstance().chercherGroupeNom("filou");
		System.out.print("marie"+groupe);
		Integer id_Groupe = groupe.getId_Groupe();
		
		GroupeManager.getInstance().quitterGroupe(id_Eleve, id_Groupe);
		
		response.sendRedirect("profil");
	}
	
}
