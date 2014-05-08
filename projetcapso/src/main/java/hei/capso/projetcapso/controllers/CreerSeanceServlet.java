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


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date dateDebut = null;
		try {
			dateDebut = format.parse(req.getParameter("datetimepickerdebut"));
			System.out.print(dateDebut);
		} catch (ParseException e) {
			System.err.println("Problème au parsing de la date.");
		}
		Date dateFin = null;
		try {
			dateFin = format.parse(req.getParameter("datetimepickerfin"));
		} catch (ParseException e) {
			System.err.println("Problème au parsing de la date.");
		}
		
		int idSeance;
		
		idSeance = SeanceManager.getInstance().addSeance(
				new Seance(null, matiere.getNom_Matiere(),dateDebut,dateFin, req.getParameter("place"), req.getParameter("infosSeance"), groupe.getId_Groupe(), matiere.getId_Matiere()));
				
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		
		System.out.print(idSeance);
		
		EleveManager.getInstance().rejoindreSeance(eleve.getId_Eleve(), idSeance);
		
		response.sendRedirect("calendrier");
	}
}
