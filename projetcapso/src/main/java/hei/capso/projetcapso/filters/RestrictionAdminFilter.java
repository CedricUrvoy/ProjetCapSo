package hei.capso.projetcapso.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionAdminFilter implements Filter {
    public static final String ATT_SESSION_ADMIN = "sessionAdmin";

    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Non-filtrage des ressources statiques */
        String cheminStyle = request.getRequestURI().substring( request.getContextPath().length() );
        if ( cheminStyle.startsWith( "/css" ) ) {
            chain.doFilter( request, response );
            return;
        }
        String cheminFont = request.getRequestURI().substring( request.getContextPath().length() );
        if ( cheminFont.startsWith( "/font" ) ) {
            chain.doFilter( request, response );
            return;
        }
        String cheminJs = request.getRequestURI().substring( request.getContextPath().length() );
        if ( cheminJs.startsWith( "/js" ) ) {
            chain.doFilter( request, response );
            return;
        }
        String cheminCreerProfil = request.getRequestURI().substring( request.getContextPath().length() );
        if ( cheminCreerProfil.startsWith( "/ajoutProfil" ) ) {
            chain.doFilter( request, response );
            return;
        }
        String cheminloginAdmin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( cheminloginAdmin.startsWith( "/connexionadmin" ) ) {
            chain.doFilter( request, response );
            return;
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        
        if ( session.getAttribute( ATT_SESSION_ADMIN ) == null) {
            /* Redirection vers la page publique */
        	response.sendRedirect("/projetcapso/connexion");
        } else {
			/* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
        
       
    }

    public void destroy() {
    }
}
	