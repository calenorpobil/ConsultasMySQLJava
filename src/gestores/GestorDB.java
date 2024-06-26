/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import Excepciones.MiExcepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;

/**
 *
 * @author AluDAM
 */
public class GestorDB {

    private String user;
    private String db; //Se llamaba centro
    private String conexion, password;

    private Connection conn;

    public GestorDB(String user, String db, String conexion, String password) {
        this.user = user;
        this.db = db;
        this.conexion = conexion;
        this.password = password;
        this.conn = null;
    }
    
    public boolean isMysqlEncendido() throws MiExcepcion{
        boolean encendido = false;
        String databaseName;
        ResultSet resultSet = null;
        try {
            resultSet = conn.getMetaData().getCatalogs();
            // Iterate each catalog in the ResultSet
            while (resultSet.next()) {
                databaseName = resultSet.getString(1);
                 // Get the database name, which is at position 1
                 return true;
            }
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la Base de Datos... "+ex.getErrorCode());
        } finally{
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                throw new MiExcepcion(ex.getMessage());
            }
        }
        return encendido;
    }

    public int altaArticulo(Articulo al) throws MiExcepcion {
        PreparedStatement st = null;
        String sentencia = "INSERT INTO articulos VALUES(?, ?, ?, ?, ?);";
        try {
            //NO USAR STATEMENT
            st = this.conn.prepareStatement(
                    sentencia
            );
            //Insertamos los valores en cada interrogante
            st.setString(1, al.getCod_art());
            st.setString(2, al.getDescripcion());
            st.setFloat(3, al.getPrecio());
            st.setInt(4, al.getCantidad());
            st.setInt(5, al.getCantidad_min());
            return st.executeUpdate();
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1062 -> {
                    throw new MiExcepcion("Clave Duplicada: " + al.getCod_art());
                }
                case 1064 -> {
                    throw new MiExcepcion("Sentencia SQL mal escrita. ");
                }
                case 1406 -> {
                    throw new MiExcepcion("Datos no válidos. ");
                }
            }
            throw new MiExcepcion("Error en la sentencia SQL que dice: " + sentencia + "\n"
                    + "Código: " + ex.getErrorCode()+"\n\n\n"+ex.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
            } catch (SQLException | NullPointerException ex) {
                throw new MiExcepcion("Error insertando. Posible pérdida de información. ");
            }
        }

    }

    public void cerrarConexion() throws MiExcepcion {
        try {
            //Si no se hace esto, no se guardan los datos
            if (conn != null) {
                this.conn.close();
                System.out.println("Puerta cerrada, soy feliz. ");
            } else {
                System.out.println("Ni siquiera habia una conexion, como voy a cerrar...");
            }
        } catch (SQLException ex) {
            throw new MiExcepcion("Problemas al cerrar , posible pérdida de información \n" + ex.getMessage()
                    + " --> " + ex.getErrorCode());
        }
    }

    public void inicializarBBDD() throws MiExcepcion {
        //o initDataBase
        try {
            //cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conectamos con una BBDD concreta: 
            this.conn = DriverManager.getConnection(conexion + db, user, password);
            System.out.println("Conexion abierta CUIDAO");
        } catch (ClassNotFoundException ex) {
            throw new MiExcepcion("Acuérdate de añadir la dependencia en el "
                    + "archivo po.xml. Cópialo del Ejer1. ");
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1045->{
                    throw new MiExcepcion("Usuario o contraseña incorrectos. ");
                }default ->{
                    throw new MiExcepcion(
                        "La Base de Datos esta apagada...\n"
                        + "Mira el programa sin hacer nada ;)\n\n"
                        + ex.getErrorCode());
                }
                    
            }
        }
    }

    public String[][] listado() throws MiExcepcion {
        String resultado = "";

        PreparedStatement st = null;
        ArrayList<String[]> res = new ArrayList<>();
        String sentencia = "select * from articulos;";
        try {
            //NO USAR STATEMENT
            st = this.conn.prepareStatement(
                    sentencia
            );
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Articulo ar = new Articulo(
                        rs.getString(1), 
                        rs.getString(2),
                        rs.getFloat(3), 
                        rs.getInt(4), 
                        rs.getInt(5));

                res.add(ar.toArrayListado());
            }
            String [][] listado = res.toArray(new String[0][0]);

            return listado;
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la sentencia SQL que dice: " + sentencia + "\n"
                    + "Código: " + ex.getErrorCode());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException | NullPointerException ex) {
                throw new MiExcepcion("Error cerrando... \n"
                        + "Posible pérdida de información. ");
            }
        }

    }
    public Articulo pasaDatos(String codigo) throws MiExcepcion {
        String resultado = "";

        PreparedStatement st = null;
        String sentencia = "select * from articulos where cod_art = ?;";
        Articulo ar = null;
        try {
            //NO USAR STATEMENT
            inicializarBBDD();
            st = this.conn.prepareStatement(
                    sentencia
            );
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            String[] res = new String[rsmd.getColumnCount()];

            int vez=0;
            while (rs.next()) {
                ar = new Articulo(
                        rs.getString(1), 
                        rs.getString(2),
                        rs.getFloat(3), 
                        rs.getInt(4), 
                        rs.getInt(5));
            }

            return ar;
        } catch (SQLException ex) {
            throw new MiExcepcion(ex.getMessage());
//            throw new MiExcepcion("Error en la sentencia SQL que dice: " + sentencia + "\n"
//                    + "Código: " + ex.getErrorCode());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                cerrarConexion();
            } catch (SQLException | NullPointerException ex) {
                throw new MiExcepcion("Error cerrando... \n"
                        + "Posible pérdida de información. ");
            }
        }

    }

    public boolean existeArticulo(String codigo) throws MiExcepcion {
        String resultado =null;
        PreparedStatement st = null;
        String sentencia = "SELECT cod_art FROM articulos WHERE cod_art = ?;";
        try {
            inicializarBBDD();
            //NO USAR STATEMENT
            st = this.conn.prepareStatement(
                    sentencia
            );
            //Insertamos los valores en cada interrogante
            st.setString(1, codigo);
            
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                resultado+=rs.getString(1);
                System.out.println("Buscando... "+resultado);
            }
            return resultado!=null;
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la sentencia SQL que dice: " + sentencia + "\n"
                    + "Código: " + ex.getErrorCode()+"\n\n\n"+ex.getMessage());
        } finally {
            try {
                if (st!=null) {
                    st.close();
                }
            } catch (SQLException | NullPointerException ex) {
                throw new MiExcepcion("Error insertando. Posible pérdida de información. ");
            }
            cerrarConexion();
        }

    }

}
