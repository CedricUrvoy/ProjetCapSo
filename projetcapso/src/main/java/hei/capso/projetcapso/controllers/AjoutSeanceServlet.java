package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.GroupeManager;
import hei.capso.projetcapso.manager.MatiereManager;
import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutSeanceServlet extends HttpServlet{

	/**
	 * 
	 */
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Liste matiere dans formulaire
		List<Matiere> matieres = MatiereManager.getInstance().listerMatiere();
		req.setAttribute("matieres", matieres);
		
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/ajoutSeance.jsp");
	view.forward(req, resp);
	}
}
