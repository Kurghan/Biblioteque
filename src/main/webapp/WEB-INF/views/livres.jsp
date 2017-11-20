<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/livres.css'/>" />
<title>Livres</title>
</head>
<body>
	<fieldset id="general">
		<div class="groupBoutons">
			<a href="<c:url value='/accueil'/>"><input type="button"
				value="Accueil" class="btn"></a><br> <br> <a
				href="<c:url value='/recherche'/>"><input type="button"
				value="Recherche" class="btn"></a><br> <br> <a
				href="<c:url value='/livres'/>"><input type="button"
				value="Livres" class="btn"></a><br> <br> <a
				href="<c:url value='/utilisateurs'/>"><input type="button"
				value="utilisateur" class="btn"></a><br> <br> <a
				href="<c:url value='/auteurs'/>"><input type="button"
				value="Auteurs" class="btn"></a><br> <br>
		</div>
		<div class="groupBoutonsUsers">
			<a href="<c:url value='/displayListBook'/>"><input type="button" value="Afficher liste" class="btnUsers"></a>
			<br> <br>
			<a href="<c:url value='/addBook'/>"><input type="button" value="Nouveau" class="btnUsers"></a><br><br>
			<form action="<c:url value='/deleteBook'/>" method="get">
			<input type="submit" value="Effacer" class="btnUsers">
			<br><br>
			<input type="text" id="txtId" name="txtId">
			</form>
			<a href="<c:url value='/modifyBook'/>"><input type="button" value="Modifier" class="btnUsers"></a><br>
			<br> 
			<input type="button" value="Emprunteurs" class="btnUsers"><br>
			<br>
		</div>
		<div id="resultatRecherche">
			<div id=rechercheInListe>
				Liste <input type="text" id=inputRechercheInListe>
			</div>
			<table class="listeLivres">
				<tr>
					<th>ISBN</th>
					<th>Titre</th>
					<th>Auteur</th>
					<th id="checkVide"></th>
				</tr>
				<c:forEach var="livre" items="${Livres}">
					<tr>
						<td id="idISBN">${livre.ISBN}</td>
						<td>${livre.titre}</td>
						<td>${livre.auteur}</td>
						<td><input onchange="getId(${livre.ISBN})" type="radio" name="rdBook" id="rdBook"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<fieldset id="RRapide">
			<legend class="legend">Recherche rapide</legend>
			<p id=recherchePar>par :</p>
			<SELECT name="nom" size="1" id="listeRRapide">
				<OPTION>Titre
				<OPTION>Auteur
				<OPTION>Utilisateur
			</SELECT><br> <input type="text" id="inputRechercheRapide">
		</fieldset>
		<br>
		<fieldset id="resultatRRapide">
			<legend class="legend">resultat Recherche rapide</legend>
		</fieldset>
	</fieldset>
	<script type="text/javascript" src="<c:url value ='/javaScript/livre.js'/>"/></script>
</body>
</html>