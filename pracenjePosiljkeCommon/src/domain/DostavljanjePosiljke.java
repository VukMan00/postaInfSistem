/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class DostavljanjePosiljke implements GenericEntity{
    
    private PostanskiRadnik postar;
    private Korisnik primalac;
    private Adresnica posiljka;
    private LocalDate datumDostave;
    private LocalDateTime vremeDostave;
    private TipPartition kvartal;
    
    public DostavljanjePosiljke(){
        
    }
    
    public DostavljanjePosiljke(Korisnik primalac,Adresnica posiljka,LocalDate datumDostave, LocalDateTime vremeDostave){
        this.primalac = primalac;
        this.posiljka = posiljka;
        this.datumDostave = datumDostave;
        this.vremeDostave = vremeDostave;
    }

    public DostavljanjePosiljke(PostanskiRadnik postar, Korisnik primalac, Adresnica posiljka, LocalDate datumDostave, LocalDateTime vremeDostave) {
        this.postar = postar;
        this.primalac = primalac;
        this.posiljka = posiljka;
        this.datumDostave = datumDostave;
        this.vremeDostave = vremeDostave;
    }

    public PostanskiRadnik getPostar() {
        return postar;
    }

    public void setPostar(PostanskiRadnik postar) {
        this.postar = postar;
    }

    public Korisnik getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Korisnik primalac) {
        this.primalac = primalac;
    }

    public Adresnica getPosiljka() {
        return posiljka;
    }

    public void setPosiljka(Adresnica posiljka) {
        this.posiljka = posiljka;
    }

    public LocalDate getDatumDostave() {
        return datumDostave;
    }

    public void setDatumDostave(LocalDate datumDostave) {
        this.datumDostave = datumDostave;
    }

    public LocalDateTime getVremeDostave() {
        return vremeDostave;
    }

    public void setVremeDostave(LocalDateTime vremeDostave) {
        this.vremeDostave = vremeDostave;
    }

    public TipPartition getKvartal() {
        return kvartal;
    }

    public void setKvartal(TipPartition kvartal) {
        this.kvartal = kvartal;
    }
    

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
           .append("adr.sifraAdresnice,adr.napomena,adr.sadrzina, ")
           .append("vr.oznakaVrece, ")
           .append("dp.jmbgPrimalac,dp.imePrezime, ")
           .append("dp.datumDostave,dp.vremeDostave, ")
           .append("k.jmbg AS jmbgPosiljalac,k.imePrezime AS imePrezimePosiljalac ")
           .append("FROM ").append(getTableName()).append(" dp ")
           .append("INNER JOIN VUK.adresnica_view adr ").append("ON dp.posiljka=adr.sifraAdresnice ")
           .append("INNER JOIN VUK.korisnik k ON adr.jmbgPosiljalac=k.jmbg ")
           .append("INNER JOIN VUK.popis_posiljaka_u_s_vreci vr ON adr.oznakaVrece=vr.oznakaVrece");        
        return sb.toString();
    }
    
    @Override
    public String getSelectValuesWithCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
           .append("adr.sifraAdresnice,adr.napomena,adr.sadrzina, ")
           .append("vr.oznakaVrece, ")
           .append("dp.jmbgPrimalac,dp.imePrezime, ")
           .append("dp.datumDostave,dp.vremeDostave, ")
           .append("k.jmbg AS jmbgPosiljalac,k.imePrezime AS imePrezimePosiljalac ")
           .append("FROM ").append(getTableName()).append(" dp ")
           .append("INNER JOIN VUK.adresnica_view adr ").append("ON dp.posiljka=adr.sifraAdresnice ")
           .append("INNER JOIN VUK.korisnik k ON adr.jmbgPosiljalac=k.jmbg ")
           .append("INNER JOIN VUK.popis_posiljaka_u_s_vreci vr ON adr.oznakaVrece=vr.oznakaVrece")
           .append(" WHERE ").append("UPPER(dp.imePrezime)=").append("'").append(primalac.getImePrezime().toUpperCase()).append("' ");        
        return sb.toString();
    }
    
   @Override
    public String getSelectValuesWithPartition() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
           .append("adr.sifraAdresnice,adr.napomena,adr.sadrzina, ")
           .append("vr.oznakaVrece, ")
           .append("dp.jmbgPrimalac,dp.imePrezime, ")
           .append("dp.datumDostave,dp.vremeDostave, ")
           .append("k.jmbg AS jmbgPosiljalac,k.imePrezime AS imePrezimePosiljalac ")
           .append("FROM ").append(getTableName()).append(" PARTITION(").append(kvartal).append(")").append(" dp ")
           .append("INNER JOIN VUK.adresnica_view adr ").append("ON dp.posiljka=adr.sifraAdresnice ")
           .append("INNER JOIN VUK.korisnik k ON adr.jmbgPosiljalac=k.jmbg ")
           .append("INNER JOIN VUK.popis_posiljaka_u_s_vreci vr ON adr.oznakaVrece=vr.oznakaVrece");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            Integer sifraAdresnice = rs.getInt("sifraAdresnice");
            String napomenaPosiljka = rs.getString("napomena");
            String sadrzinaPosiljka = rs.getString("sadrzina");
            Integer oznakaVrece = rs.getInt("oznakaVrece");
            LocalDate datumDostavePosiljke = rs.getDate("datumDostave").toLocalDate();
            LocalDateTime vremeDostavePosiljke = rs.getTimestamp("vremeDostave").toLocalDateTime();
            String jmbgPosiljalac = rs.getString("jmbgPosiljalac");
            String imePrezimePosiljalac = rs.getString("imePrezimePosiljalac");
            String jmbgPrimalac = rs.getString("jmbgPrimalac");
            String imePrezimePrimalac = rs.getString("imePrezime");
            
            primalac = new Korisnik(jmbgPrimalac, imePrezimePrimalac);
            Korisnik posiljalac = new Korisnik(jmbgPosiljalac,imePrezimePosiljalac);
            
            PopisPosiljakaUSVreci vreca = new PopisPosiljakaUSVreci();
            vreca.setOznakaVrece(oznakaVrece);
            posiljka = new Adresnica(sifraAdresnice,posiljalac,primalac);
            posiljka.setVreca(vreca);
            posiljka.setNapomena(napomenaPosiljka);
            posiljka.setSadrzina(sadrzinaPosiljka);
            
            return new DostavljanjePosiljke(primalac, posiljka, datumDostavePosiljke, vremeDostavePosiljke);
        } catch (SQLException ex) {
            Logger.getLogger(DostavljanjePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.dostavljanje_posiljke_denorm";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraPostara,jmbgPrimalac,posiljka,datumDostave,vremeDostave";
    }

    @Override
    public String getInsertValues() {
        String datumDostaveFormmated = formatDatumDostave();
        String vremeDostaveFormmated = formatVremeDostave();
        StringBuilder sb = new StringBuilder();
        sb.append(postar.getSifraRadnika()).append(",")
           .append("'").append(primalac.getJmbg()).append("',")
           .append(posiljka.getSifraAdresnice()).append(",")
           .append("TO_DATE(").append("'").append(datumDostaveFormmated).append("','DD-MM-YYYY'),")
           .append("TO_TIMESTAMP(").append("'").append(vremeDostaveFormmated).append("','DD-MM-YYYY HH24:MI:SS') ");
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

    private String formatDatumDostave() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDatumDostave = dtf.format(datumDostave);
        return formattedDatumDostave;
    }

    private String formatVremeDostave() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedVremeDostave = dtf.format(vremeDostave);
        return formattedVremeDostave;
    }
}
