<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>******</title>
		<meta name="***********" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/login_style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
	
	<div id="boite_1">nomDuSite</div>
	<div id="boite_2">
		<form id="login">
    <fieldset id="inputs">
        <input class="input" id="username" type="text" placeholder="Email" autofocus required>   
        <input class="input"  id="password" type="password" placeholder="Mot de passe" required>
    </fieldset>
    <fieldset id="actions">
    	<a class="text_form" href="">Mot de Passe oublié ? </a>
    	<a class="text_form" href="">Pas encore inscrit ?</a>
        <input class="input" type="submit" id="submit" value="Connexion">
        
    </fieldset>
</form>
	</div>
	
	
	</body>