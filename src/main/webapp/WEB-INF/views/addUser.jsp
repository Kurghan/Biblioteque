<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/addUser.css'/>" />
<title>Ajout d'un utilisateur</title>
</head>
<body>
	<fieldset id="general">
		<form action="<c:url value='/validateAddUser'/>" method="get"
			id="formAddBook">
			<label class=lbl>Nom :</label> <input type="text" class=input name="nom"><br>
			<label class=lbl>Prenom :</label> <input type="text" class=input name="prenom"><br><br>
			<label class=lbl>Numero de téléphone :</label><input type="text" name="numeroTelephone" id="" class="calendrier" size="20" autocomplete ="off" /><br>
			<div class=grpButtons>
				<div id="btnReturn">
					<a href="<c:url value='/utilisateurs'/>"><input type="button"
						value="Retour" class="btn"></a>
				</div>
				<div id="btnAdd">
					<a href="<c:url value='/utilisateurs'/>"><input type="submit"
						value="Ajouter" class="btn"></a>
				</div>
			</div>
		</form>
	</fieldset>
</body>

</html>