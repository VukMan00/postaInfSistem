/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.vrece;

import domain.PopisPosiljakaUSVreci;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllVrece extends AbstractGenericOperation{

    private List<PopisPosiljakaUSVreci> vrece;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vrece = repository.getAll((PopisPosiljakaUSVreci)param);
    }
    
    public List<PopisPosiljakaUSVreci> getVrece(){
        return vrece;
    }
    
}
