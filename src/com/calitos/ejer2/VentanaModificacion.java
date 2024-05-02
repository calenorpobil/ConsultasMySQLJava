/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.calitos.ejer2;

import Excepciones.MiExcepcion;
import static com.calitos.ejer2.Ejer2.miConexion;
import gestores.GestorDB;
import java.awt.Color;
import java.awt.event.KeyEvent;
import modelo.Articulo;
import static utils.Utilidades.muestraErrorGrafico;

/**
 *
 * @author AluDAM
 */
public class VentanaModificacion extends javax.swing.JFrame {

    private final GestorDB miConexion;
    private final Ejer2 ventanaVieja;
    private final String ERROR_NO_ENCONTRADO=
            "El código de artículo no existe. ";

    /**
     * Creates new form VentanaModificacion
     * @param ventanaVieja
     * @param miConexion
     */
    public VentanaModificacion(Ejer2 ventanaVieja, GestorDB miConexion) {
        this.ventanaVieja = ventanaVieja;
        this.miConexion = miConexion;
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
        botonModificacion = new javax.swing.JButton();
        etiMensajes = new javax.swing.JLabel();
        botonVolver1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoCodigo.setText("Código");
        textoCodigo.setToolTipText("Código");
        textoCodigo.setName(""); // NOI18N
        textoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCodigoActionPerformed(evt);
            }
        });
        textoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCodigoKeyTyped(evt);
            }
        });

        textoDescripcion.setText("Descripción");
        textoDescripcion.setToolTipText("Descripción");
        textoDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDescripcionActionPerformed(evt);
            }
        });

        textoCantidad.setText("Cantidad");
        textoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCantidadActionPerformed(evt);
            }
        });

        textoPrecio.setText("Precio");
        textoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPrecioActionPerformed(evt);
            }
        });

        textoCantidadMinima.setText("Cantidad mínima");
        textoCantidadMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCantidadMinimaActionPerformed(evt);
            }
        });

        etiTitulo.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 36)); // NOI18N
        etiTitulo.setText("MODIFICACIÓN DE ARTÍCULOS");

        botonVolver.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 36)); // NOI18N
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonModificacion.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 36)); // NOI18N
        botonModificacion.setText("MODIF");
        botonModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificacionActionPerformed(evt);
            }
        });

        etiMensajes.setText("mensajes bonitos");

        botonVolver1.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 36)); // NOI18N
        botonVolver1.setText("LIMPIAR");
        botonVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiMensajes)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoCantidadMinima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(etiTitulo)))
                .addContainerGap(53, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiMensajes)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificacion)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonVolver)
                        .addComponent(botonVolver1)))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void botonModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificacionActionPerformed
        Articulo a1;

        try {
            miConexion.inicializarBBDD();
            a1 = new Articulo(
                textoCodigo.getText(),
                textoDescripcion.getText(),
                textoPrecio.getText(),
                textoCantidad.getText(),
                textoCantidadMinima.getText());
            miConexion.altaArticulo(a1);
            
            //Clase: hay que hacer st.executeUpdate();
            
            
            mensajeCorrecto();

        } catch (MiExcepcion ex) {
            mensajeIncorrecto(ex.getMessage());
        }finally{
            try {
                miConexion.cerrarConexion();
            } catch (MiExcepcion ex) {
                muestraErrorGrafico(ex.getMessage());
            }
        }
    }//GEN-LAST:event_botonModificacionActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        ventanaVieja.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void textoCantidadMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadMinimaActionPerformed
        botonModificacionActionPerformed(evt);
    }//GEN-LAST:event_textoCantidadMinimaActionPerformed

    private void textoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPrecioActionPerformed
        botonModificacionActionPerformed(evt);
    }//GEN-LAST:event_textoPrecioActionPerformed

    private void textoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadActionPerformed
        botonModificacionActionPerformed(evt);
    }//GEN-LAST:event_textoCantidadActionPerformed

    private void textoDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDescripcionActionPerformed
        botonModificacionActionPerformed(evt);
    }//GEN-LAST:event_textoDescripcionActionPerformed

    private void textoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCodigoActionPerformed
        botonModificacionActionPerformed(evt);
    }//GEN-LAST:event_textoCodigoActionPerformed

    private void botonVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolver1ActionPerformed
        limpiaFormulario();
    }//GEN-LAST:event_botonVolver1ActionPerformed

    private void textoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCodigoKeyTyped
        buscarArticulo();
    }//GEN-LAST:event_textoCodigoKeyTyped

    private void rutina() {
        setResizable(false);
        limpiaFormulario();
    }

    private void limpiaFormulario() {
        textoCodigo.setEnabled(true);
        etiMensajes.setVisible(false);
        textoCodigo.requestFocus();
        textoCantidad.setEnabled(false);
        textoCantidadMinima.setEnabled(false);
        textoPrecio.setEnabled(false);
        textoDescripcion.setEnabled(false);
        textoCodigo.setToolTipText("Código");
        textoCantidad.setToolTipText("Cantidad");
        textoCantidadMinima.setToolTipText("Cantidad mínima");
        textoDescripcion.setToolTipText("Descripción");
        textoPrecio.setToolTipText("Precio");
        textoCodigo.setText("Código");
        textoPrecio.setText("Precio");
        textoCantidad.setText("Cantidad");
        textoCantidadMinima.setText("Cantidad mínima");
        textoDescripcion.setText("Descripción");
    }
    private void mensajeCorrecto() {
        etiMensajes.setText("Enhorabuena, modificado. ");
        etiMensajes.setForeground(Color.green);
        etiMensajes.setVisible(true);
    }
    private void mensajeIncorrecto(String ex) {
        etiMensajes.setText(ex);
        etiMensajes.setForeground(Color.red);
        etiMensajes.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificacion;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton botonVolver1;
    private javax.swing.JLabel etiMensajes;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoCantidadMinima;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDescripcion;
    private javax.swing.JTextField textoPrecio;
    // End of variables declaration//GEN-END:variables

    private void buscarArticulo() {
        String codigo = textoCodigo.getText();
        
        try {
            miConexion.inicializarBBDD();
            
            if(!miConexion.existeArticulo(codigo)){
                etiMensajes.setText(ERROR_NO_ENCONTRADO);
            }else{
                textoCantidad.setEnabled(true);
                textoCantidadMinima.setEnabled(true);
                textoPrecio.setEnabled(true);
                textoDescripcion.setEnabled(true);
                textoCodigo.setEnabled(false);
            }
            
            
            
            
        } catch (MiExcepcion ex) {
            mensajeIncorrecto(ex.getMessage());
        }finally{
            try {
                miConexion.cerrarConexion();
            } catch (MiExcepcion ex) {
                muestraErrorGrafico(ex.getMessage());
            }
        }
        
    }
}
