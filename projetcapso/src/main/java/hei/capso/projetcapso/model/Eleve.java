package hei.capso.projetcapso.model;

import java.util.Date;

public class Eleve {

		private Integer id_Eleve;
		private String nom_Eleve;
		private String prenom_Eleve;
		private String image_Eleve;
		private String email_Eleve;
		private String password_eleve;
		private Date date;
		private Integer id_Classe;
		private Integer id_Domaine;
		



		//CONSTRUCTEUR
		/*public Eleve(Integer id_Eleve, String nom_Eleve, String prenom_Eleve, String image_Eleve, String email_Eleve, Integer id_Classe, Integer id_Domaine) {
			this.id_Eleve = id_Eleve;
			this.nom_Eleve = nom_Eleve;
			this.prenom_Eleve = prenom_Eleve;
			this.image_Eleve = image_Eleve;
			this.email_Eleve = email_Eleve;
			this.id_Classe = id_Classe;
			this.id_Domaine = id_Domaine;
		}*/
		
		public Eleve() {
			// TODO Auto-generated constructor stub
		}
		
		public Eleve(Integer id_Eleve, String email_Eleve) {
			this.id_Eleve = id_Eleve;
			this.email_Eleve = email_Eleve;
		}
		
		

		public Eleve(Integer id_Eleve, String nom_Eleve, String prenom_Eleve,
						String image_Eleve, String email_Eleve, String password_eleve) {
					this.id_Eleve = id_Eleve;
					this.nom_Eleve = nom_Eleve;
					this.prenom_Eleve = prenom_Eleve;
					this.image_Eleve = image_Eleve;
					this.email_Eleve = email_Eleve;
					this.password_eleve = password_eleve;
				}

// GETTER & SETTER

		public Integer getId_Eleve() {
			return id_Eleve;
		}





		public void setId_Eleve(Integer id_Eleve) {
			this.id_Eleve = id_Eleve;
		}





		public String getNom_Eleve() {
			return nom_Eleve;
		}





		public void setNom_Eleve(String nom_Eleve) {
			this.nom_Eleve = nom_Eleve;
		}





		public String getPrenom_Eleve() {
			return prenom_Eleve;
		}





		public void setPrenom_Eleve(String prenom_Eleve) {
			this.prenom_Eleve = prenom_Eleve;
		}





		public String getImage_Eleve() {
			return image_Eleve;
		}





		public void setImage_Eleve(String image_Eleve) {
			this.image_Eleve = image_Eleve;
		}





		public String getEmail_Eleve() {
			return email_Eleve;
		}





		public void setEmail_Eleve(String email_Eleve) {
			this.email_Eleve = email_Eleve;
		}





		public String getPassword_eleve() {
			return password_eleve;
		}





		public void setPassword_eleve(String password_eleve) {
			this.password_eleve = password_eleve;
		}





		public Date getDate() {
			return date;
		}





		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getId_Classe() {
			return id_Classe;
		}

		public void setId_Classe(Integer id_Classe) {
			this.id_Classe = id_Classe;
		}

		public Integer getId_Domaine() {
			return id_Domaine;
		}

		public void setId_Domaine(Integer id_Domaine) {
			this.id_Domaine = id_Domaine;
		}
		


		
		
		
}
