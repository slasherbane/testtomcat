<%-- 
    Document   : Add
    Created on : 25 sept. 2020, 09:50:27
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Ajout</title>
    </head>
    <body>
         <jsp:include page="NAV.jsp" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/check_form.js"></script>
        <div  class="warn" id="warn">
            Please Insert valid informations !
        </div>
        <form  name="Add_acompte" onsubmit="return validate_form()" action="${pageContext.request.contextPath}/Add" method="POST">
            <div class="form-container">
                <label for="    Montant">Enter the Amount </label>
                <input type="number" name="Montant" id="Montant" >
            </div>
            <div class="form-container">
                <label for="Type">Enter the type </label>
                <input type="number" name="Type" id="Type" >
            </div>
            <div class="form-container">
                <input type="submit" value="Envoie!">
            </div>
        </form>
    </body>
</html>
