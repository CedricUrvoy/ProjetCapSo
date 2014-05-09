package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Eleve;

import java.io.IOException;




import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ElevesSeanceServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8486564529525204090L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		Integer idSeance = Integer.parseInt(req.getParameter("idSeance"));
		
		List<Eleve> listeElevesSeances = SeanceManager.getInstance().listeElevesSeance(idSeance);
		
		System.out.print(listeElevesSeances);
		
		req.setAttribute("eleves",listeElevesSeances);
	}
}
