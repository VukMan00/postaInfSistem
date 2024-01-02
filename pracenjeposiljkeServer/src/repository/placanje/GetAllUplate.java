/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.placanje;

import domain.Uplata;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllUplate extends AbstractGenericOperation{
    
    private List<Uplata> uplate;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        uplate = repository.getAll((Uplata)param);
    }
    
    public List<Uplata> getUplate(){
        return uplate;
    }
    
}
