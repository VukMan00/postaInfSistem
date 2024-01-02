/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.mesto;

import domain.Mesto;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllMesto extends AbstractGenericOperation{
    
    private List<Mesto> mesta;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        mesta = repository.getAll((Mesto)param);
    }
    
    public List<Mesto> getMesta(){
        return mesta;
    }
    
}
