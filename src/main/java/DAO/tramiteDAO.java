package DAO;

import Model.cargo;
import Model.tramite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConectar;



public class tramiteDAO{

    private int Dni;
    
 
    
    public int save(tramite tram) {
    int salida = -1;
    Connection cn = null;
    PreparedStatement pstm = null;
    try {
        cn = new MySqlConectar().getConnection();
        String sql = "INSERT INTO tramite (Nombres, Apellidos, DNI, tipo_tramite) VALUES (?,?,?,?)";
        pstm = cn.prepareStatement(sql);
        pstm.setString(1, tram.getNombres());
        pstm.setString(2, tram.getApellidos());
        pstm.setInt(3, tram.getDni());
        pstm.setString(4, tram.getTipo_tramite());
        salida = pstm.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstm != null)
                pstm.close();
            if (cn != null)
                cn.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    return salida;
}
   // Método para iniciar sesión y obtener datos del usuario
    public static tramite Personatramite( int Dni) {
        PreparedStatement pstm = null;
        Connection cn = null;
        ResultSet rs = null;
        tramite tra = null;

        try {
            cn = new MySqlConectar().getConnection();
            String sql = "SELECT * FROM tramite WHERE DNI = ? ";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, Dni);
           
            rs = pstm.executeQuery();

            if (rs.next()) {
                tra = new tramite();
                
                tra.setNombres(rs.getString("Nombres"));
                tra.setApellidos(rs.getString("Apellidos"));
                tra.setDni(rs.getInt("DNI"));
                tra.setTipo_tramite(rs.getString("tipo_tramite"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
                if (cn != null)
                    cn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return tra;
    }
    
    
        public List<tramite> listarTramites() throws Exception {
        PreparedStatement pstm = null;
        Connection cn = null;
        ResultSet rs = null;
        tramite tra;
        
        List<tramite> tramites = null;
        
        
        cn = new MySqlConectar().getConnection();
        
       try {
            cn = new MySqlConectar().getConnection();
            String sql = "SELECT * FROM tramite";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, Dni);
           
            rs = pstm.executeQuery();

            if (rs.next()) {
                tra = new tramite();
                
                tra.setNombres(rs.getString("Nombres"));
                tra.setApellidos(rs.getString("Apellidos"));
                tra.setDni(rs.getInt("DNI"));
                tra.setTipo_tramite(rs.getString("tipo_tramite"));
            }

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
                if (cn != null)
                    cn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return tramites;
    }
}





 






    
    
    
    
    
    
    
    
     