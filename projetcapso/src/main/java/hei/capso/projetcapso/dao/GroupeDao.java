package hei.capso.projetcapso.dao ;

import hei.capso.projetcapso.model.Groupe;

import java.util.List;

public interface GroupeDao {

	public List<Groupe> listerGroupeType(String type);
	
	public List<Groupe> listerGroupe();
		
	public List<Groupe> listerGroupeEleve(Integer id);
	
	public void ajouterGroupe(Groupe groupe);
		
	public void quitterGroupe(Integer id_Eleve,Integer id_Groupe);
		
	public Groupe chercherGroupeNom(String nom_Groupe);
		
	public Groupe listerTypeEleve(Integer id,String type);
				
	public List<Groupe> listertypeGroupeEleve(Integer id);
				
	public List<Groupe> comptergroupeeleve();
		
	public void supprimerGroupe(Integer id_Groupe);

	public void supprimerlienGroupe(Integer id_Groupe) 	;	
	
	public void supprimerlienSeance(Integer id_Groupe);

}

