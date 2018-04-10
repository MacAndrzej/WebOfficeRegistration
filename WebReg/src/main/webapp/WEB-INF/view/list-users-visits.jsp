<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Admin-Rodzice</title>
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel użytkownika /wizyty/</h2>
		</div>
	</div>

	<input type="button" value="Menu"
		onclick="window.location.href='../loggedUser/'; return false;"
		class="add-button" />

	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Nazwisko, imię (dziecka)</th>
						<th>Data wizyty</th>
						<th>Godzina wizyty</th>
						<th>Aktualność wizyty</th>
						<th>Operacje</th>
					</tr>
				</thead>
				<c:forEach var="tempVisit" items="${visits}" varStatus="status">
					<c:url var="updateLink" value="/loggedUser/showFormForUpdateVisit">
						<c:param name="visitId" value="${tempVisit.id }"></c:param>
					</c:url>
					<tr>
						<td>${status.count }.</td>
						<td>${tempVisit.child.getSurname() }&nbsp
							${tempVisit.child.getName() }</td>
						<td>${tempVisit.dateOfVisitPlanned}</td>
						<td>${tempVisit.timeOfVisitPlanned}</td>
						<td><c:if test="${tempVisit.termOfVisitCancelled==true }">Odwołana</c:if>
							<c:if test="${tempVisit.termOfVisitCancelled==false }">Aktualna</c:if>
						</td>
						<td><a href="${updateLink}">Popraw</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>