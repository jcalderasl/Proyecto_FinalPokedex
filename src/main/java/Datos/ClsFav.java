
package Datos;

/**
 *
 * @author PC
 */
public class ClsFav {
    
   private double id_usuario; 
   private String nombre;
   private String favoritos;
   private String correo;

    @Override
    public String toString() {
        return "ClsFav{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", favoritos=" + favoritos + ", correo=" + correo + '}';
    }

   
    public double getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(double id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
   
   

    

   
}
