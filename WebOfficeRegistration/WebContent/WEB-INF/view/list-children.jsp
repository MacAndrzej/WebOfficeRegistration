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

	<input type="button" value="Dodaj dziecko"
		onclick="window.location.href='showFormForAddChild'; return false;"
		class="add-button" />


	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Data urodzenia</th>
						<th>Operacje</th>
					</tr>
				</thead>
				<c:forEach var="tempChild" items="${children}">
				<c:url var="updateLink" value="/admin/showFormForUpdateChild">
				<c:param name="childId" value="${tempChild.id}"></c:param>
				</c:url>
					<tr>
						<td>${tempChild.surname}</td>
						<td>${tempChild.name}</td>
						<td>${tempChild.dateOfBirth}</td>
						<td><a href="${updateLink}">Popraw</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>

	</div>



</body>
</html>