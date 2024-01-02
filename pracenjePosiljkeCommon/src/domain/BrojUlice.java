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
import structureTypes.BrojUlice_obj;

/**
 *
 * @author Vuk
 */
public class BrojUlice implements GenericEntity{
    
    private Integer brojUlice;
    private Mesto mesto;
    private Adresa adresa;
    private BrojUlice_obj podaciBrojUlice;

    public BrojUlice(Integer brojUlice, Mesto mesto, Adresa adresa,BrojUlice_obj podaciBrojUlice) {
        this.brojUlice = brojUlice;
        this.mesto = mesto;
        this.adresa = adresa;
        this.podaciBrojUlice = podaciBrojUlice;
    }

    public Integer getBrojUlice() {
        return brojUlice;
    }

    public void setBrojUlice(Integer brojUlice) {
        this.brojUlice = brojUlice;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public BrojUlice_obj getPodaciBrojUlice() {
        return podaciBrojUlice;
    }

    public void setPodaciBrojUlice(BrojUlice_obj podaciBrojUlice) {
        this.podaciBrojUlice = podaciBrojUlice;
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
        return "VUK.BROJULICE";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "brojUlice,sifraMesta,redniBroj,podaciBrojUlice";
    }

    @Override
    public String getInsertValues() {
        return "?,?,?,?";
    }

    @Override
    public String getUpdateSetValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("brojUlice=").append("?").append(", ")
          .append("sifraMesta=").append("?").append(", ")
          .append("redniBroj=").append("?").append(", ")
          .append("podaciBrojUlice=").append("?");
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("brojUlice=").append(brojUlice)
          .append(" AND ")
          .append("sifraMesta=").append(mesto.getSifraMesta())
          .append(" AND ")
          .append("redniBroj=").append(adresa.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getDeleteCondition() {
        StringBuilder sb = new StringBuilder();
        sb.append("brojUlice=").append(brojUlice)
          .append(" AND ")
          .append("sifraMesta=").append(mesto.getSifraMesta())
          .append(" AND ")
          .append("redniBroj=").append(adresa.getRedniBroj());
        return sb.toString();
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        try {
            statement.setObject(1, brojUlice);
            statement.setObject(2, mesto.getSifraMesta());
            statement.setObject(3, adresa.getRedniBroj());
            statement.setObject(4, podaciBrojUlice);
        } catch (SQLException ex) {
            Logger.getLogger(BrojUlice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTypeMap(Connection connection) {
        try {
            Map<String, Class<?>> typeMap = new HashMap<>();
            typeMap.put("VUK.BROJULICE_OBJ",BrojUlice_obj.class);
            connection.setTypeMap(typeMap);
        } catch (SQLException ex) {
            Logger.getLogger(BrojUlice.class.getName()).log(Level.SEVERE, null, ex);
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
