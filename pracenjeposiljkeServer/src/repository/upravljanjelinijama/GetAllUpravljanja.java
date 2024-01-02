/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.upravljanjelinijama;

import domain.Upravlja;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllUpravljanja extends AbstractGenericOperation{
    
    private List<Upravlja> upravljanja;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        upravljanja = repository.getAll((Upravlja)param);
    }
    
    public List<Upravlja> getUpravljanja(){
        return upravljanja;
    }
}
