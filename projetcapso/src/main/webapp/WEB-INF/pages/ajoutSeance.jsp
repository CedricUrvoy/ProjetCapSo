<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Ajout Seance</title>
		<meta name="AjoutSeance" content="AjoutSeance" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/login_style2.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
	
	<div id="boite_1_ajout">Nouvelle séance</div>
	<div id="boite_2_ajout">
		<form id="ajout">
    <fieldset id="inputs_ajout">
    	<label>Matière</label></br>
        <input class="input" type=text list=matiere >
			<datalist id=matiere >
				<c:forEach var="matiere" items="${matieres}">
  				 	<option> ${matiere.nom_Matiere}
  				 </c:forEach>
  			</datalist></br>
		 <label>Date : </label></br>
        <input class="input" id="date" type="date" placeholder="date" required></br>
        <label>Heure de début : </label></br>
        <input class="input" id="mail" type="time" placeholder="prenom.nom@hei.fr" required></br>
        <label>Heure de fin : </label></br>
        <input class="input" id="password" type="time" placeholder="Mot de passe" required></br>
        <label>Commentaires</label>
        <textarea rows="8" cols="50"></textarea>
    </fieldset>
    
    <fieldset id="ajout">
        <input class="input" type="submit" id="submit" value="Valider"> 
    </fieldset>
</form>
	</div>
	
	
	</body>