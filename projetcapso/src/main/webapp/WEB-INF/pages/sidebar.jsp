<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside >
	<div class="sidebar close" >
		<p id="chevron">&gt</p>
		<div class="sidebar open">
		<img id="img_side" alt="" src="img/photo_profil/cedric.jpg">
		<div id="identite_side">
			<H2 class ="info_profil">${sessionScope.sessionEleve.prenom_Eleve}</H2>
			<H2 class ="info_profil">${sessionScope.sessionEleve.nom_Eleve}</H2>
		</div>
		
		<div id="groupe_side">
			<ul>
				<li class="li_sidebar"><a  class="cal_group" href="">Personnel</a></li>
				<c:forEach var="groupe" items="${groupes}">
					<li class="li_sidebar"><a  class="cal_group" href="">${groupe.nom_Groupe }</a></li>
				</c:forEach>
			</ul>
		</div>
		<p id="chevron">&lt</p>
	</div>
	</div>
</aside>