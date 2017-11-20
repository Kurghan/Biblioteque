<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/utilisateurs.css'/>"/>
<title>Utilisateurs</title>
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
		<div class="groupBoutonsUsers">
			<a href="<c:url value='/displayListUsers'/>"><input type="button" value="Afficher liste" class="btnUsers"></a><br> <br>
			<a href="<c:url value='/displayAddUser'/>"><input type="button" value="Nouveau" class="btnUsers"></a><br><br> 
			<form action ="<c:url value='/deleteUser'/>" method="get" id="form">
			<input type="submit" value="Effacer" class="btnUsers"> 
			<input type="text" id="txtName" name="txtName"></form><br>
			<form action ="<c:url value='/displayModifyUser'/>" method="get" id="form">
			<br> <input type="submit" value="Modifier" class="btnUsers">
			<input type="text" id="txtName1" name="txtName1"></form><br><br>
			<br> <input type="button" value="Historique" class="btnUsers"><br>
			<br> <input type="button" value="Emprunter" class="btnUsers"><br>
			<br>
		</div>
		<div id="resultatRecherche">
		<div id=rechercheInListe>Liste
		<input type="text" id=inputRechercheInListe>
		</div>
					
			<table class="listeUsers">
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Telephone</th>
					<th>N°abonné</th>
					<th id="checkVide"></th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.nom}</td>
						<td>${user.prenom}</td>
						<td>0${user.numTelephone}</td>
						<td>${user.numeroAbonne}</td>
						<td><input onchange="getNum('${user.numeroAbonne}')" type="radio"	name="rdAuthor" id="rdAuthor"></td>
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
		<script type="text/javascript" src="<c:url value ='/javaScript/utilisateurs.js'/>"/></script>
</body>
</html>