

import hei.capso.projetcapso.manager.EleveManager;
import hei.capso.projetcapso.manager.SeanceManager;
import hei.capso.projetcapso.model.Eleve;
import hei.capso.projetcapso.model.Seance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreerSeanceServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8813581600125656088L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		//AJOUTER UN GROUPE
		
		SeanceManager.getInstance().addSeance(
				new Seance(null, null, , end, place, infos, idGroupe, idMatiere)
		
		
		
		HttpSession session = req.getSession();
		Eleve eleve = (Eleve) session.getAttribute("sessionEleve");
		req.setAttribute("eleve",eleve);
		Integer id_Eleve = eleve.getId_Eleve();
		

		Integer id_groupe = GroupeManager.getInstance().listerGroupes().size();
		EleveManager.getInstance().rejoindreSeance(eleve.getId_Eleve(), null);
		
		response.sendRedirect("profil");
	}
}
