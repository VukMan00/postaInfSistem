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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class PostanskiRadnik implements GenericEntity{
    
    private Integer sifraRadnika;
    private String imePrezime;
    private TipRadnika titula;
    private Posta posta;
    
    public PostanskiRadnik(){
        
    }

    public PostanskiRadnik(Integer sifraRadnika, String imePrezime, TipRadnika titula, Posta posta) {
        this.sifraRadnika = sifraRadnika;
        this.imePrezime = imePrezime;
        this.titula = titula;
        this.posta = posta;
    }

    public Integer getSifraRadnika() {
        return sifraRadnika;
    }

    public void setSifraRadnika(Integer sifraRadnika) {
        this.sifraRadnika = sifraRadnika;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public TipRadnika getTitula() {
        return titula;
    }

    public void setTitula(TipRadnika titula) {
        this.titula = titula;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }
    
    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.sifraRadnika);
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
        final PostanskiRadnik other = (PostanskiRadnik) obj;
        return Objects.equals(this.sifraRadnika, other.sifraRadnika);
    }
    
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT pr.sifraRadnika,pr.imePrezime,pr.titula, ")
           .append("p.redniBroj,p.naziv")
           .append(" FROM ").append(getTableName()).append(" pr ")
           .append("INNER JOIN VUK.posta p ON pr.redniBrojPoste=p.redniBroj");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            sifraRadnika = rs.getInt("sifraRadnika");
            imePrezime = rs.getString("imePrezime");
            titula = rs.getInt("titula")==1 ? TipRadnika.POSTAR : TipRadnika.OBRACUNSKI_RADNIK;
            Integer redniBrojPoste = rs.getInt("redniBroj");
            String nazivPoste = rs.getString("naziv");
            
            posta = new Posta(redniBrojPoste, nazivPoste);
            return new PostanskiRadnik(sifraRadnika, imePrezime, titula, posta);
        } catch (SQLException ex) {
            Logger.getLogger(PostanskiRadnik.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.postanski_radnik";
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
        return "sifraRadnika="+sifraRadnika;
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
