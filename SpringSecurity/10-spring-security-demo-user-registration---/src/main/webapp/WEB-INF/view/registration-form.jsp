<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Koulgar
  Date: 16.04.2019
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Registration Form -->
<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="crmUser" class="form-horizontal">

    <!-- Check for registration error -->
    <c:if test="${registrationError != null}">
        <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                ${registrationError}
        </div>
    </c:if>

    <!-- User name -->
    <form:input path="userName" placeholder="username" class="form-control" />

    <!-- Password -->
    <form:password path="password" placeholder="password" class="form-control" />

    <!-- First Name -->
    <form:input path="firstName" placeholder= "first name" class="form-control" />

    <button type="submit" class="btn btn-primary">Register</button>
</form:form>
</body>
</html>
