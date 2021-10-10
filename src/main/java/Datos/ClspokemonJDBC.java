
package Datos;


import com.mycompany.Pokedex_Proyect.ClsConexion;
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
public class ClspokemonJDBC {
    //creamos las constatantes
    private static final String SQL_SELECT = "select id, name, species,color,habitat,capture_rate, base_experience from pokemon";

    public DefaultTableModel verInformacion(){
    String [] nomColumnas = {"id","Name","Species","Color","Habitat","Capture_rate","Base_experience"};
    String [] registros = new String[7];
        
    DefaultTableModel modelo = new DefaultTableModel(null,nomColumnas);
        
    Connection conn = null;
    PreparedStatement stmt = null;        
    ResultSet rs = null;
    
    try{
        conn = ClsConexion.getConnection();//realizamos la conexion
        stmt = conn.prepareStatement(SQL_SELECT); //mandamos a llamar a la instruccion                       
        rs = stmt.executeQuery();
        
        while(rs.next()){
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("name");
            registros[2] = rs.getString("species");
            registros[3] = rs.getString("color");
            registros[4] = rs.getString("habitat");
            registros[5] = rs.getString("capture_rate");
            registros[6] = rs.getString("base_experience");
                
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
    
    
