<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Calendrier</title>
		<meta name="***********" content="******" />
		
		
		<!-- Fichiers styles -->
		<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<link rel="stylesheet" type="text/css" href="../css/calendrier.css"/>

		<!--FullCalendar Dependencies-->
		<link href='../fullcalendar/fullcalendar.css' rel='stylesheet' />
		<link href='../fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
		
		<!-- DatePicker Dependencies -->
		<link rel="stylesheet" type="text/css" href="../datetimepicker/jquery.datetimepicker.css"/>
	
		<!--jQuery-->
		<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
		<script type='text/javascript' src='../js/jquery.min.js'></script>
		<script type='text/javascript' src='../js/jquery-ui.custom.min.js'></script>
		
		<!--FullCalendar-->
		<script type='text/javascript' src='../fullcalendar/moment-with-langs.js'></script>
		<script type='text/javascript' src='../fullcalendar/fullcalendar.js'></script>
		<script type='text/javascript' src='../fullcalendar/lang/fr.js'></script>
		<script type='text/javascript' src='../fullcalendar/gcal.js'></script>
		
		
		<!--  DateTimePicker -->
		<script type="text/javascript" src="../datetimepicker/jquery.datetimepicker.js"></script>
		
		<!-- Scripts JS -->
		<script type='text/javascript' src="../js/calendar.js"></script>		
		<script type='text/javascript' src="../js/app.js"></script>
		
 		

		
	</head>

	<body >
		<jsp:include page="../header.jsp" />
		<div class=content>
			
			<h1 class="big titre" id="titreCalendrier">Calendrier - Personnel</h1>
			
			
			<!--FullCalendar container div-->
			<div id='calendar'></div>
			<div id ='calendrierGoogle'>${eleve.calendrier_Eleve}</div>
			
			
			<!-- Bouton d'ajout de seance -->
			<div id="boutonAjout" class="centrer">
				<div class="centrerBouton">
					<form  name=DFormAjout action="javascript:showDiv('ajoutSeance')">
					<input type="submit" value="Ajouter une Séance" class="turquoise-flat-button"></form>
				</div>
			</div>
			
			<!--Pop UP ajout seance-->
			<div class="hideshow" id="ajoutSeance" style="visibility: hidden;">
			    <div class="fade"></div> 
		    	<div class="popup_block">
			    	<div id="titrePopup">Nouvelle séance</div>
					<div id="contentPopup">
						<form id="ajout" name="DForm" method="POST">
						    <fieldset id="inputs_ajout">
						    	<label>Matière</label>
						         <select class="input"  list=matiere name="matiere" >
										<c:forEach var="matiere" items="${matieres}">
						  				 	<option id="matiere_${matiere.id_Matiere}"> ${matiere.nom_Matiere}
						  				</c:forEach>
						  			</select>
						  		<label>Groupe</label>
						  		<select class="input"  list=groupe name="groupe" >
												<option id="groupe_0"> Personnel
							  			<c:forEach var="groupe" items="${groupes}">
							  				 	<option id="groupe_${groupe.id_Groupe}"> ${groupe.nom_Groupe}
							  			</c:forEach>
						  			</select>
						  		<label>Date début : </label>	
								<input class="input horaire" type="text" id="datetimepickerdebut" name="datetimepickerdebut"/>
								<label>Date de fin : </label>	
								<input class="input horaire" type="text" id="datetimepickerfin" name="datetimepickerfin"/>
						        <label>Lieu</label>
						        <input class="input" type="text" id="place" name="place">
						        <label>Commentaires</label>
						        <textarea class= "input" id="infosSeance" name="infosSeance" rows="8" cols="50"></textarea>
						    </fieldset>
						    
						    <fieldset id="boutons">
						        <input type="Submit" class="turquoise-button" name="VALIDER" value="Valider" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULER" value="Annuler" onclick="doAct(this);">
						    </fieldset>
						</form>	
					</div>
				</div>
			</div>
			
			
			
		<!--Pop UP detail seance-->
			
			<div class="hideshow" id="detailSeance" style="visibility: hidden;">
			    <div class="fade"></div> 
		    	<div class="popup_block seance">
			    	<div id="titrePopup"><p id="info_matiere"></p></div>
					<div id="contentPopup">
						<form id="ajout" name="DForm2" method="POST">
								<label >Date :</label>
								<p class="info_seance" id="info_dateStart"></p>
						        <label>Heure de début : </label>
						        <p class="info_seance" id="start"></p>
						        <label>Heure de fin : </label>
						        <p class="info_seance" id="end"></p>
						        	<label>Lieu : </label>
						        <p class="info_seance" id="infosplace"></p>
						        <label>Informations de la séance :</label>
						        <p class="info_seance" id="infos"></p>	
						        <label>Elèves inscrits</label>
						   	    <p class="info_seance" id="eleves"></p>	
						    <fieldset class="boutons">
						        <input type="Submit" class="turquoise-button" id="rejoindre" name="QUITTERSEANCE" value="Quitter" onclick="doAct(this);"> 
						        <input type="Submit" class="turquoise-button" name="ANNULER2" value="Annuler" onclick="doAct(this);">
						    </fieldset>	
						</form>
					</div>
				</div>
			</div>
			
			<jsp:include page="sidebar.jsp" />
			
			
			
		</div>

		

		<jsp:include page="../footer.jsp" />
		
     
	</body>
	
<script>
	$('#datetimepickerdebut').datetimepicker({
		step:15,
		mask:'9999/19/39 29:59'
	});
	$('#datetimepickerfin').datetimepicker({
		step:15,
		mask:'9999/19/39 29:59'
	});
</script>