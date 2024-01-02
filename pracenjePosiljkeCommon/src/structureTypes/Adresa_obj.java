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
public class Adresa_obj implements Serializable,SQLData{
    
    private Mesto_obj podaciMesto;
    private String naziv;

    public Adresa_obj() {
    }

    public Adresa_obj(Mesto_obj podaciMesto,String naziv) {
        this.podaciMesto = podaciMesto;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Mesto_obj getPodaciMesto() {
        return podaciMesto;
    }

    public void setPodaciMesto(Mesto_obj podaciMesto) {
        this.podaciMesto = podaciMesto;
    }
   

    @Override
    public String getSQLTypeName() throws SQLException {
        return "VUK.ADRESA_OBJ";
    }

    @Override
    public void readSQL(SQLInput stream, String string) throws SQLException {
        this.naziv = stream.readString();
        Mesto_obj mestoObj = new Mesto_obj();
        mestoObj.readSQL(stream, "VUK.MESTO_OBJ");
        this.podaciMesto = mestoObj;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeObject(podaciMesto);
        stream.writeString(naziv);
    }
    
    
}
