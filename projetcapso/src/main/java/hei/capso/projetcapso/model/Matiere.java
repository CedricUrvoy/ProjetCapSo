package hei.capso.projetcapso.model;



public class Matiere {

		private Integer id_Matiere;
		private String nom_Matiere;


		//CONSTRUCTEUR
		public Matiere(Integer id_Matiere, String nom_Matiere) {
			this.id_Matiere = id_Matiere;
			this.nom_Matiere = nom_Matiere;

		}


		public Integer getId_Matiere() {
			return id_Matiere;
		}


		public void setId_Matiere(Integer id_Matiere) {
			this.id_Matiere = id_Matiere;
		}


		public String getNom_Matiere() {
			return nom_Matiere;
		}


		public void setNom_Matiere(String nom_Matiere) {
			this.nom_Matiere = nom_Matiere;
		}


		

}
