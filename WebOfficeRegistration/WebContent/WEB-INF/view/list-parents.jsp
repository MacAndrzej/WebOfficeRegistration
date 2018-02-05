<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Admin-Rodzice</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>
	<input type="button" value="Dodaj rodzica"
		onclick="window.location.href='showFormForAddParent'; return false;"
		class="add-button" />

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Nazwisko</th>
					<th>Imię</th>
					<th>Numer telefonu</th>
					<th>Email</th>
					<th>Operacje</th>
				</tr>
				<c:forEach var="tempParent" items="${parents}">

					<c:url var="updateLink" value="/admin/showFormForUpdateParent">
						<c:param name="parentId" value="${tempParent.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/admin/deleteParent">
						<c:param name="parentId" value="${tempParent.id}"></c:param>
					</c:url>


					<tr>
						<td>${tempParent.surname }</td>
						<td>${tempParent.name }</td>
						<td>${tempParent.telephoneNumber }</td>
						<td>${tempParent.email }</td>
						<td><a href="${updateLink}">Popraw</a> | <a
							href="${deleteLink}" onclick="return confirm('Czy napewno usunąć wybrane dane ?')">Usuń</a></td>
					</tr>
				</c:forEach>


			</table>

		</div>

	</div>

</body>
</html>
