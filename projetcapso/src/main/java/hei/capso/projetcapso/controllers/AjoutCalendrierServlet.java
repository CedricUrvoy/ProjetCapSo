package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.model.Eleve;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AjoutCalendrierServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -4248818399063295955L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN GROUPE
		
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		Integer id_Eleve = eleve.getId_Eleve();
		
		EleveManager.getInstance().ajoutCalendrier(id_Eleve, req.getParameter("liencalendrier"));
		
		response.sendRedirect("profil");
	}
}