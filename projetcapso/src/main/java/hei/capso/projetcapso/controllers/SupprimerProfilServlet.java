package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.manager.EleveManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerProfilServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916053796230177686L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//SUPPRIMER UN PROFIL
		Integer idEleve = Integer.parseInt(req.getParameter("id"));
		EleveManager.getInstance().SupprimerGroupeEleve(idEleve);
		EleveManager.getInstance().SupprimerSeanceEleve(idEleve);
		EleveManager.getInstance().SupprimerProfil(idEleve);
		
		resp.sendRedirect("gestionprofils");
	}
}
