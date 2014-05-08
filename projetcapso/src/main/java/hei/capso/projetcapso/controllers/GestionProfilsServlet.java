package hei.capso.projetcapso.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionProfilsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4958039801632454751L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/gestionProfils.jsp");
	view.forward(req, resp);
	}
}
