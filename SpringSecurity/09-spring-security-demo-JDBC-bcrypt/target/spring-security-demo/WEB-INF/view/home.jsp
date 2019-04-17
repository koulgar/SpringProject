<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	Welcome to company home page!
	<p>
		User : <security:authentication property="principal.username"/>
		<br>
		<br>
		Role : <security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasRole('MANAGER')">
	<hr>
		<!-- Add a link to point to /leaders.. this is for the Manager -->
	<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
	(Only for Manager peeps.)
	<hr>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<hr>
	<!-- Add a link to point to /systems.. this is for the Admins -->
	<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
	(Only for Admin peeps.)
	<hr>
	</security:authorize>


	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>

</body>

</html>