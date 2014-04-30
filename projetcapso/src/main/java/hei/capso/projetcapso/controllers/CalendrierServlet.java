package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.manager.MatiereManager;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalendrierServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	HttpSession session = req.getSession();	
		
	// CREATION DE L'ELEVE EN SESSION
	
	Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
	req.setAttribute("eleve",eleve);
	
	//LISTER LES GROUPES DE L'ELEVE
	Integer id_Eleve = eleve.getId_Eleve();
	List<Groupe> groupes = GroupeManager.getInstance().listerGroupeEleve(id_Eleve);
	req.setAttribute("groupes", groupes);
		
	//LISTER LES MATIERES
	List<Matiere> matieres = MatiereManager.getInstance().listerMatiere();
	req.setAttribute("matieres", matieres);
		
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/calendrier.jsp");
	view.forward(req, resp);
	}
}
