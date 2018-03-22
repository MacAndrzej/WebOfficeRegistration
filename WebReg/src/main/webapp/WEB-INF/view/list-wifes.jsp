<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Lp.</th>
				<th>Nazwisko</th>
				<th>Imię</th>
			</tr>
		</thead>

		<c:forEach var="tempWife" items="${wifes }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${tempWife.name }</td>
				<td>${tempWife.surname }</td>
				<td></td>

			</tr>


		</c:forEach>
	</table>
</body>
</html>