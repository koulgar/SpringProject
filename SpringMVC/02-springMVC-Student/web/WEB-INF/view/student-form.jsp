<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName"/>
        <br><br>
        Last name: <form:input path="lastName"/>
        <br><br>
        Country: <form:select path="country">
        <form:options items="${countryOptions}"/>
        </form:select>
        <br><br>
        Favorite Language: <br>
        <form:radiobuttons path="favoriteLanguage" items="${favoriteLanguage}"/>
        <br><br>
        Operating Systems:
        <form:checkboxes path="operatingSystem" items="${operatingSystem}"/>
        <br><br>
<%--        Java <form:radiobutton path="favoriteLanguage" value="Java"/>--%>
<%--        C# <form:radiobutton path="favoriteLanguage" value="C#"/>--%>
<%--        PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>--%>
<%--        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>--%>
<%--        <form:option value="Turkey" label="Turkey"/>--%>
<%--        <form:option value="France" label="France"/>--%>
<%--        <form:option value="German" label="Germany"/>--%>
<%--        <form:option value="India" label="India"/>--%>
        <br><br>
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>