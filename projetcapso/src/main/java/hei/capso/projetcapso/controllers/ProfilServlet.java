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

public class ProfilServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		
		
		//LISTER LES GROUPES DE L'ELEVE
				Integer id_Eleve = eleve.getId_Eleve();
				List<Groupe> groupe = GroupeManager.getInstance().listerGroupeEleve(id_Eleve);
				
				req.setAttribute("groupes", groupe);
			
				
		// Liste classes dans formulaire
				List<Groupe> classe = GroupeManager.getInstance().listerClasses();
				req.setAttribute("classes", classe);
				
		// Liste domaines dans formulaire
				List<Groupe> domaines = GroupeManager.getInstance().listerDomaines();
				req.setAttribute("domaines", domaines);
				
		// Liste classes dans formulaire
				List<Groupe> promo = GroupeManager.getInstance().listerPromos();
				req.setAttribute("promos", promo);
		
		//  classe de l'eleve 
				Groupe classeEleve = GroupeManager.getInstance().chercherGroupeTypeEleve(id_Eleve, "Classe").get(0);
				req.setAttribute("classeEleve", classeEleve);
				
		//  domaine de l'eleve 
				Groupe domaineEleve = GroupeManager.getInstance().chercherGroupeTypeEleve(id_Eleve, "Domaine").get(0);
				req.setAttribute("domaineEleve", domaineEleve);
				
		//  domaine de l'eleve 
				Groupe promoEleve = GroupeManager.getInstance().chercherGroupeTypeEleve(id_Eleve, "Promo").get(0);
				req.setAttribute("promoEleve", promoEleve);
				
		//  groupe de l'eleve 
				List<Groupe> groupeEleve = GroupeManager.getInstance().chercherGroupeTypeEleve(id_Eleve, "Groupe");
				
				req.setAttribute("groupesEleve", groupeEleve);

	//AFFICHE LA PAGE
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/profil.jsp");
	view.forward(req, resp);

	}
	
	

}



