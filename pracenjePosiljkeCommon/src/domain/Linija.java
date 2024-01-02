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
public class Linija implements GenericEntity{
    
    private Integer sifraLinije;
    private String naziv;
    private Posta posta;
    
    public Linija(){
        
    }

    public Linija(Integer sifraLinije, String naziv) {
        this.sifraLinije = sifraLinije;
        this.naziv = naziv;
    }
    
    public Linija(Integer sifraLinije, String naziv, Posta posta) {
        this.sifraLinije = sifraLinije;
        this.naziv = naziv;
        this.posta = posta;
    }

    public Integer getSifraLinije() {
        return sifraLinije;
    }

    public void setSifraLinije(Integer sifraLinije) {
        this.sifraLinije = sifraLinije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.sifraLinije);
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
        final Linija other = (Linija) obj;
        return Objects.equals(this.sifraLinije, other.sifraLinije);
    }
    
    

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT l.sifraLinije,l.naziv AS nazivLinije,l.redniBrojPoste, ")
          .append("p.naziv AS nazivPoste")
          .append(" FROM ").append(getTableName()).append(" l ")
          .append("INNER JOIN VUK.posta p ON l.redniBrojPoste=p.redniBroj");
        return sb.toString();
    }

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            sifraLinije = rs.getInt("sifraLinije");
            naziv = rs.getString("nazivLinije");
            Integer redniBrojPoste = rs.getInt("redniBrojPoste");
            String nazivPoste = rs.getString("nazivPoste");
            posta = new Posta(redniBrojPoste, nazivPoste);
            
            return new Linija(sifraLinije, naziv, posta);
        } catch (SQLException ex) {
            Logger.getLogger(Linija.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.linija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraLinije,naziv,redniBrojPoste";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifraLinije).append(",")
          .append("'").append(naziv).append("',")
          .append(posta.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("naziv='").append(naziv).append("',")
          .append("redniBrojPoste=").append(posta.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "sifraLinije=" + sifraLinije;
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
    
    
    
}
