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
    
     private float PromedioEdad;
     private int NumHombresDeportistas;
     private int NumMujeresDeportistas;
     private String DeporteMasRegistros;
     private String DeporteMenosRegistros;
     private String CategoriaMasRegistros;
     private String CategoriaMenosRegistros;
                        
      
    
    public Deportistas(){
        
    }

    public Deportistas(String categoria, float PromedioEdad, int NumHombresDeportistas, int NumMujeresDeportistas, String DeporteMasRegistros, String DeporteMenosRegistros, String CategoriaMasRegistros, String CategoriaMenosRegistros) {
        this.categoria = categoria;
        this.PromedioEdad = PromedioEdad;
        this.NumHombresDeportistas = NumHombresDeportistas;
        this.NumMujeresDeportistas = NumMujeresDeportistas;
        this.DeporteMasRegistros = DeporteMasRegistros;
        this.DeporteMenosRegistros = DeporteMenosRegistros;
        this.CategoriaMasRegistros = CategoriaMasRegistros;
        this.CategoriaMenosRegistros = CategoriaMenosRegistros;
    }

    public Deportistas(String categoria, float PromedioEdad, int NumHombresDeportistas, int NumMujeresDeportistas, String DeporteMasRegistros, String DeporteMenosRegistros, String CategoriaMasRegistros, String CategoriaMenosRegistros, String cedula, String deporte, String nombres, String apellidos, java.util.Date fechaNacimiento, String genero, String cargo, int edad) {
        super(cedula, deporte, nombres, apellidos, fechaNacimiento, genero, cargo, edad);
        this.categoria = categoria;
        this.PromedioEdad = PromedioEdad;
        this.NumHombresDeportistas = NumHombresDeportistas;
        this.NumMujeresDeportistas = NumMujeresDeportistas;
        this.DeporteMasRegistros = DeporteMasRegistros;
        this.DeporteMenosRegistros = DeporteMenosRegistros;
        this.CategoriaMasRegistros = CategoriaMasRegistros;
        this.CategoriaMenosRegistros = CategoriaMenosRegistros;
    }

    

    public float getPromedioEdad() {
        return PromedioEdad;
    }

    public void setPromedioEdad(float PromedioEdad) {
        this.PromedioEdad = PromedioEdad;
    }

    public int getNumHombresDeportistas() {
        return NumHombresDeportistas;
    }

    public void setNumHombresDeportistas(int NumHombresDeportistas) {
        this.NumHombresDeportistas = NumHombresDeportistas;
    }

    public int getNumMujeresDeportistas() {
        return NumMujeresDeportistas;
    }

    public void setNumMujeresDeportistas(int NumMujeresDeportistas) {
        this.NumMujeresDeportistas = NumMujeresDeportistas;
    }

    public String getDeporteMasRegistros() {
        return DeporteMasRegistros;
    }

    public void setDeporteMasRegistros(String DeporteMasRegistros) {
        this.DeporteMasRegistros = DeporteMasRegistros;
    }

    public String getDeporteMenosRegistros() {
        return DeporteMenosRegistros;
    }

    public void setDeporteMenosRegistros(String DeporteMenosRegistros) {
        this.DeporteMenosRegistros = DeporteMenosRegistros;
    }

    public String getCategoriaMasRegistros() {
        return CategoriaMasRegistros;
    }

    public void setCategoriaMasRegistros(String CategoriaMasRegistros) {
        this.CategoriaMasRegistros = CategoriaMasRegistros;
    }

    public String getCategoriaMenosRegistros() {
        return CategoriaMenosRegistros;
    }

    public void setCategoriaMenosRegistros(String CategoriaMenosRegistros) {
        this.CategoriaMenosRegistros = CategoriaMenosRegistros;
    }

    

    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
