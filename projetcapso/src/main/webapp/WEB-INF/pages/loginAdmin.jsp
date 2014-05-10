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
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/login_style.css"/>" />
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
	
	<div id="blockLogin">
		<div id="titrePopup">SoliCours Administration</div>
		<div id="contentPopup">
			<form method="post"  action="<c:url value="/connexionadmin" />" id="login">
			    <fieldset id="inputs">
			        <input class="input" id="email" name="email" type="text" placeholder="Identifiant" autofocus required>   
			        <span class="erreur">${form.erreurs['email']}</span>
			        <input class="input"  id="password" type="password" name="password" placeholder="Mot de passe" required>
			        <span class="erreur">${form.erreurs['password']}</span>
			        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
			    </fieldset>
			    <fieldset id="actions">
			    	<a class="text_form" href="connexion">Retour</a>
			        <input class="bouton" type="submit" id="submit" value="Connexion">
				</fieldset>
			</form>	
		</div>
	</div>
	
	</body>