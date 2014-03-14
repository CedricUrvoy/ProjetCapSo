<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>******</title>
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
		<script src='fullcalendar/fullcalendar.min.js'></script>
		<script type="text/javascript">
		
			/*
				jQuery document ready
			*/
			
			$(document).ready(function()
			{
				/*
					date store today date.
					d store today date.
					m store current month.
					y store current year.
				*/
				var date = new Date();
				var d = date.getDate();
				var m = date.getMonth();
				var y = date.getFullYear();
				
				/*
					Initialize fullCalendar and store into variable.
					Why in variable?
					Because doing so we can use it inside other function.
					In order to modify its option later.
				*/
				
				var calendar = $('#calendar').fullCalendar(
				{
					/*
						header option will define our calendar header.
						left define what will be at left position in calendar
						center define what will be at center position in calendar
						right define what will be at right position in calendar
					*/
					header:
					{
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					/*
						defaultView option used to define which view to show by default,
						for example we have used agendaWeek.
					*/
					defaultView: 'agendaWeek',
					/*
						selectable:true will enable user to select datetime slot
						selectHelper will add helpers for selectable.
					*/
					selectable: true,
					selectHelper: true,
					/*
						when user select timeslot this option code will execute.
						It has three arguments. Start,end and allDay.
						Start means starting time of event.
						End means ending time of event.
						allDay means if events is for entire day or not.
					*/
					select: function(start, end, allDay)
					{
						/*
							after selection user will be promted for enter title for event.
						*/
						var title = prompt('Event Title:');
						/*
							if title is enterd calendar will add title and event into fullCalendar.
						*/
						if (title)
						{
							calendar.fullCalendar('renderEvent',
								{
									title: title,
									start: start,
									end: end,
									allDay: allDay
								},
								true // make the event "stick"
							);
						}
						calendar.fullCalendar('unselect');
					},
					/*
						editable: true allow user to edit events.
					*/
					editable: true,
					/*
						events is the main option for calendar.
						for demo we have added predefined events in json object.
					*/
					events: [
						{
							title: 'All Day Event',
							start: new Date(y, m, 1)
						},
						{
							title: 'Long Event',
							start: new Date(y, m, d-5),
							end: new Date(y, m, d-2)
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: new Date(y, m, d-3, 16, 0),
							allDay: false
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: new Date(y, m, d+4, 16, 0),
							allDay: false
						},
						{
							title: 'Meeting',
							start: new Date(y, m, d, 10, 30),
							allDay: false
						},
						{
							title: 'Lunch',
							start: new Date(y, m, d, 12, 0),
							end: new Date(y, m, d, 14, 0),
							allDay: false
						},
						{
							title: 'Birthday Party',
							start: new Date(y, m, d+1, 19, 0),
							end: new Date(y, m, d+1, 22, 30),
							allDay: false
						},
						{
							title: 'Click for Google',
							start: new Date(y, m, 28),
							end: new Date(y, m, 29),
							url: 'http://google.com/'
						}
					]
				});
				
			});
	
		</script>
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
		<div id='calendar'></div>>
	</body>