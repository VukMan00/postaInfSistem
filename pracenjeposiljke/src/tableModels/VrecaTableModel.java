/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.PopisPosiljakaUSVreci;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class VrecaTableModel extends AbstractTableModel{
    
    private List<PopisPosiljakaUSVreci> vrece;

    public VrecaTableModel(List<PopisPosiljakaUSVreci> vrece) {
        this.vrece = vrece;
    }
    
    @Override
    public int getRowCount() {
        return vrece.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PopisPosiljakaUSVreci vreca = vrece.get(rowIndex);
        switch(columnIndex){
            case 0:
                return vreca.getOznakaVrece();
            case 1:
                return vreca.getSpisak().getOznakaSpiska();
            case 2:
                return vreca.getDatumStampe();
            case 3:
                return vreca.getVremeStampe();
            case 4:
                return vreca.getPostaPosiljalac().getNaziv();
            case 5:
                return vreca.getPostaPrimalac().getNaziv();
            case 6:
                return vreca.getMasaVrece();
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"OznakaVrece","OznakaSpiska","DatumStampe","VremeStampe","PostaPosiljalac","PostaPrimalac","Masa"};
        return columnNames[column];
    }

    public List<PopisPosiljakaUSVreci> getVrece() {
        return vrece;
    }
    
    public void remove(PopisPosiljakaUSVreci vreca){
        vrece.remove(vreca);
    }
    
}
