/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import Controlador.ControladorMenuPrincipal;
import vista.VistaPrincipal;

/**
 *
 * @author alejo
 */
public class Cooperativa_Taxis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         VistaPrincipal vista = new VistaPrincipal();
         ControladorMenuPrincipal controlador= new ControladorMenuPrincipal(vista);    
         controlador.iniciaControl();
    }
    
}
