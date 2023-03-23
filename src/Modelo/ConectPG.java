/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejo
 */
public class ConectPG {

    Connection con;
    
    String cadenaConexion = "jdbc:postgresql://localhost:5432/Cooperativa"; // conexion String o cadena de conexion
    String usuarioPG = "postgres";
    String passPG = "12345"; //contrasenia de postgres

    public ConectPG() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectPG.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            con = DriverManager.getConnection(cadenaConexion,usuarioPG,passPG);
        } catch (SQLException ex) {
            Logger.getLogger(ConectPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet consulta(String sql){ 
        
        try { 
        Statement st = con.createStatement(); //recive como parametro la consulta
        return st.executeQuery(sql);//Ejecuto la consulta y me devuelve un 'Resultset'
        
        } catch (SQLException ex) {
            Logger.getLogger(ConectPG.class.getName()).log(Level.SEVERE, null, ex);
            return null; //Si se da la excepcion me retorna un null
        }
    }
     public SQLException accion (String sql){
        try {
            Statement st = con.createStatement();
            st.execute(sql); //Solo ejecuta la consulta y me retorna true o false
            st.close();
            return null; //retorna null si todo esta bien
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectPG.class.getName()).log(Level.SEVERE, null, ex);
            return ex; //retorna la excepcion si existio una excepcion
        }
    }
     
    public Connection getCon(){
        return con;
    }
}
