<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

            <%-- put new button: Add Customer --%>
        <input type="button" value="Add Customer"
                onclick="window.location.href='showFormForAdd';return false"
                class="add-button"/>
            <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="searchName" placeholder="empty search for customer list"/>
                <input type="submit" value="Search" class="add-button" />
            </form:form>
<br>
            <form:form action="replace" method="GET">
                Find email: <input type="text" name="findName"/>
                Replace replace: <input type="text" name="replaceName"/>
                <input type="submit" value="Replace" class="add-button"/>
            </form:form>


<div id="container">
    <div id="content">
            <%-- add our html table here --%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <%-- loop over and print our customer --%>
            <c:forEach var="tempCustomer" items="${customers}">
                <!-- construct and "update" button -->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <c:url var="deleteLink"  value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="${updateLink}">Update</a>
                    |
                        <a href="${deleteLink}"
                        onclick="return confirm('Are you sure you want to delete ${tempCustomer.firstName} ${tempCustomer.lastName}?')">Delete</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>
