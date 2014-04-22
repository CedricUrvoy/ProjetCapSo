<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

		
	</head>

	<body>
		<jsp:include page="header.jsp" />
		<h1 class="big titre">Calendrier - Nom du groupe</h1>
		<!--FullCalendar container div-->
		<div id='calendar'></div>
		
		<div class="centrer">
			<div class="centrerBouton">
				<form action="javascript:showDiv()">
				<input type="submit" value="Ajouter une Seance" class="turquoise-flat-button"></form>
			</div>
		</div>
		
		<div id="hideshow" style="visibility: hidden;">
		    <div id="fade"></div> 
	    	<div class="popup_block">
	    		<div class="popup">
			    	<div id="boite_1_ajout">Nouvelle séance</div>
					<div id="boite_2_ajout">
						<form id="ajout">
						    <fieldset id="inputs_ajout">
						    	<label>Matière</label></br>
						        <input class="input" type=text list=matiere >
									<datalist id=matiere >
										<c:forEach var="matiere" items="${matieres}">
						  				 	<option> ${matiere.nom_Matiere}
						  				 </c:forEach>
						  			</datalist></br>
								 <label>Date : </label></br>
						        <input class="input" id="date" type="date" placeholder="date" required></br>
						        <label>Heure de début : </label></br>
						        <input class="input" id="mail" type="time" placeholder="prenom.nom@hei.fr" required></br>
						        <label>Heure de fin : </label></br>
						        <input class="input" id="password" type="time" placeholder="Mot de passe" required></br>
						        <label>Commentaires</label>
						        <textarea rows="8" cols="50"></textarea>
						    </fieldset>
						    
						    <fieldset id="ajout">
						        <input class="input" type="submit" id="submit" value="Valider"> 
						    </fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
	</body>