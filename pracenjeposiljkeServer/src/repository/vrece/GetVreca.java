/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.vrece;

import domain.PopisPosiljakaUSVreci;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetVreca extends AbstractGenericOperation{
    
    private PopisPosiljakaUSVreci vreca;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vreca = (PopisPosiljakaUSVreci) repository.get((PopisPosiljakaUSVreci)param);
    }
    
    public PopisPosiljakaUSVreci getVreca(){
        return vreca;
    }
    
}
