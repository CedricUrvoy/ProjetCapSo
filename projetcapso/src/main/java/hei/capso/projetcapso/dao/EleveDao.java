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
	
	public Eleve chercherEleveMail(String mail_Eleve);
	
	public void changerMDP(Integer id_Eleve,  String password_Eleve) ;
	
	public void supprimerProfil(Integer id_Eleve);
	
	public void supprimerSeanceEleve(Integer id_Eleve);
	
	public void supprimerGroupeEleve(Integer id_Eleve);
	
	public void ajouterCalendrier (Integer id_Eleve, String lienCalendrier);
	
	public void derniereConnexion(Integer id_Eleve,Date derniereConnexion);
	
}