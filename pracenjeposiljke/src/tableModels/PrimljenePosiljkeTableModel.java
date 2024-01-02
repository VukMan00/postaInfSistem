/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.DostavljanjePosiljke;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class PrimljenePosiljkeTableModel extends AbstractTableModel{
    
    List<DostavljanjePosiljke> posiljke;
    
    public PrimljenePosiljkeTableModel(List<DostavljanjePosiljke> posiljke){
        this.posiljke = posiljke;
    }

    @Override
    public int getRowCount() {
        return posiljke.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DostavljanjePosiljke dp = posiljke.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return dp.getPosiljka().getSifraAdresnice();
            }
            case 1 -> {
                return dp.getPosiljka().getNapomena();
            }
            case 2 -> {
                return dp.getPosiljka().getSadrzina();
            }
            case 3 -> {
                return dp.getDatumDostave();
            }
            case 4 -> {
                return dp.getVremeDostave();
            }
            case 5 -> {
                return dp.getPosiljka().getPosiljalac().getJmbg();
            }
            case 6 -> {
                return dp.getPosiljka().getPosiljalac().getImePrezime();
            }
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"SifraAdresnice","Napomena","Sadrzaj","DatumDostave","VremeDostave","JMBG","ImePrezime"};
        return columnNames[column];
    }
    
    public List<DostavljanjePosiljke> getPosiljke(){
        return posiljke;
    }
    
    public void remove(DostavljanjePosiljke dostavljanjePosiljke){
        posiljke.remove(dostavljanjePosiljke);
    }   
}
