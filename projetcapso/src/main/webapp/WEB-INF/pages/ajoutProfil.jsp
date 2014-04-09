<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Créer ton profil</title>
		<meta name="Crée ton profil" content="Crée ton profil" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/login_style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
	
	<div id="boite_1_ajout">Nouveau Profil</div>
	<div id="boite_2_ajout">
		<form id="ajout" method="post" action="ajoutProfil">
    <fieldset id="inputs_ajout">
    	<label>Nom : </label></br>
        <input class="input" id="nom" type="text" placeholder="Nom" autofocus required></br>
		 <label>Prénom : </label></br>
        <input class="input" id="prenom" type="text" placeholder="Prénom" required></br>
        <label>Mail : </label></br>
        <input class="input" id="mail" type="email" placeholder="prenom.nom@hei.fr" required></br>
        <label>Mot de passe : </label></br>
        <input class="input" id="password" type="password" placeholder="Mot de passe" required></br>
    </fieldset>
    <fieldset class="groupe">
    	<label>Classe</label>
        <input class="input" type=text list=classe >
			<datalist id=classe >
  				 <c:forEach var="groupe" items="${groupes}">
  				 <option> ${groupe.nom_Groupe}
  				 </c:forEach>
			</datalist>
		<label>Domaine</label>
		<input class="input" type=text list=domaine >
			<datalist id=domaine >
				<c:forEach var="domaine" items="${domaines}">
  					 <option> ${domaine.nom_Groupe}
  				 </c:forEach>
			</datalist>
    </fieldset>
    <fieldset id="ajout">
        <input class="input" type="submit" id="submit" value="Valider"> 
    </fieldset>
</form>
	</div>
	
	
	</body>