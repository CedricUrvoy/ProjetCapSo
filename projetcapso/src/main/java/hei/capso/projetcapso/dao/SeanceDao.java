package hei.capso.projetcapso.dao;

import hei.capso.projetcapso.model.Seance;

import java.util.List;


public interface SeanceDao {
	
	public List<Seance> listerSeancePerso(int idEleve);
	
	public List<Seance>	listerSeanceGroupe(int idGroupe);
	
	public Seance getSeance (int idSeance);
	
	public int addSeance(Seance seance);
	
	public void modifSeance(int idSeance, Seance seance);
	
	public void deleteSeance (int idSeance);
	
	
}