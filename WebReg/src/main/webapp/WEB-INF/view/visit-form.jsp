<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
<link type="text/css" rel="stylesheet" href="/css/add-parent-style.css">
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
		<div id="content">
			<h3>Zapisz wizytę</h3>
			<form:form action="saveVisit" modelAttribute="visits" method="POST">
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>Termin wizyty: </label></td>
							<td><form:input type="date" path="dateOfVisitPlanned" /> <form:errors
									path="dateOfVisitPlanned" class="errorInputValidation" /></td>
						</tr>
						<tr>
							<td><label>Godzina wizyty: </label></td>
							<td><form:input type="time" path="timeOfVisitPlanned" /> <form:errors
									path="timeOfVisitPlanned" class="errorInputValidation" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Zapisz" class="save" /></td>
						</tr>
					<tbody>
				</table>

			</form:form>
		</div>
	</div>
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/admin/listVisits">Powrót
			do listy wizyt</a>
	</security:authorize>





</body>
</html>