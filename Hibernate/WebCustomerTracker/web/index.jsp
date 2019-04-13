<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <%-- reference style sheet --%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <title>Main Menu Page</title>

  </head>
  <body>
  <div id="wrapper">
    <div id="header">
      <h2>Main Menu Page</h2>
    </div>
  </div>

  <h4>Press button to see CRM Page</h4>
    <input type="button" value="Goto Page"
           onclick="window.location.href='customer/list';return false"
           class="add-button"/>
  </body>
</html>
