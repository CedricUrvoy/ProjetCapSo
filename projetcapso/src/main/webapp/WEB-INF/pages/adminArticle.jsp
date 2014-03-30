<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="blog" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Ajouter un article</title>
		<meta name="Blog" content="Blog" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" />
			
		<h1 class="titre">Ajouter un article</h1>
		<article class = "article">			
			<h1 class="titre_art">Titre de l'article :
			<input size="100" type="text" id="name" placeholder="Titre de l'article " />
			</h1>
			<div class = "image">
				<img alt="" src="">
			</div>
			<div class = "text-art">
				<h1 class="titre_art">Texte de l'article :
			
			</h1>
				<textarea placeholder=" Entrer ici le texte de l'article " rows="5" cols="80"></textarea>
			<div class="suite_valider">Valider</div>
			</div>
			
		</article>
		
	</body>