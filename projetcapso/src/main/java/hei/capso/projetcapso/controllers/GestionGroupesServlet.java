package hei.capso.projetcapso.controllers;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionGroupesServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2229557011969613842L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/gestionGroupes.jsp");
	view.forward(req, resp);
	}
}
