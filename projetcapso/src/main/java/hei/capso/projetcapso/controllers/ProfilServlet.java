package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.model.Eleve;

import java.io.IOException;

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
		
	//AFFICHE LA PAGE
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/profil.jsp");
	view.forward(req, resp);
	
	//RECUPERE ELEVE CONNECTE
	
	
	}
}
