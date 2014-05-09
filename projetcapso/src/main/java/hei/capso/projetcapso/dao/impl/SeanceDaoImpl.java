package hei.capso.projetcapso.dao.impl;

import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.SeanceDao;
import hei.capso.projetcapso.model.Eleve;
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
		Integer groupe;
		
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance "
					+ "INNER JOIN Seance_Eleve ON Seance_id_Seance = id_Seance "
					+ "INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere "
					+ "LEFT JOIN Groupe ON  Groupe_id_Groupe = id_Groupe "
					+ "WHERE Eleve_id_Eleve=?");
			stmt.setInt(1, idEleve);
			ResultSet results = stmt.executeQuery();
			while (results.next()){
				
				
			Object idGroupeSeance = results.getObject("id_Groupe");
			
			if (idGroupeSeance != null)
			{
			groupe = results.getInt("id_Groupe");
			}else{
			groupe = null;
			}
				
				
				Seance seance = new Seance(
						results.getInt("id_Seance"),
						results.getString("nom_Matiere"),
						results.getTimestamp("date_Debut_Seance"),
						results.getTimestamp("date_Fin_Seance"), 
						results.getString("lieu_Seance"),
						results.getString("info_Seance"),
						null,
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
		
	public List<Seance> listerSeanceGroupe(Integer idGroupe) {
		
		List<Seance> listeSeanceGroupe = new ArrayList<Seance>();
				
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere INNER JOIN Groupe ON  Groupe_id_Groupe = id_Groupe WHERE Groupe_id_Groupe=?");
			stmt.setInt(1, idGroupe);
			ResultSet results = stmt.executeQuery();
			while (results.next()){;
				
				
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
		Integer idGroupe = null;
		
		try{
			/**** Creation de la connexion ****/
			
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connection ****/
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Seance"
					+ "INNER JOIN Matiere ON Matiere_id_Matiere = id_Matiere"
					+ "LEFT JOIN Groupe ON  Groupe_id_Groupe = id_Groupe"
					+ "Where id_Seance=?");
			stmt.setInt(1, idSeance);
			ResultSet results = stmt.executeQuery();
			if (results.next()){
				
			Object idGroupeSeance = results.getObject("id_Groupe");
			
			if (idGroupeSeance != null)
			{
			idGroupe = results.getInt("id_Groupe");
			}else{
			idGroupe = null;
			}
				
				 seance = new Seance(
						results.getInt("id_Seance"),
						results.getString("nom_Matiere"),
						results.getDate("date_Debut_Seance"),
						results.getDate("date_Fin_Seance"), 
						results.getString("lieu_Seance"),
						results.getString("info_Seance"),
						idGroupe,
						results.getInt("id_Matiere"), 
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
			if (seance.getIdGroupe()==null){
				stmt.setNull(5,java.sql.Types.INTEGER);
			}else{
				stmt.setInt(5, seance.getIdGroupe());
			}
			
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

	public List<Eleve> listerElevesSeances(Integer idSeance) {

		List<Eleve> listeElevesSeances = new ArrayList<Eleve>();
		
		/**** Creation de la connexion ****/
		
		try
		{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			/**** Utilisation de la connexion ****/
			

			PreparedStatement stmt = connection.prepareStatement("SELECT id_Eleve, nom_Eleve , prenom_Eleve FROM Eleve INNER JOIN seance_eleve ON Eleve_id_Eleve = id_Eleve WHERE Seance_id_Seance=?");
			stmt.setInt(1, idSeance);
			ResultSet results = stmt.executeQuery();
			while (results.next()){;
				
				
				Eleve eleve = new Eleve(
						results.getInt("id_Eleve"),
						results.getString("nom_Eleve"),
						results.getString("prenom_Eleve"));
				listeElevesSeances.add(eleve);
			}
		
			/**** Fermer la connexion ****/
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return listeElevesSeances;
	}
}