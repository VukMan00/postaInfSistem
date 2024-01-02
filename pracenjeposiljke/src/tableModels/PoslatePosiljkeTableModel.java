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
public class PoslatePosiljkeTableModel extends AbstractTableModel{
    
    List<Adresnica> posiljke;
    
    public PoslatePosiljkeTableModel(List<Adresnica> posiljke){
        this.posiljke = posiljke;
    }
    
    @Override
    public int getRowCount() {
        return posiljke.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Adresnica adresnica = posiljke.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return adresnica.getSifraAdresnice();
            }
            case 1 -> {
                return adresnica.getNapomena();
            }
            case 2 -> {
                return adresnica.getSadrzina();
            }
            case 3 -> {
                return adresnica.getPrimalac().getJmbg();
            }
            case 4 -> {
                return adresnica.getPrimalac().getImePrezime();
            }
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"sifraAdresnice","Napomena","Sadrzina","JMBG","ImePrezime"};
        return columnNames[column];
    }
    
    public List<Adresnica> getPoslatePosiljke(){
        return posiljke;
    }
    
    public void remove(Adresnica adresnica){
        posiljke.remove(adresnica);
    }
}
