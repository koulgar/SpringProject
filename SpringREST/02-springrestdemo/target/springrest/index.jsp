<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Spring REST Demo</h2>
    <hr>
    <a href="${pageContext.request.contextPath}test/hello">Go to Hello Page.</a>
    <hr>
    <a href="${pageContext.request.contextPath}api/students">Go to Students Page.</a>
    <hr>
</body>
</html>
