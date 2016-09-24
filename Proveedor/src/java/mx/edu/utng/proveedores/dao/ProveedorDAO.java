/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.proveedores.dao;

import java.util.List;
import mx.edu.utng.proveedores.model.Proveedor;
 
   /* Document   : estudiante.jsp
    *Created on : 20/09/2016, 12:27:38 PM
    *Author: RRSR
*/

public interface ProveedorDAO {
    void agregarProveedor(Proveedor proveedor);
    void borrarProveedor(int idProveedor);
    void cambiarProveedor(Proveedor proveedor);
    List<Proveedor> desplegarProveedor();
    Proveedor elegirProveedor(int idProveedor);

}
