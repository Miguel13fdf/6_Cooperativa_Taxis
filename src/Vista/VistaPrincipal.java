/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author alejo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    public JMenuItem getMnItmCrearPersona() {
        return MnItmCrearPersona;
    }

    public void setMnItmCrearPersona(JMenuItem MnItmCrearPersona) {
        this.MnItmCrearPersona = MnItmCrearPersona;
    }

    public JButton getBtnListaPersonas() {
        return btnListaPersonas;
    }

    public void setBtnListaPersonas(JButton btnListaPersonas) {
        this.btnListaPersonas = btnListaPersonas;
    }

    public JButton getBtnPersonas() {
        return btnPersonas;
    }

    public void setBtnPersonas(JButton btnPersonas) {
        this.btnPersonas = btnPersonas;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public void setBtnProductos(JButton btnProductos) {
        this.btnProductos = btnProductos;
    }

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        this.setTitle("Examen En Clases  - PROMAGAMACION VISUAL - ALEJANDRO HARO");
        this.setVisible(true);
    }

    public JMenu getMnPersonas() {
        return MnPersonas;
    }

    public void setMnPersonas(JMenu MnPersonas) {
        this.MnPersonas = MnPersonas;
    }

   

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }


  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnPersonas = new javax.swing.JButton();
        btnListaPersonas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnProductos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnPersonas = new javax.swing.JMenu();
        MnItmCrearPersona = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        lblMensaje.setText("Tienda v1.1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(710, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jToolBar1.setRollover(true);

        btnPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/user.png"))); // NOI18N
        btnPersonas.setToolTipText(" Crear Persona (Alt + P)");
        btnPersonas.setFocusable(false);
        btnPersonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPersonas);

        btnListaPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/application.png"))); // NOI18N
        btnListaPersonas.setToolTipText("Listado de Personas");
        btnListaPersonas.setFocusable(false);
        btnListaPersonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListaPersonas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnListaPersonas);
        jToolBar1.add(jSeparator3);

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/maximize.png"))); // NOI18N
        btnProductos.setToolTipText("Mantenimiento de Productos");
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnProductos);

        MnPersonas.setText("Socios");

        MnItmCrearPersona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        MnItmCrearPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/user.png"))); // NOI18N
        MnItmCrearPersona.setText("Crear Socios");
        MnPersonas.add(MnItmCrearPersona);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/application.png"))); // NOI18N
        jMenuItem1.setText("Lista Socios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MnPersonas.add(jMenuItem1);
        MnPersonas.add(jSeparator1);
        MnPersonas.add(jSeparator2);

        jMenuBar1.add(MnPersonas);

        jMenu4.setText("Salir");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnItmCrearPersona;
    private javax.swing.JMenu MnPersonas;
    private javax.swing.JButton btnListaPersonas;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}
