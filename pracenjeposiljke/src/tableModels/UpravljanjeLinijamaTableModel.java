/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.Upravlja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class UpravljanjeLinijamaTableModel extends AbstractTableModel{
    
    private List<Upravlja> upravljanje;
    
    public UpravljanjeLinijamaTableModel(List<Upravlja> upravljanje){
        this.upravljanje = upravljanje;
    }

    @Override
    public int getRowCount() {
        return upravljanje.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Upravlja upravlja = upravljanje.get(rowIndex);
        switch(columnIndex){
            case 0:
               return upravlja.getVozac().getImePrezime();
            case 1:
                return upravlja.getLinija().getNaziv();
            case 2:
                return upravlja.getDatumVoznje();
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Vozac","Linija","DatumVoznje"};
        return columnNames[column];
    }
    
    public List<Upravlja> getUpravljanje(){
        return upravljanje;
    }
    
    public void removeUpravlja(Upravlja upravlja){
        upravljanje.remove(upravlja);
    }
    
}
