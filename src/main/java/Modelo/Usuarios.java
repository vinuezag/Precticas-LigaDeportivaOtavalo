/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;


/*
Table: usuarios
Columns:
CEDULA varchar(10) 
USUARIO varchar(10) 
CONTRASENA varchar(10)
*/
public class Usuarios extends Personas {
    
    private String usuario;
    private String password;
    
    public Usuarios(){
        
    }

    public Usuarios(String usuario, String password, String cedula, String deporte, String nombres, String apellidos, Date fechaNacimiento, String genero, String cargo, int edad) {
        super(cedula, deporte, nombres, apellidos, fechaNacimiento, genero, cargo, edad);
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
            
    

    
    
    
}
