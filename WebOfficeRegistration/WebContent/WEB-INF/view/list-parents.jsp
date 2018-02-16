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
			<h2>Panel administracyjny /rodzice/</h2>
		</div>
	</div>

	<input type="button" value="Dodaj rodzica"
		onclick="window.location.href='showFormForAddParent'; return false;"
		class="add-button" />

	<input type="button" value="Lista dzieci"
		onclick="window.location.href='listChildren'; return false;"
		class="add-button" />

	<input type="button" value="Lista wizyt"
		onclick="window.location.href='listVisits'; return false;"
		class="add-button" />

	<input type="button" value="Menu"
		onclick="window.location.href='../home'; return false;"
		class="add-button" />



	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Numer telefonu</th>
						<th>Email</th>
						<th>Operacje</th>
					</tr>
				</thead>
				<c:forEach var="tempParent" items="${parents}" varStatus="status">

					<c:url var="updateLink" value="/admin/showFormForUpdateParent">
						<c:param name="parentId" value="${tempParent.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/admin/deleteParent">
						<c:param name="parentId" value="${tempParent.id}"></c:param>
					</c:url>
					<c:url var="childForParentLink" value="/admin/showChildForParent">
						<c:param name="parentId" value="${tempParent.id}"></c:param>
					</c:url>


					<tr>
						<td>${status.count}.</td>
						<td>${tempParent.surname }</td>
						<td>${tempParent.name }</td>
						<td>${tempParent.telephoneNumber }</td>
						<td>${tempParent.email }</td>
						<td><a href="${updateLink}">Popraw</a> | <a
							href="${deleteLink}"
							onclick="return confirm('Czy napewno usunąć wybrane dane ?')">Usuń</a>
							| <a href="${childForParentLink}">Dzieci</a></td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a> |
	<a href="${pageContext.request.contextPath}/admin/listVisits">Powrót
		do listy wizyt</a>

</body>
</html>
