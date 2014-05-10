package hei.capso.projetcapso.controllers;

import hei.capso.projetcapso.model.ConnexionForm;
import hei.capso.projetcapso.model.Eleve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConnexionAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4843572106022934423L;
	
	public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
    	RequestDispatcher view = req.getRequestDispatcher("WEB-INF/pages/loginAdmin.jsp");
    	view.forward(req, resp);
    }
	

    public void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Integer admin = form.connecterAdmin( req );

        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( "sessionAdmin", admin );
        } else {
            session.setAttribute( "sessionAdmin", null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        req.setAttribute( "form", form );
        req.setAttribute( "utilisateur", admin );

        if ( session.getAttribute( "sessionAdmin" ) == null ) {
            /* Redirection vers la page publique */
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/loginAdmin.jsp" ).forward( req, resp );
        } else {
            /* Affichage de la page restreinte */
        	resp.sendRedirect("admin/pageadmin");
        }
    }
}