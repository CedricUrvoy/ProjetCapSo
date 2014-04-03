package hei.capso.projetcapso.model;



public class Groupe {

		private Integer id_Groupe;
		private String nom_Groupe;
		private String type_Groupe;


		//CONSTRUCTEUR
		public Groupe(Integer id_Groupe, String nom_Groupe, String type_Groupe) {
			super();
			this.id_Groupe = id_Groupe;
			this.nom_Groupe = nom_Groupe;
			this.type_Groupe = type_Groupe;
		}


		public Integer getId_Groupe() {
			return id_Groupe;
		}


		public void setId_Groupe(Integer id_Groupe) {
			this.id_Groupe = id_Groupe;
		}


		public String getNom_Groupe() {
			return nom_Groupe;
		}


		public void setNom_Groupe(String nom_Groupe) {
			this.nom_Groupe = nom_Groupe;
		}


		public String getType_Groupe() {
			return type_Groupe;
		}


		public void setType_Groupe(String type_Groupe) {
			this.type_Groupe = type_Groupe;
		}

}
