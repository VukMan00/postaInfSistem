/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class PotvrdaOPrijemuPosiljke implements GenericEntity{
    
    private Integer prijemniBroj;
    private LocalDate datumStampe;
    private LocalDateTime vremeStampe;
    private Adresnica posiljka;
    private Korisnik primalac;
    private Korisnik posiljalac;
    
    public PotvrdaOPrijemuPosiljke(){
        
    }

    public PotvrdaOPrijemuPosiljke(Integer prijemniBroj, LocalDate datumStampe, LocalDateTime vremeStampe, Adresnica posiljka, Korisnik primalac, Korisnik posiljalac) {
        this.prijemniBroj = prijemniBroj;
        this.datumStampe = datumStampe;
        this.vremeStampe = vremeStampe;
        this.posiljka = posiljka;
        this.primalac = primalac;
        this.posiljalac = posiljalac;
    }

    private PotvrdaOPrijemuPosiljke(Integer prijemniBroj, LocalDate datumStampe, LocalDateTime vremeStampe, Adresnica posiljka) {
        this.prijemniBroj = prijemniBroj;
        this.datumStampe = datumStampe;
        this.vremeStampe = vremeStampe;
        this.posiljka = posiljka;
    }

    public Integer getPrijemniBroj() {
        return prijemniBroj;
    }

    public void setPrijemniBroj(Integer prijemniBroj) {
        this.prijemniBroj = prijemniBroj;
    }

    public LocalDate getDatumStampe() {
        return datumStampe;
    }

    public void setDatumStampe(LocalDate datumStampe) {
        this.datumStampe = datumStampe;
    }

    public LocalDateTime getVremeStampe() {
        return vremeStampe;
    }

    public void setVremeStampe(LocalDateTime vremeStampe) {
        this.vremeStampe = vremeStampe;
    }

    public Adresnica getPosiljka() {
        return posiljka;
    }

    public void setPosiljka(Adresnica posiljka) {
        this.posiljka = posiljka;
    }

    public Korisnik getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Korisnik primalac) {
        this.primalac = primalac;
    }

    public Korisnik getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Korisnik posiljalac) {
        this.posiljalac = posiljalac;
    }

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT prijemniBroj,datumStampe,vremeStampe,sifraAdresnice")
          .append(" FROM ").append(getTableName());
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            prijemniBroj = rs.getInt("prijemniBroj");
            datumStampe = rs.getDate("datumStampe").toLocalDate();
            vremeStampe = rs.getTimestamp("vremeStampe").toLocalDateTime();
            Integer sifraAdresnice = rs.getInt("sifraAdresnice");
            
            posiljka = new Adresnica();
            posiljka.setSifraAdresnice(sifraAdresnice);
            return new PotvrdaOPrijemuPosiljke(prijemniBroj, datumStampe, vremeStampe, posiljka);
        } catch (SQLException ex) {
            Logger.getLogger(PotvrdaOPrijemuPosiljke.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.potvrda_o_prijemu_posiljke_denorm";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "prijemniBroj,datumStampe,vremeStampe,sifraAdresnice";
    }

    @Override
    public String getInsertValues() {
        String datumStampeFormmated = formatDatumStampe();
        String vremeStampeFormmated = formatVremeStampe();
        StringBuilder sb = new StringBuilder();
        sb.append(prijemniBroj).append(",")
          .append("TO_DATE(").append("'").append(datumStampeFormmated).append("','DD-MM-YYYY'),")
          .append("TO_TIMESTAMP(").append("'").append(vremeStampeFormmated).append("','DD-MM-YYYY HH24:MI:SS'),")
          .append(posiljka.getSifraAdresnice());
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        String datumStampeFormmated = formatDatumStampe();
        String vremeStampeFormmated = formatVremeStampe();
        sb.append("datumStampe=").append("TO_DATE(").append("'").append(datumStampeFormmated).append("','DD-MM-YYYY'),")
          .append("vremeStampe=").append("TO_TIMESTAMP(").append("'").append(vremeStampeFormmated).append("','DD-MM-YYYY HH24:MI:SS'),")
          .append("sifraAdresnice=").append(posiljka.getSifraAdresnice());
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "prijemniBroj="+prijemniBroj;
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

    private String formatDatumStampe() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDatumStampe = dtf.format(datumStampe);
        return formattedDatumStampe;
    }

    private String formatVremeStampe() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedVremeStampe = dtf.format(vremeStampe);
        return formattedVremeStampe;
    }

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
