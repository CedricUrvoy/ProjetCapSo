<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/app.js"></script>
<title>GESTION DES PROFILS</title>
</head>
<body>

<nav class="navigation">
		
		<div class="menu centrer">
			<div class="logo">
				<img src="img/Logo.png" alt="nomDuSite" title="nomDuSite"/>
				<a href="calendrier">SoliCours</a>
			</div>
			<ul class= "onglet">
				
				<li><a href="gestiongroupes" >GROUPES</a></li>
				<li><a href="profil">PROFILS</a></li>
				
				<li><a href="deconnexion">DECONNEXION</a></li>
				
			</ul>
		</div>
	</nav>
	
	
	<div id="gestion_groupe">
		<h1 class="big titre">Gestion des Profils</h1>
		<div class="cadre">
			<table class="tableau_gestion">
			<tr class="gestion">
				
			    <th class="gestion">Nom</th>
			    <th class="gestion">Prenom</th>
			    <th class="gestion">Derniere séance</th>
			    <th class="gestion">Supprimer</th>
			</tr>
			<c:forEach var="eleve" items="${eleves}">
			<tr class="gestion">
				<td class="gestion">${eleve.nom_Eleve}</td>
				<td class="gestion">${eleve.prenom_Eleve}</td>
				<td class="gestion">DATE</td>
				<td class="gestion">
					<input type="submit" value="Supprimer le profil" class="turquoise-button modif_group" name="SUPPROFIL" onclick="doAct(this);">
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	

</body>
</html>