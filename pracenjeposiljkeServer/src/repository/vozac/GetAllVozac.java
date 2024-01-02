/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.vozac;

import domain.Vozac;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllVozac extends AbstractGenericOperation{
    
    private List<Vozac> vozaci;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vozaci = repository.getAll((Vozac)param);
    }
    
    public List<Vozac> getVozaci(){
        return vozaci;
    }
    
}
