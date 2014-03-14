<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageSelectionnee" value="calendrier" scope="request"></c:set>
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
		<jsp:include page="header.jsp" />
		
		
		<h1 class="titre">Article</h1>
		<article class = "article_uni">			
			<h1 class="titre_art">Titre de l'article</h1>
			<div class = "image">
				<img alt="" src="">
				<p class="legende"> Publié le 21/02/2014</p>
			</div>
			<div class = "text-art">
				<p class="text">"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
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