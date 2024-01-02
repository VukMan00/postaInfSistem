/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.spisakRazmene;

import domain.SpisakRazmene;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllSpisakRazmene extends AbstractGenericOperation{
    
    private List<SpisakRazmene> spiskovi;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        spiskovi = repository.getAll((SpisakRazmene)param);
    }
    
    public List<SpisakRazmene> getSpiskovi(){
        return spiskovi;
    }
}
