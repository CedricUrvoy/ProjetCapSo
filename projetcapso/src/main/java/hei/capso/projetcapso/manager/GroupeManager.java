package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.GroupeDao;
import hei.capso.projetcapso.dao.impl.GroupeDaoImpl;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;

import java.util.List;

public class  GroupeManager {

	private static GroupeManager instance;
	
	private GroupeDao groupeDao;

	public static GroupeManager getInstance() {
		if(instance == null) 
		{
			instance = new GroupeManager();
		}
		return instance;
	}
	
	
	private GroupeManager() {

		groupeDao = new GroupeDaoImpl();

	}


	public List<Groupe> listerGroupeType(String type) {
		List<Groupe> liste = groupeDao.listerGroupeType(type);
		return liste;
	}
	
	public List<Groupe> listerGroupes() {
		List<Groupe> liste = groupeDao.listerGroupe();
		return liste;
	}
	
	public List<Groupe> listerGroupeEleve(Integer idEleve) {
		List<Groupe> liste = groupeDao.listerGroupeEleve(idEleve);
		return liste;
	}
	
	public void ajouterGroupe(Groupe groupe) {
		groupeDao.ajouterGroupe(groupe);
	}
	
	public void quitterGroupe(int idEleve, int idGroupe) {
		groupeDao.quitterGroupe(idEleve, idGroupe);
	}
	
	public Groupe chercherGroupeNom(String nomGroupe) {
		Groupe groupe = groupeDao.chercherGroupeNom(nomGroupe);
		return groupe;
	}
	
	
	public Groupe chercherTypeEleve(Integer idEleve, String type) {
		Groupe groupe = groupeDao.listerTypeEleve(idEleve, type);
		return groupe;
	}
	
	public List<Groupe> listertypeGroupeEleve(Integer idEleve) {
		List<Groupe> liste = groupeDao.listertypeGroupeEleve(idEleve);
		return liste;
	}
	
	public List<Groupe> comptergroupeeleve() {
		 List<Groupe> liste = groupeDao.comptergroupeeleve();
		return liste;
	}
	
	public void supprimerGroupe(Integer idGroupe) {
		groupeDao.supprimerGroupe(idGroupe);
	}
	
	public void supprimerlienGroupe(Integer idGroupe) {
		groupeDao.supprimerlienGroupe(idGroupe);
	}
	
	public void supprimerlienSeance(Integer idGroupe) {
		groupeDao.supprimerlienSeance(idGroupe);
	}
	public List<Eleve> listeMembreGroupe(Integer idGroupe) {
		return groupeDao.listeMembreGroupe(idGroupe);
	}
}