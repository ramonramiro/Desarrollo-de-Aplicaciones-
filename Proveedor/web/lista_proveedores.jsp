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
        <title>Lista de Proveedores</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de proveedor</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Celular</th>
                <th>SitioWeb</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="proveedor" 
                           items="${proveedores}">
                    <tr>
                        <td>${proveedor.idProveedor}</td>
                        <td>${proveedor.nombre}</td>
                        <td>${proveedor.domicilio}</td>
                        <td>${proveedor.celular}</td>
                        <td>${proveedor.sitioweb}</td>
                        <td><a href="ProveedorController?action=cambiar&idProveedor=${proveedor.idProveedor}">Cambiar</a></td>
                        <td><a href="ProveedorController?action=borrar&idProveedor=${proveedor.idProveedor}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="ProveedorController?action=agregar">
                Agregar Proveedores
            </a>
            <a href="index.jsp">
                Regresar
            </a>
        </p>
    </body>
</html>
