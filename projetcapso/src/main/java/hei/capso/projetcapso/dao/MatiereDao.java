package hei.capso.projetcapso.dao ;



import hei.capso.projetcapso.model.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatiereDao {

	
	public List<Matiere> listerMatiere() {
		List<Matiere> liste = new ArrayList<Matiere>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM matiere ");

			while (results.next()) {
				Matiere matiere = new Matiere(
						results.getInt("id_Matiere"),
						results.getString("nom_Matiere"));
				liste.add(matiere);
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
	
	public Matiere chercherMatiereNom(String nom_Matiere) {
		Matiere matiere = null;
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT nom_Matiere, id_Matiere FROM matiere WHERE nom_Matiere=?");
			stmt.setString(1,nom_Matiere);
			ResultSet results = stmt.executeQuery();
			
			if(results.next()){
				matiere = new Matiere(
						results.getInt("id_Matiere"),
						results.getString("nom_Matiere"));
				
			}

			// Fermer la connexion
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return matiere;
	}
}
