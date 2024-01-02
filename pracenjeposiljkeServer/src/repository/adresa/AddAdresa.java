/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.adresa;

import domain.Adresa;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class AddAdresa extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.addWithStructureType((Adresa)param);
    }
    
}
