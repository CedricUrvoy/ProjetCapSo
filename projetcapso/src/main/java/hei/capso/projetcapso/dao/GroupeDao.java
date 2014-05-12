package hei.capso.projetcapso.dao ;

import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Groupe;

import java.util.List;

public interface GroupeDao {

	public List<Groupe> listerGroupeType(String type);
	
	public List<Groupe> listerGroupe();
		
	public List<Groupe> listerGroupeEleve(Integer idEleve);
	
	public void ajouterGroupe(Groupe groupe);
		
	public void quitterGroupe(Integer idEleve,Integer idGroupe);
		
	public Groupe chercherGroupeNom(String nomGroupe);
		
	public Groupe listerTypeEleve(Integer idEleve,String type);
				
	public List<Groupe> listertypeGroupeEleve(Integer idEleve);
				
	public List<Groupe> comptergroupeeleve();
		
	public void supprimerGroupe(Integer idGroupe);

	public void supprimerlienGroupe(Integer idGroupe) 	;	
	
	public void supprimerlienSeance(Integer idGroupe);
	
	public List<Eleve> listeMembreGroupe(Integer idGroupe);

}

