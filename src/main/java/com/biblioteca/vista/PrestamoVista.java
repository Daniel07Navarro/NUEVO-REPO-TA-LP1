package com.biblioteca.vista;

import com.biblioteca.DAO.LibroDAO;
import com.biblioteca.DAO.PrestamoDAO;
import com.biblioteca.modelo.Cliente;
import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.PrestamoReporte;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrestamoVista extends javax.swing.JPanel {
    
    public PrestamoVista(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        iniciarDatosPrestamos();
    }
    
    String c[] = {"Codigo", "Titulo", "Fecha Prestamo", "Fecha Entrega", "Estado"};
    
    DefaultTableModel modelo = new DefaultTableModel(null, c);
    
    Cliente cliente;
    
    void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    void iniciarDatosPrestamos() {
        jTablePrestamos.setModel(modelo);
        List<PrestamoReporte> prestamos = PrestamoDAO.listarPrestamosReporte(this.cliente.getIdCliente());
        for (PrestamoReporte pr : prestamos) {
            modelo.addRow(new Object[]{pr.getIdPrestamo(), pr.getNombreLibro(), pr.getFechaPrestamo(), pr.getFechaEntrega(), pr.getEstado()});
        }
    }
    
    public void limpiarTableModel(DefaultTableModel model) {
        int count = model.getRowCount() - 1;
        for (int i = count; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    void devolverLibro() {
        //UPDATE STOCK +1(LIBRO) Y ESTADO (PRESTAMO)
        int fila = jTablePrestamos.getSelectedRow();
        PrestamoDAO.devolverPrestamo((int) jTablePrestamos.getValueAt(fila, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDevolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrestamos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblCatalogoLib2 = new javax.swing.JLabel();

        btnDevolver.setText("DEVOLVER");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        jTablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Titulo", "Fecha Prestamo", "Fecha Entrega", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTablePrestamos);

        jLabel1.setText("DIBUJO");

        lblCatalogoLib2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblCatalogoLib2.setForeground(new java.awt.Color(47, 100, 183));
        lblCatalogoLib2.setText("MIS PRESTAMOS ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 389, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(144, 144, 144))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblCatalogoLib2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblCatalogoLib2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
        int fila = jTablePrestamos.getSelectedRow();
        if (fila == -1) {
            mensaje("DEBE SELECCIONAR UN LIBRO");
            return;
        }
        devolverLibro();
        limpiarTableModel(modelo);
        mensaje("LIBRO DEVUELTO");
    }//GEN-LAST:event_btnDevolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrestamos;
    private javax.swing.JLabel lblCatalogoLib2;
    // End of variables declaration//GEN-END:variables
}
