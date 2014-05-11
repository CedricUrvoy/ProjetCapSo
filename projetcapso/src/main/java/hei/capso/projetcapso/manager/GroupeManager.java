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
	
	public List<Groupe> listerGroupeEleve(Integer id) {
		List<Groupe> liste = groupeDao.listerGroupeEleve(id);
		return liste;
	}
	
	public void ajouterGroupe(Groupe groupe) {
		groupeDao.ajouterGroupe(groupe);
	}
	
	public void quitterGroupe(int id_Eleve, int id_Groupe) {
		groupeDao.quitterGroupe(id_Eleve, id_Groupe);
	}
	
	public Groupe chercherGroupeNom(String nom_Groupe) {
		Groupe groupe = groupeDao.chercherGroupeNom(nom_Groupe);
		return groupe;
	}
	
	
	public Groupe chercherTypeEleve(Integer id_Eleve, String type) {
		Groupe groupe = groupeDao.listerTypeEleve(id_Eleve, type);
		return groupe;
	}
	
	public List<Groupe> listertypeGroupeEleve(Integer id) {
		List<Groupe> liste = groupeDao.listertypeGroupeEleve(id);
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