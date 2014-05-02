package hei.capso.projetcapso.controllers;



import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.manager.MatiereManager;
import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;
import hei.capso.projetcapso.model.Seance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreerSeanceServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8813581600125656088L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		Groupe groupe = GroupeManager.getInstance().chercherGroupeNom(req.getParameter("groupe"));
		Matiere matiere = MatiereManager.getInstance().chercherMatiereNom(req.getParameter("matiere"));
		
		SeanceManager.getInstance().addSeance(
				new Seance(null, matiere.getNom_Matiere(), null, null, req.getParameter("place"), req.getParameter("infosSeance"), groupe.getId_Groupe(), matiere.getId_Matiere()));
				
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		
		EleveManager.getInstance().rejoindreSeance(eleve.getId_Eleve(), 10);
		
		response.sendRedirect("calendrier");
	}
}
