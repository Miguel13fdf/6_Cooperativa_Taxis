/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import Modelo.ConectPG;
import Modelo.ModeloSocios;
import Modelo.ClaseSocios;
import java.io.File;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import vista.VistaSocios;

/**
 *
 * @author alejo
 */
public class ControlSocios {
        private ModeloSocios modelo;
        private VistaSocios vista;
         private JFileChooser jfc;
         private String criterio;

    public ControlSocios(ModeloSocios modelo, VistaSocios vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        //Hacer visible la vista
    }
    public void iniciacontrol(){
        vista.getBtnActualizar().addActionListener(l->cargaPersonas()); 
        vista.getBtnCrear().addActionListener(l->abrirDialogo(1));
        vista.getBtnEditar1().addActionListener(l->abrirDialogo(2));
        vista.getBtnaceptar().addActionListener(l->crearEditarPersonaFoto());
        vista.getBtnExaminar().addActionListener(l->examinaFoto());
        vista.getBtncancelar().addActionListener(l->cancelarIngreso());
        vista.getBtnEliminar().addActionListener(l->EliminarDatos());
       vista.getBtnImprimir().addActionListener(l -> abrirJDlgImprimir());
        vista.getBtnGenerarReporte().addActionListener(l -> Imprimir());
        //busqueda incremental
        vista.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar();
            }
        });
        
//dentro de los parentesis puede hacer un
//                vista.getBtnActualizar().addActionListener(new ActionListener()> {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
    }
   private void examinaFoto(){
    jfc=new JFileChooser();
    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int estado=jfc.showOpenDialog(vista);
    if(estado==JFileChooser.APPROVE_OPTION){
        try {
            File file = jfc.getSelectedFile();
            if (file != null) {
                Image imagen=ImageIO.read(file).getScaledInstance(
                    vista.getLblfoto().getWidth(),
                    vista.getLblfoto().getHeight(),
                    Image.SCALE_DEFAULT);

                Icon icono=new ImageIcon(imagen);
                vista.getLblfoto().setIcon(icono);
                vista.getLblfoto().updateUI();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    private void Imprimir(){
//            try {
//                ConectPG cpg=new ConectPG();
//                JasperReport jr=(JasperReport)JRLoader.loadObject(getClass().getResource("/vista/reportes/Reporte mvc.jasper"));
//                JasperPrint jp=JasperFillManager.fillReport(
//                        jr, 
//                        null,cpg.getCon());
//                JasperViewer jv=new JasperViewer(jp,false);//ver el reporte y se pone false para que no se cierre el programa 
//                jv.setVisible(true);
//            } catch (JRException ex) {
//                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
//            }
             ConectPG cpg = new ConectPG();//Instanciar la conexion con esto abrimos la conexion a la BD
        try {
           JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/Cooperativa.jasper"));
         
            


            //Hacer una vista previa
            
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", vista.getTxtTitulo().getText()); //En donde esta 'titulo' tienen que ser igual al nombre que esta en el parametro del jasper
            parametros.put("limitea", (int) Math.round(Double.parseDouble(vista.getSpinnerSueldomaximo().getValue().toString())));
            parametros.put("limiteb", (int) Math.round(Double.parseDouble(vista.getSpinnerSueldominimo().getValue().toString())));//Cuando se quiere pasar un tipo de dato int '100' se coloca la 'd' despues del dato'100d'

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());//'parametros' es el Map recien creado que contiene los parametros que iran al jasper

            JasperViewer jv = new JasperViewer(jp, false); //Se pasa false para que no se cierre el sistema 
          jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControlSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
           

        
    }
    public void abrirJDlgImprimir() {
        vista.getjDlgImprimir().setLocationRelativeTo(vista);
        vista.getjDlgImprimir().setSize(400, 313);
        vista.getjDlgImprimir().setTitle("Ingresar parametros");
        vista.getjDlgImprimir().setVisible(true);
    }
        private void cargaPersonas(){
            //Control para consultar al modelo
            // y luego en la vista
//            List<Persona> listap = modelo.listaPersonas();
//            DefaultTableModel mPersona;
//            mPersona=(DefaultTableModel)vista.getTbPersona().getModel();
//            mPersona.setNumRows(0); //limpiar la tabla
//            listap.stream().forEach(Pe->{
//                String[] filanueva ={Pe.getIdPersona(),Pe.getNombre()+ " " + Pe.getApellido(),Pe.getSexo(),String.valueOf(Pe.getFechaDeNacimiento()),Pe.getTelefono(),String.valueOf(Pe.getSueldo()),String.valueOf(Pe.getCupo())}; //Se concatena para mostrar pero para guardar por separado 
//                mPersona.addRow(filanueva);
//                
//            });
             vista.getTbPersona().setDefaultRenderer(Object.class, new ImagenTabla());//La manera de renderizar la tabla.
        vista.getTbPersona().setRowHeight(100);
        
        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTbPersona().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<ClaseSocios> listap=modelo.listaPersonas("");//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        listap.stream().forEach(pe->{
            
            tblModel.addRow(new Object[9]);//Creo una fila vacia/
            vista.getTbPersona().setValueAt(pe.getCedula(), i.value, 0);
            vista.getTbPersona().setValueAt(pe.getNombres(), i.value, 1);
            vista.getTbPersona().setValueAt(pe.getDireccion(), i.value, 2);
            

            Image foto=pe.getFoto();
            if(foto!=null){
            
                Image nimg= foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono=new ImageIcon(nimg);
                DefaultTableCellRenderer renderer= new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vista.getTbPersona().setValueAt(new JLabel(icono), i.value, 3);
                
            }else{
                 vista.getTbPersona().setValueAt(null, i.value, 3);
            }
            vista.getTbPersona().setValueAt(pe.getDiscotaxi(), i.value, 4);
            vista.getTbPersona().setValueAt(pe.getPlaca_taxi(), i.value, 5);
            vista.getTbPersona().setValueAt(pe.getMarca_taxi(), i.value, 6);
             vista.getTbPersona().setValueAt(pe.getTelefono(), i.value, 7);
            
            i.value++;
//           String[] filap={pe.getIdPersona(),pe.getNombres(),pe.getApellidos(),"25"}; 
//           tblModel.addRow(filap);
        });
        }
        private void abrirDialogo(int ce){
            String title;
            if(ce==1){
                title="Crear nuevo Socio";
                vista.getDblg().setName("crear");
                //cambia el nombre del dialogo segun srea la accion realizada
                vista.getDblg().setVisible(true);
                
            }else{
                title="Editar Socio";
                vista.getDblg().setName("editar");
                 SacarDatos();
                  
            }
            vista.getDblg().setLocationRelativeTo(vista);
            vista.getDblg().setSize(800,700);
            vista.getDblg().setTitle(title);
        }
      
       private void crearEditarPersonaFoto(){
            ModeloSocios persona=new ModeloSocios();
           if(vista.getDblg().getName()=="crear"){
               persona=(ModeloSocios) cargarDatos();
               try {
                //Foto
                FileInputStream img=new FileInputStream(jfc.getSelectedFile());
                int largo=(int)jfc.getSelectedFile().length();
                persona.setImagen(img);
                persona.setLargo(largo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControlSocios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           if( persona.crearSocioByte()){
               vista.getDblg().setVisible(false);
               limpiardialogo();
               JOptionPane.showMessageDialog(vista, "Socio Creada Satisfactoriamente");
           }else{
               JOptionPane.showMessageDialog(vista, "No se pudo crear al Socio");
           }
                 
           } else {
               if (vista.getDblg().getName() == "editar") {
                  
                   persona = (ModeloSocios) cargarDatos();
                   try {
                       //Foto
                       FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                       int largo = (int) jfc.getSelectedFile().length();
                       persona.setImagen(img);
                       persona.setLargo(largo);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(ControlSocios.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if(persona.actualizarSocioByte()){
                        vista.getDblg().setVisible(false);
                        limpiardialogo();
                     JOptionPane.showMessageDialog(vista, "Socio Editada Satisfactoriamente");
                   }else{
                       JOptionPane.showMessageDialog(vista, "No se pudo editar al Socio"); 
                   }
               }

           }
           persona.listaPersonas("");
       }
       

       private void cancelarIngreso(){
           vista.getDblg().dispose();
       }
       private void limpiardialogo(){
           vista.getTxtidentificacion().setText("");
           vista.getTxtnombres().setText("");
           vista.getTxtplacataxi().setText("");
           vista.getTxtTelefono().setText("");
           vista.getTxtmarcataxi().setText("");
           vista.getTxtDIRECCION().setText("");
           vista.getTxtdisco().setText("");
           
           vista.setLblfoto(null);
       }
       private ModeloSocios cargarDatos(){
            ModeloSocios persona=new ModeloSocios();
            
            String cedula=vista.getTxtidentificacion().getText();
               String nombres=vista.getTxtnombres().getText();
               String direccion=vista.getTxtDIRECCION().getText();
               String telefono=vista.getTxtTelefono().getText();
              String placa=vista.getTxtplacataxi().getText();
              String marca=vista.getTxtmarcataxi().getText();
              
               int discotaxi=Integer.parseInt(vista.getTxtdisco().getText());
              
               persona.setCedula(cedula);
               persona.setNombres(nombres);
               persona.setDireccion(direccion);
              
               persona.setTelefono(telefono);
              
               persona.setDiscotaxi(discotaxi);
               persona.setPlaca_taxi(placa);
               persona.setMarca_taxi(marca);
               
               return persona;
           
       }

    private void SacarDatos() {
        int fila = vista.getTbPersona().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            String id = vista.getTbPersona().getValueAt(fila, 0).toString();
            String nombres = vista.getTbPersona().getValueAt(fila, 1).toString();
            String direccion=vista.getTbPersona().getValueAt(fila, 2).toString();
            String disco= (vista.getTbPersona().getValueAt(fila, 4).toString());
            String placa=vista.getTbPersona().getValueAt(fila, 5).toString();
             String marca=vista.getTbPersona().getValueAt(fila, 6).toString();
              String telefono=vista.getTbPersona().getValueAt(fila, 7).toString();
              vista.getTxtidentificacion().setText(id);
              vista.getTxtnombres().setText(nombres);
              vista.getTxtDIRECCION().setText(direccion);
              vista.getTxtdisco().setText(disco);
              vista.getTxtplacataxi().setText(placa);
              vista.getTxtmarcataxi().setText(marca);
              vista.getTxtTelefono().setText(telefono);
           vista.getDblg().setVisible(true);
        }
              
       }
       private void EliminarDatos(){
            ModeloSocios personaEliminada=new ModeloSocios();
            int fila = vista.getTbPersona().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                String cedula;
                cedula = vista.getTbPersona().getValueAt(fila, 0).toString();
                personaEliminada.setCedula(cedula);

                if (personaEliminada.eliminarSocioDB()==null) {
                    JOptionPane.showMessageDialog(null, "El socio fue eliminada exitosamente");
                    cargaPersonas();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El socio no se pudo eliminar");
                }
            }
        }
       }
       private void buscar() {
        criterio = vista.getTxtBuscar().getText().trim();

        if (!criterio.equals("")) {
            llenarTablaBusqueda();
        } else {
            cargaPersonas();
        }
    }

    private void llenarTablaBusqueda() {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vista.getTbPersona().getModel();
        estructuraTabla.setNumRows(0);
        List<ClaseSocios> listap = modelo.listaPersonas(criterio);

        Holder<Integer> i = new Holder<>(0);
        if (!listap.isEmpty()) {

           

            listap.stream().forEach(persona -> {
                estructuraTabla.addRow(new Object[3]);
                vista.getTbPersona()
                        .setValueAt(persona.getCedula(),
                                i.value, 0);
                vista.getTbPersona()
                        .setValueAt(persona.getNombres(),
                                i.value, 1);
                vista.getTbPersona()
                        .setValueAt(persona.getDireccion(),
                                i.value, 2);
          
                //Llenar imagen
                Image foto = persona.getFoto();
                if (foto != null) {
                    foto = foto.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
                    ImageIcon icono = new ImageIcon(foto);
                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                    dtcr.setIcon(icono);
                    vista.getTbPersona().setValueAt(new JLabel(icono), i.value, 3);

                } else {
                    vista.getTbPersona().setValueAt(null, i.value, 3);
                }
                      vista.getTbPersona()
                        .setValueAt(persona.getDiscotaxi(),
                                i.value, 4);
                vista.getTbPersona()
                        .setValueAt(persona.getPlaca_taxi(),
                                i.value, 5);
                vista.getTbPersona()
                        .setValueAt(persona.getMarca_taxi(),
                                i.value, 6);
                vista.getTbPersona()
                        .setValueAt(persona.getTelefono(),
                                i.value, 7);
              
                i.value++;
            });
        } 
    }
}