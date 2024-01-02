/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Vozac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class VozacTableModel extends AbstractTableModel{
    
    private List<Vozac> vozaci;
    
    public VozacTableModel(List<Vozac> vozaci){
        this.vozaci = vozaci;
    }

    @Override
    public int getRowCount() {
        return vozaci.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozac vozac = vozaci.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return vozac.getSifraVozaca();
            }
            case 1 -> {
                return vozac.getImePrezime();
            }
            case 2 -> {
                return vozac.getTrenutnaLinija();
            }
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"SifraVozaca","ImePrezime","TrenutnaLinija"};
        return columnNames[column];
    }
    
    public List<Vozac> getVozaci(){
        return vozaci;
    }
    
    public void removeVozac(Vozac vozac){
        vozaci.remove(vozac);
    }
}
