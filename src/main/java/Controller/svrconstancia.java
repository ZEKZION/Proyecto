/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.cargoDAO;
import DAO.tramiteDAO;
import Model.cargo;
import Model.tramite;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */

@WebServlet(name = "svrconstancia", urlPatterns = {"/svrconstancia"})
 
public class svrconstancia extends HttpServlet {

     public svrconstancia() {
        super();
    }

	
        @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            String tipo = request.getParameter("accion");

            if(tipo.equals("guardartramite"))
                 
                    try {
                        generartramite(request, response);
            } catch (Exception ex) {
                Logger.getLogger(svrconstancia.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
                        
            if(tipo.equals("pdf")) 
                try {
                    generarpdf(request, response);
            } catch (Exception ex) {
                Logger.getLogger(svrconstancia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                      
            
                }
        
        
        
	protected void generartramite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

            String Nombre=request.getParameter("nombrePAG");
            String Apellidos=request.getParameter("apellidoPAG");
            int Dni=Integer.parseInt(request.getParameter("dniPAG"));
            String TipoTramite=request.getParameter("tipo-tramitePAG");
            
        
            tramite tra=new tramite();
            tra.setNombres(Nombre);
            tra.setApellidos(Apellidos);
            tra.setDni(Dni);
            tra.setTipo_tramite(TipoTramite);
            
            int dato = new tramiteDAO().save(tra);
            
                          
                
            if(dato>0)
                
                
            {
               
               tramite tram=new tramiteDAO().Personatramite(Dni);
               
             String Nombreee = tram.getNombres();
             String Apellidooo  = tram.getApellidos();
             int Dniii = tram.getDni();
             String tipo_tramiteee = tram.getTipo_tramite();

            // Se almacenan los datos del usuario en la sesión HTTP
            HttpSession session=request.getSession();
            session.setAttribute("Nombre", Nombreee);
            session.setAttribute("Apellido", Apellidooo);
            session.setAttribute("Dni", Dniii);
            session.setAttribute("Tipo_tramite", tipo_tramiteee);
           
                System.out.println("Nombre"+ tram.getNombres());
                
                response.sendRedirect("vistas/pagar-tramite.jsp");
                
            }
            
            
        }
        
 private void listar_tramites(HttpServletRequest request, HttpServletResponse response) {
        tramiteDAO dao = new tramiteDAO();
        List<tramite> tram = null;
        try {
            tram = dao.listarTramites();
            request.setAttribute("tramites", tram);
        } catch (Exception e) {
            request.setAttribute("msje", "No se puede listar los cargos info:" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/pagar-tramite.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msj", "No se puede realizar la consulta info:" + ex.getMessage());
        }
    }

    private void generarpdf(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}