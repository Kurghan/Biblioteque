<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/accueil.css'/>"/>
<title>accueil</title>
</head>
<body><fieldset id="general">
	<div class="groupBoutons">
		<a href="<c:url value='/accueil'/>"><input type="button" value="Accueil" class="btn"></a><br>
		<br> <a href="<c:url value='/recherche'/>"><input type="button" value="Recherche" class="btn"></a><br>
		<br> <a href="<c:url value='/livres'/>"><input type="button" value="Livres" class="btn"></a><br>
		<br> <a href="<c:url value='/utilisateurs'/>"><input type="button" value="utilisateur" class="btn"></a><br>
		<br> <a href="<c:url value='/auteurs'/>"><input type="button" value="Auteurs" class="btn"></a><br>
		<br>
	</div>
	<div id="imageAccueil"></div>
		<fieldset id="RRapide">
			<legend class="legend">Recherche rapide</legend>
			<p id=recherchePar> par :</p>
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
</body>
</html>