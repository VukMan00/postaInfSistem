/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.dostavniSpisak;

import domain.DostavniSpisak;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllDostavniSpisak extends AbstractGenericOperation{
    
    private List<DostavniSpisak> spiskovi;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        spiskovi = repository.getAll((DostavniSpisak)param);
    }
    
    public List<DostavniSpisak> getSpiskovi(){
        return spiskovi;
    }
}
