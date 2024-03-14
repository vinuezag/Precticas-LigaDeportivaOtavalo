/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



    public boolean eliminar(String cedula) {
    Connection con = getConexion();
    CallableStatement cs = null;

    try {
        cs = con.prepareCall("{call eliminarDeportista(?)}");
        cs.setString(1, cedula);

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


    public boolean buscarDeportistasPorCedula(Deportistas dep) {
    CallableStatement cs = null;
    ResultSet rs = null;
    Connection con = getConexion();

    String sql = "{call ConsultarDatosDeportista(?)}";

    try {
        cs = con.prepareCall(sql);
        cs.setString(1, dep.getCedula());

        rs = cs.executeQuery();

        // Manejo del resultado
        if (rs.next()) {
            // Establecer los atributos del objeto Deportistas con los datos obtenidos
            dep.setCedula(rs.getString("CEDULA"));
            dep.setDeporte(rs.getString("DEPORTE"));
            dep.setNombres(rs.getString("NOMBRES"));
            dep.setApellidos(rs.getString("APELLIDOS"));
            dep.setEdad(rs.getInt("EDAD"));
            dep.setGenero(rs.getString("GENERO"));
            dep.setCargo(rs.getString("CARGO"));
            dep.setCategoria(rs.getString("CATEGORIA_DEPORTISTA"));

            return true;
        } else {
            // No se encontraron datos
            System.out.println("La persona no es un deportista o no se encontró en la base de datos.");
            return false;
        }
    } catch (SQLException e) {
        System.err.println(e);
        return false;
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
}
    
    public List<Deportistas> buscarTodosLosDeportistas() {
    CallableStatement cs = null;
    ResultSet rs = null;
    Connection con = getConexion();
    List<Deportistas> deportistas = new ArrayList<>();

    String sql = "{call ConsultarDeportistas()}";

    try {
        cs = con.prepareCall(sql);
        rs = cs.executeQuery();

        // Manejo del resultado
        while (rs.next()) {
            // Crear un objeto Deportistas con los datos obtenidos
            Deportistas dep = new Deportistas();
            dep.setCedula(rs.getString("CEDULA"));
            dep.setDeporte(rs.getString("DEPORTE"));
            dep.setNombres(rs.getString("NOMBRES"));
            dep.setApellidos(rs.getString("APELLIDOS"));
            dep.setEdad(rs.getInt("EDAD"));
            dep.setCategoria(rs.getString("CATEGORIA"));
            dep.setGenero(rs.getString("GENERO"));
            dep.setCargo("Deportista"); // Especificar el cargo ya que no se obtiene del procedimiento almacenado

            deportistas.add(dep);
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

    return deportistas;
}

public List<Deportistas> buscarDeportistasPorDeporte(String deporte) {
    CallableStatement cs = null;
    ResultSet rs = null;
    Connection con = getConexion();
    List<Deportistas> deportistas = new ArrayList<>();

    String sql = "{call ListaDeportistaDeporte(?)}";

    try {
        cs = con.prepareCall(sql);
        cs.setString(1, deporte);
        rs = cs.executeQuery();

        // Manejo del resultado
        while (rs.next()) {
            // Crear un objeto Deportistas con los datos obtenidos
            Deportistas dep = new Deportistas();
            dep.setCedula(rs.getString("CEDULA"));
            dep.setNombres(rs.getString("NOMBRES"));
            dep.setApellidos(rs.getString("APELLIDOS"));
            dep.setEdad(rs.getInt("EDAD"));
            dep.setCategoria(rs.getString("CATEGORIA"));
            dep.setGenero(rs.getString("GENERO"));
            dep.setCargo("Deportista"); // Especificar el cargo ya que no se obtiene del procedimiento almacenado

            deportistas.add(dep);
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

    return deportistas;
}


}
