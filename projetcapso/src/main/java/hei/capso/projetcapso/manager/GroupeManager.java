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

}