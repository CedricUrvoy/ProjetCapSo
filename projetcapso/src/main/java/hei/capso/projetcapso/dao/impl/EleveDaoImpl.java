package hei.capso.projetcapso.dao.impl;


import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;

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
						.prepareStatement("INSERT INTO `eleve`(`nom_Eleve`,`prenom_Eleve`,`password_Eleve`,`email_Eleve`) VALUES(?, ?, ?, ?)");
				stmt.setString(1, eleve.getNom_Eleve());
				stmt.setString(2, eleve.getPrenom_Eleve());
				stmt.setString(3, eleve.getPassword_eleve());
				stmt.setString(4, eleve.getEmail_Eleve());

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

				List<Eleve> listeEleve = new ArrayList<Eleve>();
				
				try{
					/**** Creation de la connexion ****/
					
					Connection connection = DataSourceProvider.getDataSource().getConnection();
					
					/**** Utilisation de la connection ****/
					
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Eleve ");
					ResultSet results = stmt.executeQuery();
					while (results.next()){
						Eleve eleve = new Eleve(
								results.getInt("id_Eleve"),
								results.getString("nom_Eleve"),
								results.getString("prenom_Eleve"));
						listeEleve.add(eleve);
					}
					
					/**** Fermer la connexion ****/
					
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return listeEleve	;
			}
		

		//REJOINDRE UN GROUPE
		
		public  void rejoindreGroupe(int idEleve, int idGroupe) {
			try {
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				// Utiliser la connexion
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `eleve_groupe`(`Eleve_id_Eleve`,`Groupe_id_Groupe`) VALUES(?, ?)");
				stmt.setInt(1, idEleve);
				stmt.setInt(2, idGroupe);
				stmt.executeUpdate();

				// Fermer la connexion
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		//REJOINDRE UNE SEANCE

		public void rejoindreSeance(int idEleve, int idSeance) {
			try {
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();
		
					// Utiliser la connexion
					PreparedStatement stmt = connection
							.prepareStatement("INSERT INTO `seance_eleve`(`Eleve_id_Eleve`,`Seance_id_Seance`) VALUES(?, ?)");
					stmt.setInt(1, idEleve);
					stmt.setInt(2, idSeance);
					stmt.executeUpdate();
		
					// Fermer la connexion
					stmt.close();
					connection.close();
		
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		//QUITTER UNE SEANCE
		
		public void quitterSeance(int idEleve, int idSeance) {
			try {
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();
		
				// Utiliser la connexion
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM seance_eleve WHERE Eleve_id_Eleve= ? AND Seance_id_Seance=? ");
				stmt.setInt(1, idEleve);
				stmt.setInt(2, idSeance);
				stmt.executeUpdate();
		
				// Fermer la connexion
				stmt.close();
				connection.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//CHERCHER UN ELEVE AVEC MAIL
				public Eleve chercherEleveMail(String mail_Eleve) {
					Eleve elevecherche = null;
					try {
						Connection connection = DataSourceProvider.getDataSource()
								.getConnection();

						PreparedStatement stmt = connection.prepareStatement("SELECT eleve.email_Eleve, eleve.id_Eleve FROM eleve WHERE eleve.email_Eleve=?");
						stmt.setString(1,mail_Eleve);
						ResultSet results = stmt.executeQuery();
						
						if(results.next()){
							elevecherche = new Eleve(
									results.getInt("id_Eleve"),
									results.getString("email_Eleve"));
							
						}

						// Fermer la connexion
						results.close();
						stmt.close();
						connection.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

					return elevecherche;
				}

		// CHANGER LE MOT DE PASSE
				public void ChangerMDP(Integer id_Eleve,  String password_Eleve) {
					
					
				try {
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					// Utiliser la connexion
					PreparedStatement stmt = connection
							.prepareStatement("UPDATE eleve SET eleve.password_Eleve = ? WHERE eleve.id_Eleve = ?");
					stmt.setString(1, password_Eleve);
					stmt.setInt(2, id_Eleve );
					

					stmt.executeUpdate();

					// Fermer la connexion
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
	
				// SUPPRIMER ELEVE
				public void SupprimerProfil(Integer id_Eleve) {
					
					
				try {
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					// Utiliser la connexion
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM eleve WHERE id_Eleve=?");
					stmt.setInt(1, id_Eleve );
					

					stmt.executeUpdate();

					// Fermer la connexion
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	

				
				// SUPPRIMER SEANCE ELEVE
				public void SupprimerSeanceEleve(Integer id_Eleve) {
					
					
				try {
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					// Utiliser la connexion
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM seance_eleve WHERE Eleve_id_Eleve =?");
					stmt.setInt(1, id_Eleve );
					

					stmt.executeUpdate();

					// Fermer la connexion
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
				
				// SUPPRIMER GROUPE ELEVE
				public void SupprimerGroupeEleve(Integer id_Eleve) {
					
					
				try {
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					// Utiliser la connexion
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM eleve_groupe WHERE Eleve_id_Eleve =?");
					stmt.setInt(1, id_Eleve );
					

					stmt.executeUpdate();

					// Fermer la connexion
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
}
