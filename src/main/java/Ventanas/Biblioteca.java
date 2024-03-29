/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import static Main.Main.Vpri;
import static Ventanas.Principal.usuario;
import Estructuras.ListaImagenes;
import static Ventanas.Principal.listausuarios;
import static Ventanas.Principal.listacategorias;
import static Ventanas.Principal.indexusuario;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pablo
 */
public class Biblioteca extends javax.swing.JFrame {

    public JFileChooser Varc = new JFileChooser();
    public ListaImagenes listaimagenes = listacategorias.getListaImagenes(0);
    public DefaultListModel lista = new DefaultListModel();

    public boolean modificado = false;

    /**
     * Creates new form Biblioteca
     */
    public Biblioteca() {
        initComponents();
        this.setLocationRelativeTo(null);
        jList1.setModel(lista);
        jList1.setSelectedIndex(0);

        jLabel4.setIcon(new ImageIcon("C:\\Users\\pablo\\Documents\\NetBeansProjects\\Proyecto2\\src\\main\\java\\image\\default.jpg"));

        Varc.setFileFilter(new FileNameExtensionFilter("Imagenes (*.jpg, *.bmp)", "jpg", "JPG", "jpeg", "JPEG", "bmp", "BMP"));
        Varc.setAcceptAllFileFilterUsed(false);
        Varc.setMultiSelectionEnabled(true);

        for (int i = 0; i < listacategorias.getSize(); i++) {
            lista.addElement(listacategorias.getNombre(i));
            System.out.println("Se agrego la categoría " + i + ": " + listacategorias.getNombre(i));
        }
    }

    /**
     * @param img Imagen para redimensionar
     * @return Imagen escalada para encajar en un visor de imágenes
     */
    public int[] redimensionarImagen(BufferedImage img) {

        int ancho = 0, alto = 0, diferencia = 0;

        if (img.getWidth() <= 486 && img.getHeight() <= 346) { // Ambas dimensiones son más pequeñas
            ancho = 486;
            diferencia = 486 - img.getWidth();
            alto = img.getHeight() + diferencia * img.getHeight() / img.getWidth();

            if (alto > 346) {
                alto = 346;
                diferencia = img.getHeight() - 346;
                ancho = img.getWidth() - diferencia * img.getWidth() / img.getHeight();
            }
        } else {
            if (img.getWidth() > 486 && img.getHeight() > 346) {  // Ambas dimensiones son más grande
                ancho = 486;
                diferencia = img.getWidth() - 486;
                alto = img.getHeight() - diferencia * img.getHeight() / img.getWidth();

                if (alto > 346) {
                    alto = 346;
                    diferencia = img.getHeight() - 346;
                    ancho = img.getWidth() - diferencia * img.getWidth() / img.getHeight();
                }

            } else {
                if (img.getWidth() > 486) {  // El ancho es más grande
                    ancho = 486;
                    diferencia = img.getWidth() - 486;
                    alto = img.getHeight() - diferencia * img.getHeight() / img.getWidth();

                } else {  //El alto es más grande
                    alto = 346;
                    diferencia = img.getHeight() - 346;
                    ancho = img.getWidth() - diferencia * img.getWidth() / img.getHeight();
                }
            }
        }
        int[] dimensiones = {ancho, alto};
        return dimensiones;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Categorías");

        jButton1.setText("Agregar Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setSelectedItem("-");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("<");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText(">");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "General" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectedIndex(0);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText(usuario);

        jButton6.setText("Agregar Categoría");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        jLabel4.setFocusable(false);
        jLabel4.setMaximumSize(new java.awt.Dimension(445, 300));
        jLabel4.setMinimumSize(new java.awt.Dimension(445, 300));
        jLabel4.setPreferredSize(new java.awt.Dimension(445, 300));

        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText(" Biblioteca");

        jButton7.setText("Eliminar Categoría");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel1))))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(71, 71, 71)))
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jButton5)
                                .addGap(132, 132, 132)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // BOTON ELIMINAR CATEGORIA

        if (listacategorias.getSize() > 0) {
            System.out.println("Se eliminó la categoría: " + jList1.getSelectedIndex() + " con " + listaimagenes.getSize() + " elementos");
            listacategorias.removeNodo(jList1.getSelectedIndex());
            lista.remove(jList1.getSelectedIndex());
            jList1.setSelectedIndex(0);

            if (listacategorias.getSize() == 1) {
                jButton7.setEnabled(false);
            } else {
                jButton7.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // BOTON AGREGAR CATEGORIA        
        modificado = true;

        jTextField1.setEnabled(true);
        jTextField1.requestFocus();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jList1.setEnabled(false);
        guardar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // BOTON SALIR
        guardar();
        listausuarios.getNodoCategoria(indexusuario).setListaCategorias(listacategorias);

        int Vgua;
        if (modificado == true) {
            Vgua = JOptionPane.showConfirmDialog(null, "Se ha guardado la biblioteca, ¿Desea respaldarla?", "Confirmar", YES_NO_CANCEL_OPTION, QUESTION_MESSAGE);
        } else {
            Vgua = 1;
        }

        if (Vgua == 0) { //SI
            try {
                FileOutputStream respaldo = new FileOutputStream("C:\\Users\\pablo\\Documents\\NetBeansProjects\\Proyecto2\\respaldo.ser");
                ObjectOutputStream salida = new ObjectOutputStream(respaldo);
                salida.writeObject(listausuarios);
                salida.close();
                respaldo.close();
                System.out.println("Se respaldó la lista de usuarios");
            } catch (IOException i) {
                System.out.println("No se encontró el archivo");
                i.printStackTrace();
            }
            this.setVisible(false);
            Vpri.setVisible(true);
        } else {
            if (Vgua == 1) { //NO           
                this.setVisible(false);
                Vpri.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTON ELIMINAR IMAGEN
        modificado = true;

        if (listaimagenes.getSize() > 0) {
            listaimagenes.removeNodo(jComboBox1.getSelectedIndex());
            jComboBox1.removeItemAt(jComboBox1.getSelectedIndex());

            if (listaimagenes.getSize() == 0) {
                jLabel4.setIcon(new ImageIcon("C:\\Users\\pablo\\Documents\\NetBeansProjects\\Proyecto2\\src\\main\\java\\image\\default.jpg"));
            } else {
                jComboBox1.setSelectedIndex(0);
                jLabel4.setIcon(new ImageIcon(listaimagenes.getImagen(0).toString()));
            }
            guardar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // SELECCIONAR COMBOBOX        
        if (listaimagenes.getSize() > 0) {

            File archivo = listaimagenes.getImagen(jComboBox1.getSelectedIndex());

            try {
                BufferedImage img = ImageIO.read(archivo);
                Image image = img.getScaledInstance(redimensionarImagen(img)[0], redimensionarImagen(img)[1], SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                jLabel4.setIcon(icon);
            } catch (IOException ex) {
            }

            if (jComboBox1.getItemCount() > 1) {
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
            } else {
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTON AGREGAR IMAGEN
        modificado = true;

        Varc.setCurrentDirectory(new File("C:\\Users\\pablo\\Documents\\NetBeansProjects\\Proyecto2\\src\\main\\java\\image"));
        int seleccion = Varc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {       // Cuando se presiona aceptar 

            File[] archivos = Varc.getSelectedFiles();
            File archivo = archivos[0];

            for (int i = 0; i < archivos.length; i++) {
                archivo = archivos[i];
                listaimagenes.addNodo(archivo);
                jComboBox1.addItem(archivo.getName());
            }

            jComboBox1.setSelectedIndex(jComboBox1.getItemCount() - 1);  //// 

            try {
                BufferedImage img = ImageIO.read(archivo);
                Image image = img.getScaledInstance(redimensionarImagen(img)[0], redimensionarImagen(img)[1], SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                jLabel4.setIcon(icon);
            } catch (IOException ex) {
            }

            guardar();

            if (listaimagenes.getSize() > 1) {
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
            } else {
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // BOTON ANTERIOR        
        if (jComboBox1.getSelectedIndex() == 0)
            jComboBox1.setSelectedIndex(jComboBox1.getItemCount() - 1);
        else
            jComboBox1.setSelectedIndex(jComboBox1.getSelectedIndex() - 1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // BOTON SIGUIENTE
        if (jComboBox1.getSelectedIndex() == jComboBox1.getItemCount() - 1)
            jComboBox1.setSelectedIndex(0);
        else
            jComboBox1.setSelectedIndex(jComboBox1.getSelectedIndex() + 1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // CAJA CATEGORIA                
        //AL presionar enter:
        if (jTextField1.getText().equals("")) {
        } // Valida que no este vacio
        else {
            listacategorias.addUltimo(jTextField1.getText(), new ListaImagenes());  //Agrega nombre y lista  a la lista de categorias 
            lista.addElement(jTextField1.getText());
            jTextField1.setText("");

            jTextField1.setEnabled(false);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jList1.setEnabled(true);

            System.out.println("Se agregó la categoria");
            jList1.setSelectedIndex(lista.getSize() - 1);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // SELECCION DE CATEGORIA
        if (jList1.getSelectedIndex() >= 0) {
            listaimagenes = new ListaImagenes();
            jComboBox1.removeAllItems();

            System.out.println("Se agregó la categoria " + jList1.getSelectedIndex() + ": " + jList1.getSelectedValue());
            listaimagenes = listacategorias.getListaImagenes(jList1.getSelectedIndex());

            if (listaimagenes.getSize() > 0) {
                for (int i = 0; i < listaimagenes.getSize(); i++) {
                    File archivo = (File) listaimagenes.getImagen(i);
                    jComboBox1.addItem(archivo.getName());
                }
                System.out.println("---> Se cargaron " + jComboBox1.getItemCount() + " imágenes");
            } else {
                jLabel4.setIcon(new ImageIcon("C:\\Users\\pablo\\Documents\\NetBeansProjects\\Proyecto2\\src\\main\\java\\image\\default.jpg"));
            }

            if (listaimagenes.getSize() > 1) {
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
            } else {
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jList1ValueChanged

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
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    public void guardar() {
        listacategorias.getNodoCategoria(jList1.getSelectedIndex()).setListaImagenes(listaimagenes);  //************************ Para actualizar, se debe actualizar después de presionar regresar, siguiente, agregar imagen, salir
        System.out.println("Se guardó la categoria " + jList1.getSelectedIndex() + " con " + listaimagenes.getSize() + " elementos");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
