/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.brojUlice;

import domain.BrojUlice;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class DeleteBrojUlice extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((BrojUlice)param);
    }
    
}
