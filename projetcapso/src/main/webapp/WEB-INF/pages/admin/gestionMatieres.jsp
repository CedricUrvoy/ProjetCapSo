<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<title>Gestion des matières</title>
	</head>
	
	<body>

		<nav class="navigation">
			<div class="menu centrer">
				<div class="logo">
					<img src="../img/Logo.png" alt="nomDuSite" title="nomDuSite"/>
					<a>SoliCours</a>
				</div>
				<ul class= "onglet">
					<li><a href="gestionmatiere" >MATIERES</a></li>
					<li><a href="gestiongroupes" >GROUPES</a></li>
					<li><a href="gestionprofils">PROFILS</a></li>
					
					<li><a href="/projetcapso/deconnexion">DECONNEXION</a></li>
					
				</ul>
			</div>
		</nav>
		
		
		<div id="gestion_groupe">
			<h1 class="big titre">Gestion des Matières</h1>
			<div class="cadre">
				<table class="tableau_gestion">
				<tr class="gestion">
					
				    <th class="gestion">Nom</th>
				    <th class="gestion">Supprimer</th>
				</tr>
				<c:forEach var="matiere" items="${matieres}">
				<tr class="gestion">
					<td class="gestion">${matiere.nom_Matiere}</td>
					<td class="gestion">
						<a class="turquoise-button" href="supprimermatiere?id=${matiere.id_Matiere}" >Supprimer</a>
					</td>
				</tr>
				</c:forEach>
				</table>
			</div>
		</div>
		
		<form method="POST" name="DFormAdmin">
			<div class= "ajout_matiere">
				<input type="submit" value="Ajouter une matière" class="turquoise-button ajout_matiere" name="AJOUTMATIERE" onclick="doAct(this);">
			</div>
		</form>
		
	
	<div id="gestion_groupe">
	
	</div>
	
		<!--Pop UP Ajouter Matiere-->
			<div class="hideshow" id="ajoutmatiere" style="visibility: hidden;">
			    <div class="fade"></div> 
		    	<div class="popup_block">
			    	<div id="titrePopup">Ajouter une matière</div>
					<div id="contentPopup">
						<form id="ajout" name="DFormAM" method="POST">
						    
						    <label>Nom de la matière</label>
						    <input name="nom_matiere" class="input" type="text"  id=nom_matiere>
						    <label>Groupe de la matière</label>
						    <select class="input"  name="groupeMatiere" id="groupeMatiere" >
									   <c:forEach var="promo" items="${promos}">
  				 							<option value="${promo.id_Groupe}"> ${promo.nom_Groupe}</option>
  										</c:forEach>
									   <c:forEach var="domaine" items="${domaines}">
  				 							<option value="${domaine.id_Groupe}"> ${domaine.nom_Groupe}</option>
  										</c:forEach>
							</select>
						    <input type="Submit" class="turquoise-button" name="AJOUTER" value="Ajouter" onclick="doAct(this);"> 
						    <input type="Submit" class="turquoise-button" name="ANNULERAJOUTM" value="Annuler" onclick="doAct(this);">
						</form>
					</div>
				</div>
		</div>	

	</body>
</html>