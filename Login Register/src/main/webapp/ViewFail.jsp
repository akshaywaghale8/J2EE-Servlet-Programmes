<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Users Failed</title>
</head>
<body>
    <h1>Failed to View Users</h1>
    <%
        ArrayList<String> viewUsers = (ArrayList<String>) request.getAttribute("viewUsers");
        if (viewUsers == null) 
        {
    %>
        <p>The viewUsers object is null.</p>
    <%
        } else {
    %>
        <p>The viewUsers object is not null, but it is empty:</p>
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