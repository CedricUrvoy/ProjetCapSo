package hei.capso.projetcapso.model;

import java.util.Date;

public class Article {

		private Integer id_article;
		private String texte;
		private String titre;
		private String image;
		private Date date;
		private Integer eleve;

		
		


		//CONSTRUCTEUR pour ajout
		public Article(Integer id_Article, String titre_Article, String text_Article, String image_Article, Integer eleve, Date date_Article) {
			super();
			this.id_article = id_Article;
			this.titre = titre_Article;
			this.texte = text_Article;
			this.image = image_Article;
			this.eleve=eleve;
			this.date=date_Article;
		}

		//CONSTRUCTEUR pour liste
				public Article(Integer id_Article, String titre_Article, String text_Article, String image_Article) {
					super();
					this.id_article = id_Article;
					this.titre = titre_Article;
					this.texte = text_Article;
					this.image = image_Article;
				}

		public Integer getId_article() {
			return id_article;
		}


		public void setId_article(Integer id_article) {
			this.id_article = id_article;
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
		
		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public Integer getEleve() {
			return eleve;
		}


		public void setEleve(Integer eleve) {
			this.eleve = eleve;
		}
		


		
		
		
}
