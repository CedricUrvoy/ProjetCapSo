package hei.capso.projetcapso.manager ;


import java.util.List;

import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.dao.impl.EleveDaoImpl;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;


public class  EleveManager {

	private static EleveManager instance;
	
	private EleveDao eleveDao = new EleveDaoImpl();

	public static EleveManager getInstance() {
		if(instance == null) 
		{
			instance = new EleveManager();
		}
		return instance;
	}
	
	
	private EleveManager() {
	}
	
	/**** Lister les emails des eleves pour la connexion ****/
	
	public List<Eleve> listerEmailEleve(){
		return eleveDao.listerIdEmailEleve();
	}
	
	public Eleve getEleve(int idEleve){
		return eleveDao.getEleve(idEleve);
	}
	
	// AJOUTER ELEVE
	public void addEleve(Eleve eleve) {
		eleveDao.addEleve(eleve);
	}
	
	// REJOINDRE UN GROUPE
	public void rejoindreGroupe(int idEleve, int id_groupe) {
		eleveDao.rejoindreGroupe(idEleve, id_groupe);
	}
		
	// REJOINDRE UNE SEANCE
	public void rejoindreSeance(int idEleve, int idSeance) {
		eleveDao.rejoindreSeance(idEleve, idSeance);
	}	
	
	// QUITTER UNE SEANCE
		public void quitterSeance(int idEleve, int idSeance) {
			eleveDao.quitterSeance(idEleve, idSeance);
		}	
	
	//RECHERCHER UN ELEVE AVEC L'EMAIL
	public Eleve chercherEleveMail(String mail_Eleve) {
		Eleve eleve = eleveDao.chercherEleveMail(mail_Eleve);
		return eleve;
	}
	
	// Changer mot de passe
		public void changerMDP(Integer id_Eleve, String password_Eleve) {
			eleveDao.ChangerMDP(id_Eleve, password_Eleve);
		}
		
		public List<Eleve> listerEleve(){
			return eleveDao.listerEleves();
		}
		
	//Supprimer Eleve
		public void SupprimerProfil(Integer id_Eleve) {
			eleveDao.SupprimerProfil(id_Eleve);
		}
	
	//Supprimer lien eleve seance
		public void SupprimerSeanceEleve(Integer id_Eleve) {
			eleveDao.SupprimerSeanceEleve(id_Eleve);
		}
		//Supprimer lien eleve groupe
		public void SupprimerGroupeEleve(Integer id_Eleve) {
					eleveDao.SupprimerGroupeEleve(id_Eleve);
				}

		
}