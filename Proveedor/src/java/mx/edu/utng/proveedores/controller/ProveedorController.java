package mx.edu.utng.proveedores.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.proveedores.dao.ProveedorDAOImp;
import mx.edu.utng.proveedores.model.Proveedor;
import mx.edu.utng.proveedores.dao.ProveedorDAO;
public class ProveedorController extends HttpServlet {
   private static final String
           LISTA_PROVEEDORES = "/lista_proveedores.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "proveedor.jsp";
   private ProveedorDAO dao;
   
   public ProveedorController(){
       dao = new ProveedorDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_PROVEEDORES;
            int idProveedor = Integer.parseInt(
                request.getParameter("idProveedor"));
            dao.borrarProveedor(idProveedor);
            request.setAttribute("proveedores",
                    dao.desplegarProveedor());
            
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idProveedor = Integer.parseInt(
                request.getParameter("idProveedor"));
             Proveedor proveedor = 
                     dao.elegirProveedor(idProveedor);
             request.setAttribute("proveedor", proveedor);////aqui es otra duda de si es proveedor o proveedores 
             
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
             request.setAttribute("proveedores", dao.desplegarProveedor());//esta en duda 
         } else{
             forward = LISTA_PROVEEDORES;
             request.setAttribute("proveedores", 
                     dao.desplegarProveedor());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Proveedor proveedor = new Proveedor();
       // proveedor.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));
        proveedor.setNombre(request.getParameter("nombre"));
        proveedor.setDomicilio(request.getParameter("domicilio"));
        proveedor.setCelular(request.getParameter("celular"));
        proveedor.setSitioweb(request.getParameter("sitioweb"));
        
        String idProveedor = request.getParameter("idProveedor");
        
        if(idProveedor==null|| idProveedor.isEmpty()|| idProveedor.trim().equals("")){
            dao.agregarProveedor(proveedor);
        }else{
            proveedor.setIdProveedor(
                    Integer.parseInt(idProveedor));
            dao.cambiarProveedor(proveedor);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_PROVEEDORES);
        request.setAttribute("proveedores", 
                dao.desplegarProveedor());
        view.forward(request, response);
    }
}
