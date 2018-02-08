<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<h2>Panel administracyjny /dzieci/</h2>
		</div>
	</div>

	<input type="button" value="Dodaj dziecko"
		onclick="window.location.href='showFormForAddChild'; return false;"
		class="add-button" />


	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Data urodzenia</th>
						<th>Operacje</th>
					</tr>
				</thead>
				
				<c:forEach var="tempChild" items="${children}" varStatus="status">

					<c:url var="updateLink" value="/admin/showFormForUpdateChild">
						<c:param name="childId" value="${tempChild.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/admin/deleteChild">
						<c:param name="childId" value="${tempChild.id}"></c:param>
					</c:url>
					<c:url var="parentForChildLink" value="/admin/showParentForChild">
						<c:param name="childId" value="${tempChild.id}"></c:param>
					</c:url>


					<tr>
						<td>${status.count}.</td>
						<td>${tempChild.surname}</td>
						<td>${tempChild.name}</td>
						<td><fmt:formatDate value="${tempChild.dateOfBirth}" pattern="dd-MM-yyyy"/></td>
						<td><a href="${updateLink}">Popraw</a>|<a
							href="${deleteLink}"
							onclick="return confirm('Czy napewno chcesz nieodwracalnie usunąć dane dziecka ?')">Usuń</a>|<a
							href="${parentForChildLink}">Rodzic</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>

	</div>
	<a href="${pageContext.request.contextPath}/admin/listParents">Powrót
		do listy rodziców</a>


</body>
</html>