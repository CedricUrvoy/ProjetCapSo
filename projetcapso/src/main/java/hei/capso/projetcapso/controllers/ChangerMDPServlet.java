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

public class ChangerMDPServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555107682751423088L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//CHANGER DE MOT DE PASSE
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		Integer id_Eleve = eleve.getId_Eleve();
		String ancienmdp = eleve.getPassword_eleve();
		System.out.print("caca"+req.getParameter("nouveaumdp"));
		if (ancienmdp.equals(req.getParameter("ancienmdp")))
		{
			
			EleveManager.getInstance().changerMDP(id_Eleve, req.getParameter("nouveaumdp") );
		}

		response.sendRedirect("profil");
	}
}
