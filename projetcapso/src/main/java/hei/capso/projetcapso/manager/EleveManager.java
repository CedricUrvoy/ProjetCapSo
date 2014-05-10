package hei.capso.projetcapso.manager ;


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
	
	// CHANGER MOT DE PASSE
		public void changerMDP(Integer id_Eleve, String password_Eleve) {
			eleveDao.changerMDP(id_Eleve, password_Eleve);
		}
		
	//LISTER ELEVE
		public List<Eleve> listerEleve(){
			return eleveDao.listerEleves();
		}
		
	//SUPPRIMER ELEVE 
		public void supprimerProfil(Integer id_Eleve) {
			eleveDao.supprimerProfil(id_Eleve);
		}
	
	//SUPPRIMER LIEN ENTRE ELEVE ET SEANCE
		public void supprimerSeanceEleve(Integer id_Eleve) {
			eleveDao.supprimerSeanceEleve(id_Eleve);
		}
	//SUPPRIMER LIEN ELEVE GROUPE
		public void supprimerGroupeEleve(Integer id_Eleve) {
				eleveDao.supprimerGroupeEleve(id_Eleve);
		}

		
}