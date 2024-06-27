<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Users Successful</title>
</head>
<body>
    <h1>Users List</h1>
    <%
        ArrayList<String> viewUsers = (ArrayList<String>) request.getAttribute("viewUsers");
        if (viewUsers != null && !viewUsers.isEmpty()) 
        {
    %>
        <ul>
            <%
                for (String user : viewUsers) {
            %>
                <li><%= user %></li>
            <%
                }
            %>
        </ul>
     <%
            }
      %>
  <br>
    <a href="index.html">Home</a>
</body>
</html>