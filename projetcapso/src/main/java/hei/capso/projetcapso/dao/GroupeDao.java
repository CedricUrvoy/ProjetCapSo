package hei.capso.projetcapso.dao ;

import hei.capso.projetcapso.model.Groupe;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupeDao {

	
	public List<Groupe> listerClasses() {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM groupe WHERE type_Groupe = 'classe'");

			while (results.next()) {
				Groupe classe = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getString("type_Groupe"));
				liste.add(classe);
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
	
	public List<Groupe> listerDomaines() {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM groupe WHERE type_Groupe = 'domaine'");

			while (results.next()) {
				Groupe domaine = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getString("type_Groupe"));
				liste.add(domaine);
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
	
	//LISTER GROUPE ELEVE
	public List<Groupe> listerGroupeEleve(Integer id) {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT groupe.id_Groupe, groupe.nom_Groupe, groupe.type_Groupe, eleve.id_Eleve FROM eleve INNER JOIN eleve_groupe ON eleve_groupe.Eleve_id_Eleve = eleve.id_Eleve INNER JOIN groupe ON groupe.id_Groupe = eleve_groupe.Groupe_id_Groupe WHERE id_Eleve =?");
			stmt.setInt(1,id);
			ResultSet results = stmt.executeQuery();
			
			while (results.next()) {
				Groupe domaine = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getString("type_Groupe"));
				liste.add(domaine);
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
}
