<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="pageSelectionnee" value="blog" scope="request"></c:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Article</title>
		<meta name="***********" content="******" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/header-style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" >
		<jsp:param name="pageSelectionnee" value="article"/>
		</jsp:include>
		
		<h1 class="titre">Article</h1>
		<article class = "article_uni">			
			<h1 class="titre_art">${article.titre}</h1>
			<div class = "image">
				<img alt="" src="">
				<p class="legende"> Publié le < fmt:formatDate value="${article.date_Article}" pattern="dd MMMM yyyy"/></p>
			</div>
			<div class = "text-art">
				<p class="text">${article.texte}</p>
			</div>
			
			
		</article>
		<div class="commentaires" id="commentaires">
				<div class="bloc-commentaire">
				  <p> Commentaires</p>	
				</div>
				<ul id="listeCommentaires">
						<li class="commentaire">
							<h4 class="nom">vieonvoernvebn jvnef</h4>
							<h4>c,kslncv,kdlnvkfld</h4>
							<p>nfjzk,slkc,qmsl</p>
						</li>
				</ul>
			</div>
			<div class="bloc-commentaire">
				  <p> Ajouter un commentaire</p>	
			</div>
			<form  id="formCommentaire" method="post">
	            <fieldset> 
	                <textarea class="ajoutCommentaire"  name="text" id="text" rows="10" cols="50" required placeholder="Message"></textarea>
	            	<div id="${article.id}" class="divBoutonCommentaire">
                    	<input class="boutonCommentaire" type="button" value="Envoyer"/>
		            </div>
	            </fieldset>
		    </form>
		
	</body>