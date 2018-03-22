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
			<h2>Serwis klientów poradni</h2>
		</div>
	</div>
	


	<a href="${pageContext.request.contextPath}/about">O nas</a> |

	<a href="${pageContext.request.contextPath}/certificates">Certyfikaty</a>|

	<a href="${pageContext.request.contextPath}/contact">Kontakt</a> |

	<a href="register/showFormParent">Zarejestruj</a> |

	<a href="${pageContext.request.contextPath}/loggedUser">Zaloguj</a> 

	



</body>
</html>