<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/addBook.css'/>" />
<title>Modification d'un livre</title>
</head>
<body>
	<fieldset id="general">
		<form action="<c:url value='/validateModifyBook'/>" method="get"
			id="formAddBook">
			<label class=lbl>ISBN :</label> <input type="text" class=input
				name="ISBN"><br> <label class=lbl>Titre :</label> <input
				type="text" class=input name="titre"><br> <label
				class=lbl>Sous-titre :</label> <input type="text" class=input
				name="sousTitre"><br> <label class=lbl>Auteur :</label>
			<input type="text" class=input name="Auteur" value="${auteur}"
				id=auteur readonly><input type="button" value="Auteurs"
				id="btnAuthors" ><br> <label class=lbl>Nb
				Exemplaires :</label> <input type="text" class=input name="nbExemplaires">
			<div class=grpButtons>
				<div id="btnReturn">
					<a href="<c:url value='/livres'/>"><input type="button"
						value="Retour" class="btn"></a>
				</div>
				<div id="btnAdd">
					<a href="<c:url value='/livres'/>"><input type="submit"
						value="Ajouter" class="btn"></a>
				</div>
			</div>
		</form>
		<!-- Trigger/Open The Modal -->

		<!-- The Modal -->
		<div id="myModal" class="modal">

			<!-- Modal content -->
			<div class="modal-content">

				<fieldset id="general-modal">
					<span class="close">&times;</span>
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
									<td><input onchange="getName('${author.nom}','${author.prenom}')"
										type="radio" name="rdAuthor" id="rdAuthor" ></td>
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
						<div id="btnAdd">
							<input type="button"
								value="Ajouter" onclick="addAuthor()" class="btn" id="btnAdd-modal">
							<input type="text" id="txtName" name="txtName">
						</div>
				</fieldset>
			</div>
		</div>
	</fieldset>
	<script type="text/javascript"
		src="<c:url value ='/javaScript/addBook.js'/>" /></script>
</body>
</html>