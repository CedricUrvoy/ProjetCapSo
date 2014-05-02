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

public class AjoutGroupeServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -146760442169637960L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN GROUPE
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		Integer id_Eleve = eleve.getId_Eleve();
		
		GroupeManager.getInstance().ajouterGroupe(
				new Groupe(null, 
						req.getParameter("nom_Groupe"),
						null));
		Integer id_groupe = GroupeManager.getInstance().listerGroupes().size();
		EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_groupe);
		
		response.sendRedirect("profil");
	}
}