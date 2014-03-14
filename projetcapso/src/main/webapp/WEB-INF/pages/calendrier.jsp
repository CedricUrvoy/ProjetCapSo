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
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		
		<!--FullCalendar Dependencies-->
		<link href='fullcalendar/fullcalendar.css' rel='stylesheet' />
		<link href='fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	
		<!--jQuery-->
		<script src='js/jquery.min.js'></script>
		<script src='js/jquery-ui.custom.min.js'></script>
		
		<!--FullCalendar-->
		<script src='fullcalendar/fullcalendar.js'></script>
		<script src="js/calendar.js"></script>
		<style type="text/css">
			#calendar
			{
				width: 900px;
				margin: 0 auto;
			}
		</style>
		
	</head>

	<body>
		<jsp:include page="header.jsp" />
		<h1 class="titre">Calendrier - Nom du groupe</h1>
		<!--FullCalendar container div-->
		<div id='calendar'></div>
	</body>