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
<title>GESTION DES GROUPES</title>
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
				<li><a href="gestionprofils">PROFILS</a></li>
				
				<li><a href="deconnexion">DECONNEXION</a></li>
				
			</ul>
		</div>
	</nav>
	
	
	<div id="gestion_groupe">
		<h1 class="big titre">Gestion des groupes</h1>
		<div class="cadre">
			<table class="tableau_gestion">
			<tr class="gest_groupe">
				
			    <th class="gest_groupe">Nom du groupe</th>
			    <th class="gest_groupe">Membres</th>
			    <th class="gest_groupe">Supprimer</th>
			</tr>
			<c:forEach var="groupe" items="${groupes}">
			<tr class="gest_groupe">
				<td class="gest_groupe">${groupe.nom_Groupe}</td>
				<td class="gest_groupe">Oranges</td>
				<td class="gest_groupe">
					<input type="submit" value="Supprimer le groupe" class="turquoise-button modif_group" name="SUPGROUPE" onclick="doAct(this)";>
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	

</body>
</html>