/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    */

public class Personas {
    
    private String cedula;
    private String deporte;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String genero;
    private String cargo;
    private int edad;
    
    public Personas(){
        
    } 

    public Personas(String cedula, String deporte, String nombres, String apellidos, Date fechaNacimiento, String genero, String cargo, int edad) {
        this.cedula = cedula;
        this.deporte = deporte;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.cargo = cargo;
        this.edad = edad;
    }

    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    
    
    public void setFechaNacimiento(Date fechaNacimiento) {
                this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
            
    
}
