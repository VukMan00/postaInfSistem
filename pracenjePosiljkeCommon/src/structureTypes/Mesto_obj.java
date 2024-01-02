/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structureTypes;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


/**
 *
 * @author Vuk
 */
public class Mesto_obj implements Serializable,SQLData{
    private String naziv;
    private Integer postanskiBroj;

    public Mesto_obj() {
    }

    public Mesto_obj(String naziv, Integer postanskiBroj) {
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Integer postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "VUK.MESTO_OBJ";
    }

    @Override
    public void readSQL(SQLInput stream, String string) throws SQLException {
        this.naziv = stream.readString();
        this.postanskiBroj = stream.readInt();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(naziv);
        stream.writeInt(postanskiBroj);
    }
    
    
}
