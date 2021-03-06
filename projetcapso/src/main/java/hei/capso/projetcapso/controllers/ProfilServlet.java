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
				List<Groupe> groupes = GroupeManager.getInstance().listerGroupeEleve(id_Eleve);
				req.setAttribute("groupes", groupes);
			
				
		// LISTE DES CLASSES DANS FORMULIARE
				List<Groupe> classe = GroupeManager.getInstance().listerGroupeType("Classe");
				req.setAttribute("classes", classe);
				
		// LISTE DES DOMAINES DANS FORMULAIRE
				List<Groupe> domaines = GroupeManager.getInstance().listerGroupeType("Domaine");
				req.setAttribute("domaines", domaines);
				
		// LISTE DES PROMOS DANS FORMULAIRE
				List<Groupe> promo = GroupeManager.getInstance().listerGroupeType("Promo");
				req.setAttribute("promos", promo);
				
		// CLASSE DE L'ELEVE
				Groupe classeEleve = GroupeManager.getInstance().chercherTypeEleve(id_Eleve, "Classe");
				req.setAttribute("classeEleve", classeEleve);

		// DOMAINE DE L'ELEVE
				Groupe domaineEleve = GroupeManager.getInstance().chercherTypeEleve(id_Eleve, "Domaine");
				req.setAttribute("domaineEleve", domaineEleve);
				
		// PROMO DE L'ELEVE
				Groupe promoEleve = GroupeManager.getInstance().chercherTypeEleve(id_Eleve, "Promo");
				req.setAttribute("promoEleve", promoEleve);
				
		//LISTER LES GROUPES DE TYPE GROUPE DE L'ELEVE
				List<Groupe> groupesEleve = GroupeManager.getInstance().listertypeGroupeEleve(id_Eleve);
				req.setAttribute("groupesEleve", groupesEleve);
				
	//AFFICHE LA PAGE
	RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/pages/utilisateur/profil.jsp");
	view.forward(req, resp);

	}
	
	

}



