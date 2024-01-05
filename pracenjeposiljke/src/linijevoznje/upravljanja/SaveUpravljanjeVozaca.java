/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package linijevoznje.upravljanja;

import controller.Controller;
import domain.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class SaveUpravljanjeVozaca extends javax.swing.JDialog {

    /**
     * Creates new form SaveUpravljanjeVozaca
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    private final Vozac vozac;
    private Upravlja upravlja;
    private Linija linija;
    private final String operation;
    private List<Linija> linije;
    
    public SaveUpravljanjeVozaca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        vozac = (Vozac) localStorage.getItemFromHashMap("vozac");
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
        txtImePrezimeVozač = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbLinije = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        calendarDatumVoznje = new com.toedter.calendar.JCalendar();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Podaci Vozača");

        jLabel2.setText("Šifra");

        txtSifraVozaca.setEditable(false);
        txtSifraVozaca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setText("ImePrezime");

        txtImePrezimeVozač.setEditable(false);
        txtImePrezimeVozač.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Podaci Linije");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Dostupne linije");

        cbLinije.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setText("Datum vožnje");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSifraVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtImePrezimeVozač, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbLinije, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarDatumVoznje, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSifraVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtImePrezimeVozač, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbLinije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(calendarDatumVoznje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        upravlja = getInputDataUpravlja();
        try{
            if(operation.contains("CREATE")){
                Controller.getInstance().addUpravlja(upravlja);
                JOptionPane.showMessageDialog(this, "Upesno ste dodali liniju vozaču");
                this.dispose();
            }
            else{
                if(operation.equals("UPDATE")){
                    Controller.getInstance().updateUpravlja(upravlja);
                    JOptionPane.showMessageDialog(this, "Upesno ste ažurirali liniju vozača");
                    this.dispose();
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JCalendar calendarDatumVoznje;
    private javax.swing.JComboBox<Linija> cbLinije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtImePrezimeVozač;
    private javax.swing.JTextField txtSifraVozaca;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        try {
            txtSifraVozaca.setText(vozac.getSifraVozaca().toString());
            txtImePrezimeVozač.setText(vozac.getImePrezime());
            
            linije = Controller.getInstance().getLinije(new Linija());
            List<Linija> linijeVozaca = (List<Linija>) localStorage.getItemFromHashMap("linijevozaca");
            List<Linija> dostupneLinije = linije.stream()
                                                .filter(lin -> !linijeVozaca.contains(lin))
                                                .collect(Collectors.toList());
            cbLinije.setModel(new DefaultComboBoxModel(dostupneLinije.toArray()));
            
            if(operation.equals("UPDATE")){
                populateForm();
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveUpravljanjeVozaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Upravlja getInputDataUpravlja() {
        linija = (Linija) cbLinije.getSelectedItem();
        LocalDate datumVoznje = calendarDatumVoznje.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        return new Upravlja(vozac, linija, datumVoznje);
    }

    private void populateForm() {
        upravlja = (Upravlja) localStorage.getItemFromHashMap("upravlja");
        calendarDatumVoznje.setDate(Date.from(upravlja.getDatumVoznje().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        List<Linija> listTrenutnaLinija = linije.stream()
                                            .filter(l -> l.equals(upravlja.getLinija()))
                                            .collect(Collectors.toList());
        cbLinije.addItem(listTrenutnaLinija.get(0));
        cbLinije.setSelectedItem(upravlja.getLinija());
    }
}
