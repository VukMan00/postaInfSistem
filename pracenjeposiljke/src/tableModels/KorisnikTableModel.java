/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Korisnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class KorisnikTableModel extends AbstractTableModel{
    
    private List<Korisnik> korisnici;
    
    public KorisnikTableModel(List<Korisnik> korisnici){
        this.korisnici = korisnici;
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik korisnik = korisnici.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return korisnik.getJmbg();
            }
            case 1 -> {
                return korisnik.getImePrezime();
            }
            case 2 -> {
                return korisnik.getBrojTelefona().getBrojTelefona();
            }
            case 3 -> {
                return korisnik.getBrUlice().getAdresa().getPodaciAdresa().getNaziv() + " "
                        + korisnik.getBrUlice().getBrojUlice();
            }
            case 4 -> {
                return korisnik.getBrUlice().getMesto().getPodaciMesto().getNaziv() + " "
                        + korisnik.getBrUlice().getMesto().getPodaciMesto().getPostanskiBroj();
            }
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"JMBG","ImePrezime","BrojTelefona","Adresa","Mesto"};
        return columnNames[column];
    }
    
    public List<Korisnik> getKorisnici(){
        return korisnici;
    }
    
    public void addKorisnik(Korisnik korisnik){
        korisnici.add(korisnik);
    }
    
    public void remove(Korisnik korisnik){
        korisnici.remove(korisnik);
    }
    
}
