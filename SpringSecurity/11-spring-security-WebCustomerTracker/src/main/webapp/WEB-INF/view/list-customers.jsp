<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <%-- reference style sheet --%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <title>Customer List</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM-Customer Relationship Manager</h2>
    </div>
</div>
<br>
User : <security:authentication property="principal.username"/>
<br>
Role : <security:authentication property="principal.authorities"/>
<br>
<br>
<br>
            <%-- put new button: Add Customer --%>
        <security:authorize access="hasAnyRole('ADMIN')">
        <input type="button" value="Add Customer"
                onclick="window.location.href='showFormForAdd';return false"
                class="add-button"/>
            </security:authorize>
            <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="searchName" placeholder="empty search for customer list"/>
                <input type="submit" value="Search" class="add-button" />
            </form:form>
<br>
            <security:authorize access="hasAnyRole('ADMIN')">
            <form:form action="replace" method="GET">
                Find email: <input type="text" name="findName"/>
                Replace replace: <input type="text" name="replaceName"/>
                <input type="submit" value="Replace" class="add-button"/>
            </form:form>
            </security:authorize>

<div id="container">
    <div id="content">
            <%-- add our html table here --%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            <security:authorize access="hasAnyRole('ADMIN','MANAGER')">
            <th>Action</th>
            </security:authorize>
            </tr>
            <%-- loop over and print our customer --%>
            <c:forEach var="tempCustomer" items="${customers}">
                <!-- construct and "update" button -->
                <security:authorize access="hasAnyRole('ADMIN','MANAGER')">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                </security:authorize>
                <security:authorize access="hasAnyRole('ADMIN')">
                <c:url var="deleteLink"  value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                </security:authorize>
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <security:authorize access="hasAnyRole('ADMIN','MANAGER')">
                    <td><a href="${updateLink}">Update</a>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ADMIN')">
                    <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete ${tempCustomer.firstName} ${tempCustomer.lastName}?')">Delete</a></td>
                    </security:authorize>
                </tr>
            </c:forEach>

        </table>
    </div>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</div>

</body>
</html>
