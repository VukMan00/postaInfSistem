/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.potvrdaposiljke;

import domain.PotvrdaOPrijemuPosiljke;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class UpdatePotvrdaPosiljke extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((PotvrdaOPrijemuPosiljke)param);
    }
    
}
