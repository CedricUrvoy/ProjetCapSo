<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SoliCours</title>
		<meta name="***********" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/login_style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
	
	<div id="boite_1">SoliCours</div>
	<div id="boite_2">
	<form method="post"  action="connexion" id="login">
	    <fieldset id="inputs">
	        <input class="input" id="email" name="email" type="text" placeholder="Email" autofocus required>   
	        <span class="erreur">${form.erreurs['email']}</span>
	        <input class="input"  id="password" type="password" name="password" placeholder="Mot de passe" required>
	        <span class="erreur">${form.erreurs['password']}</span>
	        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	    </fieldset>
	    <fieldset id="actions">
	    	<a class="text_form" href="">Mot de Passe oublié ? </a>
	    	<a class="text_form" href="ajoutProfil">Pas encore inscrit ?</a>
	        <input class="input" type="submit" id="submit" value="Connexion">
	        <%-- Vérification de la présence d'un objet utilisateur en session --%>
            <c:if test="${!empty sessionScope.sessionEleve}">
                <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionEleve.email_Eleve}</p>
            </c:if>
		</fieldset>
	</form>
	</div>
	
	
	</body>