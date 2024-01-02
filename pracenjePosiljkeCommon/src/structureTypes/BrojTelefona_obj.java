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
public class BrojTelefona_obj implements Serializable,SQLData{
    private String brojTelefona;

    public BrojTelefona_obj() {
    }

    public BrojTelefona_obj(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "VUK.BROJTELEFONA_OBJ";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.brojTelefona = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(brojTelefona);
    }
    
}
