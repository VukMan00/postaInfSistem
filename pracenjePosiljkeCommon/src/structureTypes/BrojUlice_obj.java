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
public class BrojUlice_obj implements Serializable,SQLData{
    private Integer broj;
    private Adresa_obj podaciAdresa;

    public BrojUlice_obj() {
    }

    public BrojUlice_obj(Integer broj, Adresa_obj podaciAdresa) {
        this.broj = broj;
        this.podaciAdresa = podaciAdresa;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Adresa_obj getPodaciAdresa() {
        return podaciAdresa;
    }

    public void setPodaciAdresa(Adresa_obj podaciAdresa) {
        this.podaciAdresa = podaciAdresa;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "VUK.BROJULICE_OBJ";
    }

    @Override
    public void readSQL(SQLInput stream, String string) throws SQLException {
        this.broj = stream.readInt();
        Adresa_obj adresaObj = new Adresa_obj();
        adresaObj.readSQL(stream, "VUK.ADRESA_OBJ");
        this.podaciAdresa = adresaObj;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeInt(broj);
        stream.writeObject(podaciAdresa);
    }
    
}
