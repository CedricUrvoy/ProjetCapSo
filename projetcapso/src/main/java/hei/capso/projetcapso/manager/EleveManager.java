package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.EleveDao;
import hei.capso.projetcapso.model.Eleve;

import java.util.List;

public class  EleveManager {

	private static EleveManager instance;
	
	private EleveDao eleveDao;

	public static EleveManager getInstance() {
		if(instance == null) 
		{
			instance = new EleveManager();
		}
		return instance;
	}
	
	
	private EleveManager() {

		eleveDao = new EleveDao();

	}

	public void ajouterEleve(Eleve eleve) {
		eleveDao.ajouterEleve(eleve);
	}
	
}