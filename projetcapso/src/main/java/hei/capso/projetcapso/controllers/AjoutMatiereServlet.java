package hei.capso.projetcapso.controllers;



import hei.capso.projetcapso.manager.MatiereManager;
import hei.capso.projetcapso.model.Matiere;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutMatiereServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1170373427792627682L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UNE SEANCE
    	
				if (MatiereManager.getInstance().chercherMatiereNom(req.getParameter("nom_matiere"))!=null)
				{
					System.out.print("le nom de la matiere existe déjà");
				}
				else
				{	
				MatiereManager.getInstance().ajouterMatiere(
						new Matiere(null, 
								req.getParameter("nom_matiere")));
				
				Integer id_Matiere  = MatiereManager.getInstance().chercherMatiereNom(req.getParameter("nom_matiere")).getId_Matiere();
				Integer id_Groupe = Integer.parseInt(req.getParameter("groupeMatiere"));;
				System.out.print("id_Groupe = "+id_Groupe);
				MatiereManager.getInstance().matiereGroupe(id_Matiere, id_Groupe);
				}
				
				response.sendRedirect("pageadmin");
			}
	}
	
	

