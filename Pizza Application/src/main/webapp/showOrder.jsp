<%@ page import="com.akshu.pizzaApplication.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order Summary</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
        }
        
        h1 {
            text-align: center;
            color: Black;
        }
        
        table {
            width: 80%;
            margin: 0 auto;
           
            background-color: #fff;
            box-shadow: 1 1 20px rgba(0, 0, 0, 0.1);
            
             border : 2px solid black;
        }
        div {
            width: 50%;
            margin: 0 auto;
            align : left;
           
            background-color: #fff;
            box-shadow: 1 1 20px rgba(0, 0, 0, 0.1);
            
             border : 2px solid black;
        }
        
        th, td 
        {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            border : 1px solid black;
        }
        
        
        
        tr:nth-child(even) {
            background-color: #e6e6e6;
        }
        tr:nth-child(odd) 
        {
            background-color: white;
        }
        
        tr:hover 
        {
            background-color: aqua;
        }
    </style>
</head>
<body>
<div>
    <h1>Your Order...</h1>
    <table>
        <tr>
            <th style = "font-weight: bold;" >Parameter Name</th>
            <th style = "font-weight: bold;">Parameter Value</th>
        </tr>
        <%
            UserBean ub = (UserBean) request.getAttribute("userBean");
        %>
        <tr>
            <th>Submit</th>
            <th>Order Pizza</th>
        </tr>
        <tr>
            <th>Address</th>
            <th><%=ub.getAddress()%></th>
        </tr>
        <tr>
            <th>Name</th>
            <th><%=ub.getName()%></th>
        </tr>
        <tr>
            <th>Appetizer</th>
            <th><%=ub.getAppetizer()%></th>
        </tr>
        <tr>
            <th>Card Type</th>
            <th><%=ub.getCardType()%></th>
        </tr>
        <tr>
            <th>Crust</th>
            <th><%=ub.getCrust()%></th>
        </tr>
        <tr>
            <th>Card Number</th>
            <th><%=ub.getCardNumber()%></th>
        </tr>
        <tr>
            <th>Toppings</th>
            <th>
                <%
                    for (String value : ub.getToppings()) {
                %>
                    <%= value %><br>
                <%
                    }
                %>
            </th>
        </tr>
    </table>
    <br>
    </div>
</body>
</html>