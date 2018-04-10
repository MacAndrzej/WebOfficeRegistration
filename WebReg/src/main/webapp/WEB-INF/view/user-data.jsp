<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>About</title>
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel użytkownika</h2>
		</div>
	</div>
	<input type="button" value="Menu"
		onclick="window.location.href='../loggedUser/'; return false;"
		class="add-button" />
	<H2>Dane użytkownika</H2>
	<div>
		<table>
			<tr>
				<td>Nazwisko:</td>
				<td>${user.surname }</td>
			</tr>
			<tr>
				<td>Imię:</td>
				<td>${user.name }</td>
			</tr>
			<tr>
				<td>Numer telefonu:</td>
				<td>${user.telephoneNumber }</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${user.email }</td>
			</tr>
		</table>
	</div>
</body>
</html>
