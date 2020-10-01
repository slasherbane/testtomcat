<%-- 
    Document   : Delete
    Created on : 25 sept. 2020, 13:44:16
    Author     : Benjamin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Acompte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %> 
 
 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Suppression</title>
    </head>
    <body>

        <jsp:include page="NAV.jsp" />


        <form name=""Del_acompte" onsubmit="" action="${pageContext.request.contextPath}/Delete" method="POST">
            <c:if  test="${pageContext.request.getAttribute('message')} != null"> 
            <div class="alert alert-dismissible alert-warning" on>
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4 class="alert-heading">Warning!</h4>
                <p class="mb-0">  <%

                        out.println(request.getAttribute("message").toString());
                        
                       
     
                    %><a href="#" class="alert-link"></a>.</p>
            </div>
            </c:if>
     

    <div class="form-group">
        <label for="selection">Acompte</label>
        <select name='acompte_choice' class="custom-select form-control" id="selection">
            <%
                try {
                    List<Acompte> acomptes = (ArrayList<Acompte>) request.getAttribute("acomptes");
                    for (Acompte a : acomptes) {
                        out.println("<option name='selection' value=" + a.getId() + ">Acompte numéro : " + a.getId() + "</option>");
                    }
                             
                } catch (Exception e) {
                     throw e;
                }
            %>
        </select>
    </div>      
    <input type="submit" value="Envoie">
</form>
</body>
</html>