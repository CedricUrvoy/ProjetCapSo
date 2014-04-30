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
	
	
}