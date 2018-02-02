<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Parent Registration Form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h2>Formularz rejestracyjny Gabinetu Terapii</h2>
<h3>Rejestracja rodzica w systemie</h3>
	<i>Proszę wypełnij formularz. Wypełnienie pól oznaczonych (*) jest
		niezbędne.</i>
	<hr>
	<form:form action="processFormParent" modelAttribute="parent">
Nazwisko(*):<form:input path="surname" />
		<form:errors path="surname" cssClass="error" />
		<br>
		<br>
Imię(*):<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br>
		<br>
Numer telefonu:<form:input path="telephoneNumber" cssClass="error" />
		<form:errors path="telephoneNumber" cssClass="error" />
		<br>
		<br>
Adres email(*):<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br>
		<br>
Czy chcesz przesyłania powiadomień o zaplanowanej wizycie na email?
Tak<form:radiobutton path="alert" value="true" />
Nie<form:radiobutton path="alert" value="false" />
		<br>
		<br>
		<input type="submit" value="Akceptuj" />
	</form:form>
	<hr>
<a href="/">Powrót do strony głównej</a>

</body>
</html>