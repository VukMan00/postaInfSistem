/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package posiljke;

import controller.Controller;
import domain.Adresnica;
import domain.Korisnik;
import domain.PotvrdaOPrijemuPosiljke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import korisnik.OptionsKorisnik;
import korisnik.SaveKorisnik;
import posiljke.potvrda.SavePotvrdaPosiljke;
import session.LocalStorage;
import tableModels.PosiljkaTableModel;

/**
 *
 * @author Vuk
 */
public class OptionsPosiljke extends javax.swing.JDialog {

    /**
     * Creates new form OptionsPosiljke
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    private List<PotvrdaOPrijemuPosiljke> potvrde;
    
    public OptionsPosiljke(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        potvrde = new ArrayList<>();
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
        tblPosiljke = new javax.swing.JTable();
        btnCreatePosiljka = new javax.swing.JButton();
        btnUpdatePosiljka = new javax.swing.JButton();
        btnDeletePosiljka = new javax.swing.JButton();
        btnSavePotvrdaPrijemPosiljke = new javax.swing.JButton();
        btnUpdatePotvrdaPosiljke = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Pretraga pošiljke po šifri");

        txtSearchCriteria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSearchCriteria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchCriteriaKeyPressed(evt);
            }
        });

        tblPosiljke.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblPosiljke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPosiljke);

        btnCreatePosiljka.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCreatePosiljka.setText("Kreiraj pošiljku");
        btnCreatePosiljka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePosiljkaActionPerformed(evt);
            }
        });

        btnUpdatePosiljka.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUpdatePosiljka.setText("Ažuriraj pošiljku");
        btnUpdatePosiljka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePosiljkaActionPerformed(evt);
            }
        });

        btnDeletePosiljka.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeletePosiljka.setText("Izbriši pošiljku");
        btnDeletePosiljka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePosiljkaActionPerformed(evt);
            }
        });

        btnSavePotvrdaPrijemPosiljke.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSavePotvrdaPrijemPosiljke.setText("Generiši potvrdu o prijemu pošiljke");
        btnSavePotvrdaPrijemPosiljke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePotvrdaPrijemPosiljkeActionPerformed(evt);
            }
        });

        btnUpdatePotvrdaPosiljke.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUpdatePotvrdaPosiljke.setText("Ažuriraj potvrdu o prijemu pošiljke");
        btnUpdatePotvrdaPosiljke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePotvrdaPosiljkeActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSavePotvrdaPrijemPosiljke, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdatePotvrdaPosiljke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreatePosiljka, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(btnUpdatePosiljka, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(btnDeletePosiljka, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatePosiljka)
                    .addComponent(btnUpdatePosiljka)
                    .addComponent(btnDeletePosiljka))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSavePotvrdaPrijemPosiljke)
                    .addComponent(btnUpdatePotvrdaPosiljke))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePosiljkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePosiljkaActionPerformed
       // TODO add your handling code here:
        localStorage.addItemsInHashMap("operation", "CREATE");
        SavePosiljka cp = new SavePosiljka(null, true);
        cp.setLocationRelativeTo(null);
        cp.setVisible(true);
        localStorage.removeItemFromHashMap("operation");
        populateTable();
    }//GEN-LAST:event_btnCreatePosiljkaActionPerformed

    private void btnUpdatePosiljkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePosiljkaActionPerformed
        // TODO add your handling code here:
        localStorage.addItemsInHashMap("operation", "UPDATE");
        Adresnica posiljka = getSelectedPosiljka();
        if(posiljka!=null){
            localStorage.addItemsInHashMap("posiljka", posiljka);
            SavePosiljka sk = new SavePosiljka(null, true);
            sk.setLocationRelativeTo(null);
            sk.setVisible(true);
        }
        localStorage.removeItemFromHashMap("operation");
        localStorage.removeItemFromHashMap("posiljka");
        populateTable();
    }//GEN-LAST:event_btnUpdatePosiljkaActionPerformed

    private void btnDeletePosiljkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePosiljkaActionPerformed
        // TODO add your handling code here:
        Adresnica posiljka = getSelectedPosiljka();
        if(posiljka!=null){
            try {
                Controller.getInstance().deletePosiljka(posiljka);
                JOptionPane.showMessageDialog(this, "Uspesno ste izbrisali posiljku");
                populateTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Posiljka je u relaciji sa drugim tabelama", "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeletePosiljkaActionPerformed

    private void txtSearchCriteriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCriteriaKeyPressed
        // TODO add your handling code here:
        PosiljkaTableModel posiljkaTableModel = (PosiljkaTableModel)tblPosiljke.getModel();
        List<Adresnica> posiljke = posiljkaTableModel.getPosiljke();
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!txtSearchCriteria.getText().isEmpty()){
                List<Adresnica> searchPosiljka = posiljke.stream()
                                                .filter(posiljka->posiljka.getSifraAdresnice() == Integer.parseInt(txtSearchCriteria.getText().trim()))
                                                .collect(Collectors.toList());
                tblPosiljke.setModel(new PosiljkaTableModel(searchPosiljka));
            }else{
                populateTable();
            }
        }
    }//GEN-LAST:event_txtSearchCriteriaKeyPressed

    private void btnSavePotvrdaPrijemPosiljkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePotvrdaPrijemPosiljkeActionPerformed
        // TODO add your handling code here:
        Adresnica posiljka = getSelectedPosiljka();
        if(posiljka!=null && potvrde!=null){
            List<PotvrdaOPrijemuPosiljke> ppp = potvrde.stream()
                                                .filter(potvrda->potvrda.getPosiljka().equals(posiljka))
                                                .collect(Collectors.toList());
            if(ppp.isEmpty()){
                localStorage.addItemsInHashMap("posiljka", posiljka);
                localStorage.addItemsInHashMap("operation", "CREATE");
                SavePotvrdaPosiljke spp = new SavePotvrdaPosiljke(null, true);
                spp.setLocationRelativeTo(null);
                spp.setVisible(true);
                localStorage.removeItemFromHashMap("posiljka");
                localStorage.removeItemFromHashMap("operation");
                populateTable();
            }
            else{
                JOptionPane.showMessageDialog(this, "Potvrda o prijemu je već kreirana za ovu pošiljku");
            }
        }
    }//GEN-LAST:event_btnSavePotvrdaPrijemPosiljkeActionPerformed

    private void btnUpdatePotvrdaPosiljkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePotvrdaPosiljkeActionPerformed
        // TODO add your handling code here:
        Adresnica posiljka = getSelectedPosiljka();
        if(posiljka!=null && potvrde!=null){
            List<PotvrdaOPrijemuPosiljke> ppp = potvrde.stream()
                                                .filter(potvrda->potvrda.getPosiljka().equals(posiljka))
                                                .collect(Collectors.toList());
            if(!ppp.isEmpty()){
                localStorage.addItemsInHashMap("posiljke", ((PosiljkaTableModel) tblPosiljke.getModel()).getPosiljke());
                localStorage.addItemsInHashMap("potvrdaPosiljke", ppp.get(0));
                localStorage.addItemsInHashMap("operation", "UPDATE");
                SavePotvrdaPosiljke spp = new SavePotvrdaPosiljke(null, true);
                spp.setLocationRelativeTo(null);
                spp.setVisible(true);
                localStorage.removeItemFromHashMap("posiljke");
                localStorage.removeItemFromHashMap("potvrdaPosiljke");
                localStorage.removeItemFromHashMap("operation");
                populateTable();
            }
            else{
                JOptionPane.showMessageDialog(this, "Potvrda o prijemu nije kreirana za ovu pošiljku");
            }
        }
    }//GEN-LAST:event_btnUpdatePotvrdaPosiljkeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePosiljka;
    private javax.swing.JButton btnDeletePosiljka;
    private javax.swing.JButton btnSavePotvrdaPrijemPosiljke;
    private javax.swing.JButton btnUpdatePosiljka;
    private javax.swing.JButton btnUpdatePotvrdaPosiljke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPosiljke;
    private javax.swing.JTextField txtSearchCriteria;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        populateTable();
    }
    
    private void populateTable() {
        try {
            potvrde = Controller.getInstance().getPotvrdePosiljke(new PotvrdaOPrijemuPosiljke());
            tblPosiljke.setModel(new PosiljkaTableModel(Controller.getInstance().getPosiljke(new Adresnica())));
        } catch (Exception ex) {
            Logger.getLogger(OptionsKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Adresnica getSelectedPosiljka() {
        int selectedRow = tblPosiljke.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Niste izabrali posiljku");
            return null;
        }else{
            List<Adresnica> posiljke = ((PosiljkaTableModel) tblPosiljke.getModel()).getPosiljke();
            return posiljke.get(selectedRow);
        }
    }
}