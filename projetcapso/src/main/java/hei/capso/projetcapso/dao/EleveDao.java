package hei.capso.projetcapso.dao;

import hei.capso.projetcapso.model.Eleve;

import java.util.List;


public interface EleveDao {
	
	public List<Eleve> listerIdEmailEleve();
	
	public List<Eleve> listerEleves();
	
	public Eleve getEleve (int idEleve);
	
	public Eleve getEleveGroupe (int idEleve);
	
	public void addEleve(Eleve eleve);
	
	public void modifEleve(int idEleve, Eleve eleve);
	
	public void deleteEleve (int idEleve);
	
	public void rejoindreGroupe (int idEleve, int id_groupe);
}