<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Dodaj dziecko</title>

<link type="text/css" rel="stylesheet" href="/css/add-parent-style.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Panel administracyjny</h2>
		</div>
	</div>


	<!-- Registration Form -->
	<form:form
		action="${pageContext.request.contextPath}/register/processRegistrationForm"
		modelAttribute="crmUser" class="form-horizontal">
		<!-- Check for registration error -->
		<c:if test="${registrationError != null}">
			<div class="alert alert-danger col-xs-offset-1 col-xs-10">
				${registrationError}</div>
		</c:if>
…
<!-- User name -->
		<form:input path="userName" placeholder="username"
			class="form-control" />
		<!-- Password -->
		<form:password path="password" placeholder="password"
			class="form-control" />
		<button type="submit" class="btn btn-primary">Register</button>
	</form:form>




	<!-- 	<div id="container"> -->
	<!-- 		<h3>Podaj dane rodzica</h3> -->
	<%-- 		<form:form action="saveComposite" modelAttribute="composite" --%>
	<%-- 			method="POST"> --%>

	<!-- 			<table> -->
	<!-- 				<tbody> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Nazwisko: </label></td> -->
	<%-- 						<td><form:input path="parent.surname" /> <form:errors --%>
	<%-- 								path="parent.surname" class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Imię: </label></td> -->
	<%-- 						<td><form:input path="parent.name" /> <form:errors path="parent.name" --%>
	<%-- 								class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Numer telefonu: </label></td> -->
	<%-- 						<td><form:input path="parent.telephoneNumber" /> <form:errors --%>
	<%-- 								path="parent.telephoneNumber" class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Email: </label></td> -->
	<%-- 						<td><form:input path="parent.email" /> <form:errors path="parent.email" --%>
	<%-- 								class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->

	<!-- 				</tbody> -->
	<!-- 			</table> -->


	<!-- 		<h3>Podaj dane dziecka</h3> -->

	<!-- 			<table> -->
	<!-- 				<tbody> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Nazwisko:</label></td> -->
	<%-- 						<td><form:input path="child.surname" /> <form:errors --%>
	<%-- 								path="child.surname" class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Imię:</label></td> -->
	<%-- 						<td><form:input path="child.name" /> <form:errors path="child.name" --%>
	<%-- 								class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label>Data urodzenia:</label></td> -->
	<%-- 						<td><form:input type="date" path="child.dateOfBirth" /> <form:errors --%>
	<%-- 								path="child.dateOfBirth" class="errorInputValidation" /></td> --%>
	<!-- 					</tr> -->
	<!-- 					<tr> -->
	<!-- 						<td><label></label></td> -->
	<!-- 						<td><input type="submit" value="Zapisz" class="save" /></td> -->
	<!-- 					</tr> -->
	<!-- 				</tbody> -->
	<!-- 			</table> -->
	<%-- 		</form:form> --%>


	</div>

	<a href="${pageContext.request.contextPath}/admin/listChildren">Powrót
		do listy dzieci</a>


</body>
</html>