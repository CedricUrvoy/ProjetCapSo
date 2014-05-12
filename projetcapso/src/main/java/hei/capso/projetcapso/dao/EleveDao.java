package hei.capso.projetcapso.dao;

import hei.capso.projetcapso.model.Eleve;

import java.util.Date;
import java.util.List;


public interface EleveDao {
	
	public List<Eleve> listerIdEmailEleve();
	
	public List<Eleve> listerEleves();
	
	public void addEleve(Eleve eleve);
	
	public Eleve getEleve(int idEleve);
	
	public void rejoindreGroupe (int idEleve, int idGroupe);
	
	public void rejoindreSeance (int idEleve, int idSeance);
	
	public void quitterSeance (int idEleve, int idSeance);
	
	public Eleve chercherEleveMail(String mailEleve);
	
	public void changerMDP(Integer idEleve,  String passwordEleve) ;
	
	public void supprimerProfil(Integer idEleve);
	
	public void supprimerSeanceEleve(Integer idEleve);
	
	public void supprimerGroupeEleve(Integer idEleve);
	
	public void ajouterCalendrier (Integer idEleve, String lienCalendrier);
	
	public void derniereConnexion(Integer idEleve,Date derniereConnexion);
	
}