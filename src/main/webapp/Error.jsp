<%-- 
    Document   : Error
    Created on : 28 sept. 2020, 13:58:35
    Author     : Benjamin
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <jsp:include page="NAV.jsp" />
        <h1>You have encountered an error !</h1>
        <h2><%  out.println(request.getAttribute("javax.servlet.error.exception").toString());%>

         </h2>
    </body>
</html>
