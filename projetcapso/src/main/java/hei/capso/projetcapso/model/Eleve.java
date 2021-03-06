package hei.capso.projetcapso.model;

import java.util.Date;

public class Eleve {

		private Integer id_Eleve;
		private String nom_Eleve;
		private String prenom_Eleve;
		private String calendrier_Eleve;
		private String email_Eleve;
		private String password_eleve;
		private Date derniereConnexion_Eleve;
		

		public Eleve() {
			
		}
		
		public Eleve(Integer id_Eleve, String nom_Eleve, String prenom_Eleve) {
			this.id_Eleve = id_Eleve;
			this.nom_Eleve = nom_Eleve;
			this.prenom_Eleve = prenom_Eleve;
		}
		
		public Eleve(Integer id_Eleve, String nom_Eleve, String prenom_Eleve, Date derniereConnexion_Eleve) {
			this.id_Eleve = id_Eleve;
			this.nom_Eleve = nom_Eleve;
			this.prenom_Eleve = prenom_Eleve;
			this.derniereConnexion_Eleve = derniereConnexion_Eleve;
			
		}
		
		public Eleve(Integer id_Eleve, String email_Eleve) {
			this.id_Eleve = id_Eleve;
			this.email_Eleve = email_Eleve;
		}
		

		public Eleve( String password_eleve, Integer id_Eleve) {
			this.id_Eleve = id_Eleve;
			this.password_eleve = password_eleve;
		}
		
		

		public Eleve(Integer id_Eleve, String nom_Eleve, String prenom_Eleve,
						String calendrier_Eleve, String email_Eleve, String password_eleve) {
					this.id_Eleve = id_Eleve;
					this.nom_Eleve = nom_Eleve;
					this.prenom_Eleve = prenom_Eleve;
					this.calendrier_Eleve = calendrier_Eleve;
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


		public String getCalendrier_Eleve() {
			return calendrier_Eleve;
		}


		public void setCalendrier_Eleve(String calendrier_Eleve) {
			this.calendrier_Eleve = calendrier_Eleve;
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

		public Date getDerniereConnexion_Eleve() {
			return derniereConnexion_Eleve;
		}

		public void setDerniereConnexion_Eleve(Date derniereConnexion_Eleve) {
			this.derniereConnexion_Eleve = derniereConnexion_Eleve;
		}



		


		
		
		
}
