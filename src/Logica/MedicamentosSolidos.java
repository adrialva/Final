/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ADRIANA
 */
public class MedicamentosSolidos {
    String nombre;
    String descripcion;
    int cantidad;
    float precio_tableta;
    float precio_caja;
    int codigo;

    public MedicamentosSolidos() {
    }

    public MedicamentosSolidos(String nombre, String descripcion, int cantidad, float precio_tableta, float precio_caja, int codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_tableta = precio_tableta;
        this.precio_caja = precio_caja;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio_tableta() {
        return precio_tableta;
    }

    public float getPrecio_caja() {
        return precio_caja;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_tableta(float precio_tableta) {
        this.precio_tableta = precio_tableta;
    }

    public void setPrecio_caja(float precio_caja) {
        this.precio_caja = precio_caja;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return "Medicamento solido{ Nombre: " +nombre+ ", descripcion: "+ descripcion+
                ", Cantidad: "+cantidad + ", Precio tableta: "+ precio_tableta+", Precio caja: "+
                precio_caja + ", Codigo: "+codigo+"}";
    }
   
    public List<MedicamentosSolidos> listarSolidos(){
        ConexionBD conexion = new ConexionBD();
        List<MedicamentosSolidos>listaSolidos = new ArrayList<>();
        String sql ="SELECT * FROM tbl_medicamentos_solidos";
        try{
            ResultSet registros = conexion.consultarBD(sql);
            MedicamentosSolidos solidos;
            while(registros.next()){
                solidos = new MedicamentosSolidos();
                solidos.setNombre(registros.getString("Nombre"));
                solidos.setDescripcion(registros.getString("Descripcion"));
                solidos.setCantidad(registros.getInt("Cantidad"));
                solidos.setPrecio_tableta(registros.getFloat("Precio_tableta"));
                solidos.setPrecio_caja(registros.getFloat("Precio_caja"));
                solidos.setCodigo(registros.getInt("Cod_solidos"));
                listaSolidos.add(solidos);
            }
        }
        catch(SQLException ex){
            System.out.println("Error en la consulta");
        }
        return listaSolidos;
    }
    public void llenarCombo(){
        
    }
}
