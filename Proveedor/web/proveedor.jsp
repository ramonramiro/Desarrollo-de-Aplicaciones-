<%-- 
    Document   : estudiante.jsp
    Created on : 20/09/2016, 12:27:38 PM
    Author     : RRSR
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiante</title>
    </head>
    <body>
        <form action="ProveedorController" method="post">
            <fieldset>
                <legend>Registro de Proveedores</legend>
                
                <div>
                <label for="idProveedor">Id Proveedor:</label>
                <input type="text" name="idProveedor"
                       value="${proveedor.idProveedor}"
                       readonly="readonly" 
                       placeholder="Id de proveedor"/>
                </div>
                
                <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"
                       value="${proveedor.nombre}"
                       placeholder="Nombre del proveedor"/>
                </div>
                 
                <div>
                <label for="domicilio">Domicilio:</label>
                <input type="text" name="domicilio"
                       value="${proveedor.domicilio}"
                       placeholder="Domicilio del proveedor"/>
                </div>
                
                <div>
                <label for="celular">Celular:</label>
                <input type="text" name="celular"
                       value="${proveedor.celular}"
                       placeholder="Celular"/>
                </div>
                       
                <div>
                <label for="sitioweb">SitioWeb:</label>
                <input type="text" name="sitioweb"
                       value="${proveedor.sitioweb}"
                       placeholder="Sitio Web"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
