
package com.mycompany.Pokedex_Proyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ClsConexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
   private static final String JDBC_USER="root";
   private static final String JDBC_PWD="Jesus21%";
  
   
   
   public static Connection getConnection()throws SQLException{
       return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);
       
   }
public static void close(ResultSet rs){
       try {
           rs.close();
       } catch (SQLException ex) {
          ex.printStackTrace(System.out);
       }
}
public static void close(PreparedStatement stmt){
       try {
           stmt.close();
       } catch (SQLException ex) {
          ex.printStackTrace(System.out);
       }
}
public static void close(Connection cn){
       try {
           cn.close();
       } catch (SQLException ex) {
          ex.printStackTrace(System.out);
       }
}
}
