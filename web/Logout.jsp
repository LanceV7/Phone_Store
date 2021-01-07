<%--
  Created by IntelliJ IDEA.
  User: dadea
  Date: 07/01/2021
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Logout</title>
</head>
<body>
<% session.invalidate(); %>
<p>Il logout è andato a buon fine!</p>
</body>
</html>