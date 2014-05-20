<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8" />
		<title>Profil</title>
		<meta name="votre profil" content="******" />
		<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<link rel="stylesheet" type="text/css" href="../css/profil.css"/>
		<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
		<script src="../js/app.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp" />
		
		<div class="content">
			<div class="header_profil">
				<p class="pres">${eleve.prenom_Eleve} ${eleve.nom_Eleve}</p>
				<form id="Cmdp" name="DFCmdp" action="POST">
				<input type="submit" value="Changer de mot de passe" class="turquoise-button" id="mdp" name="MDP" onclick="doAct(this);">
				</form>			
			</div>
			
			<aside id="aside_groupe">
				<div id="liste_groupe">
					<div class="groupe">
						<h2 class="groupe_perso promo">Promo :</h2>
						<a class="nom_groupe" >${promoEleve.nom_Groupe}</a>
					</div>
					<div class="groupe">
						<h2 class="groupe_perso classe">Classe :</h2>
						<a onClick="afficherListeMembres('divacacher');" href="profil?id=${ClasseEleve.id_Groupe}"class="nom_groupe">${classeEleve.nom_Groupe} </a>
					</div>
					<div class="groupe">
						<h2 class="groupe_perso domaine">Domaine :</h2>
						<a class="nom_groupe">${domaineEleve.nom_Groupe}</a>	
					</div>	
					<div class="groupe">	
						<h2 class="groupe_perso">Autres groupes :</h2>
						<c:forEach var="groupesEleve" items="${groupesEleve}">
								<a class="nom_groupe perso">${groupesEleve.nom_Groupe}</a>
						</c:forEach>
					</div>
				</div>		
			</aside>
			<aside id="gestion">
				<form id="modif_group" name="DFormModifGroupe" method="POST">
					<input type="submit" value="Créer un groupe" class="turquoise-button modif_profil" name="CREER" onclick="doAct(this);">
					<input type="submit" value="Quitter un groupe" class="turquoise-button modif_profil" name="QUITTER" onclick="doAct(this);">
					<input type="submit" value="Rejoindre un groupe" class="turquoise-button modif_profil" name ="REJOINDREGROUPE" onclick="doAct(this);">
					<input type="submit" value="Ajouter son calendrier Google" class="turquoise-button modif_profil" name ="AJOUTERCALENDRIER" onclick="doAct(this);">
				</form>			
			</aside>
		</div>
		

			
		
		<!--Pop UP ajout groupe-->
		<div class="hideshow" id="creerGroupe" style="visibility: hidden;">
		    <div class="fade"></div> 
	    	<div class="popup_block">
		    	<div id="titrePopup">Nouveau Groupe</div>
				<div id="contentPopup">
					<form id="ajout" name="DFormNG" method="POST"  >
					    <fieldset  id="inputs_ajout">
					    <label>Nom du groupe</label>
					         <input name="nom_Groupe" class="input" type="text"  >
					         <p>Evitez les accents ! </p>
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
		    <div class="fade"></div> 
	    	<div class="popup_block">
		    	<div id="titrePopup">Quitter un Groupe</div>
				<div id="contentPopup">
					<form id="ajout" name="DFormQG" method="POST">
					    <fieldset id="inputs_ajout">
					    <label>Groupe à quitter</label>
					        <select class="input"  name="quitterGroupe" >
								   <c:forEach var="groupesEleve" items="${groupesEleve}">
										<option> ${groupesEleve.nom_Groupe}
									</c:forEach>
								</select>
					    </fieldset>     
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
		    <div class="fade"></div> 
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
								    <select class="input"  name="promo" id="choixPromo" >
								
									   <c:forEach var="promo" items="${promos}">
  				 							<option value="${promo.id_Groupe}"> ${promo.nom_Groupe}</option>
  										</c:forEach>
									</select>
							</p>
							<p class="cache" id="openautre">
								    <input name="autre" class="input" type=text  id="autregroupe">	
							</p>
					    </fieldset>    
					    <fieldset id="boutons">
					        <input type="Submit" class="turquoise-button" name="REJOINDREOK" value="Rejoindre" onclick="doAct(this); erreurGroupe();"> 
					        <input type="Submit" class="turquoise-button" name="ANNULERREJOINDRE" value="Annuler" onclick="doAct(this);">
					    </fieldset>
					</form>	
				</div>
			</div>
		</div>
		
		<!--Pop UP Ajouter un Calendrier-->
		<div class="hideshow" id="ajouterCalendrier" style="visibility: hidden;">
		    <div class="fade"></div> 
	    	<div class="popup_block">
		    	<div id="titrePopup">Ajout Calendrier Google</div>
				<div id="contentPopup">
					<form id="ajout" name="DFormAC" method="POST">   
					    <label>Lien du Calendrier Google</label>
					    <input name="liencalendrier" class="input" type="text"  id="liencalendrier">
					    <input type="Submit" class="turquoise-button" name="VALIDERCALENDRIER" value="Valider" onclick="doAct(this);"> 
					    <input type="Submit" class="turquoise-button" name="ANNULERAJOUTERCALENDRIER" value="Annuler" onclick="doAct(this);">
					</form>
				</div>
			</div>
		</div>			
			
		<!--Pop UP Changer MDP-->
		<div class="hideshow" id="changermdp" style="visibility: hidden;">
		    <div class="fade"></div> 
	    	<div class="popup_block">
		    	<div id="titrePopup">Changer de mot de passe </div>
				<div id="contentPopup">
					<form id="ajout" name="DFormCMDP" method="POST">   
					    <label>Ancien mot de passe</label>
					    <input name="ancienmdp" class="input" type="password"  id="ancienmdp">
					    <label>Nouveau mot de passe</label>
					    <input name="nouveaumdp" class="input" type="password"  id="nouveaumdp">
					    <input type="Submit" class="turquoise-button" name="CHANGER" value="Valider" onclick="doAct(this);"> 
					    <input type="Submit" class="turquoise-button" name="ANNULERCHANGER" value="Annuler" onclick="doAct(this);">
					</form>
				</div>
			</div>
		</div>		
		
		<!--Pop UP Liste des membres d'un groupe-->
		<div class="hideshow"  id="divacacher" style="visibility: hidden; display: none; ">
		    <div class="fade"></div> 
	    	<div class="popup_block">
		    	<div id="titrePopup">Membre de ${groupe.nom_Groupe} </div>
				<div id="contentPopup">
					<li> ${eleve.nom_Eleve} ${eleve.prenom_Eleve}</li>
				</div>
			</div>
		</div>				

		<jsp:include page="../footer.jsp" />
		        
	</body>
	

<%String erreur= (String)(request.getAttribute("erreur"));%>
	<script type="text/javascript">
	myFonction(){
	if(erreur==true)
		{
		window.alert("Ce groupe est deja créé");
		}
	}
	</script>