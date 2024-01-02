/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.potvrdaposiljke;

import domain.PotvrdaOPrijemuPosiljke;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPotvrdePosiljke extends AbstractGenericOperation{
    
    private List<PotvrdaOPrijemuPosiljke> potvrde;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        potvrde = repository.getAll((PotvrdaOPrijemuPosiljke)param);
    }
    
    public List<PotvrdaOPrijemuPosiljke> getPotvrde(){
        return potvrde;
    }
    
}
