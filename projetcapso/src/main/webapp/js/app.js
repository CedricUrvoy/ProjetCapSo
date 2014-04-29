function hideDiv() { 
    if (document.getElementById) { // DOM3 = IE5, NS6 
        document.getElementById('ajoutSeance').style.visibility = 'hidden'; 
    } else { 
        if (document.layers) { // Netscape 4 
            document.hideshow.visibility = 'hidden'; 
        } else { // IE 4 
            document.all.hideshow.style.visibility = 'hidden'; 
        } 
    } 
}
 
function showDiv() { 
    if (document.getElementById) { // DOM3 = IE5, NS6 
        document.getElementById('ajoutSeance').style.visibility = 'visible'; 
    } else { 
        if (document.layers) { // Netscape 4 
            document.hideshow.visibility = 'visible'; 
        } else { // IE 4 
            document.all.hideshow.style.visibility = 'visible'; 
        } 
    } 
}

function showDiv2() { 
    if (document.getElementById) { // DOM3 = IE5, NS6 
        document.getElementById('detailSeance').style.visibility = 'visible'; 
    } else { 
        if (document.layers) { // Netscape 4 
            document.hideshow.visibility = 'visible'; 
        } else { // IE 4 
            document.all.hideshow.style.visibility = 'visible'; 
        } 
    } 
}

function hideDiv2() { 
    if (document.getElementById) { // DOM3 = IE5, NS6 
        document.getElementById('detailSeance').style.visibility = 'hidden'; 
    } else { 
        if (document.layers) { // Netscape 4 
            document.hideshow.visibility = 'hidden'; 
        } else { // IE 4 
            document.all.hideshow.style.visibility = 'hidden'; 
        } 
    } 
}

function doAct(bouton)
{
if (bouton.name=="VALIDER" )
{
     document.DForm.action="";
     document.DForm.submit();
}
else if (bouton.name=="ANNULER" )
{
     document.DForm.action="javascript:hideDiv()";
     document.DForm.submit();
}
else if (bouton.name=="ANNULER2" )
{
     document.DForm2.action="javascript:hideDiv2()";
     document.DForm2.submit();
}
else if (bouton.name=="REJOINDRE" )
{
     document.DForm2.action="";
     document.DForm2.submit();
}
}

