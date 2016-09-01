<%-- 
    Document   : index
    Created on : 24-ago-2016, 22:13:06
    Author     : Ariel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lugares</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>
        <script   src="https://code.jquery.com/jquery-2.2.4.min.js"   integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="   crossorigin="anonymous"></script>
        <script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
        
    </head>
    <body>
        
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">GUIA 3</a>
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                  <li><a href="index.jsp">Alumnos</a></li>
                    <li><a href="alumnosgrupos.jsp">Alumnos-grupos</a></li>
                      

                </ul>


              </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
          </nav>
        <form action="scripts/reporte1.jsp"  method="Post" target="_blank>
             <input  type="hidden" name="codi" id="codi" value="${codi}"/>
            <div class="container">
                               
                
                <div class="panel panel-default"style="padding: 15px;">
                    <h1>Alumnos del grupo ${codi}</h1>
                     <input type="submit" value="Imprimir Reporte" class="btn btn-default" />
                    <jsp:useBean id="AlumnosCtrl" class="com.sv.udb.controlador.GruposAlumnosCtrl" scope="page"/>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                  <th>Fecha nacimiento</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${AlumnosCtrl.ConsTodo()}" var="fila">
                                <tr>
                                    <c:if test="${fila.codiGrup.codiGrup ==codi}">
                                        
                                        
                                    <td><c:out value="${fila.codiAlum.nombAlum}"></c:out></td>
                                    <td><c:out value="${fila.codiAlum.apelAlum}"></c:out></td>
                                    <fmt:formatDate value="${fila.codiAlum.fechNaciAlum}" pattern="dd/MM/yyyy" var="date" />  
                                     <td><c:out value="${date}"></c:out></td>
                                    
                                    </c:if>
                                   
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                 </div>
            </div>
            
        </form>
        
       
    </body>
</html>
