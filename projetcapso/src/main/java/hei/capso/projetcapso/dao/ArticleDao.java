package hei.capso.projetcapso.dao ;

import hei.capso.projetcapso.model.Article;


import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

	
	public List<Article> listerArticles() {
		List<Article> liste = new ArrayList<Article>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM article");

			while (results.next()) {
				Article article = new Article(
						results.getInt("id_Article"),
						results.getString("titre_Article"),
						results.getString("text_Article"),
						results.getString("image_Article"));
				liste.add(article);
			}

			// Fermer la connexion
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}
	
	//AJOUTER UN ARTICLE
	public void ajouterArticle(Article article) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			// Utiliser la connexion
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `article`(`titre_Article`,`text_Article`,`date_Article`) VALUES(?, ?, ?)");
			stmt.setString(1, article.getTitre());
			stmt.setString(2, article.getTexte());
			stmt.setDate(3, new Date(article.getDate().getTime()));
			stmt.executeUpdate();

			// Fermer la connexion
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
