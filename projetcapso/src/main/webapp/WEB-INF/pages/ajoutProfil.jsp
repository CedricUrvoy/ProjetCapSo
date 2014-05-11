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
		<link rel="stylesheet" type="text/css" href="css/ajout_profil_style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
		<div id ="blockAjout">
			<div id="titrePopup">Nouveau Profil</div>
			<div id="contentPopup">
				<form id="ajout" method="post" action="ajoutProfil">
				    <fieldset id="inputs_ajout">
						<label>Prénom : </label>
				        <input class="input" id="prenom" type="text" placeholder="Prénom" name="prenom_Eleve" required>
				        <label>Nom : </label>
				        <input class="input" id="nom" type="text" placeholder="Nom" name="nom_Eleve" autofocus required>
				        <label>Mail : </label>
				        <input class="input inputmail" id="mail" type="text" placeholder="prenom.nom" name="email_Eleve" required>
				        <p id="emailHei">@ hei.fr</p>
				        <label>Mot de passe : </label>
				        <input class="input" id="password" type="password" placeholder="Mot de passe" name="password_Eleve" required>
				    </fieldset>
				    <fieldset class="groupe">
				    	<label>Classe</label>
				        
							<select class="input" id=classe name="classe" >
				  				 <c:forEach var="groupe" items="${groupes}">
				  				 <option value ="${groupe.id_Groupe}"> ${groupe.nom_Groupe}</option>
				  				 </c:forEach>
							</select>
						<label>Domaine</label>
						
							<select class="input" id=domaine name="domaine" >
								<c:forEach var="domaine" items="${domaines}">
				  					 <option value ="${domaine.id_Groupe}" > ${domaine.nom_Groupe}</option>
				  				 </c:forEach>
							</select>
							<label>Promo</label>
						
							<select class="input" id=promo name="promo">
								<c:forEach var="promo" items="${promos}">
				  					 <option value ="${promo.id_Groupe}" > ${promo.nom_Groupe}</option>
				  				 </c:forEach>
							</select>
				    </fieldset>
				    <fieldset id="ajout">
				        <input class="bouton" type="submit" id="submit" value="Valider"> 
				    </fieldset>
				</form>
			</div>
		</div>
	
	</body>