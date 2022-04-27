    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@ include file = "menu.jsp" %>
 <%--   <p>Bonjour ${ !empty name ? name : '' }</p>
        <p>${ noms[1] }</p>
        
        <p>Bonjour ${ auteur.prenom } ${ auteur.nom }</p>
        <p>${ auteur.actif ? 'Vous êtes très actif !' : 'Vous êtes inactif !' }</p>
        
         <c:set var="pseudo" value="Thierno" scope="page" />
         
         <p><c:out value="${ pseudo }">Valeur par défaut</c:out></p>
         
         <c:set target="${ auteur }" property="prenom" value="MAME THIERNO" />
         <p><c:out value="${ auteur.prenom }" /></p>
         
         <c:remove var="pseudo" scope="page" />
         
         <c:if test="${ 50 > 10 }" var="variable">
           C'est vrai !
         </c:if>
         
         <c:choose>
		    <c:when test="${ variable }">Du texte</c:when>
		    <c:when test="${ autreVariable }">Du texte</c:when>
		    <c:when test="${ encoreUneAutreVariable }">Du texte</c:when>
		    <c:otherwise></c:otherwise>
          </c:choose>
          
          <c:forEach var="i" begin="0" end="5" step="2">
		       <p>Un message n°<c:out value="${ i }" /> !</p>
	      </c:forEach>
	      
	      <c:forEach items="${ titres }" var="titre" varStatus="status">
             <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
          </c:forEach>
          
          <c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/ ">
             <p>${ morceau }</p>
          </c:forTokens>      --%>
          
       <%--    <c:if test="${ !empty form.resultat }"><p><c:out value="${ form.resultat }" /></p></c:if> --%>
          
<!--           <form method="post" action="bonjour">
            <p>
                <label for="login">Login : </label>
                <input type="text" name="login" id="login" />
            </p>
            <p>
                <label for="pass">Mot de passe : </label>
                 <input type="password" name="pass" id="pass" />
            </p>
            
            <input type="submit" />
          </form> -->
          
<%--           <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
          <form method="post" action="bonjour" enctype="multipart/form-data">
             <p>
               <label for="description">Description du fichier : </label>
               <input type="text" name="description" id="description" />
             </p>
             <p>
                <label for="fichier">Fichier à envoyer : </label>
                <input type="file" name="fichier" id="fichier" />
             </p>
             
             <input type="submit" />
           </form> --%>
           
            <form method="post" action="bonjour">
		      <p>
		          <label for="nom">Nom : </label>
		          <input type="text" name="nom" id="nom" />
		      </p>
		      <p>
		          <label for="prenom">Prénom : </label>
		          <input type="text" name="prenom" id="prenom" />
		      </p>
		      
		      <input type="submit" />
            </form>
    
		    <ul>
		        <c:forEach var="utilisateur" items="${ utilisateurs }">
		            <li><c:out value="${ utilisateur.prenom }" /> <c:out value="${ utilisateur.nom }" /></li>
		        </c:forEach>
		    </ul>    
         
  
</body>
</html>