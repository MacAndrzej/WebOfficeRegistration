<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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




	<div id="container">
		<div id="content">
			

			<table>
				<thead>
					<tr>
					</tr>
					<tr>
						<th>Lp.</th>
						<th>Nazwisko dziecka</th>
						<th>Imię dziecka</th>
						<th>Nazwisko rodzica/opiekuna</th>
						<th>Imię rodzica/opiekuna</th>
					</tr>
				</thead>

				<c:forEach var="tempChild" items="${child}" varStatus="status">
					<tr>
						<td>${status.count}.</td>
						<td><c:out value="${tempChild.getSurname()}" /></td>
						<td><c:out value="${tempChild.getName()}" /></td>
						<td><c:out value="${parent.surname}" /></td>
						<td><c:out value="${parent.name}" /></td>
					</tr>
				</c:forEach>


			</table>

		</div>
	</div>
	<a href="${pageContext.request.contextPath }/admin/listParents">Powrót
		do listy rodziców</a>
</body>
</html>