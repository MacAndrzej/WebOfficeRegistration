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
			<h2>Panel administracyjny /wizyty/</h2>
		</div>
	</div>

	<input type="button" value="Dodaj wizytę"
		onclick="window.location.href='showFormForAddVisit'; return false;"
		class="add-button" />

	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Numer identyfikacyjny wizyty</th>
						<th>Termin wizyty</th>
						<th>Aktualność wizyty</th>
						<th>Wizytę przeniesiono na termin</th>
						<th>Kiedy wykonano zmianę terminu wizyty</th>
						<th>Klient nie pojawił się i nie odwołał wizyty</th>
						<th>Operacje</th>
					</tr>

					<c:forEach var="tempVisit" items="${visits}" varStatus="status">

						<c:url var="updateLink" value="/admin/showFormForUpdateVisit">
							<c:param name="visitId" value="${tempVisit.id }"></c:param>
						</c:url>

						<tr>
							<td>${status.count }</td>
							<td>${tempVisit.id }</td>
							<td>${tempVisit.dateOfVisitPlanned}</td>
							<td><c:if test="${tempVisit.termOfVisitCancelled==true }">Odwołana</c:if>
								<c:if test="${tempVisit.termOfVisitCancelled==false }">Aktualna</c:if>
							</td>
							<td><fmt:formatDate value="${tempVisit.dateOfVisitChanged }"
									type="both" dateStyle="short" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${tempVisit.termOfModification}"
									type="both" dateStyle="short" 
									pattern="yyyy-MM-dd" /></td>
							<td><c:if test="${tempVisit.absence=true}">Nie pojawił się</c:if>
								<c:if test="${tempVisit.absence=false}">Odwołał</c:if></td>
							<td><a href="${updateLink}">Popraw</a></td>
						</tr>

					</c:forEach>
				</thead>
			</table>
		</div>
	</div>



	<a href="${pageContext.request.contextPath}/admin/listParents">Powrót
		do listy rodziców</a> |
	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>
</body>
</html>