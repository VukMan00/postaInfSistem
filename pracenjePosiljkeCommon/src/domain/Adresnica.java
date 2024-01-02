/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class Adresnica implements GenericEntity{

    private Integer sifraAdresnice;
    private PopisPosiljakaUSVreci vreca;
    private SpisakRazmene spisak;
    private Korisnik posiljalac;
    private Korisnik primalac;
    private Integer masa;
    private String napomena;
    private String sadrzina;
    
    public Adresnica(Integer sifraAdresnice, Korisnik posiljalac, Korisnik primalac){
        this.sifraAdresnice = sifraAdresnice;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
    }

    public Adresnica(Integer sifraAdresnice, PopisPosiljakaUSVreci vreca, SpisakRazmene spisak, Korisnik posiljalac, Korisnik primalac, Integer masa) {
        this.sifraAdresnice = sifraAdresnice;
        this.vreca = vreca;
        this.spisak = spisak;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.masa = masa;
    }

    public Adresnica(Integer sifraAdresnice, PopisPosiljakaUSVreci vreca, SpisakRazmene spisak, Korisnik posiljalac, Korisnik primalac, Integer masa, String napomena, String sadrzina) {
        this.sifraAdresnice = sifraAdresnice;
        this.vreca = vreca;
        this.spisak = spisak;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.masa = masa;
        this.napomena = napomena;
        this.sadrzina = sadrzina;
    }
    
    public Adresnica() {
        
    }

    public Integer getSifraAdresnice() {
        return sifraAdresnice;
    }

    public void setSifraAdresnice(Integer sifraAdresnice) {
        this.sifraAdresnice = sifraAdresnice;
    }

    public PopisPosiljakaUSVreci getVreca() {
        return vreca;
    }

    public void setVreca(PopisPosiljakaUSVreci vreca) {
        this.vreca = vreca;
    }

    public SpisakRazmene getSpisak() {
        return spisak;
    }

    public void setSpisak(SpisakRazmene spisak) {
        this.spisak = spisak;
    }

    public Korisnik getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Korisnik posiljalac) {
        this.posiljalac = posiljalac;
    }

    public Korisnik getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Korisnik primalac) {
        this.primalac = primalac;
    }

    public Integer getMasa() {
        return masa;
    }

    public void setMasa(Integer masa) {
        this.masa = masa;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getSadrzina() {
        return sadrzina;
    }

    public void setSadrzina(String sadrzina) {
        this.sadrzina = sadrzina;
    }

    @Override
    public String toString() {
        return sifraAdresnice.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.sifraAdresnice);
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
        final Adresnica other = (Adresnica) obj;
        return Objects.equals(this.sifraAdresnice, other.sifraAdresnice);
    }

    
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
                .append("adr.sifraAdresnice,adr.oznakaVrece,adr.oznakaSpiska,adr.napomena,adr.sadrzina,adr.masa, ")
                .append("adr.jmbgPrimalac,adr.jmbgPosiljalac,kPrimalac.imePrezime AS imePrezimePrimalac, ")
                .append("kPosiljalac.imePrezime AS imePrezimePosiljalac ")
                .append("FROM ").append(getTableName()).append(" adr ")
                .append("INNER JOIN VUK.korisnik kPrimalac ")
                .append("ON adr.jmbgPrimalac=kPrimalac.jmbg ")
                .append("INNER JOIN VUK.korisnik kPosiljalac ")
                .append("ON adr.jmbgPosiljalac=kPosiljalac.jmbg ");
        return sb.toString();           
    }
    
    
    @Override
    public String getSelectValuesWithCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSelectValues())
          .append(" WHERE oznakaVrece=").append(vreca.getOznakaVrece());
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            sifraAdresnice = rs.getInt("sifraAdresnice");
            Integer oznakaVrece = rs.getInt("oznakaVrece");
            Integer oznakaSpiska = rs.getInt("oznakaSpiska");
            napomena = rs.getString("napomena");
            sadrzina = rs.getString("sadrzina");
            masa = rs.getInt("masa");
            String jmbgPrimalac = rs.getString("jmbgPrimalac");
            String jmbgPosiljalac = rs.getString("jmbgPosiljalac");
            String imePrezimePrimalac = rs.getString("imePrezimePrimalac");
            String imePrezimePosiljalac = rs.getString("imePrezimePosiljalac");
            
            primalac = new Korisnik(jmbgPrimalac, imePrezimePrimalac);
            posiljalac = new Korisnik(jmbgPosiljalac,imePrezimePosiljalac);
            
            vreca = new PopisPosiljakaUSVreci();
            vreca.setOznakaVrece(oznakaVrece);
            
            spisak = new SpisakRazmene();
            spisak.setOznakaSpiska(oznakaSpiska);
            
            return new Adresnica(sifraAdresnice,vreca,spisak,posiljalac,primalac,masa,napomena,sadrzina);
        } catch (SQLException ex) {
            Logger.getLogger(Adresnica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.adresnica_view";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraAdresnice, oznakaVrece, oznakaSpiska, jmbgPosiljalac, jmbgPrimalac, masa, napomena, sadrzina";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifraAdresnice).append(",")
          .append(vreca.getOznakaVrece()).append(",")
          .append(spisak.getOznakaSpiska()).append(",")
          .append("'").append(posiljalac.getJmbg()).append("',")
          .append("'").append(primalac.getJmbg()).append("',")
          .append(masa).append(",")
          .append("'").append(napomena).append("',")
          .append("'").append(sadrzina).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("sifraAdresnice=").append(sifraAdresnice).append(",")
          .append("oznakaVrece=").append(vreca.getOznakaVrece()).append(",")
          .append("oznakaSpiska=").append(spisak.getOznakaSpiska()).append(",")
          .append("jmbgPosiljalac='").append(posiljalac.getJmbg()).append("',")
          .append("jmbgPrimalac='").append(primalac.getJmbg()).append("',")
          .append("masa=").append(masa).append(",")
          .append("napomena='").append(napomena).append("',")
          .append("sadrzina='").append(sadrzina).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "sifraAdresnice=" + sifraAdresnice;
    }

    @Override
    public String getDeleteCondition() {
        return "sifraAdresnice=" + sifraAdresnice;
    }

    @Override
    public String getWhereGetCondition() {
        return "sifraAdresnice=" + sifraAdresnice;
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
