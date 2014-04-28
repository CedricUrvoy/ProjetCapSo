package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.ArticleManager;
import hei.capso.projetcapso.model.Article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		Article article = ArticleManager.getInstance().getArticle(id);
		req.setAttribute("article", article);
		
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/article.jsp");
	view.forward(req, resp);
	}
}
