 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Acompte"%>
<%@ page errorPage="Error.jsp" %> 
<%-- 
    Document   : newjsp
    Created on : 22 sept. 2020, 11:59:32
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="SCRIPT.jsp" />
        <title>Index Page</title>
    </head>
    <body>
        <div class="decorative-bar d-flex">
            <div style="justify-content: center;margin: auto">
                <label  class="badge badge-primary">Tomcat Test App</label>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="dflex col-12 ">
                    <div class="decorative-half-circle"></div>
                </div>
            </div>
        </div>
        <div class="conatiner-fluid">
            <div class="row"></div>
            <div class="dflex col-12" >
                <form action="${pageContext.request.contextPath}/LogInOut" method="POST">



                    <div style="width: 500px;margin-top: 5%;margin-left: auto;margin-right: auto;" class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">$</span>
                        </div>
                        <input  type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div style="width: 500px;margin-left: auto;margin-right: auto;" class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"> #</span>
                        </div>
                        <input  type="text" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1">
                    </div>

                    <div class="enter-button">
                        <div class="d-flex" style="transform: rotate(-45deg);margin: 20%">
                            <input style="background-color:red;border:1px solid black;border-radius: 25% " type="submit" class="btn-group btn-group-sm btn-primary"    aria-describedby="basic-addon1" value="Log In">  

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
