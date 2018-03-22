<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>Parent Confirmation Form</title>

</head>
<body>
	Potwierdzenie rejestracji rodzica: ${parent.surname} ${parent.name }. <br>
	Dane kontaktowe - numer telefonu: ${parent.telephoneNumber}, adres email: ${parent.email}.<br>
	Zgoda na powiadomienia przez email o zaplanowanych wizytach: 
	<c:if test="${parent.alert=='true'}">
	wybrano.
	</c:if>
	<c:if test="${parent.alert=='false'}">
	nie wybrano.
	</c:if>
	
</body>
</html>