package hei.capso.projetcapso.model;

import hei.capso.projetcapso.manager.EleveManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class ConnexionForm {

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Eleve connecterEleve( HttpServletRequest req ) {
        
    	/* Récupération des champs du formulaire */
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.print(password);
        String passwordReel = null;
        
        List<Eleve> emailEleve = EleveManager.getInstance().listerEmailEleve();
        
        Integer idEleve = null;
      
        Eleve eleveConnexion = new Eleve();
        Eleve eleve = null;

        /* Validation du champ email. */
        try {
          idEleve = validationEmail( email, emailEleve);
          Eleve elevePotentiel = EleveManager.getInstance().getEleve(idEleve);
          passwordReel = elevePotentiel.getPassword_eleve();
          System.out.print(passwordReel);
          
        } catch ( Exception e ) {	
            setErreur( "email", e.getMessage() );
        }
        eleveConnexion.setEmail_Eleve(email);
        
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( password , passwordReel);
        } catch ( Exception e ) {
            setErreur( "password", e.getMessage() );
        }
        eleveConnexion.setPassword_eleve(password);

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
            eleve = EleveManager.getInstance().getEleve(idEleve);
        } else {
            resultat = "Échec de la connexion.";
        }

        
		return eleve;
    }

    
    public int connecterAdmin( HttpServletRequest req ){
    	
    	/* Récupération des champs du formulaire */
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        List<Eleve> emailEleve = EleveManager.getInstance().listerEmailEleve();
        
        Integer idEleve = null;
      
        Eleve eleveConnexion = new Eleve();
        Eleve eleve = null;

        /* Validation du champ email. */
        try {
          idEleve = validationEmail( email, emailEleve);
          Eleve elevePotentiel = EleveManager.getInstance().getEleve(idEleve);
          
        } catch ( Exception e ) {	
            setErreur( "email", e.getMessage() );
        }
        eleveConnexion.setEmail_Eleve(email);
        
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( password , "admin");
        } catch ( Exception e ) {
            setErreur( "password", e.getMessage() );
        }
        eleveConnexion.setPassword_eleve(password);

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
            eleve = EleveManager.getInstance().getEleve(idEleve);
        } else {
            resultat = "Échec de la connexion.";
        }

        
		return 1;
    }
    
    
    /**
     * Valide l'adresse email saisie.
     */
    private Integer validationEmail( String email, List<Eleve> emailEleve) throws Exception {
        
    	boolean emailValide = false;
    	
    	if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide" );
        }
        
        for (int i = 0; i < emailEleve.size(); i++) {
			if (emailEleve.get(i).getEmail_Eleve().matches(email)){emailValide = true;return emailEleve.get(i).getId_Eleve();}
		}
        
        if (emailValide==false){
        	throw new Exception ("Compte non crée");
        }
		return 0;
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String passwordPotentiel,String passwordReel) throws Exception {
        if ( passwordPotentiel != null ) {
      
        	if ( passwordPotentiel.matches(passwordReel)) {
        		
        	}else{
        		throw new Exception( "Le mot de passe est incorrect" );
        	}
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    @SuppressWarnings("unused")
	private static String getValeurChamp( HttpServletRequest req, String nomChamp ) {
        String valeur = req.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}