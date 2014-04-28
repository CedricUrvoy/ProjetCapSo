package hei.capso.projetcapso.model;

import java.util.Date;

public class Article {

		private Integer id;
		private String texte;
		private String titre;
		private String image;
		private Date date_Article;
		private Integer eleve;

		
		


		//CONSTRUCTEUR pour ajout
		public Article(Integer id_Article, String titre_Article, String text_Article, String image_Article, Integer eleve, Date date_Article) {
			super();
			this.id = id_Article;
			this.titre = titre_Article;
			this.texte = text_Article;
			this.image = image_Article;
			this.eleve=eleve;
			this.date_Article=date_Article;
		}

		//CONSTRUCTEUR pour liste
				public Article(Integer id_Article, String titre_Article, String text_Article, String image_Article, Date date_Article) {
					super();
					this.id = id_Article;
					this.titre = titre_Article;
					this.texte = text_Article;
					this.image = image_Article;
					this.date_Article = date_Article;
				}

				public Integer getId() {
					return id;
				}

				public void setId(Integer id) {
					this.id = id;
				}

				public String getTexte() {
					return texte;
				}

				public void setTexte(String texte) {
					this.texte = texte;
				}

				public String getTitre() {
					return titre;
				}

				public void setTitre(String titre) {
					this.titre = titre;
				}

				public String getImage() {
					return image;
				}

				public void setImage(String image) {
					this.image = image;
				}

				public Date getDate_Article() {
					return date_Article;
				}

				public void setDate_Article(Date date_Article) {
					this.date_Article = date_Article;
				}

				public Integer getEleve() {
					return eleve;
				}

				public void setEleve(Integer eleve) {
					this.eleve = eleve;
				}

				
				



		
		
		
}
