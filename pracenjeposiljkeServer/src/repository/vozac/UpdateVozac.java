/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.vozac;

import domain.Vozac;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class UpdateVozac extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((Vozac)param);
    }
    
}
