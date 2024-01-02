/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModels;

import domain.DostavniSpisak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class DostavniSpisakTableModel extends AbstractTableModel{
    
    private List<DostavniSpisak> spiskovi;
    
    public DostavniSpisakTableModel(List<DostavniSpisak> spiskovi){
        this.spiskovi = spiskovi;
    }

    @Override
    public int getRowCount() {
        return spiskovi.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DostavniSpisak spisak = spiskovi.get(rowIndex);
        switch(columnIndex){
            case 0 -> {
                return spisak.getOznakaDostavnogSpiska();
            }
            case 1 -> {
                return spisak.getDatumStampe();
            }
            case 2 -> {
                return spisak.getVremeStampe();
            }
            case 3 -> {
                return spisak.getVreca().getOznakaVrece();
            }
            case 4 -> {
                return spisak.getPosta().getNaziv();
            }
            case 5 -> {
                return spisak.getPostar().getImePrezime();
            }
            case 6 -> {
                return spisak.getObracunskiRadnik().getImePrezime();
            }
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"OznakaDostavnogSpiska","DatumStampe","VremeStampe","OznakaVrece","Posta","Postar","ObracunskiRadnik"};
        return columnNames[column];
    }
    
    public List<DostavniSpisak> getDostavniSpiskovi(){
        return spiskovi;
    }
    
    public void addDostavniSpisak(DostavniSpisak spisak){
        spiskovi.add(spisak);
    }
    
    public void removeDostavniSpisak(DostavniSpisak spisak){
        spiskovi.remove(spisak);
    }
}
