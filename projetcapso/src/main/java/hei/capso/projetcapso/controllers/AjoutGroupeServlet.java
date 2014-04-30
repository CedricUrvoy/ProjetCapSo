package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutGroupeServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN GROUPE
		
		GroupeManager.getInstance().ajouterGroupe(
				new Groupe(null, 
						request.getParameter("nom_Groupe"),
						null));
		
		response.sendRedirect("groupe");
	}
}
