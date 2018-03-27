<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Dodaj dziecko</title>

<link type="text/css" rel="stylesheet" href="/css/add-parent-style.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>

	<div id="container">
		<h3>Podaj dane rodzica</h3>
		<form:form action="saveParent" modelAttribute="parent" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Nazwisko: </label></td>
						<td><form:input path="surname" /> <form:errors
								path="surname" class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Imię: </label></td>
						<td><form:input path="name" /> <form:errors path="name"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Numer telefonu: </label></td>
						<td><form:input path="telephoneNumber" /> <form:errors
								path="telephoneNumber" class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /> <form:errors path="email"
								class="errorInputValidation" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Zapisz" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>


	</div>

	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>


</body>
</html>