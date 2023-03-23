/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alejo
 */
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ModeloSocios extends ClaseSocios {

    ConectPG cpg = new ConectPG();

    public ModeloSocios() {
    }

    public ModeloSocios(String cedula, String nombres, String direccion, int discotaxi, String placa_taxi, String marca_taxi, String telefono, Image foto, FileInputStream imagen, int largo) {
        super(cedula, nombres, direccion, discotaxi, placa_taxi, marca_taxi, telefono, foto, imagen, largo);
    }

    public List<ClaseSocios> listaPersonas(String filtro) {
        try {
            List<ClaseSocios> lista = new ArrayList<>();

            String sql = "SELECT cedula, nombres, direccion, discotaxi, placataxi, marca, telefono ,foto FROM socios WHERE ";
            sql += "UPPER(cedula) LIKE UPPER('%" + filtro + "%') ";
            sql += "OR UPPER(nombres) LIKE UPPER('%" + filtro + "%') ";
            sql += "OR UPPER(direccion) LIKE UPPER('%" + filtro + "%') ";

            ConectPG conpg = new ConectPG();
            ResultSet rs = conpg.consulta(sql);

            while (rs.next()) {
                ClaseSocios persona = new ClaseSocios();
                persona.setCedula(rs.getString("cedula"));
                persona.setNombres(rs.getString("nombres"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setDiscotaxi(rs.getInt("discotaxi"));
                persona.setPlaca_taxi(rs.getString("placataxi"));
                persona.setMarca_taxi(rs.getString("marca"));
                persona.setTelefono(rs.getString("telefono"));

                // Proceso de conversión de la foto
                byte[] bytea = rs.getBytes("foto");
                if (bytea != null) {
                    persona.setFoto(obtenerImagen(bytea));
                }

                lista.add(persona);
            }

            rs.close();

            return lista;

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ImageInputStream iis = ImageIO.createImageInputStream(bis);
        Iterator<ImageReader> it = ImageIO.getImageReaders(iis);

        if (!it.hasNext()) {
            throw new IOException("No se encontró un lector de imágenes para el formato proporcionado");
        }

        ImageReader reader = it.next();
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);

    }

    public boolean crearSocioByte() {
        try {
            String sql = "INSERT INTO socios (cedula, nombres, direccion, foto, discotaxi, placataxi, marca,telefono) ";
            sql += "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setString(1, getCedula());
            ps.setString(2, getNombres());
            ps.setString(3, getDireccion());
            ps.setBinaryStream(4, getImagen(), getLargo());
            ps.setInt(5, getDiscotaxi());
            ps.setString(6, getPlaca_taxi());
            ps.setString(7, getMarca_taxi());
            ps.setString(8, getTelefono());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloSocios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizarSocioByte() {
        try {
            String sql = "UPDATE socios SET nombres=?, direccion=?, foto=?, discotaxi=?, placataxi=?, marca=? WHERE cedula=?";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setString(1, getNombres());
            ps.setString(2, getDireccion());
            ps.setBinaryStream(3, getImagen(), getLargo());
            ps.setInt(4, getDiscotaxi());
            ps.setString(5, getPlaca_taxi());
            ps.setString(6, getMarca_taxi());
            ps.setString(7, getCedula());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloSocios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public SQLException eliminarSocioDB() { //eliminas la instancia en la BD

        String sql = "DELETE FROM socios WHERE cedula = '" + getCedula() + "';";

        ConectPG conpg = new ConectPG();

        SQLException ex = conpg.accion(sql); //Devuelve un valor de tipo "SQLException". Si devuelve 'null' esta bien, caso contrario me retornara la excepcion.
        return ex;
    }

}
