<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pageSelectionnee" value="blog" scope="request"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>NeedaRide</title>
		<meta name="description" content="WebSite Ski/FixedGear/Kyte" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="js/needaride.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp" />
		<figure class = bloc-img>
			<img src="img/blog/pres/ArticleBlog.jpg" alt="Blog" title="Blog"/>
			<figcaption>${article.nameCategorie}</figcaption>
		</figure>
		<div class="contenu">
			<article class="article">
					<aside class="bloc-date" id="bloc-date">
			           <p><fmt:formatDate value="${article.date}" pattern="dd MMMM yyyy"/></p>
			        </aside>
			        <div class="articleText">
			            <h3>${article.title}</h3>
			            <div class="bloc-infos-article">
				        	<p class="infosAuthor"> By : <a href="cedpilou">${article.nameAuthor}</a></p>
				        	<p class="infosCategorie">Categorie : <a href="ski">${article.nameCategorie}</a></p>
				        	<p><a href="#commentaires">[${article.nbrCommentaire}] Commentaires	</a></p>
				        	<a href="http://www.facebook.com"><img src="img/blog/divers/PartagerFacebook.png" alt="facebook" title="facebook"/></a>
							<a href="http://www.twitter.com"><img src="img/blog/divers/PartagerTwitter.png" alt="twitter" title="twiter"/></a>		
			       		 </div>
			            <img id="imageArticle" src="${article.image}" alt="${article.title}" title="${article.title}"/>
			            <div class="text">
				            <p>${article.description}</p>
			            </div>
			        </div> 
			</article>
			<div class="commentaires" id="commentaires">
				<div class="bloc-commentaire">
				  <p> Commentaires</p>	
				</div>
				<ul id="listeCommentaires">
					<c:forEach var="commentaire" items="${commentaires}">
						<li class="commentaire">
							<h4 class="nom">${commentaire.name} </h4>
							<h4>(${commentaire.email})  :</h4>
							<p> ${commentaire.text}</p>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="bloc-commentaire">
				  <p> Ajouter un commentaire</p>	
			</div>
			<form  id="formCommentaire" method="post">
	            <fieldset> 
	            	<input  class="ajoutCommentaire" type="email" name="email" id="email" required placeholder="  Email" />
	             	<input  class="ajoutCommentaire" type="text" name="name" id="name" required placeholder="  Nom" />
	                <textarea class="ajoutCommentaire"  name="text" id="text" rows="10" cols="50" required placeholder="Message"></textarea>
	            	<div class="ajoutComment" id="${article.id}">
                    	<input id="boutonEnvoyer" type="button" value="Envoyer"/>
		            </div>
	            </fieldset>
		    </form>
		</div>
		<jsp:include page="sidebar.jsp" />
	</body>
</html>