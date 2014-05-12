package hei.capso.projetcapso.dao.impl;

import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.MatiereDao;
import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatiereDaoImpl implements MatiereDao {

	//LISTER LES MATIERES D'UNE PROMO ET D'UN DOMAINE
	public List<Matiere> listerMatiere(String nomPromo,String nomDomaine) {
		List<Matiere> liste = new ArrayList<Matiere>();
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection.prepareStatement("SELECT matiere.nom_Matiere, matiere.id_Matiere, groupe_matiere.Groupe_id_Groupe, groupe_matiere.Matiere_id_Matiere, groupe.nom_Groupe, groupe.id_Groupe FROM groupe INNER JOIN groupe_matiere ON groupe_matiere.Groupe_id_Groupe = groupe.id_Groupe INNER JOIN matiere ON matiere.id_Matiere = groupe_matiere.Matiere_id_Matiere WHERE groupe.nom_Groupe = ? OR groupe.nom_Groupe =?");
			stmt.setString(1,nomPromo);
			stmt.setString(2,nomDomaine);
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
	public Matiere chercherMatiereNom(String nomMatiere) {
		Matiere matiere = null;
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection.prepareStatement("SELECT nom_Matiere, id_Matiere FROM matiere WHERE nom_Matiere=?");
			stmt.setString(1,nomMatiere);
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
	public  void matiereGroupe(int idMatiere, int idGroupe) {
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `groupe_matiere`(`Groupe_id_Groupe`,`Matiere_id_Matiere`) VALUES(?, ?)");
			stmt.setInt(1, idGroupe);
			stmt.setInt(2, idMatiere);
			stmt.executeUpdate();

			/**** Fermer la connexion ****/
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Matiere> listerToutesMatieres() {
			
		List<Matiere> liste = new ArrayList<Matiere>();
			try {
				/**** Creation de la connexion ****/
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				/**** Utilisation de la connection ****/
				Statement stmt = connection.createStatement();
				ResultSet results = stmt.executeQuery("SELECT * FROM matiere");

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


	@Override
	public void supprimerMatiere(Integer idMatiere) {
			try {
				/**** Creation de la connexion ****/
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				/**** Utilisation de la connection ****/
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM matiere WHERE id_Matiere= ?");
				stmt.setInt(1, idMatiere);
				stmt.executeUpdate();

				/**** Fermer la connexion ****/
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}


	@Override
	public void supprimerLienMatiereGroupe(Integer idMatiere) {
		try {
			/**** Creation de la connexion ****/
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			/**** Utilisation de la connection ****/
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM groupe_matiere WHERE Matiere_id_Matiere= ?");
			stmt.setInt(1, idMatiere);
			stmt.executeUpdate();

			/**** Fermer la connexion ****/
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	}

