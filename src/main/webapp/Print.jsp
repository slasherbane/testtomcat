<%-- 
    Document   : Print
    Created on : 24 sept. 2020, 16:30:07
    Author     : Benjamin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Acompte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pge de vue</title>
    </head>
    <body>
        <jsp:include page="NAV.jsp" />

        <div class="container">
            <div class="row-cols-2">

        <%
            try {
                List<Acompte> acomptes = (ArrayList<Acompte>) request.getAttribute("acomptes");
                if (!acomptes.isEmpty()) {
                    out.print("<table class='table'>"
                            + "<thead class='thead-dark'>"
                            + "<tr>"
                            + "<th scope='col'>#</th>"
                            + "<th scope='col'>Montant</th>"
                            + "<th scope='col'>Validateur</th>"
                            + "</tr>"
                            + "</thead>"
                            + "<tbody>");
         
                    for (Acompte a : acomptes) {
                        out.print("<tr>");
                        out.print("<td>" + a.getId() + "</td>");
                        out.print("<td> " + a.getMontantAccorde() + "</td>");
                        out.print("<td>" + a.getIdValideur().getPrenom() + "</td>");
                        out.print("</tr>");
                    }
                    out.print("<tbody></table>");
                }
            } catch (Exception e) {

                e.printStackTrace();

                //   out.println(e);
            }

        %>
              
        </div>
    </body>
</html>
