/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasLogin extends Conexion {
    
    public String iniciarSesion(Usuarios user) {
        Connection con = getConexion();
        CallableStatement cs = null;
        String nombreUsuario = null;
        
        try {
            cs = con.prepareCall("{call IniciarSesion(?, ?, ?)}");
            cs.setString(1, user.getUsuario());
            cs.setString(2, user.getPassword());
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);
            cs.execute();
            nombreUsuario = cs.getString(3);
            cs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
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
        return nombreUsuario;
    }
}
