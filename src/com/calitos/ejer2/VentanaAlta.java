/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.calitos.ejer2;

import Excepciones.MiExcepcion;
import static com.calitos.ejer2.Ejer2.miConexion;
import copiarArchivos.Utilidades;
import static copiarArchivos.Utilidades.muestraErrorGrafico;
import gestores.GestorDB;
import modelo.Articulo;

/**
 *
 * @author AluDAM
 */
public class VentanaAlta extends javax.swing.JFrame {

    Ejer2 ventanaVieja;
    GestorDB conn;
    /**
     * Creates new form VentanaAlta
     */
    public VentanaAlta(Ejer2 ventanaVieja, GestorDB miConexion) {
        this.ventanaVieja = ventanaVieja;
        this.conn = miConexion;
        initComponents();
        rutina();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoCodigo = new javax.swing.JTextField();
        textoDescripcion = new javax.swing.JTextField();
        textoCantidad = new javax.swing.JTextField();
        textoPrecio = new javax.swing.JTextField();
        textoCantidadMinima = new javax.swing.JTextField();
        etiTitulo = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        botonAlta = new javax.swing.JButton();
        etiMensajes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoCodigo.setText("Código");

        textoDescripcion.setText("Descripción");

        textoCantidad.setText("Cantidad");

        textoPrecio.setText("Precio");

        textoCantidadMinima.setText("Cantidad mínima");

        etiTitulo.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        etiTitulo.setText("ALTA DE ARTÍCULOS");

        botonVolver.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 36)); // NOI18N
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonAlta.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 36)); // NOI18N
        botonAlta.setText("ALTA");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });

        etiMensajes.setText("mensajes bonitos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(etiTitulo)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(etiMensajes)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(etiTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiMensajes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(botonAlta))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        ventanaVieja.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed
        
        
        try {
            miConexion.inicializarBBDD();
            miConexion.altaArticulo(new Articulo(
                    textoCodigo.getText(), 
                    textoDescripcion.getText(), 
                    textoPrecio.getText(), 
                    textoCantidad.getText(), 
                    textoCantidadMinima.getText()));
            
            
            
        } catch (MiExcepcion ex) {
            muestraErrorGrafico(ex.getMessage());
        }finally{
            try {
                miConexion.cerrarConexion();
            } catch (MiExcepcion ex) {
                muestraErrorGrafico(ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_botonAltaActionPerformed

    private void rutina() {
        etiMensajes.setVisible(false);
        textoCodigo.requestFocus();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel etiMensajes;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoCantidadMinima;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDescripcion;
    private javax.swing.JTextField textoPrecio;
    // End of variables declaration//GEN-END:variables
}