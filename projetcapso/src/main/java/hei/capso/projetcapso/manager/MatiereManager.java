package hei.capso.projetcapso.manager ;


import hei.capso.projetcapso.dao.MatiereDao;
import hei.capso.projetcapso.dao.impl.MatiereDaoImpl;
import hei.capso.projetcapso.model.Matiere;

import java.util.List;

public class  MatiereManager {

	private static MatiereManager instance;
	
	private MatiereDao matiereDao;

	public static MatiereManager getInstance() {
		if(instance == null) 
		{
			instance = new MatiereManager();
		}
		return instance;
	}
	
	
	private MatiereManager() {

		matiereDao = new MatiereDaoImpl();

	}


	public List<Matiere> listerMatiere(String nomPromo,String nomDomaine) {
		List<Matiere> liste = matiereDao.listerMatiere(nomPromo, nomDomaine);
		return liste;
	}
	
	public Matiere chercherMatiereNom(String nomMatiere) {
		Matiere matiere = matiereDao.chercherMatiereNom(nomMatiere);
		return matiere;
	}
	
	public void ajouterMatiere(Matiere matiere) {
		matiereDao.ajouterMatiere(matiere);
	}
	
	public void matiereGroupe(Integer idMatiere,Integer idGroupe) {
		matiereDao.matiereGroupe(idMatiere, idGroupe);
	}
	
	public List<Matiere> listertoutesMatiere(){
		return matiereDao.listerToutesMatieres();
	}
	
	public void supprimerMatiere(Integer idMatiere) {
		matiereDao.supprimerMatiere(idMatiere);
	}
	
	public void supprimerLienMatiereGroupe(Integer idMatiere) {
		matiereDao.supprimerLienMatiereGroupe(idMatiere);
	}
}
