

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
	
	var idGroupe = 0;
	var nomGroupe='Personnel';
	$("#groupe_"+idGroupe).addClass("active");
	
	$("ul#listeGroupes").on("click",".cal_group", function() {
		
		calendar.fullCalendar( 'removeEventSource','calendrierPerso');
		idGroupe = this.id.substring(7);
		
		if(idGroupe!=0){
			nomGroupe = this.innerHTML;
			$("#rejoindre").val("Rejoindre");
			$("#rejoindre").attr('name', "REJOINDRESEANCE");
		}else{
			nomGroupe='Personnel';
			$("#rejoindre").val("Quitter");
			$("#rejoindre").attr('name', "QUITTERSEANCE");
		}

		calendar.fullCalendar( 'addEventSource', {
				url: 'calendrierPerso',
   				type:"GET",
   				data: {idGroupe:idGroupe},
   				success: function(data) {console.log(data);return data;}});
		$("#titreCalendrier").html('Calendrier - '+nomGroupe);
		
		for (var int = 0; int < 100; int++) {
			$("#groupe_"+int).removeClass("active");
		}
		$("#groupe_"+idGroupe).addClass("active");
		
		
	});
		
	
	
	/***** Creation du calendrier *****/
	
	var calendar = $('#calendar').fullCalendar(
	{

		header:
		{
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},

		defaultView: 'agendaWeek',
		
		height: 600,
		
		
		/**** Gestion de l'ajout d'un event automatique ****/
		
		
		/*
			selectable:true will enable user to select datetime slot
			selectHelper will add helpers for selectable.
		*/
		selectable: false,
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
		
		
		/**** Pour editer les evenements ****/
		
		editable: false,

		/**** Recupere les evenements du calendrier perso ****/
		
		events: {
			url: 'calendrierPerso',
	        type:"GET",
	        data: {idGroupe:0},
	        success: function(data) {console.log(data);return data;}
		},
		
		/**** Infos sur l'evenement ****/
		
	    eventClick: function(event) {
	    	
	    	$("div.seance").attr('id', event.id);
	    	$("#info_matiere").html(event.title);
	    	$("#info_dateStart").html(event.start.format("dddd Do MMMM "));
	    	$("#start").html(event.start.format(" HH:mm"));
	    	$("#end").html(event.end.format(" HH:mm"));
	    	$("#place").html(event.place);
	    	$("#infos").html(event.infos);
	    	showDiv('detailSeance');
	    	
	    }
		
		
	});
	

});