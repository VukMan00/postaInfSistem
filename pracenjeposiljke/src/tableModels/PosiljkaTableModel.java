/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Adresnica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class PosiljkaTableModel extends AbstractTableModel{
    
    private List<Adresnica> posiljke;

    public PosiljkaTableModel(List<Adresnica> posiljke) {
        this.posiljke = posiljke;
    }

    @Override
    public int getRowCount() {
        return posiljke.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Adresnica posiljka = posiljke.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return posiljka.getSifraAdresnice();
            }
            case 1 -> {
                return posiljka.getVreca().getOznakaVrece();
            }
            case 2 -> {
                return posiljka.getSpisak().getOznakaSpiska();
            }
            case 3 -> {
                return posiljka.getPosiljalac().getImePrezime();
            }
            case 4 -> {
                return posiljka.getPrimalac().getImePrezime();
            }
            case 5 -> {
                return posiljka.getMasa();
            }
            case 6 -> {
                return posiljka.getSadrzina();
            }
            case 7 -> {
                return posiljka.getNapomena();
            }
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"SifraAdresnice","OznakaVrece","OznakaSpiska","Posiljalac","Primalac","MasaPosiljke","Sadrzina","Napomena"};
        return columnNames[column];
    }
    
    public List<Adresnica> getPosiljke(){
        return posiljke;
    }
    
    public void addPosiljka(Adresnica adresnica){
        posiljke.add(adresnica);
    }
    
    public void remove(Adresnica adresnica){
        posiljke.remove(adresnica);
    }
    
}
