package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.ArticleManager;
import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Article;
import hei.capso.projetcapso.model.Seance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	
	
	private Date genererDate(int annee, int mois, int jour, int heure, int minute) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, annee);
		cal.set(Calendar.MONTH, mois);
		cal.set(Calendar.DAY_OF_MONTH, jour);
		cal.set(Calendar.HOUR_OF_DAY, heure);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		
		List<Seance> seances = SeanceManager.getInstance().listeSeancePersonnel(2);
		 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create(); 
		String calendrierJson = gson.toJson(seances);
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.write(calendrierJson);
		System.out.print(calendrierJson);

	}
}
