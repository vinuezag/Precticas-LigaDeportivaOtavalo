/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;

/*
    Table: personas
Columns:
CEDULA varchar(10) PK 
DEPORTE varchar(25) 
NOMBRES varchar(25) 
APELLIDOS varchar(25) 
FECHA_NACIMIENTO date 
GENERO varchar(10) 
CARGO varchar(15)

Table: deportistas
Columns:
CEDULA varchar(10) 
CATEGORIA varchar(15)
    */

public class Deportistas extends Personas{
    
    private String categoria;
    
    public Deportistas(){
        
    }

    public Deportistas(String categoria) {
        this.categoria = categoria;
    }

    public Deportistas(String categoria, String cedula, String deporte, String nombres, String apellidos, Date fechaNacimiento, String genero, String cargo, int edad) {
        super(cedula, deporte, nombres, apellidos, fechaNacimiento, genero, cargo, edad);
        this.categoria = categoria;
    }

    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
