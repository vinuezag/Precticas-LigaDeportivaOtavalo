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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultasDisciplinas {
    
    public boolean registrar(Disciplinas disciplina) {
        Conexion conexion = new Conexion(); 
        Connection con = conexion.getConexion(); 

        CallableStatement cs = null;

        try {
            cs = con.prepareCall("{call AgregarDisciplina(?)}");
            cs.setString(1, disciplina.getDeporte());

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

    public boolean eliminar(String deporte) {
        Conexion conexion = new Conexion(); // Crear una instancia de Conexion
        Connection con = null;
        CallableStatement cs = null;
        
        try {
            con = conexion.getConexion(); // Llamar al método getConexion() de la instancia de Conexion
            cs = con.prepareCall("{call EliminarDisciplina(?)}");
            cs.setString(1, deporte);
            
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public List<String> consultarDisciplinas() {
        Conexion conexion = new Conexion(); 
        Connection con = conexion.getConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        List<String> disciplinas = new ArrayList<>();

        try {
            cs = con.prepareCall("{call ConsultarDisciplinas()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                disciplinas.add(rs.getString("DEPORTE"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
        return disciplinas;
    }
}
