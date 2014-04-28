package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutProfilServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Liste classes dans formulaire
				List<Groupe> groupes = GroupeManager.getInstance().listerClasses();
				req.setAttribute("groupes", groupes);
				
		// Liste domaines dans formulaire
				List<Groupe> domaines = GroupeManager.getInstance().listerDomaines();
				req.setAttribute("domaines", domaines);
				
		//AFFICHER LA PAGE
				RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/ajoutProfil.jsp");
				view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN ELEVE
		
	EleveManager.getInstance().addEleve(
			new Eleve(null, 
						request.getParameter("nom_Eleve"), 
				    	request.getParameter("prenom_Eleve"), 
						request.getParameter("image_Eleve"),
						request.getParameter("email_Eleve"),
						Integer.parseInt(request.getParameter("id_Classe")), 
						Integer.parseInt(request.getParameter("id_Domaine"))));
		
		response.sendRedirect("eleve");
	}
}
