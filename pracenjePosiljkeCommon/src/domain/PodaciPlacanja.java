/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vuk
 */
public class PodaciPlacanja implements GenericEntity{
    
    private Integer redniBrojPlacanja;
    private Integer sifraPlacanja;
    private Integer modelPlacanja;
    private Integer iznos;
    private TipPlacanja tipPlacanja;

    public PodaciPlacanja(Integer redniBrojPlacanja, Integer sifraPlacanja, Integer modelPlacanja, Integer iznos, TipPlacanja tipPlacanja) {
        this.redniBrojPlacanja = redniBrojPlacanja;
        this.sifraPlacanja = sifraPlacanja;
        this.modelPlacanja = modelPlacanja;
        this.iznos = iznos;
        this.tipPlacanja = tipPlacanja;
    }

    public Integer getRedniBrojPlacanja() {
        return redniBrojPlacanja;
    }

    public void setRedniBrojPlacanja(Integer redniBrojPlacanja) {
        this.redniBrojPlacanja = redniBrojPlacanja;
    }

    public Integer getSifraPlacanja() {
        return sifraPlacanja;
    }

    public void setSifraPlacanja(Integer sifraPlacanja) {
        this.sifraPlacanja = sifraPlacanja;
    }

    public Integer getModelPlacanja() {
        return modelPlacanja;
    }

    public void setModelPlacanja(Integer modelPlacanja) {
        this.modelPlacanja = modelPlacanja;
    }

    public Integer getIznos() {
        return iznos;
    }

    public void setIznos(Integer iznos) {
        this.iznos = iznos;
    }

    public TipPlacanja getTipPlacanja() {
        return tipPlacanja;
    }

    public void setTipPlacanja(TipPlacanja tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
    }

    @Override
    public String getSelectValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithCondition() {
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
        return "VUK.podaci_placanja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "redniBrojPlacanja,sifraPlacanja,modelPlacanja,iznos,idPlacanja";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(redniBrojPlacanja).append(",")
          .append(sifraPlacanja).append(",")
          .append(modelPlacanja).append(",")
          .append(iznos).append(",")
          .append(tipPlacanja==TipPlacanja.UPLATNICA ? 1 : 0);
        return sb.toString();
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
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
