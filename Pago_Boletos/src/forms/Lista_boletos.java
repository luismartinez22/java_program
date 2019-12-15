/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Dominio.Facade;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pago_boletos.cvs_Import;
import pago_boletos.gest_boleto;

/**
 *
 * @author luis
 */
public class Lista_boletos extends javax.swing.JFrame implements Observer {
    Facade objF;

    cvs_Import import_cvs = new cvs_Import();
    /**
     * Creates new form Login
     */
    Lista_boletos() {
        initComponents();
        objF = Facade.getInstance();
        gest_boleto.getInstance().addObserver(this);
        setLocationRelativeTo(null);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_code = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 1000, 700));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de juego", "Fecha del sorteo", "Fecha del pago", "OCR", "Validado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setBounds(new java.awt.Rectangle(0, 0, 980, 588));
        jTable1.setMaximumSize(new java.awt.Dimension(980, 588));
        jTable1.setMinimumSize(new java.awt.Dimension(980, 588));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Importar archivo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_code.setToolTipText("");
        txt_code.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txt_codeComponentAdded(evt);
            }
        });
        txt_code.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_codeInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txt_codeCaretPositionChanged(evt);
            }
        });
        txt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codeActionPerformed(evt);
            }
        });
        txt_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codeKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codeKeyReleased(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese OCR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeKeyReleased

    private void txt_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codeKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE)
                || (vChar == KeyEvent.VK_ENTER))) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "Por favor, ingrese solo numeros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_codeKeyTyped

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        try {
            String path = "";
            FileDialog fd = new FileDialog(new JFrame());
            fd.setVisible(true);
            File[] f = fd.getFiles();
            if(f.length > 0){
                path = fd.getFiles()[0].getAbsolutePath();
                Workbook workbook = WorkbookFactory.create(new File(path));

                // Getting the Sheet at index zero
                Sheet sheet = workbook.getSheetAt(0);

                // Create a DataFormatter to format and get each cell's value as String
                DataFormatter dataFormatter = new DataFormatter();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int x = sheet.getLastRowNum();
                for(int e = 1; e <= x; e++){
                    int ocr = 0;
                    String fecha_sorteo = "";
                    String fecha_pago = "";
                    String tipo_juego = "";
                    Vector row = new Vector();
                    for(int i = 0; i < 5; i++){
                        String cellValue = dataFormatter.formatCellValue(sheet.getRow(e).getCell(i));
                        sheet.getColumnBreaks();
                        if(i == 0){
                            tipo_juego = cellValue;
                            row.add(cellValue);
                        }else if(i  == 1){
                            fecha_sorteo = cellValue;
                            row.add(cellValue);
                        }else if(i == 3){
                            fecha_pago = cellValue;
                            row.add(cellValue);
                        }else if(i == 4 && cellValue.length() == 9){
                            ocr = Integer.parseInt(cellValue);
                            row.add(cellValue);
                        }
                    }
                    this.Agregar(ocr, tipo_juego, fecha_sorteo, fecha_pago);
                    model.addRow(row);
                }
                workbook.close();
            }


        } catch (IOException ex) {
            Logger.getLogger(Lista_boletos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Lista_boletos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(Lista_boletos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        menu frm = new menu();
        frm.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codeActionPerformed
        // TODO add your handling code here:
        int ocr;
        String value = txt_code.getText();
        if(!"".equals(value)){
            ocr = Integer.parseInt(value.substring(0, 9));
                try {
                    this.Modificar(ocr);
                } catch (IOException ex) {
                    Logger.getLogger(Lista_boletos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

    }//GEN-LAST:event_txt_codeActionPerformed

    private void txt_codeComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txt_codeComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeComponentAdded

    private void txt_codeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_codeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeInputMethodTextChanged

    private void txt_codeCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_codeCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeCaretPositionChanged

    protected void Agregar(int ocr, String tipo_juego, String fecha_sorteo, String fecha_pago) throws IOException {
        boolean validado = false;
        if (!(objF.alta_boleto(ocr, fecha_sorteo, fecha_pago, tipo_juego, validado))) {
            throw new IOException("Hubo un error, por favor vuelve a importar el archivo");
        }
    }
        
    protected void Modificar(int ocr) throws IOException {
        //lo modifica
            if(this.validateOcr(ocr)){
                objF.modificar_boleto(ocr);
            }
    }
     
     private boolean validateOcr(int ocr){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int x = model.getRowCount();
        for(int e = 0; e < x; e++){
            Object columnValue = model.getValueAt(e,3);
            if(columnValue != null && columnValue.equals(String.valueOf(ocr))){
                if(model.getValueAt(e, 4) != null){
                    JOptionPane.showMessageDialog(null, "OCR numero " + ocr + " ya fue validado!", "Error", JOptionPane.ERROR_MESSAGE); 
                    txt_code.setText("");
                    return false;
                }else{
                    model.setValueAt(true, e, 4);
                    txt_code.setText("");
                    model.fireTableDataChanged();
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "OCR no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        txt_code.setText("");
        return false;
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
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
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_boletos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_code;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
    }
}
