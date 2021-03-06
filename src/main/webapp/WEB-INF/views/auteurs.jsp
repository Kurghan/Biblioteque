<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/auteurs.css'/>" />
<title>Auteurs</title>
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
			<a href="<c:url value='/displayListAuthor'/>"><input
				type="button" value="Afficher liste" class="btnUsers"></a><br>
			<br> <a href="<c:url value='/addAuthor'/>"><input
				type="button" value="Nouveau" class="btnUsers"></a><br> <br>
			<form action="<c:url value='/deleteAuthor'/>" method="get">
			<input type="submit" value="Effacer" class="btnUsers"><br>
			<input type="text" id="txtName" name="txtName">
			</form>
			<br> <input type="button" value="Modifier" class="btnUsers"><br>
			<br>
		</div>
		<div id="resultatRecherche">
			<div id=rechercheInListe>
				Liste <input type="text" id=inputRechercheInListe>
			</div>
			<table class="listeAuteur">
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date de naissance</th>
					<th id="checkVide"></th>
				</tr>
				<c:forEach var="author" items="${authors}">
					<tr>
						<td>${author.nom}</td>
						<td>${author.prenom}</td>
						<td>${author.dateNaissance}</td>
						<td><input onchange="getName('${author.nom}')" type="radio"	name="rdAuthor" id="rdAuthor"></td>
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
	<script type="text/javascript" src="<c:url value ='/javaScript/auteurs.js'/>"/></script>
</body>
</html>