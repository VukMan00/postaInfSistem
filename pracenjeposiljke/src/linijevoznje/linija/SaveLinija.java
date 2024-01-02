/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package linijevoznje.linija;
import controller.Controller;
import domain.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class SaveLinija extends javax.swing.JDialog {

    /**
     * Creates new form SaveLinija
     */
    private final LocalStorage localStorage = LocalStorage.getInstance();
    private final String operation;
    private Linija linija;
    
    public SaveLinija(java.awt.Frame parent, boolean modal) {
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
        txtSifraLinije = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbPosta = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Podaci Linija");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Šifra linije");

        txtSifraLinije.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Naziv");

        txtNaziv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Pošta");

        cbPosta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnSave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(cbPosta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSifraLinije, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSifraLinije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPosta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        linija = getInputData();
        if(operation.equals("CREATE")){
            try {
                Controller.getInstance().addLinija(linija);
                JOptionPane.showMessageDialog(this, "Upesno kreirana linija");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }else if(operation.equals("UPDATE")){
            try {
                Controller.getInstance().updateLinija(linija);
                JOptionPane.showMessageDialog(this, "Upesno ažurirana linija");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Posta> cbPosta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSifraLinije;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        try {
            cbPosta.setModel(new DefaultComboBoxModel(
                    Controller.getInstance().getPoste(new Posta()).toArray()));
            txtSifraLinije.setEnabled(true);
            if(operation.equals("UPDATE")){
                populateForm();
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveLinija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateForm() {
        linija = (Linija) localStorage.getItemFromHashMap("linija");
        
        txtSifraLinije.setEnabled(false);
        txtSifraLinije.setText(linija.getSifraLinije().toString());
        txtNaziv.setText(linija.getNaziv());
        cbPosta.setSelectedItem(linija.getPosta());
    }

    private Linija getInputData() {
        Integer sifralinije = Integer.parseInt(txtSifraLinije.getText());
        String naziv = txtNaziv.getText();
        Posta posta = (Posta) cbPosta.getSelectedItem();
        
        return new Linija(sifralinije, naziv, posta);
    }
}