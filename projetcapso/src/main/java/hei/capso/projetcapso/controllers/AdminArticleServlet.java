package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.ArticleManager;
import hei.capso.projetcapso.model.Article;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminArticleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	
		
		
		
	// AFFICHE LA PAGE	
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/adminArticle.jsp");
	view.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN ARTICLE
		Date date =new Date();
		ArticleManager.getInstance().ajouterArticle(
				new Article(null, 
						request.getParameter("titre_Article"), 
						request.getParameter("text_Article"), 
						null,
						null,
						date));
		
		response.sendRedirect("article");
	}

}
