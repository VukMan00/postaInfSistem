/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package linijevoznje;

import controller.Controller;
import domain.Linija;
import domain.Upravlja;
import domain.Vozac;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import linijevoznje.upravljanja.SaveUpravljanjeVozaca;
import session.LocalStorage;
import tableModels.UpravljanjeLinijamaTableModel;
import tableModels.VozacTableModel;

/**
 *
 * @author Vuk
 */
public class OptionsUpravlja extends javax.swing.JDialog {

    /**
     * Creates new form OptionsUpravlja
     */
    private final LocalStorage localStorage = LocalStorage.getInstance();
    private List<Upravlja> upravljanjeVozaca;
    private final Vozac vozac;
    
    public OptionsUpravlja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        vozac = (Vozac) localStorage.getItemFromHashMap("vozac");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUpravlja = new javax.swing.JTable();
        btnAddUpravlja = new javax.swing.JButton();
        btnUpdateUpravlja = new javax.swing.JButton();
        btnDeleteUpravlja = new javax.swing.JButton();
        lblVozac = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Linije kojim Vozač upravljaja");

        tblUpravlja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUpravlja);

        btnAddUpravlja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAddUpravlja.setText("Dodaj liniju vozaču");
        btnAddUpravlja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUpravljaActionPerformed(evt);
            }
        });

        btnUpdateUpravlja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUpdateUpravlja.setText("Izmeni liniju vozača");
        btnUpdateUpravlja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUpravljaActionPerformed(evt);
            }
        });

        btnDeleteUpravlja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeleteUpravlja.setText("Izbriši liniju vozača");
        btnDeleteUpravlja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUpravljaActionPerformed(evt);
            }
        });

        lblVozac.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblVozac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVozac.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAddUpravlja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateUpravlja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteUpravlja)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVozac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVozac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUpravlja)
                    .addComponent(btnUpdateUpravlja)
                    .addComponent(btnDeleteUpravlja))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUpravljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUpravljaActionPerformed
        // TODO add your handling code here:
        List<Linija> linijeVozaca = new ArrayList<>();
        upravljanjeVozaca.forEach(uv -> linijeVozaca.add(uv.getLinija()));
        localStorage.addItemsInHashMap("linijevozaca", linijeVozaca);
        localStorage.addItemsInHashMap("operation", "CREATE");
        SaveUpravljanjeVozaca suv = new SaveUpravljanjeVozaca(null, true);
        suv.setLocationRelativeTo(null);
        suv.setVisible(true);
        localStorage.removeItemFromHashMap("linijevozaca");
        localStorage.removeItemFromHashMap("operation");
        populateTable();
    }//GEN-LAST:event_btnAddUpravljaActionPerformed

    private void btnUpdateUpravljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUpravljaActionPerformed
        // TODO add your handling code here:
        Upravlja upravlja = getSelectedUpravlja();
        if(upravlja!=null){
           
            List<Linija> linijeVozaca = new ArrayList<>();
            upravljanjeVozaca.forEach(uv -> linijeVozaca.add(uv.getLinija()));
            localStorage.addItemsInHashMap("linijevozaca", linijeVozaca);
            localStorage.addItemsInHashMap("operation", "UPDATE");
            localStorage.addItemsInHashMap("upravlja", upravlja);

            SaveUpravljanjeVozaca suv = new SaveUpravljanjeVozaca(null, true);
            suv.setLocationRelativeTo(null);
            suv.setVisible(true);

            localStorage.removeItemFromHashMap("linijevozaca");
            localStorage.removeItemFromHashMap("operation");
            localStorage.removeItemFromHashMap("upravlja");
            populateTable();
        }
    }//GEN-LAST:event_btnUpdateUpravljaActionPerformed

    private void btnDeleteUpravljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUpravljaActionPerformed
        // TODO add your handling code here:
        Upravlja upravlja = getSelectedUpravlja();
        if(upravlja!=null){
            try {
                Controller.getInstance().deleteUpravlja(upravlja);
                JOptionPane.showMessageDialog(this, "Upesno ste izbrisali liniju vozaču");
                populateTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteUpravljaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUpravlja;
    private javax.swing.JButton btnDeleteUpravlja;
    private javax.swing.JButton btnUpdateUpravlja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVozac;
    private javax.swing.JTable tblUpravlja;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        lblVozac.setText(vozac.getImePrezime());
        populateTable();
    }

    private void populateTable() {
        try {
            List<Upravlja> upravljanja = Controller.getInstance().getUpravljanjaLinijama(new Upravlja());
            upravljanjeVozaca = upravljanja.stream()
                    .filter(upr -> upr.getVozac().equals(vozac))
                    .collect(Collectors.toList());
            tblUpravlja.setModel(new UpravljanjeLinijamaTableModel(upravljanjeVozaca));
        } catch (Exception ex) {
            Logger.getLogger(OptionsUpravlja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Upravlja getSelectedUpravlja() {
        int selectedRow = tblUpravlja.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Niste izabrali upravljanje");
            return null;
        }else{
            return ((UpravljanjeLinijamaTableModel) tblUpravlja.getModel()).getUpravljanje().get(selectedRow);
        }
    }
}