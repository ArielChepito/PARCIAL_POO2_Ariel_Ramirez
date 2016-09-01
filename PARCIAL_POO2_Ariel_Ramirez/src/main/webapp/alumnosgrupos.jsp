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
        <form action="GruposAlumnosServ"  method="Post">
             <input  type="hidden" name="codi" id="codi" value="${codi}"/>
            <div class="container">
                
                
                <div class="panel panel-default" style="padding: 15px;">
                    <h2>CRUD de Lugares Acceso</h2>
                    <div class="form-group">
                        <label for="nomb">Alumnos: </label>
                        <select name="cmbAlumno" class="form-control" id="cmbAlumno">
           <jsp:useBean id="beanUnidadCtrl" class="com.sv.udb.controlador.AlumnosCtrl" scope="page"/>
                                        <c:forEach items="${beanUnidadCtrl.ConsTodo()}" var="fila">
                                            <c:choose>
                                                <c:when test="${fila.codiAlum eq cmbUnidad}">
                                                    <option name="codi_unid" value="${fila.codiAlum}" selected="">${fila.nombAlum}</option>
                                                </c:when>
                                                <c:otherwise>
                                            <option name="codi_unid" value="${fila.codiAlum}">${fila.nombAlum}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        </select>
                                 
                                        <label for="nomb">Grupos: </label>
                      
                                        <div class="row">
                                        <div class="col-lg-6">
    <div class="input-group">
       <select name="cmbGrupo" class="form-control"  id="cmbGrupo">
           <jsp:useBean id="beanUnidadCtrl2" class="com.sv.udb.controlador.GruposCtrl" scope="page"/>
                                        <c:forEach items="${beanUnidadCtrl2.ConsTodo()}" var="fila">
                                            <c:choose>
                                                <c:when test="${fila.codiGrup eq cmbUnidad}">
                                                    <option name="codi_unid" value="${fila.codiGrup}" selected="">${fila.nombGrup}</option>
                                                </c:when>
                                                <c:otherwise>
                                            <option name="codi_unid" value="${fila.codiGrup}">${fila.nombGrup}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        </select>
      <span class="input-group-btn">
          
          
        <input  class="btn btn-default" name="lugaAcceBton"type="submit" value="Alumnos" />
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
                                        </div>
                                        
                    </div>
                    <div class="btn-group">
                        <input type="submit" name="lugaAcceBton" value="Guardar" class="btn btn-default" />
                    </div>
                </div>
                <div class="panel panel-default"style="padding: 15px;">
                    <jsp:useBean id="AlumnosCtrl" class="com.sv.udb.controlador.GruposAlumnosCtrl" scope="page"/>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha Alta</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${AlumnosCtrl.ConsTodo()}" var="fila">
                                <tr>
                                   
                                    <td><c:out value="${fila.codiAlum.nombAlum}"></c:out></td>
                                    <td><c:out value="${fila.codiGrup.nombGrup}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                 </div>
            </div>
            
        </form>
        
       
    </body>
</html>
