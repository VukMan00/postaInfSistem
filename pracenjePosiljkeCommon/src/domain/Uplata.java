/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class Uplata implements GenericEntity{
    
    private Korisnik korisnik;
    private Posta posta;
    private Adresnica posiljka;
    private Uplatnica uplatnica;
    private LocalDate datumUplate;
    
    public Uplata(){
        
    }

    public Uplata(Korisnik korisnik, Posta posta, Adresnica posiljka, Uplatnica uplatnica, LocalDate datumUplate) {
        this.korisnik = korisnik;
        this.posta = posta;
        this.posiljka = posiljka;
        this.uplatnica = uplatnica;
        this.datumUplate = datumUplate;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

    public Adresnica getPosiljka() {
        return posiljka;
    }

    public void setPosiljka(Adresnica posiljka) {
        this.posiljka = posiljka;
    }

    public Uplatnica getUplatnica() {
        return uplatnica;
    }

    public void setUplatnica(Uplatnica uplatnica) {
        this.uplatnica = uplatnica;
    }
        
    public LocalDate getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(LocalDate datumUplate) {
        this.datumUplate = datumUplate;
    }

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("up.datumUplate, ")
          .append("k.jmbg AS jmbgUplatilac,k.imePrezime AS imePrezimeUplatilac, ")
          .append("p.redniBroj AS rbPoste,p.naziv AS nazivPoste, ")
          .append("adr.sifraAdresnice,adr.oznakaVrece, ")
          .append("upl.sifraUplatnica,upl.iznos")
          .append(" FROM ").append(getTableName()).append(" up ")
          .append("INNER JOIN VUK.korisnik k ON up.jmbgKorisnik=k.jmbg ")
          .append("INNER JOIN VUK.posta p ON up.redniBrojPoste=p.redniBroj ")
          .append("INNER JOIN VUK.adresnica_osnovno adr ON up.posiljka=adr.sifraAdresnice ")
          .append("INNER JOIN VUK.uplatnica upl ON up.sifraUplatnice=upl.sifraUplatnica");
        return sb.toString();
    }

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            datumUplate = rs.getDate("datumUplate").toLocalDate();
            String jmbgUplatilac = rs.getString("jmbgUplatilac");
            String imePrezimeUplatilac = rs.getString("imePrezimeUplatilac");
            Integer rbPoste = rs.getInt("rbPoste");
            String nazivPoste = rs.getString("nazivPoste");
            Integer sifraAdresnice = rs.getInt("sifraAdresnice");
            Integer oznakaVrece = rs.getInt("oznakaVrece");
            Integer sifraUplatnice = rs.getInt("sifraUplatnica");
            Integer iznos = rs.getInt("iznos");
            
            korisnik = new Korisnik(jmbgUplatilac, imePrezimeUplatilac);
            posta = new Posta(rbPoste, nazivPoste);
            
            posiljka = new Adresnica();
            posiljka.setSifraAdresnice(sifraAdresnice);
            PopisPosiljakaUSVreci vreca = new PopisPosiljakaUSVreci();
            vreca.setOznakaVrece(oznakaVrece);
            posiljka.setVreca(vreca);
            
            uplatnica = new Uplatnica();
            uplatnica.setSifraUplatnice(sifraUplatnice);
            uplatnica.setIznos(iznos);
            
            return new Uplata(korisnik, posta, posiljka, uplatnica, datumUplate);
        } catch (SQLException ex) {
            Logger.getLogger(Uplata.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.uplata";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "jmbgKorisnik,redniBrojPoste,posiljka,sifraUplatnice,datumUplate";
    }

    @Override
    public String getInsertValues() {
        String datumUplateFormmated = formatDatumUplate();
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(korisnik.getJmbg()).append("',")
          .append(posta.getRedniBroj()).append(",")
          .append(posiljka.getSifraAdresnice()).append(",")
          .append(uplatnica.getSifraUplatnice()).append(",")
          .append("TO_DATE(").append("'").append(datumUplateFormmated).append("','DD-MM-YYYY') ");
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereGetCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("jmbgKorisnik='").append(korisnik.getJmbg()).append("'")
          .append(" AND ")
          .append("posiljka=").append(posiljka.getSifraAdresnice());
        return sb.toString();
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setTypeMap(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String formatDatumUplate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDatumStampe = dtf.format(datumUplate);
        return formattedDatumStampe;
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
