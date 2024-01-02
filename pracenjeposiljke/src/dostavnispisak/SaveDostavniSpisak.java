/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dostavnispisak;

import controller.Controller;
import domain.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class SaveDostavniSpisak extends javax.swing.JDialog {

    /**
     * Creates new form SaveDostavniSpisak
     */
    private final LocalStorage localStorage = LocalStorage.getInstance();
    private final String operation;
    private List<Posta> poste;
    private List<PostanskiRadnik> radnici;
    private List<PostanskiRadnik> postari;
    private List<PostanskiRadnik> obracunskiRadnici;
    private List<PopisPosiljakaUSVreci> vrece;
    private PopisPosiljakaUSVreci vreca;
    private Posta posta;
    private PostanskiRadnik postar;
    private PostanskiRadnik obracunskiRadnik;
    private DostavniSpisak dostavniSpisak;
    
    public SaveDostavniSpisak(java.awt.Frame parent, boolean modal) {
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

        cbHour = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOznakaDostavnogSpiska = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        calendarDatumStampe = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        cbSati = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbMinuti = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSekunde = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbVrece = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbPostar = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbObracunskiRadnik = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbPosta = new javax.swing.JComboBox<>();
        btnClearForm = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        cbHour.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Podaci Dostavnog Spiska");

        jLabel2.setText("Oznaka dostavnog spiska");

        txtOznakaDostavnogSpiska.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Datum štampe");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Vreme štampe");

        cbSati.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(":");

        cbMinuti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(":");

        cbSekunde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Podaci Vreća");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Vreće");

        cbVrece.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbVrece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVreceActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Podaci Pošta ");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Poštar");

        cbPostar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Obračunski radnik");

        cbObracunskiRadnik.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Pošta");

        cbPosta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnClearForm.setText("Očisti polja");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtOznakaDostavnogSpiska, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(2, 2, 2)
                                            .addComponent(calendarDatumStampe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbSati, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSekunde, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(cbVrece, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbPostar, 0, 235, Short.MAX_VALUE)
                                    .addComponent(cbObracunskiRadnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPosta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOznakaDostavnogSpiska, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(calendarDatumStampe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbSekunde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbVrece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPosta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbPostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbObracunskiRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbVreceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVreceActionPerformed
        // TODO add your handling code here:
        PopisPosiljakaUSVreci ppsv = (PopisPosiljakaUSVreci) cbVrece.getSelectedItem();
        List<Posta> posteVrece = poste.stream()
                                    .filter(postaVrece -> ppsv.getPostaPrimalac().equals(postaVrece))
                                    .collect(Collectors.toList());
        List<PostanskiRadnik> postariVrece = postari.stream()
                                                .filter(postarVrece -> postarVrece.getPosta().equals(ppsv.getPostaPrimalac()))
                                                .collect(Collectors.toList());
        List<PostanskiRadnik> obracunskiRadniciVrece = obracunskiRadnici.stream()
                                                .filter(obrRadnikVrece -> obrRadnikVrece.getPosta().equals(ppsv.getPostaPrimalac()))
                                                .collect(Collectors.toList());
        
        cbPosta.setEnabled(true);
        cbPostar.setEnabled(true);
        cbObracunskiRadnik.setEnabled(true);
        
        cbPosta.setModel(new DefaultComboBoxModel(posteVrece.toArray()));
        cbPostar.setModel(new DefaultComboBoxModel(postariVrece.toArray()));
        cbObracunskiRadnik.setModel(new DefaultComboBoxModel(obracunskiRadniciVrece.toArray()));
    }//GEN-LAST:event_cbVreceActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        // TODO add your handling code here:
        txtOznakaDostavnogSpiska.setText("");
        calendarDatumStampe.setDate(new Date());
        cbSati.setSelectedItem(0);
        cbMinuti.setSelectedIndex(0);
        cbSekunde.setSelectedIndex(0);
        cbVrece.setSelectedIndex(0);
        cbPosta.setEnabled(false);
        cbPostar.setEnabled(false);
        cbObracunskiRadnik.setEnabled(false);
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        vreca = getInputDataVrece();
        posta = getInputDataPosta();
        postar = getInputDataPostar();
        obracunskiRadnik = getInputDataObracunskiRadnik();
        dostavniSpisak = getInputDostavniSpisak();
        if(operation.equals("CREATE")){
            try {
                Controller.getInstance().addDostavniSpisak(dostavniSpisak);
                JOptionPane.showMessageDialog(this, "Upesno kreiran dostavni spisak");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }else if(operation.equals("UPDATE")){
            try {
                Controller.getInstance().updateDostavniSpisak(dostavniSpisak);
                JOptionPane.showMessageDialog(this, "Upesno ažuriran dostavni spisak");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JCalendar calendarDatumStampe;
    private javax.swing.JComboBox<String> cbHour;
    private javax.swing.JComboBox<String> cbMinuti;
    private javax.swing.JComboBox<PostanskiRadnik
    > cbObracunskiRadnik;
    private javax.swing.JComboBox<Posta> cbPosta;
    private javax.swing.JComboBox<PostanskiRadnik> cbPostar;
    private javax.swing.JComboBox<String> cbSati;
    private javax.swing.JComboBox<String> cbSekunde;
    private javax.swing.JComboBox<PopisPosiljakaUSVreci> cbVrece;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtOznakaDostavnogSpiska;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        try {
            poste = Controller.getInstance().getPoste(new Posta());
            radnici = Controller.getInstance().getPostanskiRadnici(new PostanskiRadnik());
            vrece = Controller.getInstance().getVrece(new PopisPosiljakaUSVreci());
            postari = radnici.stream()
                             .filter(p -> p.getTitula() == TipRadnika.POSTAR)
                             .collect(Collectors.toList());
            obracunskiRadnici = radnici.stream()
                                        .filter(obr->obr.getTitula()==TipRadnika.OBRACUNSKI_RADNIK)
                                        .collect(Collectors.toList());
            
            cbVrece.setModel(new DefaultComboBoxModel(vrece.toArray()));
            cbPosta.setModel(new DefaultComboBoxModel(poste.toArray()));
            cbPostar.setModel(new DefaultComboBoxModel(postari.toArray()));
            cbObracunskiRadnik.setModel(new DefaultComboBoxModel(obracunskiRadnici.toArray()));
            
            txtOznakaDostavnogSpiska.setEditable(true);
            cbPosta.setEnabled(false);
            cbPostar.setEnabled(false);
            cbObracunskiRadnik.setEnabled(false);
            
            if(operation.equals("UPDATE")){
                populateForm();
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveDostavniSpisak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateForm() {
        dostavniSpisak = (DostavniSpisak) localStorage.getItemFromHashMap("dostavniSpisak");
        txtOznakaDostavnogSpiska.setEditable(false);
        txtOznakaDostavnogSpiska.setText(dostavniSpisak.getOznakaDostavnogSpiska().toString());
        calendarDatumStampe.setDate(Date.from(dostavniSpisak.getDatumStampe().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        LocalDateTime vremeStampe = dostavniSpisak.getVremeStampe();
        int hours = vremeStampe.getHour();
        int minutes = vremeStampe.getMinute();
        int seconds = vremeStampe.getSecond();
        cbSati.setSelectedItem(String.format("%02d", hours));
        cbMinuti.setSelectedItem(String.format("%02d", minutes));
        cbSekunde.setSelectedItem(String.format("%02d", seconds));
        cbVrece.setSelectedItem(dostavniSpisak.getVreca());
        cbPosta.setSelectedItem(dostavniSpisak.getPosta());
        cbPostar.setSelectedItem(dostavniSpisak.getPostar());
        cbObracunskiRadnik.setSelectedItem(dostavniSpisak.getObracunskiRadnik()); 
    }

    private PopisPosiljakaUSVreci getInputDataVrece() {
        return (PopisPosiljakaUSVreci) cbVrece.getSelectedItem();
    }

    private Posta getInputDataPosta() {
        return (Posta) cbPosta.getSelectedItem();
    }

    private PostanskiRadnik getInputDataPostar() {
        return (PostanskiRadnik) cbPostar.getSelectedItem();
    }

    private PostanskiRadnik getInputDataObracunskiRadnik() {
        return (PostanskiRadnik) cbObracunskiRadnik.getSelectedItem();
    }

    private DostavniSpisak getInputDostavniSpisak() {
        Integer oznakaDostavnogSpiska = Integer.parseInt(txtOznakaDostavnogSpiska.getText());
        LocalDate datumStampe = calendarDatumStampe.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer sati = Integer.parseInt((String)cbSati.getSelectedItem());
        Integer minuti = Integer.parseInt((String)cbMinuti.getSelectedItem());
        Integer sekunde = Integer.parseInt((String)cbSekunde.getSelectedItem());
        LocalDateTime vremeStampe = LocalDateTime.of(datumStampe.getYear(),datumStampe.getMonth().getValue(),datumStampe.getDayOfMonth(), sati, minuti, sekunde);
        
        return new DostavniSpisak(oznakaDostavnogSpiska, datumStampe, vremeStampe, vreca, posta, postar, obracunskiRadnik);
    }
}
