/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dostavnispisak;

import controller.Controller;
import domain.DostavniSpisak;
import dostavljanjeposiljke.PosiljkePoKvartalu;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import otpremnica.OptionsOtpremnica;
import session.LocalStorage;
import tableModels.DostavniSpisakTableModel;

/**
 *
 * @author Vuk
 */
public class OptionsDostavniSpisak extends javax.swing.JDialog {

    /**
     * Creates new form OptionsDostavniSpisak
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    
    public OptionsDostavniSpisak(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearchCriteria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDostavniSpisak = new javax.swing.JTable();
        btnUpdateDostavniSpisak = new javax.swing.JButton();
        btnCreateDostavniSpisak = new javax.swing.JButton();
        btnDeleteDostavniSpisak = new javax.swing.JButton();
        btnOtpremnicaView = new javax.swing.JButton();
        btnPregledIsporucenihPosiljki = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Pretraga dostavnog spiska po oznaci");

        txtSearchCriteria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchCriteriaKeyPressed(evt);
            }
        });

        tblDostavniSpisak.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDostavniSpisak);

        btnUpdateDostavniSpisak.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUpdateDostavniSpisak.setText("Ažuriraj spisak");
        btnUpdateDostavniSpisak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDostavniSpisakActionPerformed(evt);
            }
        });

        btnCreateDostavniSpisak.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCreateDostavniSpisak.setText("Kreiraj spisak");
        btnCreateDostavniSpisak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDostavniSpisakActionPerformed(evt);
            }
        });

        btnDeleteDostavniSpisak.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeleteDostavniSpisak.setText("Izbriši spisak");
        btnDeleteDostavniSpisak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDostavniSpisakActionPerformed(evt);
            }
        });

        btnOtpremnicaView.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnOtpremnicaView.setText("Pregled otpremnica");
        btnOtpremnicaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtpremnicaViewActionPerformed(evt);
            }
        });

        btnPregledIsporucenihPosiljki.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPregledIsporucenihPosiljki.setText("Pregled isporučenih pošiljaka");
        btnPregledIsporucenihPosiljki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregledIsporucenihPosiljkiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreateDostavniSpisak)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnUpdateDostavniSpisak, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(btnDeleteDostavniSpisak, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnOtpremnicaView, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnPregledIsporucenihPosiljki)
                                .addGap(59, 59, 59))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateDostavniSpisak)
                    .addComponent(btnUpdateDostavniSpisak)
                    .addComponent(btnDeleteDostavniSpisak))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtpremnicaView)
                    .addComponent(btnPregledIsporucenihPosiljki))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateDostavniSpisakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDostavniSpisakActionPerformed
        // TODO add your handling code here:
        localStorage.addItemsInHashMap("operation", "UPDATE");
        DostavniSpisak dostavniSpisak = getSelectedDostavniSpisak();
        if(dostavniSpisak!=null){
            localStorage.addItemsInHashMap("dostavniSpisak", dostavniSpisak);
            SaveDostavniSpisak sds = new SaveDostavniSpisak(null, true);
            sds.setLocationRelativeTo(null);
            sds.setVisible(true);
        }
        localStorage.removeItemFromHashMap("operation");
        localStorage.removeItemFromHashMap("dostavniSpisak");
        populateTable();
    }//GEN-LAST:event_btnUpdateDostavniSpisakActionPerformed

    private void btnCreateDostavniSpisakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDostavniSpisakActionPerformed
        // TODO add your handling code here:
        localStorage.addItemsInHashMap("operation", "CREATE");
        SaveDostavniSpisak sds = new SaveDostavniSpisak(null, true);
        sds.setLocationRelativeTo(null);
        sds.setVisible(true);
        localStorage.removeItemFromHashMap("operation");
        populateTable();
    }//GEN-LAST:event_btnCreateDostavniSpisakActionPerformed

    private void btnDeleteDostavniSpisakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDostavniSpisakActionPerformed
        // TODO add your handling code here:
        DostavniSpisak dostavniSpisak = getSelectedDostavniSpisak();
        if(dostavniSpisak!=null){
            try {
                Controller.getInstance().deleteDostavniSpisak(dostavniSpisak);
                JOptionPane.showMessageDialog(this, "Uspesno ste izbrisali dostavni spisak");
                populateTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Dostavni  je u relaciji sa drugim tabelama", "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteDostavniSpisakActionPerformed

    private void txtSearchCriteriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCriteriaKeyPressed
        // TODO add your handling code here:
        DostavniSpisakTableModel dostavniSpisakTableModel = (DostavniSpisakTableModel)tblDostavniSpisak.getModel();
        List<DostavniSpisak> spiskovi = dostavniSpisakTableModel.getDostavniSpiskovi();
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!txtSearchCriteria.getText().isEmpty()){
                List<DostavniSpisak> searchSpisak = spiskovi.stream()
                                                .filter(spisak->spisak.getOznakaDostavnogSpiska() == Integer.parseInt(txtSearchCriteria.getText().trim()))
                                                .collect(Collectors.toList());
                tblDostavniSpisak.setModel(new DostavniSpisakTableModel(searchSpisak));
            }else{
                populateTable();
            }
        }
    }//GEN-LAST:event_txtSearchCriteriaKeyPressed

    private void btnOtpremnicaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtpremnicaViewActionPerformed
        // TODO add your handling code here:
        DostavniSpisak dostavniSpisak = getSelectedDostavniSpisak();
        if(dostavniSpisak!=null){
            localStorage.addItemsInHashMap("dostavniSpisak", dostavniSpisak);
            OptionsOtpremnica op = new OptionsOtpremnica(null, true);
            op.setLocationRelativeTo(null);
            op.setVisible(true);
            localStorage.removeItemFromHashMap("dostavniSpisak");
        }
    }//GEN-LAST:event_btnOtpremnicaViewActionPerformed

    private void btnPregledIsporucenihPosiljkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregledIsporucenihPosiljkiActionPerformed
        // TODO add your handling code here:
        PosiljkePoKvartalu ppk = new PosiljkePoKvartalu(null, true);
        ppk.setLocationRelativeTo(null);
        ppk.setVisible(true);
    }//GEN-LAST:event_btnPregledIsporucenihPosiljkiActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDostavniSpisak;
    private javax.swing.JButton btnDeleteDostavniSpisak;
    private javax.swing.JButton btnOtpremnicaView;
    private javax.swing.JButton btnPregledIsporucenihPosiljki;
    private javax.swing.JButton btnUpdateDostavniSpisak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDostavniSpisak;
    private javax.swing.JTextField txtSearchCriteria;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        populateTable();
    }

    private void populateTable() {
        try {
            tblDostavniSpisak.setModel(new DostavniSpisakTableModel(Controller.getInstance().getDostavneSpiskove(new DostavniSpisak())));
        } catch (Exception ex) {
            Logger.getLogger(OptionsDostavniSpisak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DostavniSpisak getSelectedDostavniSpisak() {
        int selectedRow = tblDostavniSpisak.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Niste izabrali spisak");
            return null;
        }else{
            List<DostavniSpisak> spiskovi = ((DostavniSpisakTableModel) tblDostavniSpisak.getModel()).getDostavniSpiskovi();
            return spiskovi.get(selectedRow);
        }
    }
}