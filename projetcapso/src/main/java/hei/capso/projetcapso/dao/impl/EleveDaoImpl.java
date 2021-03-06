package hei.capso.projetcapso.dao.impl;


import hei.capso.projetcapso.dao.DataSourceProvider;
import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.model.Eleve;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EleveDaoImpl implements EleveDao{
	
	
	// FAIRE LA LISTE DES ID ET MAIL DES ELEVES
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
				/**** Creation de la connexion ****/
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				/**** Utilisation de la connection ****/
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `eleve`(`nom_Eleve`,`prenom_Eleve`,`password_Eleve`,`email_Eleve`) VALUES(?, ?, ?, ?)");
				stmt.setString(1, eleve.getNom_Eleve());
				stmt.setString(2, eleve.getPrenom_Eleve());
				stmt.setString(3, eleve.getPassword_eleve());
				stmt.setString(4, eleve.getEmail_Eleve());

				stmt.executeUpdate();

				/**** Fermer la connexion ****/
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		// RECUPERATION DES DONNEES D'UN ELEVE SANS SES GROUPES 

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
							results.getString("lienCalendrier_Eleve"), 
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


		public List<Eleve> listerEleves() {

				List<Eleve> listeEleve = new ArrayList<Eleve>();
				
				try{
					/**** Creation de la connexion ****/
					
					Connection connection = DataSourceProvider.getDataSource().getConnection();
					
					/**** Utilisation de la connection ****/
					
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Eleve ORDER BY derniereConnexion_Eleve ");
					ResultSet results = stmt.executeQuery();
					while (results.next()){
						Eleve eleve = new Eleve(
								results.getInt("id_Eleve"),
								results.getString("nom_Eleve"),
								results.getString("prenom_Eleve"),
								results.getDate("derniereConnexion_Eleve"));
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
				/**** Creation de la connexion ****/
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();

				/**** Utilisation de la connection ****/
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `eleve_groupe`(`Eleve_id_Eleve`,`Groupe_id_Groupe`) VALUES(?, ?)");
				stmt.setInt(1, idEleve);
				stmt.setInt(2, idGroupe);
				stmt.executeUpdate();

				/**** Fermer la connexion ****/
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		//REJOINDRE UNE SEANCE

		public void rejoindreSeance(int idEleve, int idSeance) {
			try {
				/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();
		
					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("INSERT INTO `seance_eleve`(`Eleve_id_Eleve`,`Seance_id_Seance`) VALUES(?, ?)");
					stmt.setInt(1, idEleve);
					stmt.setInt(2, idSeance);
					stmt.executeUpdate();
		
					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();
		
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		//QUITTER UNE SEANCE
		
		public void quitterSeance(int idEleve, int idSeance) {
			try {
				/**** Creation de la connexion ****/
				Connection connection = DataSourceProvider.getDataSource()
						.getConnection();
		
				/**** Utilisation de la connection ****/
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM seance_eleve WHERE Eleve_id_Eleve= ? AND Seance_id_Seance=? ");
				stmt.setInt(1, idEleve);
				stmt.setInt(2, idSeance);
				stmt.executeUpdate();
		
				/**** Fermer la connexion ****/
				stmt.close();
				connection.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//CHERCHER UN ELEVE AVEC MAIL
				public Eleve chercherEleveMail(String mailEleve) {
					Eleve elevecherche = null;
					try {
						/**** Creation de la connexion ****/
						Connection connection = DataSourceProvider.getDataSource()
								.getConnection();
						
						/**** Utilisation de la connection ****/
						PreparedStatement stmt = connection.prepareStatement("SELECT eleve.email_Eleve, eleve.id_Eleve FROM eleve WHERE eleve.email_Eleve=?");
						stmt.setString(1,mailEleve);
						ResultSet results = stmt.executeQuery();
						
						if(results.next()){
							elevecherche = new Eleve(
									results.getInt("id_Eleve"),
									results.getString("email_Eleve"));
							
						}

						/**** Fermer la connexion ****/
						results.close();
						stmt.close();
						connection.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

					return elevecherche;
				}

		// CHANGER LE MOT DE PASSE
				public void changerMDP(Integer idEleve,  String passwordEleve) {
					
					
				try {
					/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("UPDATE eleve SET eleve.password_Eleve = ? WHERE eleve.id_Eleve = ?");
					stmt.setString(1, passwordEleve);
					stmt.setInt(2, idEleve );
					

					stmt.executeUpdate();

					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
	
				// SUPPRIMER ELEVE
				public void supprimerProfil(Integer idEleve) {
					
					
				try {
					/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM eleve WHERE id_Eleve=?");
					stmt.setInt(1, idEleve );
					

					stmt.executeUpdate();

					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	

				
				// SUPPRIMER SEANCE ELEVE
				public void supprimerSeanceEleve(Integer idEleve) {
					
					
				try {
					/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM seance_eleve WHERE Eleve_id_Eleve =?");
					stmt.setInt(1, idEleve );
					

					stmt.executeUpdate();

					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
				
				// SUPPRIMER GROUPE ELEVE
				public void supprimerGroupeEleve(Integer idEleve) {
					
					
				try {
					/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("DELETE FROM eleve_groupe WHERE Eleve_id_Eleve =?");
					stmt.setInt(1, idEleve );
					

					stmt.executeUpdate();

					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}




				public void ajouterCalendrier(Integer idEleve,String lienCalendrier) {

				try {
					/**** Creation de la connexion ****/
					Connection connection = DataSourceProvider.getDataSource()
							.getConnection();

					/**** Utilisation de la connection ****/
					PreparedStatement stmt = connection
							.prepareStatement("UPDATE eleve SET lienCalendrier_Eleve = ? WHERE id_Eleve=?");
					stmt.setInt(2, idEleve );
					stmt.setString(1, lienCalendrier );

					stmt.executeUpdate();

					/**** Fermer la connexion ****/
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
					
					
			}




				public void derniereConnexion(Integer idEleve,java.util.Date derniereConnexion) {
					
					try {
						/**** Creation de la connexion ****/
						Connection connection = DataSourceProvider.getDataSource()
								.getConnection();

						/**** Utilisation de la connection ****/
						PreparedStatement stmt = connection
								.prepareStatement("UPDATE eleve SET derniereConnexion_Eleve = ? WHERE id_Eleve=?");
						stmt.setInt(2, idEleve );
						stmt.setDate(1, new Date(derniereConnexion.getTime()));

						stmt.executeUpdate();

						/**** Fermer la connexion ****/
						stmt.close();
						connection.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}

}
