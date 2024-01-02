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
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class Upravlja implements GenericEntity{
    
    private Vozac vozac;
    private Linija linija;
    private LocalDate datumVoznje;
    
    public Upravlja(){
        
    }

    public Upravlja(Vozac vozac, Linija linija, LocalDate datumVoznje) {
        this.vozac = vozac;
        this.linija = linija;
        this.datumVoznje = datumVoznje;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Linija getLinija() {
        return linija;
    }

    public void setLinija(Linija linija) {
        this.linija = linija;
    }

    public LocalDate getDatumVoznje() {
        return datumVoznje;
    }

    public void setDatumVoznje(LocalDate datumVoznje) {
        this.datumVoznje = datumVoznje;
    }

    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT v.sifraVozaca,v.imePrezime, ")
          .append("l.sifraLinije,l.naziv, ")
          .append("upr.datumVoznje")
          .append(" FROM ").append(getTableName()).append(" upr ")
          .append("INNER JOIN VUK.vozac v ON upr.sifraVozaca=v.sifraVozaca ")
          .append("INNER JOIN VUK.linija l ON upr.sifraLinije=l.sifraLinije");
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
            Integer sifraVozaca = rs.getInt("sifraVozaca");
            String imePrezime = rs.getString("imePrezime");
            Integer sifraLinije = rs.getInt("sifraLinije");
            String naziv = rs.getString("naziv");
            datumVoznje = rs.getDate("datumVoznje").toLocalDate();
            
            vozac = new Vozac(sifraVozaca, imePrezime);
            linija = new Linija(sifraLinije, naziv);
            
            return new Upravlja(vozac, linija, datumVoznje);
        } catch (SQLException ex) {
            Logger.getLogger(Upravlja.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.upravlja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraVozaca,sifraLinije,datumVoznje";
    }

    @Override
    public String getInsertValues() {
        String formmattedDatumVoznje = formatDatumVoznje();
        StringBuilder sb = new StringBuilder();
        sb.append(vozac.getSifraVozaca()).append(",")
          .append(linija.getSifraLinije()).append(",")
          .append("TO_DATE(").append("'").append(formmattedDatumVoznje).append("','DD-MM-YYYY')");
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        String formmattedDatumVoznje = formatDatumVoznje();
        StringBuilder sb = new StringBuilder();
        sb.append("sifraLinije=").append(linija.getSifraLinije()).append(",")
          .append("datumVoznje=").append("TO_DATE(").append("'").append(formmattedDatumVoznje).append("','DD-MM-YYYY')");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "sifraVozaca=" + vozac.getSifraVozaca() + " AND " + "sifraLinije=" + linija.getSifraLinije();
    }

    @Override
    public String getDeleteCondition() {
        return "sifraVozaca=" + vozac.getSifraVozaca() + " AND " + "sifraLinije=" + linija.getSifraLinije();
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
    
    private String formatDatumVoznje(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDatumStampe = dtf.format(datumVoznje);
        return formattedDatumStampe;
    }
    
}
