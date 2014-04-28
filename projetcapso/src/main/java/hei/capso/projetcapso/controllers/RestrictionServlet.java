package hei.capso.projetcapso.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RestrictionServlet extends HttpServlet {


    /**
	 * 
	 */
	private static final long serialVersionUID = 6169490772577099111L;

	public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( "sessionEleve" ) == null ) {
            /* Redirection vers la page publique */
        	resp.sendRedirect( "connexion" );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/calendrier.jsp" ).forward( req, resp );
        }
    }
}