<%-- 
    Document   : NAV
    Created on : 24 sept. 2020, 16:32:18
    Author     : Benjamin
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 <%@ page errorPage="Error.jsp" %> 



<jsp:include page="SCRIPT.jsp" />

<div class="decorative-bar"></div>
<nav id="p-navbar" class="navbar navbar-expand-lg navbar-light " style="background-color: darkred;opacity: 86%"> 
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div  class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">

            <%

                Map<String, String> links = new HashMap<String, String>() {
                    {
                        put("/Print", "Vu Compte Simple");
                        put("/Add", "   Ajout Compte Simple");
                        put("/Delete", "Suppression Compte Simple");

                    }
                };

                for (Map.Entry<String, String> li : links.entrySet()) {
                    out.println(
                            "<li class='nav-item'> "
                            + "<a style='font-weight:bold' class='nav-link' href=" + application.getContextPath() + li.getKey() + ">" + li.getValue() + "</a>"
                            + "</li>"
                    );
                }

            %>

        </ul>
    </div>

</nav>
<style>

    *{
        padding: 0;
        margin:0
    }

    #header
    {
        display: flex;
        justify-content: center;  /* aligner les objet au centre horizontalement*/
        align-items: center /* la meme mais vertiale*/

    }



</style>


