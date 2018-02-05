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
			<h2>Panel administracyjny</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Nazwisko</th>
					<th>Imię</th>
					<th>Data urodzenia</th>
					<th>Operacje</th>
				</tr>
			</table>
		</div>
		
	</div>
</body>
</html>