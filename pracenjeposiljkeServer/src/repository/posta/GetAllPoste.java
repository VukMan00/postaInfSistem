/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.posta;

import domain.Posta;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPoste extends AbstractGenericOperation{
    
    private List<Posta> poste;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        poste = repository.getAll((Posta)param);
    }
    
    public List<Posta> getPoste(){
        return poste;
    }
    
}
