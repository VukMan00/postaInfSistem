/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class Otpremnica implements GenericEntity{
    
    private Integer brojUPL;
    private Integer iznos;
    private PostanskiRadnik obracunskiRadnik;
    private DostavniSpisak dostavniSpisak;
    private Adresnica posiljka;
    private Posta posta;
    private String nazivPoste;
    
    public Otpremnica(){
        
    }

    public Otpremnica(Integer brojUPL, Integer iznos, PostanskiRadnik obracunskiRadnik, DostavniSpisak dostavniSpisak,Adresnica posiljka, Posta posta) {
        this.brojUPL = brojUPL;
        this.iznos = iznos;
        this.obracunskiRadnik = obracunskiRadnik;
        this.dostavniSpisak = dostavniSpisak;
        this.posiljka = posiljka;
        this.posta = posta;
    }

    
    public Otpremnica(Integer brojUPL, Integer iznos, PostanskiRadnik obracunskiRadnik, DostavniSpisak dostavniSpisak, Adresnica posiljka, Posta posta, String nazivPoste) {
        this.brojUPL = brojUPL;
        this.iznos = iznos;
        this.obracunskiRadnik = obracunskiRadnik;
        this.dostavniSpisak = dostavniSpisak;
        this.posta = posta;
        this.posiljka = posiljka;
        this.nazivPoste = nazivPoste;
    }

    public Integer getBrojUPL() {
        return brojUPL;
    }

    public void setBrojUPL(Integer brojUPL) {
        this.brojUPL = brojUPL;
    }

    public Integer getIznos() {
        return iznos;
    }

    public void setIznos(Integer iznos) {
        this.iznos = iznos;
    }

    public PostanskiRadnik getObracunskiRadnik() {
        return obracunskiRadnik;
    }

    public void setObracunskiRadnik(PostanskiRadnik obracunskiRadnik) {
        this.obracunskiRadnik = obracunskiRadnik;
    }

    public DostavniSpisak getDostavniSpisak() {
        return dostavniSpisak;
    }

    public void setDostavniSpisak(DostavniSpisak dostavniSpisak) {
        this.dostavniSpisak = dostavniSpisak;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

    public String getNazivPoste() {
        return nazivPoste;
    }

    public void setNazivPoste(String nazivPoste) {
        this.nazivPoste = nazivPoste;
    }

    public Adresnica getPosiljka() {
        return posiljka;
    }

    public void setPosiljka(Adresnica posiljka) {
        this.posiljka = posiljka;
    }
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT otp.brojUPL,otp.iznos,otp.oznakaDostavnogSpiska,otp.nazivPoste,otp.redniBrojPoste,otp.posiljka, ")
          .append("obrRadnik.sifraRadnika AS sifraObracunskogRadnika,obrRadnik.imePrezime AS imePrezimeObracunskogRadnika ")
          .append(" FROM ").append(getTableName()).append(" otp ")
          .append("INNER JOIN VUK.postanski_radnik obrRadnik ON otp.sifraObracunskogRadnika=obrRadnik.sifraRadnika ");
        return sb.toString();
    }

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            brojUPL = rs.getInt("brojUPL");
            iznos = rs.getInt("iznos");
            Integer oznakaDostavnogSpiska = rs.getInt("oznakaDostavnogSpiska");
            Integer redniBrojPoste = rs.getInt("redniBrojPoste");
            nazivPoste = rs.getString("nazivPoste");
            Integer sifraObracunskogRadnika = rs.getInt("sifraObracunskogRadnika");
            String imePrezimeObracunskogRadnika = rs.getString("imePrezimeObracunskogRadnika");
            Integer sifraPosiljke = rs.getInt("posiljka");
            
            dostavniSpisak = new DostavniSpisak();
            dostavniSpisak.setOznakaDostavnogSpiska(oznakaDostavnogSpiska);
            
            posiljka = new Adresnica();
            posiljka.setSifraAdresnice(sifraPosiljke);
            
            posta = new Posta(redniBrojPoste, nazivPoste);
            
            obracunskiRadnik = new PostanskiRadnik(sifraObracunskogRadnika, imePrezimeObracunskogRadnika, TipRadnika.OBRACUNSKI_RADNIK, posta);
            
            return new Otpremnica(brojUPL, iznos, obracunskiRadnik, dostavniSpisak, posiljka, posta);
        } catch (SQLException ex) {
            Logger.getLogger(Otpremnica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.otpremnica_denorm";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "brojUPL,iznos,sifraObracunskogRadnika,oznakaDostavnogSpiska,posiljka,redniBrojPoste";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(brojUPL).append(",")
          .append(iznos).append(",")
          .append(obracunskiRadnik.getSifraRadnika()).append(",")
          .append(dostavniSpisak.getOznakaDostavnogSpiska()).append(",")
          .append(posiljka.getSifraAdresnice()).append(",")
          .append(posta.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("redniBrojPoste=").append(posta.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "brojUPL="+brojUPL;
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setTypeMap(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
