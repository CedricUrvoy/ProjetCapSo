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
		System.out.print("nom du groupe "+req.getParameter("classe"));
		System.out.print("claasee ? du group"+req.getParameter("groupearejoindre"));
		System.out.print(req.getParameter("groupearejoindre")=="Classe");
		if(req.getParameter("groupearejoindre")=="Classe"){
			String nom_groupe = req.getParameter("classe");
			System.out.print("nom du groupe "+req.getParameter("classe"));
			//Groupe groupe =GroupeManager.getInstance().chercherGroupeNom(nom_groupe);
			//System.out.print("marie"+groupe);
			//Integer id_Groupe = groupe.getId_Groupe();
			
			//GroupeManager.getInstance().quitterGroupe(id_Eleve, id_Groupe);
		}
		else if(req.getParameter("groupearejoindre")=="Domaine"){
			
		}
		else if(req.getParameter("groupearejoindre")=="Promo"){
			
		}
		else if(req.getParameter("groupearejoindre")=="Autre"){
	
		}
		
		//EleveManager.getInstance().rejoindreGroupe(id_Eleve, 1);
		
		response.sendRedirect("profil");
	}
}
