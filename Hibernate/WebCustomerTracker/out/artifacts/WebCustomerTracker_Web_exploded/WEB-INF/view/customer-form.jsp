<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
    <div id="wrapper">
      <div id="header">
        <h2>CRM-Customer Relationship Manager</h2>
      </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><Label>First Name:</Label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><Label>Last Name:</Label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><Label>Email:</Label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><Label></Label></td>
                    <td><input type="submit" value="save" class="add-button"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear;both;"></div>
        <p>
            <input type="button" value="Back to List"
                   onclick="window.location.href='/customer/list';return false"
                   class="add-button"/>
        </p>
    </div>

</body>
</html>
