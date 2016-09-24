<%-- 
    Document   : estudiante.jsp
    Created on : 20/09/2016, 12:27:38 PM
    Author     : RRSR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Estudiantes</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de estudiante</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Curso</th>
                <th>Año</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="estudiante" 
                           items="${estudiantes}">
                    <tr>
                        <td>${estudiante.idEstudiante}</td>
                        <td>${estudiante.nombre}</td>
                        <td>${estudiante.apellidos}</td>
                        <td>${estudiante.curso}</td>
                        <td>${estudiante.anio}</td>
                        <td><a href="EstudianteController?action=cambiar&idEstudiante=${estudiante.idEstudiante}">Cambiar</a></td>
                        <td><a href="EstudianteController?action=borrar&idEstudiante=${estudiante.idEstudiante}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="EstudianteController?action=agregar">
                Agregar estudiante
            </a>
            <a href="index.jsp">
                Regresar
            </a>
        </p>
    </body>
</html>
