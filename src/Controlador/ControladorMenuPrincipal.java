/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ModeloSocios;
import vista.VistaSocios;
import vista.VistaPrincipal;

/**
 *
 * @author alejo
 */
public class ControladorMenuPrincipal {
    VistaPrincipal vistaPrincipal;

    public ControladorMenuPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }
     public void iniciaControl(){
          vistaPrincipal.getMnPersonas().addActionListener(l->crudPersona());
            vistaPrincipal.getBtnPersonas().addActionListener(l->crudPersona());
}
    private void crudPersona(){
        //Instancio las clases del Modelo y la Vista.
        VistaSocios vistaCrudPersona = new VistaSocios();
        ModeloSocios modeloCrudPersona = new ModeloSocios();
        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getjDesktopPane1().add(vistaCrudPersona);
         ControlSocios controladorCrudPersona = new ControlSocios(modeloCrudPersona, vistaCrudPersona);
          controladorCrudPersona.iniciacontrol();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }
    public void ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }

    
}
