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
import Logica.ConexionBD;
import Logica.MedicamentosSolidos;
import java.util.List;

/**
 *
 * @author ADRIANA
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        MedicamentosSolidos solidos1 = new MedicamentosSolidos();
        List<MedicamentosSolidos> lista = solidos1.listarSolidos();
        for (MedicamentosSolidos sol : lista){
            System.out.println(sol);
        }
        
    }
// TODO code application logic here
}
