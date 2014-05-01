<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Profil</title>
		<meta name="votre profil" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script src="js/app.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" />
		
		
		<h1 class = "titre">Profil</h1>
		
		<!-- cadre profil --> 
		<div class="profil">
			<img id ="img_profil" alt="" src="img/Logo.png">
			<div id=identite>
				<H2 class ="info_profil">${eleve.prenom_Eleve}</H2>
				<H2 class ="info_profil">${eleve.nom_Eleve}</H2>
			</div>
			<div class="boite_profil" id="groupe">
				<h1 class="titre">Groupes</h1>
				<div id="liste-=_groupe">
					<c:forEach var="groupe" items="${groupes}">
							<h2 class="groupe_perso">${groupe.nom_Groupe}</h2>
					</c:forEach>
				</div>
			
			</div>
			
			<div class="boite_profil" id="modification">
				<h1 class="titre">Modification</h1>
				<form id="modif_group" name="DFormModifGroupe" method="POST">
					<input type="submit" value="Créer un groupe" class="turquoise-button modif_group" name="CREER" onclick="doAct(this);">
					<input type="submit" value="Quitter un groupe" class="turquoise-button modif_group" name="QUITTER" onclick="doAct(this);">
					<input type="submit" value="Rejoindre un groupe" class="turquoise-button modif_group" name ="REJOINDREGROUPE" onclick="doAct(this);">
					
				</form>
			
			</div>
		</div>
		
		<!--Pop UP ajout groupe-->
			<div class="hideshow" id="creerGroupe" style="visibility: hidden;">
			    <div id="fade"></div> 
		    	<div class="popup_block">
			    	<div id="titrePopup">Nouveau Groupe</div>
					<div id="contentPopup">
						<form id="ajout" name="DFormNG" method="POST"  >
						    <fieldset  id="inputs_ajout">
						    <label>Nom du groupe</label>
						         <input name="nom_Groupe" class="input" type="text"  >
						     </fieldset>
						    <fieldset id="boutons">
						        <input type="Submit" class="turquoise-button" name="VALIDERAJOUTGROUPE" value="Valider" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULERAJOUT" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>	
					</div>
				</div>
			</div>
			
			<!--Pop UP Quitter le groupe-->
			<div class="hideshow" id="quitterGroupe" style="visibility: hidden;">
			    <div id="fade"></div> 
		    	<div class="popup_block">
			    	<div id="titrePopup">Quitter un Groupe</div>
					<div id="contentPopup">
						<form id="ajout" name="DFormQG" method="POST">
						    <fieldset id="inputs_ajout">
						    <label>Groupe à quitter</label>
						        <input class="input" type=text list=groupeQuitter name="quitterGroupe" >
									<datalist id=groupeQuitter >
									   <c:forEach var="groupe" items="${groupes}">
											<option> ${groupe.nom_Groupe}
										</c:forEach>
									</datalist>
						         
						    <fieldset id="boutons">
						        <input type="Submit" class="turquoise-button" name="QUITTERGROUPE" value="Quitter" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULERQUITTER" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>	
					</div>
				</div>
			</div>
			
			<!--Pop UP Rejoindre le groupe-->
			<div class="hideshow" id="rejoindreGroupe" style="visibility: hidden;">
			    <div id="fade"></div> 
		    	<div class="popup_block">
			    	<div id="titrePopup">Rejoindre un Groupe</div>
					<div id="contentPopup">
						<form id="ajout" name="DFormRG" method="POST">
						    <fieldset id="inputs_ajout">
						    <label>Groupe à rejoindre</label>
						    <input type=radio name="groupearejoindre" value="Classe" onclick="eteindre(); afficher('openclasse')">Classe
						    <input type=radio name="groupearejoindre" value="Domaine" onclick="eteindre(); afficher('opendomaine')">Domaine
						    <input type=radio name="groupearejoindre" value="Promo" onclick="eteindre(); afficher('openpromo')">Promo
						    <input type=radio name="groupearejoindre" value="Autre" onclick="eteindre(); afficher('openautre')">Autre
						    <p class="cache" id="openclasse">
									<select class="input" name="classe" id="choixClasse">
									   <c:forEach var="classe" items="${classes}">
  				 							<option value="${classe.id_Groupe}"> ${classe.nom_Groupe}</option>
  										</c:forEach>
									</select>
							</p>
							
							<p class="cache" id="opendomaine">
								    <select class="input"  name="domaine" id="choixDomaine" >
								
									   <c:forEach var="domaine" items="${domaines}">
  				 							<option value="${domaine.id_Groupe}"> ${domaine.nom_Groupe}</option>
  										</c:forEach>
									</select>
							</p>
							
							<p class="cache" id="openpromo">
								    <input class="input" type=text list=groupePromo >
									<datalist id=groupePromo >
									   <option> H1
									   <option> H2
									   <option> H3
									   <option> H4
									   <option> H5
									</datalist>
							</p>
							<p class="cache" id="openautre">
								    <input class="input" type=text  id="autregroupe">	
							</p>

						     </fieldset>    
						    <fieldset id="boutons">
						        <input type="Submit" class="turquoise-button" name="REJOINDREOK" value="Rejoindre" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULERREJOINDRE" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>	
					</div>
				</div>
			</div>
	</body>