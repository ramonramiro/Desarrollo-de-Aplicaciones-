/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.proveedores.model;

   /* Document   : estudiante.jsp
    *Created on : 20/09/2016, 12:27:38 PM
    *Author: RRSR
*/

public class Proveedor {
   private int idProveedor;
   private String nombre;
   private String domicilio;
   private String celular;
   private String sitioweb;

    public Proveedor() {
        this(0,"","","","");
    }

    public Proveedor(int idProveedor, String nombre, String domicilio, String celular, String sitioweb) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.sitioweb = sitioweb;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", domicilio=" + domicilio + ", celular=" + celular + ", sitioweb=" + sitioweb + '}';
    }

 
    
}
