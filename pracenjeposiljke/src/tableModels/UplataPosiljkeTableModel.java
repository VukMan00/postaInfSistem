/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Uplata;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class UplataPosiljkeTableModel extends AbstractTableModel{
    
    private List<Uplata> uplate;
    
    public UplataPosiljkeTableModel(List<Uplata> uplate){
        this.uplate = uplate;
    }

    @Override
    public int getRowCount() {
        return uplate.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Uplata uplata = uplate.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return uplata.getKorisnik().getImePrezime();
            }
            case 1 -> {
                return uplata.getPosta().getNaziv();
            }
            case 2 -> {
                return uplata.getPosiljka().getSifraAdresnice();
            }
            case 3 -> {
                return uplata.getDatumUplate();
            }
            case 4 -> {
                return uplata.getUplatnica().getIznos();
            }
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Uplatilac","NazivPoste","Posiljka","DatumUplate","Iznos"};
        return columnNames[column];
    }
    
    public List<Uplata> getUplate(){
        return uplate;
    }
    
    public void removeUplata(Uplata uplata){
        uplate.remove(uplata);
    }
}
