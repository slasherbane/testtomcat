<%-- 
    Document   : Delete
    Created on : 25 sept. 2020, 13:44:16
    Author     : Benjamin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Acompte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="NAV.jsp" %>
        <h1>Delete Page</h1>
        <form name=""Del_acompte" onsubmit="" action="${pageContext.request.contextPath}/Delete" method="POST">

            <div><label><% try {
                    out.println(request.getAttribute("message").toString());

                } catch (Exception e) {
                }
                    %></label></div>  





            <%
                try {
                    List<Acompte> acomptes = (ArrayList<Acompte>) request.getAttribute("acomptes");
                    out.println("<select name='acompte_choice'>");
                    for (Acompte a : acomptes) {
                        out.println("<option name='selection' value=" + a.getId() + ">Acompte numéro : " + a.getId() + "</option>");
                    }
                    out.print("</select>");
                } catch (Exception e) {

                }


            %>
            <input type="submit" value="Envoie">

        </form>
    </body>
</html>
