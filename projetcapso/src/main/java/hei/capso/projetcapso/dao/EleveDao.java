package hei.capso.projetcapso.dao;


import hei.capso.projetcapso.model.Eleve;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;



public class EleveDao {
	
	//AJOUTER ELEVE
		public void ajouterEleve(Eleve eleve) {
			try {
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				// Utiliser la connexion
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `eleve`(`nom_Eleve`,`prenom_Eleve`,`image_Eleve`) VALUES(?, ?, ?)");
				stmt.setString(1, eleve.getNom_Eleve());
				stmt.setString(2, eleve.getPrenom_Eleve());
				stmt.setString(3, eleve.getImage_Eleve());

				stmt.executeUpdate();

				// Fermer la connexion
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
