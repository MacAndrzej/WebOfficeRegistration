<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Panel-Rodzice</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>PRM - Parent Relationship Manager</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Nazwisko |</th>
					<th>Imię |</th>
					<th>Numer telefonu |</th>
					<th>Email</th>
				</tr>
				<c:forEach var="tempParents" items="${parents }">
					<tr>
						<td>${tempParents.surname }</td>
						<td>${tempParents.name }</td>
						<td>${tempParents.telephoneNumber }</td>
						<td>${tempParents.email }</td>
					</tr>
				</c:forEach>


			</table>

		</div>

	</div>

</body>
</html>
