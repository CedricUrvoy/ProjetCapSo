package hei.capso.projetcapso.dao.impl;


import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.model.Eleve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EleveDaoImpl implements EleveDao{
	
	// FAIRE LA LISTE DES ELEVE
	
	public List<Eleve> listerIdEmailEleve() {

		List<Eleve> listeEmailEleve = new ArrayList<Eleve>();
		
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT id_Eleve, email_Eleve FROM Eleve ");
			ResultSet results = stmt.executeQuery();
			while (results.next()){
				Eleve eleve = new Eleve(
						results.getInt("id_Eleve"),
						results.getString("email_Eleve"));
				listeEmailEleve.add(eleve);
			}
			
			/**** Fermer la connexion ****/
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeEmailEleve	;
		
	}
	
	
	
	
	//AJOUTER ELEVE
		public void addEleve(Eleve eleve) {
			try {
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				// Utiliser la connexion
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `eleve`(`nom_Eleve`,`prenom_Eleve`,`image_Eleve`,`id_Classe`,`id_Domaine`) VALUES(?, ?, ?, ?, ?)");
				stmt.setString(1, eleve.getNom_Eleve());
				stmt.setString(2, eleve.getPrenom_Eleve());
				stmt.setString(3, eleve.getImage_Eleve());
				stmt.setInt(4, eleve.getId_Classe());
				stmt.setInt(5, eleve.getId_Eleve());

				stmt.executeUpdate();

				// Fermer la connexion
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		// Recuperation des infos de l'eleve sans les groupes 

		public Eleve getEleve(int idEleve) {
			
			Eleve eleve = null;
			
			try{
				/**** Creation de la connexion ****/
				
				Connection connection = DataSourceProvider.getDataSource().getConnection();
				
				/**** Utilisation de la connection ****/
				
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Eleve WHERE id_Eleve=?");
				stmt.setInt(1, idEleve);
				ResultSet results = stmt.executeQuery();
				if (results.next()){
					 eleve = new Eleve(
							results.getInt("id_Eleve"),
							results.getString("nom_Eleve"),
							results.getString("prenom_Eleve"),
							results.getString("image_Eleve"), 
							results.getString("email_Eleve"),
							results.getString("password_Eleve"));
				}
				
				/**** Fermer la connexion ****/
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return eleve;
		}


		public Eleve getEleveGroupe(int idEleve) {
			
			// TODO Auto-generated method stub
			return null;
		}

		public void modifEleve(int idEleve, Eleve eleve) {
			// TODO Auto-generated method stub
			
		}




		public void deleteEleve(int idEleve) {
			// TODO Auto-generated method stub
			
		}




		public List<Eleve> listerEleves() {
			// TODO Auto-generated method stub
			return null;
		}

		//AJOUTER ELEVE
				public  void rejoindreGroupe(int id_Eleve, int id_Groupe) {
					try {
						Connection connection = DataSourceProvider.getDataSource()
								.getConnection();

						// Utiliser la connexion
						PreparedStatement stmt = connection
								.prepareStatement("INSERT INTO `eleve_groupe`(`Eleve_id_Eleve`,`Groupe_id_Groupe`) VALUES(?, ?)");
						stmt.setInt(1, id_Eleve);
						stmt.setInt(2, id_Groupe);
						stmt.executeUpdate();

						// Fermer la connexion
						stmt.close();
						connection.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}



	

}
