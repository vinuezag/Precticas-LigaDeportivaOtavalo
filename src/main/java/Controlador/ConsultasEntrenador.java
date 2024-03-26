/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author 59398
 */


import Modelo.Conexion;
import Modelo.Entrenadores;
import Modelo.Personas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasEntrenador extends Conexion {
    

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

    public boolean eliminar(Personas per) {
        Connection con = getConexion();
        CallableStatement cs = null;

        try {
            cs = con.prepareCall("{call eliminarEntrenador(?)}");
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

    public Personas buscarEntrenadorPorDeporte(String deporte) {
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    Personas entrenador = null;

    try {
        con = getConexion();
        cs = con.prepareCall("{call BuscarEntrenadorPorDeporte(?)}");
        cs.setString(1, deporte);
        rs = cs.executeQuery();

        if (rs.next()) {
            entrenador = new Personas();
            entrenador.setNombres(rs.getString("NOMBRES"));
            entrenador.setApellidos(rs.getString("APELLIDOS"));
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
    return entrenador;
}


}
