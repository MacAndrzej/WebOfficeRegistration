<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Access denied</title>
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h3>Przepraszamy ale nie posiadasz wystarczających uprawnień do wykonania tej operacji.</h3>
	<a href="${pageContext.request.contextPath}/home">Powrót do menu</a>
</body>
</html>