/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import structureTypes.Adresa_obj;
import structureTypes.BrojTelefona_obj;
import structureTypes.BrojUlice_obj;
import structureTypes.Mesto_obj;
/**
 *
 * @author Vuk
 */
public class Korisnik implements GenericEntity{
    
    private String jmbg;
    private String imePrezime;
    private BrojTelefona_obj brojTelefona;
    private BrojUlice brUlice;
    
    public Korisnik(){
        
    }
    
    public Korisnik(String jmbg, String imePrezime, BrojTelefona_obj brojTelefona, BrojUlice brUlice) {
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.brojTelefona = brojTelefona;
        this.brUlice = brUlice;
    }
    
    public Korisnik(String jmbg,String imePrezime){
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public BrojTelefona_obj getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(BrojTelefona_obj brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public BrojUlice getBrUlice() {
        return brUlice;
    }

    public void setBrUlice(BrojUlice brUlice) {
        this.brUlice = brUlice;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.jmbg);
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
        final Korisnik other = (Korisnik) obj;
        return Objects.equals(this.jmbg, other.jmbg);
    }
    
    
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT k.jmbg,k.imePrezime,k.brojTelefona.get_broj_telefona() AS brojTelefona,")
              .append("k.brUlice, a.redniBroj, a.podaciAdresa.naziv AS nazivAdresa,")
              .append("m.sifraMesta, m.podaciMesto.naziv AS nazivMesto, m.podaciMesto.postanskiBroj AS postanskiBroj")
              .append(" FROM ").append(getTableName()).append(" k ")
              .append("INNER JOIN VUK.brojUlice br ON k.brUlice = br.brojUlice ")
              .append("INNER JOIN VUK.adresa a ON br.redniBroj = a.redniBroj ")
              .append("INNER JOIN VUK.mesto m ON br.sifraMesta = m.sifraMesta ");
       return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            jmbg = rs.getString("JMBG");
            imePrezime = rs.getString("IMEPREZIME");
            String brTelefona = rs.getString("BROJTELEFONA");
            Integer brojUlice = rs.getInt("BRULICE");
            Integer redniBroj =  rs.getInt("REDNIBROJ");
            String nazivAdrese = rs.getString("NAZIVADRESA");
            Integer sifraMesta = rs.getInt("SIFRAMESTA");
            String nazivMesto = rs.getString("NAZIVMESTO");
            Integer postanskiBroj = rs.getInt("POSTANSKIBROJ");
            
            Mesto_obj podaciMesto = new Mesto_obj(nazivMesto, postanskiBroj);
            Mesto mesto = new Mesto(sifraMesta, podaciMesto);
            
            Adresa_obj podaciAdresa = new Adresa_obj(podaciMesto,nazivAdrese);
            Adresa adresa = new Adresa(redniBroj,mesto,podaciAdresa);
            
            BrojUlice_obj podaciBrojUlice = new BrojUlice_obj(brojUlice, podaciAdresa);
            brUlice = new BrojUlice(brojUlice, mesto, adresa, podaciBrojUlice);
            
            return new Korisnik(jmbg,imePrezime,new BrojTelefona_obj(brTelefona),brUlice);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.korisnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "jmbg,imePrezime,brojTelefona,brUlice";
    }

    @Override
    public String getInsertValues() {
        return "?,?,?,?";
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("jmbg=").append("?").append(", ")
          .append("imePrezime=").append("?").append(", ")
          .append("brojTelefona=").append("?").append(", ")
          .append("brUlice=").append("?");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "jmbg="+jmbg;
    }

    @Override
    public String getDeleteCondition() {
        return "jmbg="+jmbg;
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        try {
            statement.setObject(1, jmbg);
            statement.setObject(2, imePrezime);
            statement.setObject(3, brojTelefona);
            statement.setObject(4, brUlice.getBrojUlice());
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTypeMap(Connection connection) {
        try {
            Map<String, Class<?>> typeMap = new HashMap<>();
            typeMap.put("VUK.BROJTELEFONA_OBJ", BrojTelefona_obj.class);
            connection.setTypeMap(typeMap);
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
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