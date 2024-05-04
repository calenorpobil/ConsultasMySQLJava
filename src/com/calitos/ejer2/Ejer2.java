/*
Ejer2_Artículos

Se desea controlar una base de datos (almacen) con los 
artículos de una empresa.  De cada artículo me interesa 
la siguiente información:

cod_art:varchar(5)
descripción: varchar(25)
cantidad: integer
cantidad_min:  integer
precio: float

En entorno gráfico crear las ventanas necesarias 
para controlar las siguientes opciones:

·Alta
·Listado
·Venta
·Listado compras
·Modificar datos.
·Compras a proveedores

Opción Modificar datos -->Se mostrará una ventana como la de Alta, y 
sólo se permitirá editar el código.  Una vez introducido el código, 
si el artículo existe se mostrarán todos sus datos y se permitirá la 
edición de todos ellos , menos del código.


 */
package com.calitos.ejer2;

import Excepciones.MiExcepcion;
import gestores.GestorDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;
import utils.Utilidades;
import static utils.Utilidades.muestraErrorGrafico;

/**
 *
 * @author AluDAM
 */
public class Ejer2 extends javax.swing.JFrame {

    private static GestorDB miConexion;
    private GestorDB conn;
    private VentanaSesion ventanaVieja;

    /**
     * Creates new form VentanaAlta
     *
     * @param conn
     */
    public Ejer2(GestorDB conn, VentanaSesion ventanaVieja) {
        this.conn = conn;
        this.ventanaVieja = ventanaVieja;
        initComponents();
        inicio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAlta = new javax.swing.JButton();
        botonListado = new javax.swing.JButton();
        botonVenta = new javax.swing.JButton();
        botonListadoCompras = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonCompras = new javax.swing.JButton();
        textMensajePosible = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAlta.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonAlta.setText("Alta");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });

        botonListado.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonListado.setText("Listado");
        botonListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListadoActionPerformed(evt);
            }
        });

        botonVenta.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonVenta.setText("Venta");

        botonListadoCompras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonListadoCompras.setText("Listado Compras");

        botonModificar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonModificar.setText("Modificar Datos");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonCompras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonCompras.setText("Compras a proveedores");

        textMensajePosible.setForeground(new java.awt.Color(102, 0, 0));
        textMensajePosible.setText("mensajePosible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonListadoCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textMensajePosible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(botonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonListado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonListadoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textMensajePosible)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListadoActionPerformed
        this.setVisible(false);
        VentanaListado vL = new VentanaListado(this, miConexion);
        vL.setVisible(true);
    }//GEN-LAST:event_botonListadoActionPerformed

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed
        VentanaAlta vA = new VentanaAlta(this, miConexion);
        vA.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonAltaActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        VentanaModificacion vM = new VentanaModificacion(this, miConexion);
        vM.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonModificarActionPerformed


    private void inicio() {
        this.setEnabled(false);
        textMensajePosible.setVisible(false);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonCompras;
    private javax.swing.JButton botonListado;
    private javax.swing.JButton botonListadoCompras;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonVenta;
    private javax.swing.JLabel textMensajePosible;
    // End of variables declaration//GEN-END:variables
}
