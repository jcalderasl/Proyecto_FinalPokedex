
package Datos;


import com.mycompany.Pokedex_Proyect.ClsConexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PC
 */
public class ClsFavJDBC {
     
    
    //creamos las constatantes
    private static final String SQL_SELECT="SELECT * FROM test.tb_favoritos;";
    private static final String SQL_INSERT="insert into tb_favoritos(id_usuario, nombre,favoritos) values(?,?,?)";
    private static final String SQL_DELETE="DELETE FROM tb_favoritos WHERE codigo =?";
    
    Scanner t = new Scanner(System.in);
    Scanner t1 = new Scanner(System.in);
    Scanner t2 = new Scanner(System.in);
    String r;
    public static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;  
    
   public int guardarUsuario(String nombre, String correo, String password){
       int  resultado=0;
       Connection conexion =null;
       
       String Sentencia_guardar=("insert into tb_usuarios(nombre, correo,password) values(?,?,?)");//insertar usuarios
        
        try {
             conexion = ClsConexion.getConnection();
            sentencia_preparada=conexion.prepareStatement(Sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2,correo);
            sentencia_preparada.setString(3, password);
            
            resultado=sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            System.out.println("usuario agregado...");
          
            System.out.println("Registros afectados:" + resultado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);        
        }
        return resultado;
         
   }
    

   public int Insertar(ClsFav usuario){    //metodo para insertar tabla
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setDouble(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getNombre());     
            stmt.setString(3, usuario.getFavoritos());
         
            System.out.println("usuario` agregado...");
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
          
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;}
  
 
      public  String verificar(String correo){
      String busqueda=null;
      Connection conexion=null;
      try{
          conexion=ClsConexion.getConnection();
          String sentencia_buscar=("select nombre from tb_usuarios where correo='"+correo+"'");
          sentencia_preparada=conexion.prepareStatement(sentencia_buscar);
          resultado=sentencia_preparada.executeQuery();
          if (resultado.next()){
              String nombre=resultado.getString("nombre");
              busqueda=(nombre);
          }
          conexion.close();
      } catch (SQLException ex) {
            Logger.getLogger(ClsFavJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }return busqueda;
  }
  
      public  String busca_registro(String correo, String password){
      String busqueda_usuario=null;
      Connection conexion =null;
      try{
          conexion=ClsConexion.getConnection();
          String sentencia_busca=("select nombre, correo, password from tb_usuarios where correo='"+correo+"'&& password='"+password+"'");
          sentencia_preparada=conexion.prepareStatement(sentencia_busca);
          resultado=sentencia_preparada.executeQuery();
          if (resultado.next()){
              busqueda_usuario="encontrado";
          }else{
              busqueda_usuario="usuario no encontrado";
          }conexion.close();
          
      }catch (Exception e){
          System.out.println(e);
  }return busqueda_usuario;
           }
  
  public DefaultTableModel verInformacion(){
    String [] nomColumnas = {"id_usuario","nombre","favoritos"};
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
            registros[0] = rs.getString("id_usuario");
            registros[1] = rs.getString("nombre");
            registros[2] = rs.getString("favoritos");
            
            
                
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
    
 
  
