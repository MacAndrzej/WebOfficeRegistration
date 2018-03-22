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


		</div>
	</div>




	<div id="container">

		<div id="content">
			<c:out
				value="Dziecko: ${child.surname} ${child.name}, dane rodzica: " />

			<table>
				<thead>
					<tr>
						<th>Lp.</th>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Numer telefonu</th>
						<th>Email</th>
					</tr>
				</thead>



				<tr>
					<td>1.</td>
					<td><c:out value="${child.getParent().getSurname() }" /></td>
					<td><c:out value="${child.getParent().getName() }" /></td>
					<td><c:out value="${child.getParent().getTelephoneNumber() }" /></td>
					<td><c:out value="${child.getParent().getEmail() }" /></td>
				</tr>



			</table>

		</div>

	</div>
	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>
</body>
</html>