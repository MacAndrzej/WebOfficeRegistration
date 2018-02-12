<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Dodaj dziecko</title>
<style>
.error {
	color: red;
}
</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-parent-style.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz dane Dziecka</h3>
		<form:form action="saveChild" modelAttribute="children" method="POST">
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Nazwisko:</label></td>
						<td><form:input path="surname"  /></td>
					</tr>
					<tr>
						<td><label>Imię:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><label>Data urodzenia:</label></td>
						<td><form:input type="date" path="dateOfBirth"  /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Zapisz" class="save" /></td>
					</tr><tbody>
			</table>

		</form:form>
	</div>

	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>


</body>
</html>