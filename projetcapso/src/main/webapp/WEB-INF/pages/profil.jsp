<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Profil</title>
		<meta name="votre profil" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" />
		
		
		<h1 class = "titre">Profil</h1>
		<div class="profil">
			<div id=nom>
				<H2 class ="info_profil">Marie</H2>
				<H2 class ="info_profil">Fievet</H2>
			</div>
		<div id="groupe">
			<h1 class="titre">Groupes</h1>
			<div id="liste-=_groupe">
				<h2 class="groupe_perso">Classe : H44</h2>
				<h2 class="groupe_perso">Domaine : ITI</h2>
				<h2 id="autre_groupe">Autres groupes</h2>
				<h2 class="groupe_perso">Marqueting</h2>
				<h2 class="groupe_perso">Projet Piste</h2>
				<h2 class="groupe_perso">Dev WEB</h2>
			</div>
			
		</div>

		</div>
	</body>