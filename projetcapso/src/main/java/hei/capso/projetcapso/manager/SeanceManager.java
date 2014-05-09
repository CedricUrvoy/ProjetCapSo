package hei.capso.projetcapso.manager;

import java.util.List;

import hei.capso.projetcapso.dao.SeanceDao;
import hei.capso.projetcapso.dao.impl.SeanceDaoImpl;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Seance;

public class SeanceManager {
	
	private static SeanceManager instance;
	
	private SeanceDao seanceDao = new SeanceDaoImpl();
	
	private SeanceManager() {
	}

	public static SeanceManager getInstance() {
		if (instance == null) {
			instance = new SeanceManager();
		}
		return instance;
	}
	
	public List<Seance> listeSeancePersonnel(int idEleve){
		List<Seance> listeSeances = seanceDao.listerSeancePerso(idEleve);
		return listeSeances;
	}
	
	public List<Seance> listeSeanceGroupe(int idGroupe){
		List<Seance> listeSeances = seanceDao.listerSeanceGroupe(idGroupe);
		return listeSeances;
	}
	
	public int addSeance (Seance seance){
		int idSeance = seanceDao.addSeance(seance);
		return idSeance;
	}
	
	public List<Eleve> listeElevesSeance(int idSeance){
		List<Eleve> listeElevesSeance = seanceDao.listerElevesSeances(idSeance);
		return listeElevesSeance;
	}

}