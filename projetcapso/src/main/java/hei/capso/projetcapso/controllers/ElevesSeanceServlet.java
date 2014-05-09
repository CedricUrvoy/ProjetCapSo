package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Eleve;

import java.io.IOException;




import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ElevesSeanceServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8486564529525204090L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		
		Integer idSeance = Integer.parseInt(req.getParameter("idSeance"));
		
		List<Eleve> listeElevesSeance = SeanceManager.getInstance().listeElevesSeance(idSeance);

		
		Gson gson = new Gson(); 
		String elevesJson = gson.toJson(listeElevesSeance);
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.write(elevesJson);
		System.out.print(elevesJson);
	}
}
