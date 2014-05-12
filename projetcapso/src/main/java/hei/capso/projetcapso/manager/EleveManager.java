package hei.capso.projetcapso.manager ;



import java.util.Date;
import java.util.List;

import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.dao.impl.EleveDaoImpl;
import hei.capso.projetcapso.model.Eleve;


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
	
	//LISTER LES EMAILS DES ELEVES POUR LA CONNEXION
	public List<Eleve> listerEmailEleve(){
		return eleveDao.listerIdEmailEleve();
	}
	
	// AVOIR UN ELEVE
	public Eleve getEleve(int idEleve){
		return eleveDao.getEleve(idEleve);
	}
	
	// AJOUTER ELEVE
	public void addEleve(Eleve eleve) {
		eleveDao.addEleve(eleve);
	}
	
	// REJOINDRE UN GROUPE
	public void rejoindreGroupe(int idEleve, int idGroupe) {
		eleveDao.rejoindreGroupe(idEleve, idGroupe);
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
	public Eleve chercherEleveMail(String mailEleve) {
		Eleve eleve = eleveDao.chercherEleveMail(mailEleve);
		return eleve;
	}
	
	// CHANGER MOT DE PASSE
		public void changerMDP(Integer idEleve, String passwordEleve) {
			eleveDao.changerMDP(idEleve, passwordEleve);
		}
		
	//LISTER ELEVE
		public List<Eleve> listerEleve(){
			return eleveDao.listerEleves();
		}
		
	//SUPPRIMER ELEVE 
		public void supprimerProfil(Integer idEleve) {
			eleveDao.supprimerProfil(idEleve);
		}
	
	//SUPPRIMER LIEN ENTRE ELEVE ET SEANCE
		public void supprimerSeanceEleve(Integer idEleve) {
			eleveDao.supprimerSeanceEleve(idEleve);
		}
	//SUPPRIMER LIEN ELEVE GROUPE
		public void supprimerGroupeEleve(Integer idEleve) {
				eleveDao.supprimerGroupeEleve(idEleve);
		}
		
	// AJOUTER CALENDRIER ELEVE
		
		public void ajoutCalendrier(Integer idEleve, String lienCalendrier){
			eleveDao.ajouterCalendrier(idEleve, lienCalendrier);
		}
		
	// DERNIERE CONNEXION
		
		public void derniereConnexion(Integer idEleve, Date derniereConnexion){
			eleveDao.derniereConnexion(idEleve, derniereConnexion);			
		}

		
}