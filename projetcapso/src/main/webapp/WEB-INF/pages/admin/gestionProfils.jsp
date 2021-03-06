<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<link rel="stylesheet" type="text/css" href="../css/admin.css"/>
		<script src="../js/app.js"></script>
		<title>Gestions des profils</title>
	
	</head>
	
	<body>

		<nav class="navigation">
			<div class="menu centrer">
				<div class="logo">
					<img src="../img/Logo.png" alt="nomDuSite" title="nomDuSite"/>
					<a >SoliCours</a>
				</div>
				<ul class= "onglet">
					
					<li><a href="gestionmatiere" >MATIERES</a></li>
					<li><a href="gestiongroupes" >GROUPES</a></li>
					<li><a href="gestionprofils">PROFILS</a></li>
					
					<li><a href="/projetcapso/deconnexion">DECONNEXION</a></li>
					
				</ul>
			</div>
		</nav>
		
		
		<div id="gestion_profil">
			<h1 class="big titre">Gestion des Profils</h1>
			<div class="cadre">
				<table class="tableau_gestion">
				<tr class="gestion">
					
				    <th class="gestion">Nom</th>
				    <th class="gestion">Pr�nom</th>
				    <th class="gestion">Derni�re s�ance</th>
				    <th class="gestion">Supprimer</th>
				</tr>
				<c:forEach var="eleve" items="${eleves}">
				<tr class="gestion">
					<td class="gestion">${eleve.nom_Eleve}</td>
					<td class="gestion">${eleve.prenom_Eleve}</td>
					<td class="gestion"><fmt:formatDate pattern="dd MMMM yyyy" value="${eleve.derniereConnexion_Eleve}" /></td>
					<td class="gestion">
						<a class="turquoise-button" href="supprimerprofil?id=${eleve.id_Eleve}" >Supprimer</a>
					</td>
				</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	

	</body>
</html>