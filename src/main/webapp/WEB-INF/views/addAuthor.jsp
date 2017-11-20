<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/addAuthor.css'/>" />
<title>Ajout d'un auteur</title>
</head>
<body>
	<fieldset id="general">
		<form action="<c:url value='/validateAddAuthor'/>" method="get"
			id="formAddBook">
			<label class=lbl>Nom :</label> <input type="text" class=input name="nom"><br>
			<label class=lbl>Prenom :</label> <input type="text" class=input name="prenom"><br><br>
			<label class=lbl>Date de naissance :</label><input type="text" name="dateNaissance" id="" class="calendrier" size="20" autocomplete ="off" /><br>
			<div class=grpButtons>
				<div id="btnReturn">
					<a href="<c:url value='/auteurs'/>"><input type="button"
						value="Retour" class="btn"></a>
				</div>
				<div id="btnAdd">
					<a href="<c:url value='/auteurs'/>"><input type="submit"
						value="Ajouter" class="btn"></a>
				</div>
			</div>
		</form>
	</fieldset>
	<script type="text/javascript" src="<c:url value ='/javaScript/calendrier.js'/>" /></script>
</body>

</html>