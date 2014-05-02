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
	
	public Groupe chercherClasseEleve(Integer id_Eleve) {
		Groupe groupe = groupeDao.listerClasseEleve(id_Eleve);
		return groupe;
	}
	
	public Groupe chercherDomaineEleve(Integer id_Eleve) {
		Groupe groupe = groupeDao.listerDomaineEleve(id_Eleve);
		return groupe;
	}
	
	public Groupe chercherPromoEleve(Integer id_Eleve) {
		Groupe groupe = groupeDao.listerPromoEleve(id_Eleve);
		return groupe;
	}
}