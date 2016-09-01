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
        <form action="AlumnosServ"  method="Post">
             <input  type="hidden" name="codi" id="codi" value="${codi}"/>
            <div class="container">
                
                
                <div class="panel panel-default" style="padding: 15px;">
                    <h2>CRUD de Lugares Acceso</h2>
                    <div class="form-group">
                        <label for="nomb">Nombre: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="text" name="nomb" id="nomb"value="${nomb}"  />
                        <label for="nomb">Apellido: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="text" name="apel" id="apel"value="${apel}"  />
                        <label for="nomb">Fecha Nacimiento: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="date" name="fech" id="fech"value="${fech}"  />
                        <label for="nomb">E-Mail: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="text" name="emai" id="emai"value="${emai}"  />
                        <label for="nomb">Telefono: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="text" name="tele" id="tele"value="${tele}"  />
                        <label for="nomb">Dirección: </label>
                        <input  data-msg-required="Este campo es requerido" class="form-control" type="text" name="dire" id="dire"value="${dire}"  />
                        <label for="nomb">Genero </label>
                         <select name="cmbGenero" class="form-control" id="cmbGenero">
                           <option value="F" >Femenino</option>
                           <option value="M" >Masculino</option>
                           </select>
                    </div>
                    <div class="btn-group">
                        <input type="submit" name="lugaAcceBton" value="Guardar" class="btn btn-default" />
                        <input type="submit" name="lugaAcceBton" value="Consultar" class="btn btn-default" />
                        <input type="submit" name="lugaAcceBton" value="Modificar" class="btn btn-default" />
                        <input type="submit" name="lugaAcceBton" value="Eliminar" class="btn btn-default" />
                    </div>
                </div>
                <div class="panel panel-default"style="padding: 15px;">
                    <jsp:useBean id="AlumnosCtrl" class="com.sv.udb.controlador.AlumnosCtrl" scope="page"/>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha Alta</th>
                                 <th>Seleccione</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${AlumnosCtrl.ConsTodo()}" var="fila">
                                <tr>
                                    <td><c:out value="${fila.nombAlum}"></c:out></td>
                                    <td><c:out value="${fila.apelAlum}"></c:out></td>
                                    <td> <input type="radio" name="codiRadi" value="${fila.codiAlum}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                 </div>
            </div>
            
        </form>
        
       
    </body>
</html>
