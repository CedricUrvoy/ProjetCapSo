package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Seance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CalendrierPersoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Integer idGroupe = Integer.parseInt(req.getParameter("idGroupe"));
		List<Seance> seances = null ;
		System.out.print(idGroupe);
		
		if (idGroupe==0){
			seances = SeanceManager.getInstance().listeSeancePersonnel(1);
		}else{
			seances = SeanceManager.getInstance().listeSeanceGroupe(idGroupe);
		}
		 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create(); 
		String calendrierJson = gson.toJson(seances);
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.write(calendrierJson);
		System.out.print(calendrierJson);

	}
}
