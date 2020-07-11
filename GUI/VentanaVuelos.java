/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Aeropuerto;
import Data.Vuelo;
import business.mainClass;
import datastructures.MyQueue;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juansevargas
 */
public class VentanaVuelos extends javax.swing.JFrame {

    /**
     * Creates new form VentanaVuelos
     */
    public VentanaVuelos() 
    {
        modelo = new DefaultTableModel();
        initComponents();
        
        this.jTableVuelos.setModel(modelo);
        setColumnsVuelo();
        
        
        
        this.setLocationRelativeTo(null);
    }

    public void setColumnsVuelo()
    {
        modelo.addColumn("Id");
        modelo.addColumn("Aerolinea");
        modelo.addColumn("Código");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Hora Llegada");
    }
    
    public DefaultTableModel getModelo() {
        return modelo;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelTituloVuelos = new javax.swing.JLabel();
        jButtonrRegresarVuelos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVuelos = new javax.swing.JTable();
        jButtonSalidas = new javax.swing.JButton();
        jButtonLlegadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(760, 590));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(760, 590));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 614));

        jLabelTituloVuelos.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabelTituloVuelos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloVuelos.setText("VUELOS");
        jLabelTituloVuelos.setPreferredSize(new java.awt.Dimension(760, 590));

        jButtonrRegresarVuelos.setBackground(new java.awt.Color(153, 153, 153));
        jButtonrRegresarVuelos.setForeground(new java.awt.Color(0, 51, 51));
        jButtonrRegresarVuelos.setText("<Regresar");
        jButtonrRegresarVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrRegresarVuelosActionPerformed(evt);
            }
        });

        jTableVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableVuelos);

        jButtonSalidas.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jButtonSalidas.setText("Salidas");
        jButtonSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalidasActionPerformed(evt);
            }
        });

        jButtonLlegadas.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jButtonLlegadas.setText("Llegadas");
        jButtonLlegadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLlegadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButtonrRegresarVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(736, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTituloVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonSalidas)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonLlegadas))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelTituloVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalidas)
                            .addComponent(jButtonLlegadas))
                        .addGap(45, 45, 45)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButtonrRegresarVuelos)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonrRegresarVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrRegresarVuelosActionPerformed
        // TODO add your handling code here:
        VentanaAeropuerto0 inicio = new VentanaAeropuerto0();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonrRegresarVuelosActionPerformed

    private void jButtonSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalidasActionPerformed
        try {
            // TODO add your handling code here:
            mainClass.cargarVuelosOrdenadosSalida(0);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(VentanaVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSalidasActionPerformed

    private void jButtonLlegadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLlegadasActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            mainClass.cargarVuelosOrdenadosLlegada(0);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(VentanaVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLlegadasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLlegadas;
    private javax.swing.JButton jButtonSalidas;
    private javax.swing.JButton jButtonrRegresarVuelos;
    private javax.swing.JLabel jLabelTituloVuelos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableVuelos;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel modelo;
    
    public void rellenarTablaOrdenada(MyQueue<Vuelo> vuelos)
    {
        this.modelo.setRowCount(0);
        
        Object[] fila;
        for (Vuelo v: vuelos) 
        {
            fila = new Object[7];
            fila[0] = v.getIdVuelo();
            fila[1] = v.getAerolinea().getCodigoIdentificador();
            //fila[1] = "av";
            fila[2] = v.getCodigo();
            fila[3] = v.getOrigen();
            fila[4] = v.getDestino();
            fila[5] = (v.getHoraSalida().get(Calendar.HOUR_OF_DAY) + ":" + v.getHoraSalida().get(Calendar.MINUTE));
            //fila[5] = "5:30";
            fila[6] = (v.getHoraLlegada().get(Calendar.HOUR_OF_DAY) + ":" + v.getHoraLlegada().get(Calendar.MINUTE));
            //fila[6] = "10:30";
            this.modelo.addRow(fila);
        }
        
    }
    /**
     * 
     * @param a 
     */
    public void rellenarTablaVuelo(Aeropuerto a)
    {
        this.modelo.setRowCount(0);
        MyQueue<Vuelo> vuelos = a.getVuelos();
        
        Object[] fila;
        for (Vuelo v: vuelos) 
        {
            fila = new Object[7];
            fila[0] = v.getIdVuelo();
            fila[1] = v.getAerolinea().getCodigoIdentificador();
            //fila[1] = "av";
            fila[2] = v.getCodigo();
            fila[3] = v.getOrigen();
            fila[4] = v.getDestino();
            fila[5] = (v.getHoraSalida().get(Calendar.HOUR_OF_DAY) + ":" + v.getHoraSalida().get(Calendar.MINUTE));
            //fila[5] = "5:30";
            fila[6] = (v.getHoraLlegada().get(Calendar.HOUR_OF_DAY) + ":" + v.getHoraLlegada().get(Calendar.MINUTE));
            //fila[6] = "10:30";
            this.modelo.addRow(fila);
        }
        
    }
    
}
