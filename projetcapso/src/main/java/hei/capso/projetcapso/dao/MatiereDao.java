package hei.capso.projetcapso.dao ;

import hei.capso.projetcapso.model.Matiere;

import java.util.List;

public interface MatiereDao {

	
	public List<Matiere> listerMatiere(String nomPromo,String nomDomaine);
	
	public Matiere chercherMatiereNom(String nomMatiere);
	
	public void ajouterMatiere(Matiere matiere);
	
	public  void matiereGroupe(int idMatiere, int idGroupe);
	
	public List<Matiere> listerToutesMatieres();
}
