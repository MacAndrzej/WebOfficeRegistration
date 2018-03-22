<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Main menu</title>
<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Serwis dla użytkowników zalogowanych</h2>
		</div>
	</div>
	<hr>
	<div>
		Witaj:
		<security:authentication property="principal.username" />
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input class="add-button" type="submit" value="Wyloguj">
		</form:form>
		<hr>
	</div>


	<a href="${pageContext.request.contextPath}/about">O nas</a> |

	<a href="${pageContext.request.contextPath}/certificates">Certyfikaty</a>|

	<a href="${pageContext.request.contextPath}/contact">Kontakt</a> |

	<a href="${pageContext.request.contextPath}/about">Pokaż wizytę</a> |

	<a href="${pageContext.request.contextPath}/about">Zaplanuj wizytę</a>
	|

	<a href="${pageContext.request.contextPath}/about">Zmień wizytę</a> |

	<a href="${pageContext.request.contextPath}/contact">Ustawienia</a> 
	<security:authorize access="hasRole('ADMIN')">
		| <a href="${pageContext.request.contextPath}/admin/listVisits">Administracja</a>

	</security:authorize>
</body>
</html>