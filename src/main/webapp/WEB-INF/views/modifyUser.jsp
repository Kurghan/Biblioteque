<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/modifyUser.css'/>" />
<title>Modification d'un utilisateur</title>
</head>
<body>
	<fieldset id="general">
		<form action="<c:url value='/validateModifyUser'/>" method="get"
			id="formAddBook">
			<label class=lbl>Nom :</label> <input type="text" class=input name="nom" value=<c:out value="${user.nom}"/>><br>
			<label class=lbl>Prenom :</label> <input type="text" class=input name="prenom" value="${user.prenom}"><br><br>
			<label class=lbl>Numero de téléphone :</label><input type="text" name="numeroTelephone" value="${user.numTelephone}" id="" class="calendrier" size="20" autocomplete ="off" /><br>
			<div class=grpButtons>
				<div id="btnReturn">
					<a href="<c:url value='/utilisateurs'/>"><input type="button"
						value="Retour" class="btn"></a>
				</div>
				<div id="btnAdd">
					<a href="<c:url value='/utilisateurs'/>"><input type="submit"
						value="Modifier" class="btn"></a>
				</div>
			</div>
		</form>
	</fieldset>
</body>

</html>