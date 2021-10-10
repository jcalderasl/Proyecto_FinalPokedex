
package com.mycompany.Pokedex_Proyect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PC
 */
public class usuarioJDBC {
     private  static final String SQL_SELECT="select*from tb_usuarios";
     private static final String SQL_SELECT2="SELECT id_usuario,nombre,correo  FROM test.tb_usuarios";
     
   
      public boolean select_validacion(ClsUsuario datos){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsUsuario usuario = new ClsUsuario();
        boolean tiene_permiso = false;
        
        try {
            conn = ClsConexion.getConnection();//hacemos la conexion
            String condicion = SQL_SELECT + " where correo='"+datos.getCorreo()+"'"+" and password='"+datos.getPassword()+"'";
                     
            stmt = conn.prepareStatement(condicion);//y mandamos a llamar a la instrucion select
            rs = stmt.executeQuery();//cuando ejecute el query devuelve un tipo de dato rs
            while(rs.next()){
                tiene_permiso = true;
               
                
                String correo = rs.getString("correo");
                String password = rs.getString("password");
 
                usuario = new ClsUsuario();
                
                usuario.setCorreo(correo);
                usuario.setPassword(password);
               
                                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ClsConexion.close(rs);//mandamos
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return tiene_permiso; 
    
}
       public DefaultTableModel verInformacionDeUsuario(){
    String [] nomColumnas = {"id_usuario","nombre","correo"};
    String [] registros = new String[7];
        
    DefaultTableModel modelo = new DefaultTableModel(null,nomColumnas);
        
    Connection conn = null;
    PreparedStatement stmt = null;        
    ResultSet rs = null;
    
    try{
        conn = ClsConexion.getConnection();//realizamos la conexion
        stmt = conn.prepareStatement(SQL_SELECT2); //mandamos a llamar a la instruccion                       
        rs = stmt.executeQuery();
        
        while(rs.next()){
            registros[0] = rs.getString("id_usuario");
            registros[1] = rs.getString("nombre");
            registros[2] = rs.getString("correo");
            
            
                
            modelo.addRow(registros);
                
            }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al conectar");  
        }
        finally{
            
        try{
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
 
   
}
