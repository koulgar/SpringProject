<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="customer">
        First name: <form:input type="text" maxlength="40" path="firstName"/>
        <br><br>
        Last name(*): <form:input path="lastName" maxlength="40"/>
        <form:errors path="lastName" cssClass="error"/>
        <br><br>
        Free passes: <form:input path="freePasses" maxlength="2"/>
        <form:errors path="freePasses" cssClass="error"/>
        <br><br>
        Postal code: <form:input path="postalCode" maxlength="5"/>
        <form:errors path="postalCode" cssClass="error"/>
        <br><br>
        Course code: <form:input path="courseCode" maxlength="8"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
