/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.placanje;

import domain.Uplata;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetUplata extends AbstractGenericOperation{

    private Uplata uplata;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        uplata = (Uplata) repository.get((Uplata)param);
    }
    
    public Uplata getUplata(){
        return uplata;
    }
}
