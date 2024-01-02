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
import structureTypes.Adresa_obj;
import structureTypes.BrojTelefona_obj;
import structureTypes.BrojUlice_obj;
import structureTypes.Mesto_obj;

/**
 *
 * @author Vuk
 */
public class UserLogin implements GenericEntity{
    
    private String username;
    
    private String password;
    
    private TipUserLogin tip;

    public UserLogin(String username, String password, TipUserLogin tip) {
        this.username = username;
        this.password = password;
        this.tip = tip;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipUserLogin getTip() {
        return tip;
    }

    public void setTip(TipUserLogin tip) {
        this.tip = tip;
    }

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        if(tip == TipUserLogin.KORISNIK){
            sb.append("SELECT k.jmbg,k.imePrezime,k.brojTelefona.get_broj_telefona() AS brojTelefona,")
              .append("k.brUlice, a.redniBroj, a.podaciAdresa.naziv AS nazivAdresa,")
              .append("m.sifraMesta, m.podaciMesto.naziv AS nazivMesto, m.podaciMesto.postanskiBroj AS postanskiBroj")
              .append(" FROM VUK.korisnik k INNER JOIN VUK.brojUlice br ON k.brUlice = br.brojUlice ")
              .append(" INNER JOIN VUK.adresa a ON br.redniBroj = a.redniBroj")
              .append(" INNER JOIN VUK.mesto m ON br.sifraMesta = m.sifraMesta");
        }
        else{
            sb.append("SELECT pr.sifraRadnika,pr.imePrezime,pr.titula,")
              .append("p.redniBroj,p.naziv,")
              .append("m.sifraMesta,m.podaciMesto.naziv AS nazivMesto,m.podaciMesto.postanskiBroj AS postanskiBroj")
              .append(" FROM VUK.postanski_radnik pr INNER JOIN VUK.posta p ON pr.redniBrojPoste=p.redniBroj")
              .append(" INNER JOIN VUK.mesto m ON p.sifraMesta=m.sifraMesta");
        }
        
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        return tip==TipUserLogin.KORISNIK ? getKorisnik(rs) : getPostanskiRadnik(rs);
    }
    
    private PostanskiRadnik getPostanskiRadnik(ResultSet rs){
        try {
            Integer sifraRadnika = rs.getInt("SIFRARADNIKA");
            String imePrezime = rs.getString("IMEPREZIME");
            Integer titula = rs.getInt("TITULA");
            Integer redniBrojPoste = rs.getInt("REDNIBROJ");
            String nazivPoste = rs.getString("NAZIV");
            Integer sifraMesta = rs.getInt("SIFRAMESTA");
            String nazivMesto = rs.getString("NAZIVMESTO");
            Integer postanskiBroj = rs.getInt("POSTANSKIBROJ");
            
            Mesto mesto = new Mesto(sifraMesta, new Mesto_obj(nazivMesto, postanskiBroj));
            Posta posta = new Posta(redniBrojPoste, nazivPoste, mesto);
            return new PostanskiRadnik(sifraRadnika, imePrezime, 
                    titula==1 ? TipRadnika.POSTAR : TipRadnika.OBRACUNSKI_RADNIK, posta);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Korisnik getKorisnik(ResultSet rs){
        try {
            String jmbg = rs.getString("JMBG");
            String imePrezime = rs.getString("IMEPREZIME");
            String brojTelefona = rs.getString("BROJTELEFONA");
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
            BrojUlice brUlice = new BrojUlice(brojUlice, mesto, adresa, podaciBrojUlice);
            
            return new Korisnik(jmbg,imePrezime,new BrojTelefona_obj(brojTelefona),brUlice);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    @Override
    public String getWhereCondition() {
        if(tip == TipUserLogin.KORISNIK){
            return " WHERE k.imePrezime='" + getUsername() + "' AND" + " k.jmbg='" + getPassword() + "'";
        }
        else{
            return " WHERE pr.imePrezime='" + getUsername() + "' AND" + " pr.sifraRadnika=" + getPassword() + "";
        }
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
