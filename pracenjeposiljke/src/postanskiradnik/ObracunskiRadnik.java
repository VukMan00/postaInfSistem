/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package postanskiradnik;

import domain.PostanskiRadnik;
import dostavnispisak.OptionsDostavniSpisak;
import korisnik.OptionsKorisnik;
import linijevoznje.OptionsLinija;
import linijevoznje.OptionsVozac;
import login.RadnikLogin;
import posiljke.OptionsPosiljke;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class ObracunskiRadnik extends javax.swing.JDialog {

    /**
     * Creates new form ObracunskiRadnik
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    private PostanskiRadnik obracunskiRadnik;
    
    public ObracunskiRadnik(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        obracunskiRadnik = (PostanskiRadnik) localStorage.getItemFromHashMap("postanski-radnik");
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

        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        lbImePrezime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNazivPoste = new javax.swing.JLabel();
        lbMesto = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbKorisnik = new javax.swing.JMenu();
        miOperationKorisnik = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miOperationPosiljke = new javax.swing.JMenuItem();
        mnDostavniSpisak = new javax.swing.JMenu();
        miDostavniSpisakOpeation = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        miVozac = new javax.swing.JMenuItem();
        miLinija = new javax.swing.JMenuItem();

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Radnom mesto:");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Obračunski radnik");

        lbImePrezime.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lbImePrezime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImePrezime.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Radno mesto:");

        lbNazivPoste.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbNazivPoste.setText("jLabel3");

        lbMesto.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbMesto.setText("jLabel3");

        btnLogOut.setText("<-] Odjavite se");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        mbKorisnik.setText("Korisnik");
        mbKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbKorisnikActionPerformed(evt);
            }
        });

        miOperationKorisnik.setText("Operacije");
        miOperationKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOperationKorisnikActionPerformed(evt);
            }
        });
        mbKorisnik.add(miOperationKorisnik);

        jMenuBar1.add(mbKorisnik);

        jMenu3.setText(" Pošiljke");

        miOperationPosiljke.setText(" Operacije");
        miOperationPosiljke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOperationPosiljkeActionPerformed(evt);
            }
        });
        jMenu3.add(miOperationPosiljke);

        jMenuBar1.add(jMenu3);

        mnDostavniSpisak.setText(" Dostavni spisak");

        miDostavniSpisakOpeation.setText("Operacije");
        miDostavniSpisakOpeation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDostavniSpisakOpeationActionPerformed(evt);
            }
        });
        mnDostavniSpisak.add(miDostavniSpisakOpeation);

        jMenuBar1.add(mnDostavniSpisak);

        jMenu4.setText(" Upravljanje linijom");

        miVozac.setText("Vozač");
        miVozac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVozacActionPerformed(evt);
            }
        });
        jMenu4.add(miVozac);

        miLinija.setText("Linija");
        miLinija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLinijaActionPerformed(evt);
            }
        });
        jMenu4.add(miLinija);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbImePrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNazivPoste, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbImePrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbNazivPoste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMesto)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        RadnikLogin rl = new RadnikLogin(null, true);
        localStorage.removeItemFromHashMap("postanski-radnik");
        this.dispose();
        rl.setLocationRelativeTo(null);
        rl.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void mbKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbKorisnikActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mbKorisnikActionPerformed

    private void miOperationKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOperationKorisnikActionPerformed
        // TODO add your handling code here:
        OptionsKorisnik ok = new OptionsKorisnik(null, true);
        ok.setLocationRelativeTo(null);
        ok.setVisible(true);
    }//GEN-LAST:event_miOperationKorisnikActionPerformed

    private void miOperationPosiljkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOperationPosiljkeActionPerformed
        // TODO add your handling code here:
        OptionsPosiljke op = new OptionsPosiljke(null, true);
        op.setLocationRelativeTo(null);
        op.setVisible(true);
    }//GEN-LAST:event_miOperationPosiljkeActionPerformed

    private void miDostavniSpisakOpeationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDostavniSpisakOpeationActionPerformed
        // TODO add your handling code here:
        OptionsDostavniSpisak ods = new OptionsDostavniSpisak(null, true);
        ods.setLocationRelativeTo(null);
        ods.setVisible(true);
    }//GEN-LAST:event_miDostavniSpisakOpeationActionPerformed

    private void miVozacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVozacActionPerformed
        // TODO add your handling code here:
        OptionsVozac ov = new OptionsVozac(null, true);
        ov.setLocationRelativeTo(null);
        ov.setVisible(true);
    }//GEN-LAST:event_miVozacActionPerformed

    private void miLinijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLinijaActionPerformed
        // TODO add your handling code here:
        OptionsLinija ol = new OptionsLinija(null, true);
        ol.setLocationRelativeTo(null);
        ol.setVisible(true);
    }//GEN-LAST:event_miLinijaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel lbImePrezime;
    private javax.swing.JLabel lbMesto;
    private javax.swing.JLabel lbNazivPoste;
    private javax.swing.JMenu mbKorisnik;
    private javax.swing.JMenuItem miDostavniSpisakOpeation;
    private javax.swing.JMenuItem miLinija;
    private javax.swing.JMenuItem miOperationKorisnik;
    private javax.swing.JMenuItem miOperationPosiljke;
    private javax.swing.JMenuItem miVozac;
    private javax.swing.JMenu mnDostavniSpisak;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        lbImePrezime.setText(obracunskiRadnik.getImePrezime());
        lbNazivPoste.setText(obracunskiRadnik.getPosta().getNaziv());
        lbMesto.setText(obracunskiRadnik.getPosta().getMesto().getPodaciMesto().getNaziv() + " " + obracunskiRadnik.getPosta().getMesto().getPodaciMesto().getPostanskiBroj());
    }
}