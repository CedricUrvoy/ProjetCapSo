package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.ArticleDao;
import hei.capso.projetcapso.model.Article;

import java.util.List;

public class Manager {

	private static Manager instance;
	
	private ArticleDao articleDao;

	public static Manager getInstance() {
		if(instance == null) 
		{
			instance = new Manager();
		}
		return instance;
	}
	
	
	private Manager() {

		articleDao = new ArticleDao();

	}


	public List<Article> listerArticles() {
		List<Article> liste = articleDao.listerArticles();
		return liste;
	}
	

}