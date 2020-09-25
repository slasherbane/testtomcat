 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Acompte"%>
<%-- 
    Document   : newjsp
    Created on : 22 sept. 2020, 11:59:32
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <link rel="stylesheet" href="style.css">
        <title>Index Page</title>
    </head>
    <body>
          <%@ include file="NAV.jsp" %>
          <div name="warn"> 
          <%
           Object warn =  request.getAttribute("warning");
           
              if (warn  != null){
                   out.println(warn.toString());
          }
              
          %></div>

        <h1>Just an index page</h1>
    </body>
</html>
