package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.MatiereDao;
import hei.capso.projetcapso.model.Matiere;

import java.util.List;

public class  MatiereManager {

	private static MatiereManager instance;
	
	private MatiereDao matiereDao;

	public static MatiereManager getInstance() {
		if(instance == null) 
		{
			instance = new MatiereManager();
		}
		return instance;
	}
	
	
	private MatiereManager() {

		matiereDao = new MatiereDao();

	}


	public List<Matiere> listerMatiere(String nom_Promo,String nom_Domaine) {
		List<Matiere> liste = matiereDao.listerMatiere(nom_Promo, nom_Domaine);
		return liste;
	}
	
	public Matiere chercherMatiereNom(String nom_Matiere) {
		Matiere matiere = matiereDao.chercherMatiereNom(nom_Matiere);
		return matiere;
	}
}