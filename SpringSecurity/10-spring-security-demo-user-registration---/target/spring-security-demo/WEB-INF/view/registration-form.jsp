<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <br>
    <!-- Password -->
    <form:password path="password" placeholder="password" class="form-control" />
    <br>
    <!-- Password -->
    <form:password path="matchingPassword" placeholder="password" class="form-control" />
    <br>
    <!-- First Name -->
    <form:input path="firstName" placeholder= "first name" class="form-control" />
    <br>
    <!-- Last Name -->
    <form:input path="lastName" placeholder= "last name" class="form-control" />
    <br>
    <!-- Email -->
    <form:input path="email" placeholder= "email" class="form-control" />
    <br>
    <button type="submit" class="btn btn-primary">Register</button>
</form:form>
</body>
</html>
