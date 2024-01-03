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
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class SpisakRazmene implements GenericEntity{
    
    private Integer oznakaSpiska;
    private LocalDate datumStampe;
    private LocalDateTime vremeStampe;
    private String napomena;
    private Posta postaPrimalac;
    private Posta postaPosiljalac;
    private Vozac vozac;
    
    public SpisakRazmene(){
        
    }

    public SpisakRazmene(Integer oznakaSpiska, LocalDate datumStampe, LocalDateTime vremeStampe, String napomena, Posta postaPrimalac, Posta postaPosiljalac, Vozac vozac) {
        this.oznakaSpiska = oznakaSpiska;
        this.datumStampe = datumStampe;
        this.vremeStampe = vremeStampe;
        this.napomena = napomena;
        this.postaPrimalac = postaPrimalac;
        this.postaPosiljalac = postaPosiljalac;
        this.vozac = vozac;
    }

    public Integer getOznakaSpiska() {
        return oznakaSpiska;
    }

    public void setOznakaSpiska(Integer oznakaSpiska) {
        this.oznakaSpiska = oznakaSpiska;
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

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Posta getPostaPrimalac() {
        return postaPrimalac;
    }

    public void setPostaPrimalac(Posta postaPrimalac) {
        this.postaPrimalac = postaPrimalac;
    }

    public Posta getPostaPosiljalac() {
        return postaPosiljalac;
    }

    public void setPostaPosiljalac(Posta postaPosiljalac) {
        this.postaPosiljalac = postaPosiljalac;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    @Override
    public String toString() {
        return oznakaSpiska + " - " + napomena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.oznakaSpiska);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SpisakRazmene other = (SpisakRazmene) obj;
        return Objects.equals(this.oznakaSpiska, other.oznakaSpiska);
    }
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
          .append("sr.oznakaSpiska,sr.napomena,sr.datumStampe,sr.vremeStampe, ")
          .append("pPrimalac.redniBroj AS redniBrojPostePrimaoca,pPrimalac.naziv AS nazivPostePrimaoca, ")
          .append("pPosiljalac.redniBroj AS redniBrojPostePosiljaoca,pPosiljalac.naziv AS nazivPostePosiljaoca, ")
          .append("v.sifraVozaca,v.imePrezime,v.trenutnaLinija")
          .append(" FROM ").append(getTableName()).append(" sr ")
          .append("INNER JOIN VUK.posta pPrimalac ON sr.redniBrojPostePrimaoca=pPrimalac.redniBroj ")
          .append("INNER JOIN VUK.posta pPosiljalac ON sr.redniBrojPostePosiljaoca=pPosiljalac.redniBroj ")
          .append("INNER JOIN VUK.vozac v ON sr.sifraVozaca=v.sifraVozaca");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            oznakaSpiska = rs.getInt("oznakaSpiska");
            napomena = rs.getString("napomena");
            datumStampe = rs.getDate("datumStampe").toLocalDate();
            vremeStampe = rs.getTimestamp("vremeStampe").toLocalDateTime();
            Integer redniBrojPostePrimaoca = rs.getInt("redniBrojPostePrimaoca");
            String nazivPostePrimaoca = rs.getString("nazivPostePrimaoca");
            Integer redniBrojPostePosiljaoca = rs.getInt("redniBrojPostePosiljaoca");
            String nazivPostePosiljaoca = rs.getString("nazivPostePosiljaoca");
            Integer sifraVozaca = rs.getInt("sifraVozaca");
            String imePrezime = rs.getString("imePrezime");
            String trenutnaLinija = rs.getString("trenutnaLinija");
            
            postaPrimalac = new Posta(redniBrojPostePrimaoca, nazivPostePrimaoca);
            postaPosiljalac = new Posta(redniBrojPostePosiljaoca, nazivPostePosiljaoca);
            vozac = new Vozac(sifraVozaca, imePrezime, trenutnaLinija);
            
            return new SpisakRazmene(oznakaSpiska, datumStampe, vremeStampe, napomena, postaPrimalac, postaPosiljalac, vozac);
        } catch (SQLException ex) {
            Logger.getLogger(SpisakRazmene.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.spisak_razmene";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
