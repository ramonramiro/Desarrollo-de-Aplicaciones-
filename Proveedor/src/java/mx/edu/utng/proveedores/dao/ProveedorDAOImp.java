/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.proveedores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.proveedores.model.Proveedor;
import mx.edu.utng.proveedores.util.UtilDB;

   /* Document   : estudiante.jsp
    *Created on : 20/09/2016, 12:27:38 PM
    *Author: RRSR
*/

public class ProveedorDAOImp implements ProveedorDAO{

    private Connection connection;
    
    public ProveedorDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarProveedor(Proveedor proveedor) {
        try {
          String query = "INSERT INTO proveedores (nombre, domicilio, "
                  + " celular, sitioweb) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getCelular());
            ps.setString(4, proveedor.getSitioweb());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarProveedor(int idProveedor) {
        try {
             String query = "DELETE FROM proveedores WHERE id_proveedor= ?";
             PreparedStatement ps = connection.prepareStatement(query);
             ps.setInt(1, idProveedor);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarProveedor(Proveedor proveedor) {
    try {
          String query = "UPDATE proveedores SET nombre = ?, "
                  + " domicilio= ?, celular=?, sitioweb=? WHERE "
                  + " id_proveedor = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getCelular());
            ps.setString(4, proveedor.getSitioweb());
            ps.setInt(5, proveedor.getIdProveedor());/// este esta en duda
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Proveedor> desplegarProveedor() {
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM proveedores");
            while (resultSet.next()) {
              Proveedor proveedor = new Proveedor(
              resultSet.getInt("id_proveedor"),
              resultSet.getString("nombre"),
              resultSet.getString("domicilio"),
              resultSet.getString("celular"),
              resultSet.getString("sitioweb"));
              proveedores.add(proveedor);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return proveedores;
    }

    @Override
    public Proveedor elegirProveedor(int idProveedor) {
       Proveedor proveedor = new Proveedor();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM proveedores WHERE "
                                + " id_proveedor = ?");
        statement.setInt(1, idProveedor);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              proveedor.setIdProveedor(
                      resultSet.getInt("id_proveedor"));
              proveedor.setNombre(
                      resultSet.getString("nombre"));
              proveedor.setDomicilio(
                      resultSet.getString("domicilio"));
              proveedor.setCelular(
                      resultSet.getString("celular"));//tambien esta en duda por el tipo de int que coloque 
              proveedor.setSitioweb(resultSet.getString("sitioweb"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return proveedor;
    }
    
    
}
