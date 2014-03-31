<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="blog" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Blog</title>
		<meta name="Blog" content="Blog" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" />
		
		<h1 class="titre">Blog</h1>
		
		<c:forEach var="article" items="${articles}">
		
		<article class = "article">			
			<h1 class="titre_art">${article.titre}</h1>
			<div class = "image">
				<img alt="" src="${article.image}"/>
				<p class="legende"> Publié le 21/02/2014</p>
				<p class="legende">[ ] Commentaire(s)</p>
			</div>
			<div class = "text-art">
				<p class="text">${article.texte}</p>
			
			<div class="suite">Suite de l'article</div>
			</div>
			
		</article>
		
		</c:forEach>
	</body>