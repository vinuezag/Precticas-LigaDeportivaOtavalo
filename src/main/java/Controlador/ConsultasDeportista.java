/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultasDeportista extends Conexion{
    
    /*
    private String cedula;
    private String deporte;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String genero;
    private String cargo;
        */
    
    public boolean registrar(Personas per) {
    Connection con = getConexion();
    CallableStatement cs = null;

    try {
        cs = con.prepareCall("{call InsertarPersona(?, ?, ?, ?, ?, ?, ?)}");
        cs.setString(1, per.getCedula());
        cs.setString(2, per.getDeporte());
        cs.setString(3, per.getNombres());
        cs.setString(4, per.getApellidos());
        cs.setDate(5, new java.sql.Date(per.getFechaNacimiento().getTime()));
        cs.setString(6, per.getGenero());
        cs.setString(7, per.getCargo());

        cs.execute();
        return true;
    } catch (SQLException e) {
        System.err.println(e);
        return false;
    } finally {
        try {
            if (cs != null) {
                cs.close();
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

    public boolean modificarDeporte(Personas per) {
    Connection con = getConexion();
    CallableStatement cs = null;

    try {
        cs = con.prepareCall("{call ModificarDeporte(?, ?)}");
        cs.setString(1, per.getCedula());
        cs.setString(2, per.getDeporte());

        cs.execute();
        return true;
    } catch (SQLException e) {
        System.err.println(e);
        return false;
    } finally {
        try {
            if (cs != null) {
                cs.close();
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}



public boolean eliminar(Deportistas per) {
    Connection con = getConexion();
    CallableStatement cs = null;

    try {
        cs = con.prepareCall("{call eliminarPersona(?)}");
        cs.setString(1, per.getCedula());

        cs.execute();
        return true;
    } catch (SQLException e) {
        System.err.println(e);
        return false;
    } finally {
        try {
            if (cs != null) {
                cs.close();
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

public Deportistas consultarDatosDeportista(String cedulaDeportista) {
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    Deportistas deportista = null;

    try {
        con = getConexion();
        cs = con.prepareCall("{call ConsultarDatosDeportista(?)}");
        cs.setString(1, cedulaDeportista);
        rs = cs.executeQuery();

        if (rs.next()) {
            deportista = new Deportistas();
            deportista.setNombres(rs.getString("NOMBRES"));
            deportista.setApellidos(rs.getString("APELLIDOS"));
            deportista.setEdad(rs.getInt("EDAD"));
            deportista.setGenero(rs.getString("GENERO"));
            deportista.setDeporte(rs.getString("DEPORTE"));
            deportista.setCategoria(rs.getString("CATEGORIA_DEPORTISTA"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    return deportista;
}

public Deportistas consultarEstadisticasDeportistas() {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Deportistas deportista = new Deportistas(); // Creamos un objeto deportista para almacenar los resultados

        try {
            // Obtener conexión a la base de datos
            con = getConexion();
            
            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{call EstadisticasDeportistas()}");
            
            // Ejecutar la consulta
            rs = cs.executeQuery();

            // Leer los resultados
            if (rs.next()) {
                deportista.setPromedioEdad(rs.getFloat("Promedio de Edad de Deportistas"));
                deportista.setNumHombresDeportistas(rs.getInt("Número de Deportistas Masculinos"));
                deportista.setNumMujeresDeportistas(rs.getInt("Número de Deportistas Femeninos"));
                deportista.setDeporteMasRegistros(rs.getString("Deporte con más Registros"));
                deportista.setDeporteMenosRegistros(rs.getString("Deporte con menos Registros"));
            }
        } catch (SQLException e) {
            // Manejar errores de SQL
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            cerrarRecursos(rs, cs, con);
        }
        return deportista;
    }

public Deportistas consultarEstadisticasPorDeporte(String deporte) {
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    Deportistas deportista = new Deportistas(); // Creamos un objeto deportista para almacenar los resultados

    try {
        // Obtener conexión a la base de datos
        con = getConexion();
        
        // Preparar la llamada al procedimiento almacenado
        cs = con.prepareCall("{call EstadisticasPorDeporte(?)}");
        cs.setString(1, deporte);
        
        // Ejecutar la consulta
        rs = cs.executeQuery();

        // Leer los resultados
        if (rs.next()) {
            deportista.setPromedioEdad(rs.getFloat("Promedio de Edad"));
            deportista.setNumMujeresDeportistas(rs.getInt("Número de Mujeres"));
            deportista.setNumHombresDeportistas(rs.getInt("Número de Hombres"));
            deportista.setCategoriaMasRegistros(rs.getString("Categoría con Más Registros"));
            deportista.setCategoriaMenosRegistros(rs.getString("Categoría con Menos Registros"));
        }
    } catch (SQLException e) {
        // Manejar errores de SQL
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        cerrarRecursos(rs, cs, con);
    }
    return deportista;
}


private void cerrarRecursos(ResultSet rs, CallableStatement cs, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
