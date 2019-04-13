<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Menu</title>
</head>
<body>
    <h3>Student System - Main Menu Page</h3>
    <br>
    <img src="${pageContext.request.contextPath}/resources/images/testimage.png">
    <br>
    <form action="showForm">
        <input type="submit" value="Go to registration page." />
    </form>
</body>
</html>
