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




	<div id="container">

		<div id="content">
			<c:out
				value="Rodzic: ${parent.surname} ${parent.name}, dane dziecka: " />

			<table>
				<thead>
					<tr>
					</tr>
					<tr>
						<th>Nazwisko</th>
						<th>Imię</th>
					</tr>
				</thead>

				<c:forEach var="parent" items="${theParent.getChildren() }">
					<tr>
						<td>${parent.surname}</td>
						<td>${parent.name}></td>
					</tr>
				</c:forEach>
				

			</table>
		</div>
	</div>
	<a href="${pageContext.request.contextPath }/admin/listParents">Powrót
		do listy rodziców</a>
</body>
</html>