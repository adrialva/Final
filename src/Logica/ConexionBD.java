/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ADRIANA
 */

package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgfinal.Final;
/**
 *
 * @author ADRIANA
 */
public class ConexionBD {
    String sql;
        String driver = "com.mysql.cj.jdbc.Driver";
        String URL_bd = "jdbc:mysql://localhost:3306/prodactuz";
        String usuario = "root";
        String clave = "";
        Connection con = null;
        Statement comando = null;
        ResultSet registros = null;
        int filas_afectadas;
        String lugares[] = null;

    public String[] getLugares() {
        return lugares;
    }

    public ConexionBD() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_bd, usuario, clave);
            if (con != null) {
                System.out.println("Conexion Exitosa");
                comando = con.createStatement();
            } else {
                System.out.println("Conexion No Exitosa");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet consultarBD(String sentencia) {
        try {
            comando = con.createStatement();
            registros = comando.executeQuery(sentencia);
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return registros;
    }
    public void llenarCombo(){
        ResultSet registros2 = null;
        
        int longitud=0;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_bd, usuario, clave);
            if (con != null) {
                sql = "SELECT * FROM `tbl_lugares`  WHERE `cod_lugares` ";
                comando = con.createStatement();
                registros2 = comando.executeQuery(sql);
                while(registros2.next()){
                    longitud = registros2.getInt("cod_lugares");
                }
                registros = comando.executeQuery(sql);    
                int i=0;
                lugares = new String [longitud];
                while (registros.next()) {
                        lugares[i]= registros.getString("nombre");
                        System.out.println(lugares[i] + i);
                        i=i+1;
                    }
                con.close();
            } else {
                System.out.println("Conexion No Exitosa");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
