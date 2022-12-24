package com.biblioteca.vista;

import com.biblioteca.DAO.LibroDAO;
import com.biblioteca.modelo.Cliente;
import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.LibroReporte;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelLibros extends javax.swing.JPanel {

    public PanelLibros() {
        initComponents();
        FlatMaterialLighterIJTheme.setup();
        iniciarTabla();
    }

    String darTitulo() {
        return txtTitulo.getText();
    }

    String darAutor() {
        return txtAutor.getText();
    }

    //PrestamoVista prestamo = new PrestamoVista();
    String c[] = {"Codigo", "Titulo", "Stock", "Año", "Editorial", "Autor"};

    DefaultTableModel modelo = new DefaultTableModel(null, c);

    ConfirmacionPrestamo confirmar = new ConfirmacionPrestamo(null, true, this);

    void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    void actualizarTabla(List<LibroReporte> lista) {
        for (LibroReporte libro : lista) {
            modelo.addRow(new Object[]{
                libro.getIdLibro(),
                libro.getTitulo(),
                libro.getStock(),
                libro.getAnio(),
                libro.getNombreEditorial(),
                libro.getNombreAutor()
            });
        }

    }

    public void limpiarTableModel(DefaultTableModel model) {
        int count = model.getRowCount() - 1;
        for (int i = count; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    void iniciarTabla() {
        jTableLibros.setModel(modelo);
        List<LibroReporte> libros = LibroDAO.listarLibros();
        actualizarTabla(libros);
    }

    void buscarPorTitulo() {
        String titulo = txtTitulo.getText();
        List<LibroReporte> libros = LibroDAO.listarLibrosByTitulo(titulo);
        limpiarTableModel(modelo);
        actualizarTabla(libros);
    }

    void buscarPorAutor() {
        String autor = txtAutor.getText();
        List<LibroReporte> libros = LibroDAO.listarLibrosByNombreAutor(autor);
        limpiarTableModel(modelo);
        actualizarTabla(libros);
    }

    Cliente cliente;

    void darCliente(Cliente cliente) {
        this.cliente = cliente;
        confirmar.traerCliente(cliente);
    }

    void darLibro() {
        int fila = jTableLibros.getSelectedRow();
        int id = (int) jTableLibros.getValueAt(fila, 0);
        Libro libro = LibroDAO.darLibro(id);
        confirmar.traerLibro(libro);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnagregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLibros = new javax.swing.JTable();
        lblCatalogoLib = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);

        btnagregar.setText("Añadir a Canasta");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jTableLibros.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTableLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Titulo", "Stock", "Editorial", "Autor"
            }
        ));
        jScrollPane1.setViewportView(jTableLibros);

        lblCatalogoLib.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblCatalogoLib.setForeground(new java.awt.Color(47, 100, 183));
        lblCatalogoLib.setText("CATALOGO LIBROS");

        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTituloKeyReleased(evt);
            }
        });

        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutorKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(47, 100, 183));
        jLabel1.setText("AUTOR");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(47, 100, 183));
        jLabel2.setText("TITULO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(lblCatalogoLib)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblCatalogoLib, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyReleased
        // TODO add your handling code here:
        buscarPorTitulo();
    }//GEN-LAST:event_txtTituloKeyReleased

    private void txtAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyReleased
        // TODO add your handling code here:
        buscarPorAutor();
    }//GEN-LAST:event_txtAutorKeyReleased

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        int fila = jTableLibros.getSelectedRow();
        if (fila == -1) {
            mensaje("DEBE SELECCIONAR UN LIBRO");
            return;
        }
        darLibro();
        confirmar.setVisible(true);
    }//GEN-LAST:event_btnagregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLibros;
    private javax.swing.JLabel lblCatalogoLib;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
