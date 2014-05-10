package hei.capso.projetcapso.dao.impl;

import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.MatiereDao;
import hei.capso.projetcapso.model.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatiereDaoImpl implements MatiereDao {

	//LISTER LES MATIERES D'UNE PROMO ET D'UN DOMAINE
	public List<Matiere> listerMatiere(String nom_Promo,String nom_Domaine) {
		List<Matiere> liste = new ArrayList<Matiere>();
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection.prepareStatement("SELECT matiere.nom_Matiere, matiere.id_Matiere, groupe_matiere.Groupe_id_Groupe, groupe_matiere.Matiere_id_Matiere, groupe.nom_Groupe, groupe.id_Groupe FROM groupe INNER JOIN groupe_matiere ON groupe_matiere.Groupe_id_Groupe = groupe.id_Groupe INNER JOIN matiere ON matiere.id_Matiere = groupe_matiere.Matiere_id_Matiere WHERE groupe.nom_Groupe = ? OR groupe.nom_Groupe =?");
			stmt.setString(1,nom_Promo);
			stmt.setString(2,nom_Domaine);
			ResultSet results = stmt.executeQuery();
			
			while (results.next()) {
				Matiere matiere = new Matiere(
						results.getInt("id_Matiere"),
						results.getString("nom_Matiere"));
				liste.add(matiere);
			}

			/**** Fermer la connexion ****/
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}
	
	
	//RECHERCHER UNE MATIERE AVEC SON NOM
	public Matiere chercherMatiereNom(String nom_Matiere) {
		Matiere matiere = null;
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection.prepareStatement("SELECT nom_Matiere, id_Matiere FROM matiere WHERE nom_Matiere=?");
			stmt.setString(1,nom_Matiere);
			ResultSet results = stmt.executeQuery();
			
			if(results.next()){
				matiere = new Matiere(
						results.getInt("id_Matiere"),
						results.getString("nom_Matiere"));
				
			}

			/**** Fermer la connexion ****/
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return matiere;
	}
	
	
	//AJOUTER UNE MATIERE
	public void ajouterMatiere(Matiere matiere) {
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `matiere`(`nom_Matiere`) VALUES(?)");
			stmt.setString(1, matiere.getNom_Matiere());
			stmt.executeUpdate();

			/**** Fermer la connexion ****/
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// LIER MATIERE ET GROUPE
	public  void matiereGroupe(int id_Matiere, int id_Groupe) {
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `groupe_matiere`(`Groupe_id_Groupe`,`Matiere_id_Matiere`) VALUES(?, ?)");
			stmt.setInt(1, id_Groupe);
			stmt.setInt(2, id_Matiere);
			stmt.executeUpdate();

			/**** Fermer la connexion ****/
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
