<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<<<<<<< HEAD:projetcapso/src/main/webapp/WEB-INF/pages/gestionGroupes.jsp
<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/app.js"></script>
<title>Gestion des groupes</title>
=======
<link rel="stylesheet" type="text/css" href="../css/header-style.css"/>
<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script src="../js/app.js"></script>
<title>GESTION DES GROUPES</title>
>>>>>>> 8635e6849bd683b71549e904dbaa42313b6b175b:projetcapso/src/main/webapp/WEB-INF/pages/admin/gestionGroupes.jsp
</head>
<body>

<nav class="navigation">
		
		<div class="menu centrer">
			<div class="logo">
				<img src="../img/Logo.png" alt="nomDuSite" title="nomDuSite"/>
				<a href="calendrier">SoliCours</a>
			</div>
			<ul class= "onglet">
				
				<li><a href="gestiongroupes" >GROUPES</a></li>
				<li><a href="gestionprofils">PROFILS</a></li>
				
				<li><a href="/projetcapso/deconnexion">DECONNEXION</a></li>
				
			</ul>
		</div>
	</nav>
	
	
	<div id="gestion_groupe">
		<h1 class="big titre">Gestion des groupes</h1>
		<div class="cadre">
			<table class="tableau_gestion">
			<tr class="gestion">
				
			    <th class="gestion">Nom du groupe</th>
			    <th class="gestion">Membres</th>
			    <th class="gestion">Supprimer</th>
			</tr>
			<c:forEach var="groupe" items="${groupes}">
			<tr class="gestion">
				<td class="gestion">${groupe.nom_Groupe}</td>
				<td class="gestion">${groupe.nbEleve}</td>
				<td class="gestion">
					<a class="turquoise-button modif_group" href="supprimergroupe?id=${groupe.id_Groupe}" >Supprimer</a>
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	

</body>
</html>