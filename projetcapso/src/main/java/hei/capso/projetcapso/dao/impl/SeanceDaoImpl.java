package hei.capso.projetcapso.dao.impl;

import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.SeanceDao;
import hei.capso.projetcapso.model.Seance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;



public class SeanceDaoImpl implements SeanceDao{
	
	
	public List<Seance> listerSeancePerso(int idEleve) {
		
		List<Seance> listeSeancePersonnel = new ArrayList<Seance>();
		
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance "
					+ "INNER JOIN Seance_Eleve ON Seance_id_Seance = id_Seance "
					+ "INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere "
					+ "INNER JOIN Groupe ON  Groupe_id_Groupe = id_Groupe "
					+ "WHERE Eleve_id_Eleve=?");
			stmt.setInt(1, idEleve);
			ResultSet results = stmt.executeQuery();
			while (results.next()){
				Seance seance = new Seance(
						results.getInt("id_Seance"),
						results.getString("nom_Matiere"),
						results.getTimestamp("date_Debut_Seance"),
						results.getTimestamp("date_Fin_Seance"), 
						results.getString("lieu_Seance"),
						results.getString("info_Seance"),
						results.getInt("id_Groupe"),
						results.getInt("id_Matiere"), 
						results.getString("nom_Matiere"));
				listeSeancePersonnel.add(seance);
			}
			
			/**** Fermer la connexion ****/
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeSeancePersonnel;
	}
		
	public List<Seance> listerSeanceGroupe(int idGroupe) {
		
		List<Seance> listeSeanceGroupe = new ArrayList<Seance>();
				
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere INNER JOIN Groupe ON  Groupe_id_Groupe = id_Groupe WHERE Groupe_id_Groupe=?");
			stmt.setInt(1, idGroupe);
			ResultSet results = stmt.executeQuery();
			while (results.next()){
				Seance seance = new Seance(
						results.getInt("id_Seance"),
						results.getString("nom_Matiere"),
						results.getTimestamp("date_Debut_Seance"),
						results.getTimestamp("date_Fin_Seance"), 
						results.getString("lieu_Seance"),
						results.getString("info_Seance"),
						results.getInt("id_Groupe"),
						results.getInt("id_Matiere"), 
						results.getString("nom_Matiere"));
				listeSeanceGroupe.add(seance);
			}
			
			/**** Fermer la connexion ****/
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeSeanceGroupe;
	}

	
	public Seance getSeance(int idSeance) {
		
		Seance seance = null;
		
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance"
					+ "INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere"
					+ "INNER JOIN Groupe ON  Groupe_id_Groupe = id_Groupe"
					+ "Where id_Seance=?");
			stmt.setInt(1, idSeance);
			ResultSet results = stmt.executeQuery();
			if (results.next()){
				 seance = new Seance(
						results.getInt("id_Seance"),
						results.getString("nom_Matiere"),
						results.getDate("date_Debut_Seance"),
						results.getDate("date_Fin_Seance"), 
						results.getString("lieu_Seance"),
						results.getString("info_Seance"),
						results.getInt("id_Seance"),
						results.getInt("id_Seance"), 
						results.getString("nom_Matiere"));
			}
			
			/**** Fermer la connexion ****/
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seance;
	}

	
	public int addSeance(Seance seance) {
		
		int idSeanceCree = 0;
		
		/**** Creation de la connexion ****/
		
		try
		{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connexion ****/
			
			PreparedStatement stmt = connection.prepareStatement(""
					+ "INSERT INTO Seance(date_Debut_Seance,date_Fin_Seance,lieu_Seance,info_Seance,Groupe_id_Groupe,Matiere_id_Matiere) "
					+ "VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, new Timestamp (seance.getStart().getTime()));
			stmt.setTimestamp(2, new Timestamp (seance.getEnd().getTime()));
			stmt.setString(3,seance.getPlace());
			stmt.setString(4, seance.getInfos());
			stmt.setInt(5, seance.getIdGroupe());
			stmt.setInt(6, seance.getIdMatiere());
			stmt.executeUpdate( );
			ResultSet rs =  stmt.getGeneratedKeys();
			if (rs.next()){
			    idSeanceCree=rs.getInt(1);
			}
		
			/**** Fermer la connexion ****/
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}		
	
		return idSeanceCree;
	}
	
	public void modifSeance(int idSeance, Seance seance) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteSeance(int idSeance) {
		
		/**** Creation de la connexion ****/
		
		try
		{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connexion ****/
			
			PreparedStatement stmt = connection.prepareStatement(""
					+ "DELETE FROM Seance WHERE id_Seance=? ");
			stmt.setInt(1, idSeance);
			stmt.executeUpdate();
		
			/**** Fermer la connexion ****/
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
}