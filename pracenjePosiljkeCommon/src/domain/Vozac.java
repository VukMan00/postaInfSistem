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
public class Vozac implements GenericEntity{
    
    private Integer sifraVozaca;
    private String imePrezime;
    private String trenutnaLinija;
    
    public Vozac(){
        
    }

    public Vozac(Integer sifraVozaca, String imePrezime) {
        this.sifraVozaca = sifraVozaca;
        this.imePrezime = imePrezime;
    }
    
    public Vozac(Integer sifraVozaca, String imePrezime, String trenutnaLinija) {
        this.sifraVozaca = sifraVozaca;
        this.imePrezime = imePrezime;
        this.trenutnaLinija = trenutnaLinija;
    }

    public Integer getSifraVozaca() {
        return sifraVozaca;
    }

    public void setSifraVozaca(Integer sifraVozaca) {
        this.sifraVozaca = sifraVozaca;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getTrenutnaLinija() {
        return trenutnaLinija;
    }

    public void setTrenutnaLinija(String trenutnaLinija) {
        this.trenutnaLinija = trenutnaLinija;
    }
    
    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.sifraVozaca);
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
        final Vozac other = (Vozac) obj;
        return Objects.equals(this.sifraVozaca, other.sifraVozaca);
    } 

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sifraVozaca,imePrezime,trenutnaLinija")
          .append(" FROM ").append(getTableName());
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
            sifraVozaca = rs.getInt("sifraVozaca");
            imePrezime = rs.getString("imePrezime");
            trenutnaLinija = rs.getString("trenutnaLinija");
            
            return new Vozac(sifraVozaca, imePrezime, trenutnaLinija);
        } catch (SQLException ex) {
            Logger.getLogger(Vozac.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.vozac";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraVozaca,imePrezime";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifraVozaca).append(",")
          .append("'").append(imePrezime).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("imePrezime='").append(imePrezime).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "sifraVozaca="+sifraVozaca;
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
