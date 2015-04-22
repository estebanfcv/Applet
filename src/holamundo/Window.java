package holamundo;

import Clases.ListaImagenes;
import Clases.Panel;
import Clases.Hilo;
import ConexionBD.AppletDAO;
import ConexionBD.ConexionBD;
import TO.EstudianteTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author estebanfcv
 */
public class Window extends javax.swing.JApplet {

    private int contador;
    private int tamanio;
    private Hilo hilo;

    /**
     * Initializes the applet Window
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbComenzar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbReset = new javax.swing.JButton();
        jlInstrucciones = new javax.swing.JLabel();
        jlInstrucciones2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jbAdelante = new javax.swing.JButton();
        jbAtras = new javax.swing.JButton();
        jlMinutos = new javax.swing.JLabel();
        jlSegundos = new javax.swing.JLabel();
        jlSeparador = new javax.swing.JLabel();
        jbFinalizar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jlMensajeError = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jbComenzar.setText("Comenzar");
        jbComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComenzarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        jbReset.setText("Reiniciar");
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });

        jlInstrucciones.setText("Instrucciones: A continuacion apareceran los logos de algunos de los programas que se utilizaran");

        jlInstrucciones2.setText("en el curso. Describe con tus propias palabras lo que hayas entendido de cada uno de ellos.");

        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setText("NOTA: Contesta lo mejor que puedas ya que es una evaluacion, la retroalimentacion la recibiras");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("por correo electronico asi que no olvides escribirlo. Solo podras hacer esto una vez.");

        jlNombre.setText("Nombre");

        jlCorreo.setText("E-mail");

        jLabel5.setText("Tiempo");

        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jLabel6.setText("Descripcion");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        jbAdelante.setText("Adelante");
        jbAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdelanteActionPerformed(evt);
            }
        });

        jbAtras.setText("Atras");
        jbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtrasActionPerformed(evt);
            }
        });

        jlMinutos.setText("00");

        jlSegundos.setText("00");

        jlSeparador.setText(":");

        jbFinalizar.setText("Finalizar");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jbAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCorreo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbComenzar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdelante))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlMinutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlSeparador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlSegundos)
                        .addGap(9, 9, 9)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlInstrucciones)
                            .addComponent(jlInstrucciones2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlMensajeError)
                            .addComponent(jbFinalizar))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbReset)
                    .addComponent(jLabel5)
                    .addComponent(jlMinutos)
                    .addComponent(jlSegundos)
                    .addComponent(jlSeparador))
                .addGap(15, 15, 15)
                .addComponent(jlInstrucciones)
                .addGap(5, 5, 5)
                .addComponent(jlInstrucciones2)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAdelante))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNombre)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCorreo)
                            .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbComenzar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jbAtras)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jlMensajeError)
                .addGap(18, 18, 18)
                .addComponent(jbFinalizar)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComenzarActionPerformed
        if (!util.Util.validarEmail(jtfCorreo.getText())) {
            jlMensajeError.setText("El correo no es válido");
            jlMensajeError.setForeground(Color.red);
            return;
        }
        jbComenzar.setEnabled(false);
        jbAdelante.setEnabled(true);
        jbAtras.setEnabled(true);
        jbFinalizar.setEnabled(true);
        jbGuardar.setEnabled(true);
        jbReset.setEnabled(true);
        pintarPanel();
        hilo = new Hilo(this);
        Thread thread = new Thread(hilo);
        thread.start();
    }//GEN-LAST:event_jbComenzarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // Pimer metodo en activarse, aqui se inicializaran los valores
        ConexionBD.setConexion();
        jbComenzar.setEnabled(true);
        jbAdelante.setEnabled(false);
        jbAtras.setEnabled(false);
        jbFinalizar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbReset.setEnabled(false);
        contador = 0;
        jtfNombre.setText("");
        jlMinutos.setText("00");
        jlSegundos.setText("00");
        jtfCorreo.setText("");
        ListaImagenes.armarListaImagenes();
        tamanio = ListaImagenes.getTamanio();
    }//GEN-LAST:event_formComponentShown

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        hilo.setCorriendo(false);
        ListaImagenes.armarListaImagenes();
        jbComenzar.setEnabled(true);
        jbAdelante.setEnabled(false);
        jbAtras.setEnabled(false);
        jbFinalizar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbReset.setEnabled(false);
        jtfNombre.setText("");
        jtfCorreo.setText("");
        jlMinutos.setText("00");
        jlSegundos.setText("00");
        contador = 0;

    }//GEN-LAST:event_jbResetActionPerformed

    public void abrirVentana() {
        JOptionPane.showMessageDialog(null, "Se acabó el tiempo");
        hilo.reanudarHilo();
        hilo.setCorriendo(false);
        insertarDatos();
    }

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtrasActionPerformed
        try {
            contador--;
            if (contador < 0) {
                contador = tamanio - 1;
            }
            pintarPanel();
            jtaDescripcion.setText(ListaImagenes.getDescripcion(contador));
        } catch (Exception e) {
            jLabel2.setText(e.getMessage());
        }
    }//GEN-LAST:event_jbAtrasActionPerformed

    private void jbAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdelanteActionPerformed
        try {
            contador++;
            if (contador == tamanio) {
                contador = 0;
            }
            pintarPanel();
            jtaDescripcion.setText(ListaImagenes.getDescripcion(contador));
        } catch (Exception e) {
            jLabel2.setText(e.getMessage());
        }
    }//GEN-LAST:event_jbAdelanteActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        ListaImagenes.setDescripcion(contador, jtaDescripcion.getText());
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        hilo.suspenderHilo();
        boolean vacio = false;
        for (int i = 0; i < tamanio; i++) {
            if (ListaImagenes.getDescripcion(i).isEmpty()) {
                vacio = true;
                break;
            }
        }
        if (vacio) {
            String titulo = "Notificación";
            String mensaje = "¿Desea finalizar la prueba ? \n Dejo preguntas sin contestar";
            int x = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (x == 0) { // si
                hilo.reanudarHilo();
                hilo.setCorriendo(false);
                insertarDatos();
            } else { // no
                hilo.reanudarHilo();
            }
        } else {

            hilo.reanudarHilo();
            hilo.setCorriendo(false);
            insertarDatos();
        }
    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void insertarDatos() {
        EstudianteTO estudiante = new EstudianteTO();
        estudiante.setNombre(jtfNombre.getText());
        estudiante.setEmail(jtfCorreo.getText());
        estudiante.setFecha(new Date());
        estudiante.setTiempo(jlMinutos + ":" + jlSegundos);
        int id = AppletDAO.insertarEstudiante(estudiante);
        if (id == 0) {
            jlMensajeError.setText("Hubo un error al insertar los datos del estudiante.");
            jlMensajeError.setForeground(Color.red);
            return;
        }
        if (!AppletDAO.insertarRespuestas(ListaImagenes.getLista(), id)) {
            jlMensajeError.setText("Hubo un error al insertar las resupuestas.");
            jlMensajeError.setForeground(Color.red);
            return;
        }
        jlMensajeError.setText("La inserción se realizó con éxito. Se le enviará un correo a tu profesor para evaluarte.");
        jlMensajeError.setForeground(Color.green);
    }

    private void pintarPanel() {
        jPanel1.removeAll();
        Panel p = new Panel(ListaImagenes.getNombreImagen(contador));
        jPanel1.add(p, BorderLayout.CENTER);
        jPanel1.repaint();
    }

    public JLabel getJlMinutos() {
        return jlMinutos;
    }

    public void setJlMinutos(JLabel jlMinutos) {
        this.jlMinutos = jlMinutos;
    }

    public JLabel getJlSegundos() {
        return jlSegundos;
    }

    public void setJlSegundos(JLabel jlSegundos) {
        this.jlSegundos = jlSegundos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdelante;
    private javax.swing.JButton jbAtras;
    private javax.swing.JButton jbComenzar;
    private javax.swing.JButton jbFinalizar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbReset;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlInstrucciones;
    private javax.swing.JLabel jlInstrucciones2;
    private javax.swing.JLabel jlMensajeError;
    private javax.swing.JLabel jlMinutos;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSegundos;
    private javax.swing.JLabel jlSeparador;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
