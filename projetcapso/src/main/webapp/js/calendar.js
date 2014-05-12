

/*
	jQuery document ready
*/


$(document).ready(function()
{
	/* Date d'aujourd'hui */

	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
	
	/* Variable permettant de recuperer le groupe actuel */

	var idGroupe = 0;
	var nomGroupe='Personnel';
	$("#groupe_"+idGroupe).addClass("active");
	
	/* Variable permettant de recuperer le calendrier Google si celui a été ajouté */
	
	var calendrierGoogle = document.getElementById("calendrierGoogle");
	console.log(calendrierGoogle.innerHTML);
	
	
	/* Fonction permettant au click sur un groupe de changer la source des evenements
	 * afin  d'afficher le calendrier correspondant
	 */ 
	
	$("ul#listeGroupes").on("click",".cal_group", function() {
		
		calendar.fullCalendar( 'removeEventSource','affichageSeances');
		calendar.fullCalendar( 'removeEventSource', {
			url:calendrierGoogle.innerHTML});
		idGroupe = this.id.substring(7);
		
		if(idGroupe!=0){
			nomGroupe = this.innerHTML;
			$("#rejoindre").val("Rejoindre");
			$("#rejoindre").attr('name', "REJOINDRESEANCE");
		}else{
			nomGroupe='Personnel';
			$("#rejoindre").val("Quitter");
			$("#rejoindre").attr('name', "QUITTERSEANCE");
			
			calendar.fullCalendar( 'addEventSource', {
				url:calendrierGoogle.innerHTML,
				color:'#235383'});
		}
		calendar.fullCalendar( 'addEventSource', {
				url: 'affichageSeances',
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
		
		height: 500,
		
		
		
		
		/*
			selectHelper will add helpers for selectable.
		*/
		selectable: false, // Permet la selection d'une datetime sur le calendrier
		selectHelper: true, //Permet un affichage lors de la selection
		
		
		/*** Permet la recuperation des debut et fin de l'evenement lors d'une selection ***/
		
		select: function(start, end, allDay)
		{
			
			
			var title = prompt('Event Title:');

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
		
		eventSources: [
		    {
			url: 'affichageSeances',
	        type:"GET",
	        data: {idGroupe:0},
	        success: function(data) {console.log(data);return data;}
	        },
	        {
	        	url:calendrierGoogle.innerHTML,
	        	color:'#235383'
	        }
			],
		
		/**** Infos sur l'evenement ****/
		
	    eventClick: function(event) {
	    	
	    	$("div.seance").attr('id', event.id);
	    	$("#info_matiere").html(event.title);
	    	$("#info_dateStart").html(event.start.format("dddd Do MMMM "));
	    	$("#start").html(event.start.format(" HH:mm"));
	    	$("#end").html(event.end.format(" HH:mm"));
	    	$("#infosplace").html(event.place);
	    	$("#infos").html(event.infos);
	    	var idSeance = event.id;
	    	var eleves = new Array;
	    	$.ajax(
	    	{ 
	    		url:"elevesSeance", 
	    		type:"POST", 
	    		dataType:'json',
	    		data:{idSeance:idSeance},
	    		success:function(data){	
	    			eleves=data;
	    			console.log(eleves);
	    			for(var i=0;i<eleves.length;i++) 
	    			{
	  	    		  var obj = eleves[i];
	  	    		  $("#eleves").append("<p>"+obj.prenom_Eleve +" "+obj.nom_Eleve+"</p>");
	    			};
		    	}
	    	});
	    	showDiv('detailSeance');
	    	
	    }
	});
	

});