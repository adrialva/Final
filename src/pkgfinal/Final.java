/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADRIANA
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sql;
        String driver = "com.mysql.cj.jdbc.Driver";
        String URL_bd = "jdbc:mysql://localhost:3306/prodactuz";
        String usuario = "root";
        String clave = "";
        Connection con = null;
        Statement comando = null;
        ResultSet registros = null;
        int filas_afectadas;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL_bd, usuario, clave);
            if (con != null) {
                System.out.println("Conexion Exitosa");
                comando = con.createStatement();
                sql = "select nombre from tbl_administradores";
                registros = comando.executeQuery(sql);
                while (registros.next()) {
                    System.out.println("Nombre:" + registros.getString("nombre"));
                }
                sql = "INSERT INTO tbl_administradores(nombre) VALUES ('Arnulfo');";
                filas_afectadas = comando.executeUpdate(sql);
                System.out.println("Se afectaron " + filas_afectadas + " registros");
                con.close();
            } else {
                System.out.println("Conexion No Exitosa");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Final.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Final.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// TODO code application logic here
}
