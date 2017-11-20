<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/recherche.css'/>"/>
<title>Recherche</title>
</head>
<body>
	<fieldset id="general">
		<div class="groupBoutons">
		<a href="<c:url value='/accueil'/>"><input type="button" value="Accueil" class="btn"></a><br>
		<br> <a href="<c:url value='/recherche'/>"><input type="button" value="Recherche" class="btn"></a><br>
		<br> <a href="<c:url value='/livres'/>"><input type="button" value="Livres" class="btn"></a><br>
		<br> <a href="<c:url value='/utilisateurs'/>"><input type="button" value="utilisateur" class="btn"></a><br>
		<br> <a href="<c:url value='/auteurs'/>"><input type="button" value="Auteurs" class="btn"></a><br>
		<br>
		</div>
		<div id="blocRecherche">
			<div id=blocTxtRecherche>
				<p id=txtISBN>ISBN :</p>
				<p id=txtTitre>Titre :</p>
				<p id=txtSousTitre>Sous-titre :</p>
				<p id=txtAuteur>Auteur :</p>
			</div>
			<div id=blocTextRecherche>
				<SELECT name="nom" size="1" id="listeRecherche">
					<OPTION>Livre 
					<OPTION>Emprunteur
					<OPTION>Auteur
				</SELECT>
				<input type="text" class="textRecherche">
				<input type="text" class="textRecherche"> 
				<input type="text" class="textRecherche">
				<input type="text" class="textRecherche">
				<input type="button" value="Rechercher" id="btnRechercher">
			</div>
			
		</div>
		<div id="resultatRecherche"></div>
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
</body>
</html>