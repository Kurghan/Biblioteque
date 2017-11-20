<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/listeAuteurs.css'/>" />
<title>Liste des Auteurs</title>
</head>
<body>
	<fieldset id="general">
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
						<td id="idISBN">${author.nom}</td>
						<td>${author.prenom}</td>
						<td>${author.dateNaissance}</td>
						<td><input onchange="getName('${author.nom}')" type="radio"
							name="rdAuthor" id="rdAuthor"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="btnReturn">
			<a href="<c:url value='/addBook'/>"><input type="button"
				value="Retour" class="btn"></a>
		</div>
		<div id="btnCreatAuthor">
			<a href="<c:url value='/addAuthor'/>"><input type="button"
				value="Nouveau" class="btn" id=btnCreatAuteur></a>
		</div>
		<form action="<c:url value='/selectedAuthor'/>" method="get" target="addBook.jsp">
			<div id="btnAdd">
				<a href="<c:url value=''/>"><input type="submit" value="Ajouter" onclick=""
					class="btn"></a> <input type="text" id="txtName" name="txtName">
			</div>
		</form>
	</fieldset>
	<script type="text/javascript" src="<c:url value ='/javaScript/listeAuteurs.js'/>" /></script>
</body>
</html>