<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Calendrier domaine</title>
		<meta name="***********" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<!-- <link rel="stylesheet" type="text/css" href="css/login_style2.css"/> -->
		
		
		
		<!--FullCalendar Dependencies-->
		<link href='fullcalendar/fullcalendar.css' rel='stylesheet' />
		<link href='fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	
		<!--jQuery-->
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script src='js/jquery.min.js'></script>
		<script src='js/jquery-ui.custom.min.js'></script>
		
		<!--FullCalendar-->
		<script src='js/moment-with-langs.js'></script>
		<script src='fullcalendar/fullcalendar.js'></script>
		<script src='fullcalendar/lang/fr.js'></script>
		<script src="js/calendar.js"></script>
		
		<script src="js/app.js"></script>

		
	</head>

	<body>
		<jsp:include page="header.jsp" />
		<h1 class="big titre" >Calendrier - Nom du groupe</h1>
		<!--FullCalendar container div-->
		<div id='calendar'></div>
		
		<div class="centrer">
			<div class="centrerBouton">
				<form action="javascript:showDiv()">
				<input type="submit" value="Ajouter une Seance" class="turquoise-flat-button"></form>
			</div>
		</div>
		
		<!--Pop UP ajout seance-->
		<div id="hideshow" style="visibility: hidden;">
		    <div id="fade"></div> 
	    	<div class="popup_block">
	    		<div class="popup">
			    	<div id="boite_1_ajout">Nouvelle séance</div>
					<div id="boite_2_ajout">
						<form id="ajout" name="DForm" method="POST">
						    <fieldset id="inputs_ajout">
						    	<label>Matière</label></br>
						         <input class="input" type=text list=matiere >
									<datalist id=matiere >
										<c:forEach var="matiere" items="${matieres}">
						  				 	<option> ${matiere.nom_Matiere}
						  				 </c:forEach>
						  			</datalist></br>
								 <label>Date : </label></br>
						        <input class="input" id="date" type="date" placeholder="" required></br>
						        <label>Heure de début : </label></br>
						        <input class="input" id="heure_debut" type="time" placeholder="" required></br>
						        <label>Heure de fin : </label></br>
						        <input class="input" id="heure_fin" type="time" placeholder="" required></br>
						        <label>Commentaires</label>
						        <textarea rows="8" cols="50"></textarea>
						    </fieldset>
						    
						    <fieldset id="ajout">
						        <input type="Submit" class="turquoise-button" name="VALIDER" value="Valider" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULER" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		
		
	<!--Pop UP detail seance-->
		
		<div id="hideshow2" style="visibility: hidden;">
		    <div id="fade"></div> 
	    	<div class="popup_block">
	    		<div class="popup">
			    	<div id="boite_1_ajout">Nouvelle séance</div>
					<div id="boite_2_ajout">
						<form id="ajout" name="DForm2" method="POST">
						    	<label >Matière :</label>
						    	<p class="info_seance" id="info_matiere"></p></br>
								<label >Date :</label>
								<p class="info_seance" id="info_dateStart"></p></br>
						        <label>Heure de début : </label>
						        <p class="info_seance" id="start"></p></br>
						        <label>Heure de fin : </label>
						        <p class="info_seance" id="end"></p></br>
						        <label>Lieu : </label>
						        <p class="info_seance" id="place"></p></br>
						        <label>Informations de la séance :</label>
						        <p class="info_seance" id="infos"></p>		    
						    <fieldset id="ajout">
						        <input type="Submit" class="turquoise-button" name="REJOINDRE" value="Rejoindre" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULER2" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
	</body>