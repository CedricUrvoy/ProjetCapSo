package hei.capso.projetcapso.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.GroupeDao;
import hei.capso.projetcapso.model.Groupe;

public class GroupeDaoImpl implements GroupeDao{

	//LISTER LES GROUPES SUIVANT LE TYPE DE GROUPE
	public List<Groupe> listerGroupeType(String type) {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM groupe WHERE type_Groupe = ? ORDER BY nom_Groupe");
			stmt.setString(1,type);
			ResultSet results = stmt.executeQuery();
			

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

	//LISTER LES GROUPES
	@Override
	public List<Groupe> listerGroupe() {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM groupe");

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
	@Override
	public List<Groupe> listerGroupeEleve(Integer id) {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT groupe.id_Groupe, groupe.nom_Groupe, groupe.type_Groupe, eleve.id_Eleve FROM eleve INNER JOIN eleve_groupe ON eleve_groupe.Eleve_id_Eleve = eleve.id_Eleve INNER JOIN groupe ON groupe.id_Groupe = eleve_groupe.Groupe_id_Groupe WHERE id_Eleve =? ORDER BY groupe.nom_Groupe");
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

	//AJOUTER GROUPE
	@Override
	public void ajouterGroupe(Groupe groupe) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			// Utiliser la connexion
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `groupe`(`nom_Groupe`,`type_Groupe`) VALUES(?,'Groupe')");
			stmt.setString(1, groupe.getNom_Groupe());
			stmt.executeUpdate();

			// Fermer la connexion
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//QUITTER UN GROUPE
	@Override
	public void quitterGroupe(Integer id_Eleve, Integer id_Groupe) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			// Utiliser la connexion
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM eleve_groupe WHERE Eleve_id_Eleve= ? AND Groupe_id_Groupe=? ");
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

	//CHERCHER UN GROUPE AVEC NOM 
	@Override
	public Groupe chercherGroupeNom(String nom_Groupe) {
		Groupe groupecherche = null;
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT groupe.nom_Groupe, groupe.id_Groupe, groupe.type_Groupe FROM groupe WHERE groupe.nom_Groupe=?");
			stmt.setString(1,nom_Groupe);
			ResultSet results = stmt.executeQuery();
			
			if(results.next()){
				groupecherche = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getString("type_Groupe"));
				
			}

			// Fermer la connexion
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return groupecherche;
	}

	//LISTER GROUPE TYPE ELEVE
	@Override
	public Groupe listerTypeEleve(Integer id, String type) {
		Groupe groupe = new Groupe();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT groupe.id_Groupe, groupe.nom_Groupe, groupe.type_Groupe, eleve.id_Eleve FROM eleve INNER JOIN eleve_groupe ON eleve_groupe.Eleve_id_Eleve = eleve.id_Eleve INNER JOIN groupe ON groupe.id_Groupe = eleve_groupe.Groupe_id_Groupe WHERE id_Eleve =? AND groupe.type_Groupe=?");
			stmt.setInt(1,id);
			stmt.setString(2,type);
			ResultSet results = stmt.executeQuery();
			
			if(results.next()) {
				groupe = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getString("type_Groupe"));
				
			}

			// Fermer la connexion
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return groupe;
	}

	//LISTER GROUPE ELEVE
	@Override
	public List<Groupe> listertypeGroupeEleve(Integer id) {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT groupe.id_Groupe, groupe.nom_Groupe, groupe.type_Groupe, eleve.id_Eleve FROM eleve INNER JOIN eleve_groupe ON eleve_groupe.Eleve_id_Eleve = eleve.id_Eleve INNER JOIN groupe ON groupe.id_Groupe = eleve_groupe.Groupe_id_Groupe WHERE id_Eleve =? AND type_Groupe='Groupe'");
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

	
	//COMPTER LE NOMBRE D'ELEVE PAR GROUPE
	@Override
	public List<Groupe> comptergroupeeleve() {
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			
			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT groupe.id_Groupe, groupe.nom_Groupe, COUNT( Groupe_id_Groupe ) AS nbEleve FROM eleve_groupe RIGHT JOIN groupe ON groupe.id_Groupe = eleve_groupe.Groupe_id_Groupe WHERE groupe.type_Groupe='Groupe' GROUP BY Groupe_id_Groupe ORDER BY nom_Groupe");
			
			
			while (results.next()) {
				Groupe domaine = new Groupe(
						results.getInt("id_Groupe"),
						results.getString("nom_Groupe"),
						results.getInt("nbEleve"));
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

	//SUPPRIMER UN GROUPE
	@Override
	public void SupprimerGroupe(Integer id_Groupe) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			// Utiliser la connexion
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM groupe WHERE id_Groupe= ?");
			stmt.setInt(1, id_Groupe);
			stmt.executeUpdate();

			// Fermer la connexion
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//SUPPRIMER LES LIENS GROUPES & ELEVE
	@Override
	public void SupprimerlienGroupe(Integer id_Groupe) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			// Utiliser la connexion
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM eleve_groupe WHERE Groupe_id_Groupe= ?");
			stmt.setInt(1, id_Groupe);
			stmt.executeUpdate();

			// Fermer la connexion
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
