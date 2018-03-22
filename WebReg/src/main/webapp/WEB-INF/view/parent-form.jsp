<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Dodaj rodzica</title>

<link type="text/css" rel="stylesheet" href="/css/add-parent-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz dane Rodzica</h3>
		<form:form action="saveParent" modelAttribute="parents" method="POST">
			<form:hidden path="id" />

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

		<a href="${pageContext.request.contextPath}/admin/listParents">Powrót
			do listy rodziców</a>


	</div>




	<!-- <h2>Formularz rejestracyjny Gabinetu Terapii</h2> -->
	<!-- <h3>Rejestracja rodzica w systemie</h3> -->
	<!-- 	<i>Proszę wypełnij formularz. Wypełnienie pól oznaczonych (*) jest -->
	<!-- 		niezbędne.</i> -->
	<!-- 	<hr> -->
	<%-- 	<form:form action="processFormParent" modelAttribute="parent"> --%>
	<%-- Nazwisko(*):<form:input path="surname" /> --%>
	<%-- 		<form:errors path="surname" cssClass="error" /> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<%-- Imię(*):<form:input path="name" /> --%>
	<%-- 		<form:errors path="name" cssClass="error" /> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<%-- Numer telefonu:<form:input path="telephoneNumber" cssClass="error" /> --%>
	<%-- 		<form:errors path="telephoneNumber" cssClass="error" /> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<%-- Adres email(*):<form:input path="email" /> --%>
	<%-- 		<form:errors path="email" cssClass="error" /> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<!-- Czy chcesz przesyłania powiadomień o zaplanowanej wizycie na email? -->
	<%-- Tak<form:radiobutton path="alert" value="true" /> --%>
	<%-- Nie<form:radiobutton path="alert" value="false" /> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<!-- 		<input type="submit" value="Akceptuj" /> -->
	<%-- 	</form:form> --%>
	<!-- 	<hr> -->
	<!-- <a href="/">Powrót do strony głównej</a> -->

</body>
</html>