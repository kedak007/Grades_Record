/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Evaluacion;
import model.sql.EvaluacionGrupo;
import model.InstanciaEvaluacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.sql.Miembro;

/**
 *
 * @author KEDAC
 */
public class JDlgDiseño extends javax.swing.JDialog {

    private String codigoGrupo;
    private ArrayList<Evaluacion> evaluaciones;
    private boolean evaluado;
    DefaultTableModel tablaEvaluaciones;

    /**
     * Creates new form JDlgDiseño
     */
    public JDlgDiseño(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        evaluaciones = new ArrayList<>();
        tablaEvaluaciones = new DefaultTableModel();
        tablaEvaluaciones.addColumn("Tipo de Evaluación");
        tablaEvaluaciones.addColumn("Porcentaje");
        tablaEvaluaciones.addColumn("Tipo de Instancia");
        tablaEvaluaciones.addColumn("Cantidad de Instancia");
        this.jTblEvaluaciones.setModel(tablaEvaluaciones);
        setIconImage(new ImageIcon(getClass().getResource("/view/source/favicon.ico")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/view/source/fondo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
    }

    public void setCodigoGrupo(String pCodigo) throws SQLException {
        this.codigoGrupo = pCodigo;
    }

    public void cargarEvaluaciones() throws SQLException {
        ArrayList<String> evaluacionesG = EvaluacionGrupo.getInstance().evaluacionGrupo(this.codigoGrupo);
        if (!evaluacionesG.isEmpty()) {
            String[] informacion = new String[4];
            int j = 0;
            for (String evaluacionesG1 : evaluacionesG) {
                informacion[j] = evaluacionesG1;
                j++;
                if (j == 4) {
                    this.tablaEvaluaciones.addRow(informacion);
                    j = 0;
                }
            }
            this.jBtnEvaluacion.setEnabled(false);
            this.jBtnModificarProcentaje.setEnabled(false);
            this.evaluado = true;
        } else {
            this.evaluado = false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnEvaluacion = new javax.swing.JButton();
        jBtnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEvaluaciones = new javax.swing.JTable();
        jBtnModificarProcentaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diseño de Evaluación");
        setResizable(false);

        jBtnEvaluacion.setText("Agregar Evaluación");
        jBtnEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEvaluacionActionPerformed(evt);
            }
        });

        jBtnFinalizar.setText("Finalizar Diseño");
        jBtnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFinalizarActionPerformed(evt);
            }
        });

        jTblEvaluaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTblEvaluaciones.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTblEvaluaciones);

        jBtnModificarProcentaje.setText("Modificar Porcentaje");
        jBtnModificarProcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarProcentajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnEvaluacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnModificarProcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jBtnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEvaluacion)
                    .addComponent(jBtnFinalizar)
                    .addComponent(jBtnModificarProcentaje))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEvaluacionActionPerformed
        this.setVisible(false);
        JDlgEvaluacion evaluacion = new JDlgEvaluacion(null, true);
        try {
            evaluacion.setCodigoGrupo(this.codigoGrupo);
            evaluacion.cargarTipoEvaluaciones();
        } catch (SQLException ex) {
            Logger.getLogger(JDlgDiseño.class.getName()).log(Level.SEVERE, null, ex);
        }
        evaluacion.setLocationRelativeTo(null);
        evaluacion.setVisible(true);
        Evaluacion temporal = evaluacion.getEvaluacion();
        boolean existe = false;
        for (Evaluacion _evaluacion : evaluaciones) {
            if (_evaluacion.getTipoEvaluacion().equals(temporal.getTipoEvaluacion())) {
                JOptionPane.showMessageDialog(rootPane, "Ya existe una Evaluación de ese Tipo!");
                existe = true;
            }
        }
        if (!existe) {
            this.evaluaciones.add(temporal);
            String[] informacion = new String[4];
            informacion[0] = temporal.getTipoEvaluacion();
            informacion[1] = temporal.getPorcentaje() + "%";
            informacion[2] = temporal.getTipoInstancia();
            informacion[3] = temporal.getCantidadInstancia() + "";
            this.tablaEvaluaciones.addRow(informacion);
        }
        this.setVisible(true);
    }//GEN-LAST:event_jBtnEvaluacionActionPerformed

    private void jBtnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFinalizarActionPerformed
        if (this.evaluado) {
            this.setVisible(false);
        } else {
            float porcentaje = 0;
            for (Evaluacion evaluacion : evaluaciones) {
                porcentaje += evaluacion.getPorcentaje();
            }
            if (porcentaje == 100) {
                this.setVisible(false);
                for (Evaluacion e : evaluaciones) {
                    try {
                        EvaluacionGrupo.getInstance().insertarEvaluacion(this.codigoGrupo, e.getTipoEvaluacion(), e.getPorcentaje(), e.getCantidadInstancia(), e.getTipoInstancia());
                        if (e.getTipoInstancia().equals("Fija")) {
                            for (InstanciaEvaluacion inst : e.getInstancias()) {
                                EvaluacionGrupo.getInstance().insertarInstancia(this.codigoGrupo, e.getTipoEvaluacion(), inst.getValor(), inst.getDescripcion(), inst.getFecha());
                                ArrayList<String> miembros = Miembro.getInstance().miembrosGrupo(this.codigoGrupo);
                                for (String miembro : miembros) {
                                    EvaluacionGrupo.getInstance().inicializarNotas(miembro, codigoGrupo, e.getTipoEvaluacion());
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JDlgDiseño.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "Diseño realizado con éxito!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "El porcentaje debe de sumar 100!");
            }
        }
    }//GEN-LAST:event_jBtnFinalizarActionPerformed

    private void jBtnModificarProcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarProcentajeActionPerformed
        JDlgModificarPorcentaje modificar = new JDlgModificarPorcentaje(null, true);
        modificar.setEvaluaciones(this.evaluaciones);
        modificar.esEvaluacion();
        modificar.cargarEvaluaciones();
        modificar.setLocationRelativeTo(null);
        modificar.setVisible(true);
        this.evaluaciones = modificar.getEvaluaciones();
        for (int i = 0; i < evaluaciones.size(); i++) {
            if (this.tablaEvaluaciones.getValueAt(i, 0).equals(evaluaciones.get(i).getTipoEvaluacion())) {
                this.tablaEvaluaciones.setValueAt(evaluaciones.get(i).getPorcentaje() + "%", i, 1);
            }
        }
    }//GEN-LAST:event_jBtnModificarProcentajeActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgDiseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgDiseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgDiseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgDiseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgDiseño dialog = new JDlgDiseño(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEvaluacion;
    private javax.swing.JButton jBtnFinalizar;
    private javax.swing.JButton jBtnModificarProcentaje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblEvaluaciones;
    // End of variables declaration//GEN-END:variables
}
