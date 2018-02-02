<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Child Registration Form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h2>Formularz rejestracyjny Gabinetu Terapii</h2>
<h3>Rejestracja dziecka w systemie</h3>
	<i>Proszę wypełnij formularz. Wypełnienie pól oznaczonych (*) jest
		niezbędne.</i>
	<hr>
	<form:form action="processFormChild" modelAttribute="child">
Nazwisko(*):<form:input path="surname" />
		<form:errors path="surname" cssClass="error" />
		<br>
		<br>
Imię(*):<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br>
		<br>
Data urodzenia:<form:input path="dateOfBirth" cssClass="error" />	
		<br>
		<br>
		<input type="submit" value="Akceptuj" />
	</form:form>
	<hr>
<a href="/">Powrót do strony głównej</a>
	
</body>
</html>