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
import java.util.logging.Level;
import java.util.logging.Logger;
import structureTypes.Adresa_obj;

/**
 *
 * @author Vuk
 */
public class Adresa implements GenericEntity{
    
    private Integer redniBroj;
    private Mesto mesto;
    private Adresa_obj podaciAdresa;

    public Adresa(Integer redniBroj,Mesto mesto, Adresa_obj podaciAdresa) {
        this.redniBroj = redniBroj;
        this.mesto = mesto;
        this.podaciAdresa = podaciAdresa;
    }

    public Integer getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Integer redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Adresa_obj getPodaciAdresa() {
        return podaciAdresa;
    }

    public void setPodaciAdresa(Adresa_obj podaciAdresa) {
        this.podaciAdresa = podaciAdresa;
    }
    
    @Override
    public String getSelectValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.adresa";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "redniBroj,sifraMesta,podaciAdresa";
    }

    @Override
    public String getInsertValues() {
        return "?,?,?";
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("redniBroj=").append("?").append(", ")
          .append("sifraMesta=").append("?").append(", ")
          .append("podaciAdresa=").append("?");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("redniBroj=").append(redniBroj)
          .append(" AND ")
          .append("sifraMesta=").append(mesto.getSifraMesta());
        return sb.toString();
    }

    @Override
    public String getDeleteCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("redniBroj=").append(redniBroj)
          .append(" AND ")
          .append("sifraMesta=").append(mesto.getSifraMesta());
        return sb.toString();
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        try {
            statement.setObject(1, redniBroj);
            statement.setObject(2, mesto.getSifraMesta());
            statement.setObject(3, podaciAdresa);
        } catch (SQLException ex) {
            Logger.getLogger(Adresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTypeMap(Connection connection) {
        try {
            Map<String, Class<?>> typeMap = new HashMap<>();
            typeMap.put("VUK.ADRESA_OBJ",Adresa_obj.class);
            connection.setTypeMap(typeMap);
            System.out.println(typeMap.get("VUK.ADRESA_OBJ"));
        } catch (SQLException ex) {
            Logger.getLogger(Adresa.class.getName()).log(Level.SEVERE, null, ex);
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
