var div;
function hideDiv(){
    div.style.visibility = 'hidden';
}
 
function showDiv(hideshow) {
    div = document.getElementById(hideshow);
    div.style.visibility = 'visible';
}



function doAct(bouton)
{
	//POP UP AJOUTER SEANCE
if (bouton.name=="VALIDER" )
{     
	
    document.DForm.action="creerSeance";
    document.DForm.submit();
}
else if (bouton.name=="ANNULER" )
{
     document.DForm.action="javascript:hideDiv()";
     document.DForm.submit();
}

	//POP UP DETAILS SEANCE
else if (bouton.name=="ANNULER2" )
{
     document.DForm2.action="javascript:hideDiv()";
     $("#eleves").html("");
     document.DForm2.submit();
}
else if (bouton.name=="REJOINDRESEANCE" )
{
	var id = $('div.seance').attr('id');
	console.log(id);
	document.DForm2.action="rejoindreseance?idSeance="+id;
     document.DForm2.submit();
}
else if (bouton.name=="QUITTERSEANCE" )
{
	var id = $('div.seance').attr('id');
	console.log(id);
	document.DForm2.action="quitterseance?idSeance="+id;
    document.DForm2.submit();
}


	//AFFICHAGE POP UP CREER GROUPE
else if (bouton.name=="CREER" )
{
     document.DFormModifGroupe.action="javascript:showDiv('creerGroupe')";
     document.DFormModifGroupe.submit();
}
else if (bouton.name=="VALIDERAJOUTGROUPE" )
{
     document.DFormNG.action="ajoutgroupe";
     document.DFormNG.submit();
}
else if (bouton.name=="ANNULERAJOUT" )
{
     document.DFormNG.action="javascript:hideDiv()";
     document.DFormNG.submit();
}
	//AFFICHAGE POP UP QUITTER SEANCE
else if (bouton.name=="QUITTER" )
{
     document.DFormModifGroupe.action="javascript:showDiv('quitterGroupe')";
     document.DFormModifGroupe.submit();
}
else if (bouton.name=="QUITTERGROUPE" )
{
     document.DFormQG.action="quittergroupe";
     document.DFormQG.submit();
}
else if (bouton.name=="ANNULERQUITTER" )
{
     document.DFormQG.action="javascript:hideDiv()";
     document.DFormQG.submit();
}
	//AFFICHAGE POP UP REJOINDRE SEANCE
else if (bouton.name=="REJOINDREGROUPE" )
{
     document.DFormModifGroupe.action="javascript:showDiv('rejoindreGroupe')";
     document.DFormModifGroupe.submit();
}

else if (bouton.name=="REJOINDREOK" )
{
     document.DFormRG.action="rejoindregroupe";
     document.DFormRG.submit();
}
else if (bouton.name=="ANNULERREJOINDRE" )
{
	 eteindre();
     document.DFormRG.action="javascript:hideDiv()";
     document.DFormRG.submit();
}

// AFFICHAGE POP UP AJOUTER CALENDRIER

else if (bouton.name=="AJOUTERCALENDRIER" )
{
     document.DFormModifGroupe.action="javascript:showDiv('ajouterCalendrier')";
     document.DFormModifGroupe.submit();
}
else if (bouton.name=="VALIDERCALENDRIER" )
{
     document.DFormAC.action="ajoutCalendrier";
     document.DFormAC.submit();
}
else if (bouton.name=="ANNULERAJOUTERCALENDRIER" )
{
     document.DFormAC.action="javascript:hideDiv()";
     document.DFormAC.submit();
}


//CHANGER DE MOT DE PASSE
else if (bouton.name=="MDP" )
{
	
     document.DFCmdp.action="javascript:showDiv('changermdp')";
     document.DFCmdp.submit();
}
else if (bouton.name=="CHANGER" )
{
	 
     document.DFormCMDP.action="changermdp";
     document.DFormCMDP.submit();
}
else if (bouton.name=="ANNULERCHANGER" )
{
	
     document.DFormCMDP.action="javascript:hideDiv()";
     document.DFormCMDP.submit();
}
//AJOUTER UNE MATIERE
else if (bouton.name=="AJOUTMATIERE" )
{
	
    document.DFormAdmin.action="javascript:showDiv('ajoutmatiere')";
    document.DFormAdmin.submit();
}
else if (bouton.name=="AJOUTER" )
{
     document.DFormAM.action="ajoutmatiere";
     document.DFormAM.submit();
}
else if (bouton.name=="ANNULERAJOUTM" )
{
	 
     document.DFormAM.action="javascript:hideDiv()";
     document.DFormAM.submit();
}
}


//FORMULAIRE REJOINDRE GROUPE

function afficher(input)
{
    document.getElementById(input).style.display = "block";
}
function eteindre()
{
    document.getElementById('openclasse').style.display = "none";
    document.getElementById('opendomaine').style.display = "none";
    document.getElementById('openpromo').style.display = "none";
    document.getElementById('openautre').style.display = "none";
}


//Pour l'instant ne sert pas 
function erreurGroupe(erreur)
{
if(erreur==true)
	{
	window.alert("Ce groupe est deja créé");
	}
}

function afficherListeMembres(div)
{
	var divContenu = div.getElementsByTagName('div')[0];
    if(divContenu.style.display == 'none') {
        divContenu.style.display = 'block';
    } else {
        divContenu.style.display = 'none';
    }
}
