package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;

import hei.capso.projetcapso.model.Eleve;


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
		
		
		
		EleveManager.getInstance().rejoindreGroupe(id_Eleve, 1);
		
		response.sendRedirect("profil");
	}
}
