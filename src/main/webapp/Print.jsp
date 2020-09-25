<%-- 
    Document   : Print
    Created on : 24 sept. 2020, 16:30:07
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
        <title>Print Page</title>
    </head>
   <body>
        <%@ include file="NAV.jsp" %>

        <%
            
        
            
                try {
                    List<Acompte> acomptes = (ArrayList<Acompte>) request.getAttribute("acomptes");
                    if (!acomptes.isEmpty()) {
                        out.print("<table><tbody>");
                        out.print("Liste des acompte");
                        for (Acompte a : acomptes) {
                            out.print("<tr>");
                            out.print("<td>Id: " + a.getId() + "</td>");
                            out.print("<td>Mmontant: " + a.getMontantAccorde() + "</td>");
                            out.print("<td>Validateur: " + a.getIdValideur().getPrenom() + "</td>");
                            out.print("</tr>");
                        }
                        out.print("<tbody></table>");
                    }
                } catch (NullPointerException e) {
                    //   out.println(e);
                }
            
        %>


    </body>
</html>
