/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package linijevoznje.vozac;

import controller.Controller;
import domain.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class SaveVozac extends javax.swing.JDialog {

    /**
     * Creates new form SaveVozac
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    private Vozac vozac;
    private String operation;
    
    public SaveVozac(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        operation = (String) localStorage.getItemFromHashMap("operation");
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
        jLabel2 = new javax.swing.JLabel();
        txtSifraVozaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImePrezime = new javax.swing.JTextField();
        lbTrenutnaLinija = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtTrenutnaLinija = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Podaci Vozač");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Šifra");

        txtSifraVozaca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Ime i prezime");

        txtImePrezime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbTrenutnaLinija.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbTrenutnaLinija.setText("Trenutna linija");

        btnSave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtTrenutnaLinija.setEditable(false);
        txtTrenutnaLinija.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSifraVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbTrenutnaLinija, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtImePrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtTrenutnaLinija)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSifraVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrenutnaLinija)
                    .addComponent(txtTrenutnaLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        vozac = getInputData();
        try{
            if(operation.equals("CREATE")){
                Controller.getInstance().addVozac(vozac);
                JOptionPane.showMessageDialog(this, "Upesno kreiran vozač");
                this.dispose();
            }else if(operation.equals("UPDATE")){
                Controller.getInstance().updateVozac(vozac);
                JOptionPane.showMessageDialog(this, "Upesno ažuriran vozač");
                this.dispose();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbTrenutnaLinija;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtSifraVozaca;
    private javax.swing.JTextField txtTrenutnaLinija;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        try {
            List<Posta> poste = Controller.getInstance().getPoste(new Posta());
            txtTrenutnaLinija.setVisible(false);
            lbTrenutnaLinija.setVisible(false);
            txtSifraVozaca.setEditable(true);
            if(operation.equals("UPDATE")){
                populateForm();
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveVozac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateForm() {
        txtTrenutnaLinija.setVisible(true);
        lbTrenutnaLinija.setVisible(true);
        vozac = (Vozac) localStorage.getItemFromHashMap("vozac");
        
        txtSifraVozaca.setText(vozac.getSifraVozaca().toString());
        txtSifraVozaca.setEditable(false);
        txtImePrezime.setText(vozac.getImePrezime());
        txtTrenutnaLinija.setText(vozac.getTrenutnaLinija());
    }

    private Vozac getInputData() {
        Integer sifraVozaca = Integer.parseInt(txtSifraVozaca.getText());
        String imePrezime = txtImePrezime.getText();
        return new Vozac(sifraVozaca, imePrezime);
    }
}
