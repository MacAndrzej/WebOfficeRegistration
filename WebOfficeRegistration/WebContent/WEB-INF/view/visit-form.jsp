<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Dodaj wizytę</title>
<style>
.error {
	color: red;
}
</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-parent-style.css">
<script
	src="${pageContext.request.contextPath }/resources/javascript/data-z-formularza-input.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz wizytę</h3>
		<form:form action="saveVisit" modelAttribute="visits" method="POST">

			<fmt:formatDate value="${tempVisit.dateOfVisitPlanned}"
				dateStyle="short" pattern="dd.MM.yyyy" />
			<table>
				<tbody>
					<tr>
						<td><label>Termin wizyty: </label></td>
						<td><form:input path="dateOfVisitPlanned" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Zapisz" class="save" /></td>
					</tr>
				<tbody>
			</table>

		</form:form>
	</div>

	<a href="${pageContext.request.contextPath}/admin/listVisits">Powrót
		do listy wizyt</a>


</body>
</html>