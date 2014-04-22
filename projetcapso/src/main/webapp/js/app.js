function hideDiv() { 
    if (document.getElementById) { // DOM3 = IE5, NS6 
        document.getElementById('hideshow').style.visibility = 'hidden'; 
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
        document.getElementById('hideshow').style.visibility = 'visible'; 
    } else { 
        if (document.layers) { // Netscape 4 
            document.hideshow.visibility = 'visible'; 
        } else { // IE 4 
            document.all.hideshow.style.visibility = 'visible'; 
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
else
{
     alert("Ouais, mais là, faut cliquer sur un bouton\nSinon, je sais pas ce que tu veux pauvre nain !" );
}
}