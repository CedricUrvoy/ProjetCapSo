package hei.capso.projetcapso.dao ;



import hei.capso.projetcapso.model.Groupe;
import hei.capso.projetcapso.model.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface MatiereDao {

	
	public List<Matiere> listerMatiere(String nom_Promo,String nom_Domaine);
	
	public Matiere chercherMatiereNom(String nom_Matiere);
	
	public void ajouterMatiere(Matiere matiere);
	
	public  void matiereGroupe(int id_Matiere, int id_Groupe);
}
