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
			<h2>Panel administracyjny /dzieci/</h2>

			<h2>Nazwisko dziecka: ${tempChil.surname}</h2>


		</div>

		<div id="container">
			<div id="content">
				<table>
					<thead>
						<tr>
							<th>Nazwisko</th>
							<th>Imię</th>
							<th>Numer telefonu</th>
							<th>Email</th>
						</tr>
					</thead>
<%-- 					<c:forEach var="tempChild" items="${child}"> --%>
<!-- 						<tr> -->
<%-- 							<td>${tempChild.surname}</td> --%>
<%-- 							<td>${tempChild.name}</td> --%>
<%-- 							<td>${tempChild.name}</td> --%>
<%-- 							<td>${tempChild.name}</td> --%>
<!-- 						</tr> -->

<%-- 					</c:forEach> --%>

				</table>
			
			</div>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>
</body>
</html>