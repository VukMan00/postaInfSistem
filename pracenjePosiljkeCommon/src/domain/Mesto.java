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
import structureTypes.Mesto_obj;

/**
 *
 * @author Vuk
 */
public class Mesto implements GenericEntity{
    
    private Integer sifraMesta;
    private Mesto_obj podaciMesto;

    public Mesto(){
        
    }
    public Mesto(Integer sifraMesta, Mesto_obj podaciMesto) {
        this.sifraMesta = sifraMesta;
        this.podaciMesto = podaciMesto;
    }

    public Integer getSifraMesta() {
        return sifraMesta;
    }

    public void setSifraMesta(Integer sifraMesta) {
        this.sifraMesta = sifraMesta;
    }

    public Mesto_obj getPodaciMesto() {
        return podaciMesto;
    }

    public void setPodaciMesto(Mesto_obj podaciMesto) {
        this.podaciMesto = podaciMesto;
    }

    @Override
    public String toString() {
        return podaciMesto.getNaziv() + " - " + podaciMesto.getPostanskiBroj();
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.sifraMesta, other.sifraMesta)) {
            return false;
        }
        if(!Objects.equals(this.podaciMesto.getNaziv(), other.podaciMesto.getNaziv())){
            return false;
        }
        return Objects.equals(this.podaciMesto.getPostanskiBroj(), other.podaciMesto.getPostanskiBroj());
    }
        
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
           .append("m.sifraMesta,m.podaciMesto.naziv AS naziv,m.podaciMesto.postanskiBroj AS postanskiBroj")
           .append(" FROM ").append(getTableName()).append(" m ");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            sifraMesta = rs.getInt("sifraMesta");
            String naziv = rs.getString("naziv");
            Integer postanskiBroj = rs.getInt("postanskiBroj");
            return new Mesto(sifraMesta,new Mesto_obj(naziv,postanskiBroj));
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.mesto";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "sifraMesta,podaciMesto";
    }

    @Override
    public String getInsertValues() {
        return "?,?";
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
        return "sifraMesta=" + sifraMesta;
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        try {
            statement.setObject(1, sifraMesta);
            statement.setObject(2, podaciMesto);
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTypeMap(Connection connection) {
        try {
            Map<String, Class<?>> typeMap = new HashMap<>();
            typeMap.put("VUK.MESTO_OBJ",Mesto_obj.class);
            connection.setTypeMap(typeMap);
            System.out.println(typeMap.get("VUK.MESTO_OBJ"));
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
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
