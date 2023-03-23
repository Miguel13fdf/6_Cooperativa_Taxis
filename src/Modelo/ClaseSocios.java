/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author USUARIO
 */
public class ClaseSocios {
    private String cedula;
    private String nombres;
    private String direccion;
    private int discotaxi;
    private String placa_taxi;
    private String marca_taxi;
      //Foto
     private Image foto;
    //Guardar la foto
     private FileInputStream imagen;
     private int largo;

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the discotaxi
     */
    public int getDiscotaxi() {
        return discotaxi;
    }

    /**
     * @param discotaxi the discotaxi to set
     */
    public void setDiscotaxi(int discotaxi) {
        this.discotaxi = discotaxi;
    }

    /**
     * @return the placa_taxi
     */
    public String getPlaca_taxi() {
        return placa_taxi;
    }

    /**
     * @param placa_taxi the placa_taxi to set
     */
    public void setPlaca_taxi(String placa_taxi) {
        this.placa_taxi = placa_taxi;
    }

    /**
     * @return the marca_taxi
     */
    public String getMarca_taxi() {
        return marca_taxi;
    }

    /**
     * @param marca_taxi the marca_taxi to set
     */
    public void setMarca_taxi(String marca_taxi) {
        this.marca_taxi = marca_taxi;
    }

    /**
     * @return the foto
     */
    public Image getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Image foto) {
        this.foto = foto;
    }

    /**
     * @return the imagen
     */
    public FileInputStream getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }
    
}
