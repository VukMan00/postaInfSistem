/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Linija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class LinijaTableModel extends AbstractTableModel{
    
    private List<Linija> linije;

    public LinijaTableModel(List<Linija> linije) {
        this.linije = linije;
    }
    
    @Override
    public int getRowCount() {
        return linije.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Linija linija = linije.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return linija.getSifraLinije();
            }
            case 1 -> {
                return linija.getNaziv();
            }
            case 2 -> {
                return linija.getPosta().getNaziv();
            }
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"SifraLinije","Naziv","Posta"};
        return columnNames[column];
    }

    public List<Linija> getLinije() {
        return linije;
    }
    
    public void remove(Linija linija){
        linije.remove(linija);
    }
    
}
