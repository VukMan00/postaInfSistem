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
public class PopisPosiljakaUSVreci implements GenericEntity{
    
    private Integer oznakaVrece;
    private SpisakRazmene spisak;
    private LocalDate datumStampe;
    private LocalDateTime vremeStampe;
    private Posta postaPrimalac;
    private Posta postaPosiljalac;
    private Integer masaVrece;
    
    public PopisPosiljakaUSVreci(){
        
    }

    public PopisPosiljakaUSVreci(Integer oznakaVrece, SpisakRazmene spisak, LocalDate datumStampe, LocalDateTime vremeStampe, Posta postaPrimalac, Posta postaPosiljalac, Integer masaVrece) {
        this.oznakaVrece = oznakaVrece;
        this.spisak = spisak;
        this.datumStampe = datumStampe;
        this.vremeStampe = vremeStampe;
        this.postaPrimalac = postaPrimalac;
        this.postaPosiljalac = postaPosiljalac;
        this.masaVrece = masaVrece;
    }

    public Integer getOznakaVrece() {
        return oznakaVrece;
    }

    public void setOznakaVrece(Integer oznakaVrece) {
        this.oznakaVrece = oznakaVrece;
    }

    public SpisakRazmene getSpisak() {
        return spisak;
    }

    public void setSpisak(SpisakRazmene spisak) {
        this.spisak = spisak;
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

    public Integer getMasaVrece() {
        return masaVrece;
    }

    public void setMasaVrece(Integer masaVrece) {
        this.masaVrece = masaVrece;
    }
    
    @Override
    public String toString() {
        return "" + oznakaVrece;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.oznakaVrece);
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
        final PopisPosiljakaUSVreci other = (PopisPosiljakaUSVreci) obj;
        return Objects.equals(this.oznakaVrece, other.oznakaVrece);
    }

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
          .append("vr.oznakaVrece,vr.datumStampe,vr.vremeStampe,vr.masaVrece,vr.oznakaSpiska, ")
          .append("pPrimalac.redniBroj AS redniBrojPostePrimaoca,pPrimalac.naziv AS nazivPostePrimaoca, ")
          .append("pPosiljalac.redniBroj AS redniBrojPostePosiljaoca,pPosiljalac.naziv AS nazivPostePosiljaoca ")
          .append(" FROM ").append(getTableName()).append(" vr ")
          .append("INNER JOIN VUK.posta pPrimalac ON vr.redniBrojPostePrimaoca=pPrimalac.redniBroj ")
          .append("INNER JOIN VUK.posta pPosiljalac ON vr.redniBrojPostePosiljaoca=pPosiljalac.redniBroj");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            oznakaVrece = rs.getInt("oznakaVrece");
            datumStampe = rs.getDate("datumStampe").toLocalDate();
            vremeStampe = rs.getTimestamp("vremeStampe").toLocalDateTime();
            masaVrece = rs.getInt("masaVrece");
            Integer oznakaSpiska = rs.getInt("oznakaSpiska");
            Integer redniBrojPostePrimaoca = rs.getInt("redniBrojPostePrimaoca");
            String nazivPostePrimaoca = rs.getString("nazivPostePrimaoca");
            Integer redniBrojPostePosiljaoca = rs.getInt("redniBrojPostePosiljaoca");
            String nazivPostePosiljaoca = rs.getString("nazivPostePosiljaoca");
            
            spisak = new SpisakRazmene();
            spisak.setOznakaSpiska(oznakaSpiska);
            
            postaPrimalac = new Posta(redniBrojPostePrimaoca, nazivPostePrimaoca);
            postaPosiljalac = new Posta(redniBrojPostePosiljaoca, nazivPostePosiljaoca);
            
            return new PopisPosiljakaUSVreci(oznakaVrece, spisak, datumStampe, vremeStampe, postaPrimalac, postaPosiljalac, masaVrece);      
        } catch (SQLException ex) {
            Logger.getLogger(PopisPosiljakaUSVreci.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.popis_posiljaka_u_s_vreci";
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
