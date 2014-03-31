package hei.capso.projetcapso.controllers;


import hei.capso.projetcapso.manager.Manager;
import hei.capso.projetcapso.model.Article;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800409617440767322L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Article> articles = Manager.getInstance().listerArticles();
		req.setAttribute("articles", articles);
		
	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/blog.jsp");
	view.forward(req, resp);
	}
}
