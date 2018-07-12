<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Error</title>
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Aplikacja do rejestracji klientów poradni</h2>
		</div>
	</div>
	<H3>Zły format danych zapytania.(400 Bad request)</H3>
	<p>${exception.getMessage()}</p>
	<a href="${pageContext.request.contextPath}/">Powrót do menu</a>

</body>
</html>
