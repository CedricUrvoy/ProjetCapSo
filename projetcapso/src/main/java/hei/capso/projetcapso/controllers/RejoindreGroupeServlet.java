package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Eleve;


import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;
import java.util.List;

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
			
			if(GroupeManager.getInstance().chercherClasseEleve(id_Eleve)==null)
			{
				id_Groupe = Integer.parseInt(req.getParameter("classe"));
				EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_Groupe);
			}
			else
				{
				System.out.print("vous appartez deja à un groupe classe !!!!");
				}
		}
		
		else if(req.getParameter("groupearejoindre").equals("Domaine")){
			
			if(GroupeManager.getInstance().chercherDomaineEleve(id_Eleve)==null)
			{
			id_Groupe = Integer.parseInt(req.getParameter("domaine"));
			EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_Groupe);
			}
			else
			{
				System.out.print("vous appartez deja à un groupe domaine !!!!");
			}
		}
		
		else if(req.getParameter("groupearejoindre").equals("Promo")){
			if(GroupeManager.getInstance().chercherPromoEleve(id_Eleve)==null)
			{
			id_Groupe = Integer.parseInt(req.getParameter("promo"));
			EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_Groupe);
			}
			else
			{
				System.out.print("vous appartez deja à un groupe domaine !!!!");
			}
		}
		
		else if(req.getParameter("groupearejoindre").equals("Autre")){
			String nom_Groupe = req.getParameter("autre");
			Groupe groupe = GroupeManager.getInstance().chercherGroupeNom(nom_Groupe);
			if (groupe==null)
			{System.out.print("LE nom n'existe pas");}
			else if(groupe.getType_Groupe().equals("Classe") || groupe.getType_Groupe().equals("Domaine") || groupe.getType_Groupe().equals("Promo"))
			{
				System.out.print("Vous ne pouvez pas rejoindre ce groupe ici");
			}
			else 
			{id_Groupe =groupe.getId_Groupe();
			EleveManager.getInstance().rejoindreGroupe(id_Eleve, id_Groupe);}
			
		}

		
		response.sendRedirect("profil");
	}
}