package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.GroupeDao;
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

		groupeDao = new GroupeDao();

	}


	public List<Groupe> listerClasses() {
		List<Groupe> liste = groupeDao.listerClasses();
		return liste;
	}
	
	public List<Groupe> listerDomaines() {
		List<Groupe> liste = groupeDao.listerDomaines();
		return liste;
	}
	public List<Groupe> listerGroupes() {
		List<Groupe> liste = groupeDao.listerGroupe();
		return liste;
	}
	
	public List<Groupe> listerPromos() {
		List<Groupe> liste = groupeDao.listerPromo();
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
	
	public List<Groupe> chercherGroupeTypeEleve(Integer id_Eleve,String type_Groupe) {
		List<Groupe> liste = groupeDao.listerGroupeTypeEleve(id_Eleve, type_Groupe);
		return liste;
	}
	

}