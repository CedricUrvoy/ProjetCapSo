package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.ArticleDao;
import hei.capso.projetcapso.model.Article;

import java.util.List;

public class ArticleManager {

	private static ArticleManager instance;
	
	private ArticleDao articleDao;

	public static ArticleManager getInstance() {
		if(instance == null) 
		{
			instance = new ArticleManager();
		}
		return instance;
	}
	
	
	private ArticleManager() {

		articleDao = new ArticleDao();

	}

	//LISTER ARTICLE
	public List<Article> listerArticles() {
		List<Article> liste = articleDao.listerArticles();
		return liste;
	}
	
	//AJOUTER ARTICLE
	public void ajouterArticle(Article article) {
		articleDao.ajouterArticle(article);
	}
	

}