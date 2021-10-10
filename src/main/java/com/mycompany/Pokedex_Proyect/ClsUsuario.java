
package com.mycompany.Pokedex_Proyect;



/**
 *
 * @author PC
 */
public class ClsUsuario {
     private String correo;
   private String password;
  
    public ClsUsuario(){
        
    }
    
    
    public ClsUsuario(String correo, String contraseña){
       
        this.correo=correo;
         this.password=contraseña;
         
    }

    @Override
    public String toString() {
        return "usuario{" + "correo=" + getCorreo() + ", contraseña=" + getPassword() + '}';
    }

    /**
     * @return the usuario
     */
   

    
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the favoritos
     */
   
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    
    
}