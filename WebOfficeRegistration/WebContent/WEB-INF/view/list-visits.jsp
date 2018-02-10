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

	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Numer identyfikacyjny wizyty</th>
						<th>Termin wizyty</th>
						<th>Aktualność wizyty</th>
						<th>Termin przeniesionej wizyty</th>
						<th>Klient nie pojawił się i nie odwołał wizyty</th>
					</tr>
					<c:forEach var="tempVisit" items="${visits}" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${tempVisit.id }</td>
							<td>${tempVisit.termOfVisitPlanned }</td>
							<td><c:if test="${tempVisit.termOfVisitCancelled==true }">Odwołana</c:if>
								<c:if test="${tempVisit.termOfVisitCancelled==false }">Aktualna</c:if>
							</td>
							<td>${tempVisit.termOfVisitChanged }</td>
							<td><c:if test="${tempVisit.absence=true}">Nie pojawił się</c:if>
								<c:if test="${tempVisit.absence=false}">Odwołał</c:if></td>
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